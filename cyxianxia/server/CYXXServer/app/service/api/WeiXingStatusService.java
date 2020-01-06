package service.api;

import java.io.UnsupportedEncodingException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.google.gson.Gson;

import cache.CacheKey;
import cache.RemoteCache;
import config.GameStatus;
import play.Logger;
import play.db.jpa.Transactional;
import weixin.CompanyWinXinSSL;
import weixin.CompanyWinXinSignUtils;
import weixin.vo.MchPayInfo;
import weixin.vo.WeiXinJsapiTicket;
import weixin.vo.WinXinCompanyRes;
import weixin.vo.WxParam;


@Transactional
public class WeiXingStatusService {

	
	//获取退款的api接口
	public static final String weiXinPayUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	
	
	public static WeiXinJsapiTicket getJsapi_ticket( String accessToken){
		try {
			String url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accessToken+"&type=jsapi";
			Connection con = Jsoup.connect( url ).ignoreContentType(true);
	        con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36").get(); 
	        Response doc= con.execute(); 
	        WeiXinJsapiTicket weiXinJsapiTicket =  new Gson().fromJson(doc.body(), WeiXinJsapiTicket.class);
	        if( weiXinJsapiTicket.getErrcode() == 0 ) {
	        	RemoteCache.safeSet( CacheKey.getWeiXinTicketCacheKey(), weiXinJsapiTicket.getTicket() , null );
			}
	        return weiXinJsapiTicket;
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
	}
	
	
	public static WxParam getEncryptJsapiTicket(  String url ){
		String ticket = (String) RemoteCache.get( CacheKey.getWeiXinTicketCacheKey() );
		if( ticket == null ) {
			return null;
		}
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//随机生成的时间戳
		String noncestr = RandomStringUtils.randomAlphanumeric(16);//生成的16位随机码
		String url1 = null;
		try {
			url1 = java.net.URLDecoder.decode(url,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}//在调用js的页面完整URL
		String signature= getSignature( ticket , url1, timestamp, noncestr);//开始进行sha1签名
		WxParam wxparam = new WxParam();
		wxparam.setNonce(noncestr);
		wxparam.setSignature(signature);
		wxparam.setTimestamp(timestamp);
		wxparam.setAppId( GameStatus.UserAPPID );
		return wxparam;
	}
	
	public static String getSignature(String ticket , String url,String timeStamp,String nonceStr ){  
		//所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1：
		String signValue = "jsapi_ticket="+ticket+"&noncestr="+nonceStr+"×tamp="+timeStamp+"&url="+url;  
		String signature = DigestUtils.sha1Hex(signValue);
		return signature;    
	}
	
	
	/**
	 * @param pay_openid
	 * @param money
	 * @param playerId
	 * @return 用户领取红包
	 */
	public static WinXinCompanyRes zhuangZhang( String pay_openid , int money , Long playerId , String dec ){
		
		try {
			
			MchPayInfo mchPayInfo = new MchPayInfo();
			mchPayInfo.setMch_appid(GameStatus.UserAPPID);
			mchPayInfo.setMchid(GameStatus.mch_id);
			mchPayInfo.setOpenid(pay_openid);
			
			String amount  = (money * 100) +"";
			mchPayInfo.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
			mchPayInfo.setPartner_trade_no(UUID.randomUUID().toString().replace("-", ""));
			mchPayInfo.setAmount(amount);
			mchPayInfo.setCheck_name("NO_CHECK");
			mchPayInfo.setDesc(dec);
			mchPayInfo.setRe_user_name(""+playerId);
			mchPayInfo.setSpbill_create_ip("192.168.1.88");
	
	        //2.0 生成map集合
	        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>(); 
	        packageParams.put("mch_appid", mchPayInfo.getMch_appid());         //微信公众号的appid
	        packageParams.put("mchid", mchPayInfo.getMchid());       //商务号
	        packageParams.put("nonce_str",mchPayInfo.getNonce_str());  //随机生成后数字，保证安全性
	
	        packageParams.put("partner_trade_no",mchPayInfo.getPartner_trade_no()); //生成商户订单号
	        packageParams.put("openid",mchPayInfo.getOpenid());            // 支付给用户openid
	        packageParams.put("check_name",mchPayInfo.getCheck_name());    //是否验证真实姓名呢
	        packageParams.put("re_user_name",mchPayInfo.getRe_user_name());//收款用户姓名
	        packageParams.put("amount",mchPayInfo.getAmount());            //企业付款金额，单位为分
	        packageParams.put("desc",mchPayInfo.getDesc());                //企业付款操作说明信息。必填。
	        packageParams.put("spbill_create_ip",mchPayInfo.getSpbill_create_ip()); //调用接口的机器Ip地址
	        
	        Logger.info(new Gson().toJson(packageParams) , 1 );
	        //3.0 生成自己的签名
	        String sign  = CompanyWinXinSignUtils.creatSign(packageParams);
	        //4.0 封装退款对象
	        packageParams.put("sign", sign);
	
	        //5.0将当前的map结合转化成xml格式
	        String reuqestXml = CompanyWinXinSignUtils.getRequestXml(packageParams);
	
	        //6.0获取需要发送的url地址
	        String weixinPost = CompanyWinXinSSL.doRefund(weiXinPayUrl, reuqestXml).toString();
	        //7.0 解析返回的xml数据
	        WinXinCompanyRes refundResult = CompanyWinXinSignUtils.parseXmlToMapEnterpriceToCustomer(weixinPost);
	        return  refundResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		return null;
	}
	
	
}
