/**
 * 
 */
package weixin;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.google.gson.Gson;

import cache.CacheDate;
import config.GameStatus;
import play.Logger;
import weixin.vo.WeiXinRes;
import weixin.vo.WeiXinUserRes;

/**
 * <p>Title: H5Util</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月25日-下午4:13:35</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public class WinXinUserH5Util {
	
	public static String getAccessTokenUrl_weixin_1 = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
	
	public static String getAccessTokenUrl_weixin_2 = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	
	public static String getAccessTokenUrl_h5_1 = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	
	public static String getAccessTokenUrl_h5_2 = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	
	public static String getWinXinUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo";
	
	public static String unionidUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
	
	public static String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
	
	//发送微信系消息
	public static String  weiXinMessage = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	
		
	public static String getAccessTokenUrl( boolean isWeiXinGZH  , int type ) {
		if( isWeiXinGZH ) {
			if( type == 1 ) {
				return getAccessTokenUrl_weixin_1;
			}
			return getAccessTokenUrl_weixin_2;
		}
		if( type == 1 ) {
			return getAccessTokenUrl_h5_1;
		}
		return getAccessTokenUrl_h5_2;
	}
    /**
     * 获取请求用户信息的access_token(访问令牌)
     * @param code
     * @return
     */
	public static WeiXinRes getUserInfoAccessToken(String code , int type ) {
		
        try {
        	String url = "";
        	if( type == 1 ){
        		url = String.format( getAccessTokenUrl( GameStatus.isWeiXinGZH , 1 ) ,GameStatus.UserAPPID, GameStatus.UserAPPSECRET, code);
        	}else if( type == 2 ){
        		url = String.format( getAccessTokenUrl( GameStatus.isWeiXinGZH , 2 ) ,GameStatus.Pay_APPID, GameStatus.Pay_APPSECRET, code);
			}else if( type == 3 ){
        		url = String.format( getAccessTokenUrl( GameStatus.isWeiXinGZH , 2 ) ,GameStatus.TemplateAPPID, GameStatus.TemplateAPPSECRET, code);
			}
            Connection con = Jsoup.connect(url).ignoreContentType(true);
            con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36"); 
            Response doc= con.execute(); 
            Logger.info("getUserInfoAccessToken-->"+ doc.body() );
            return new Gson().fromJson(doc.body(), WeiXinRes.class);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * 获取用户信息
     * @param accessToken
     * @param openId
     * @return
     */
    public static WeiXinUserRes getUserInfo(String accessToken, String openId) {
    	
        try {
        	
        	Connection con = Jsoup.connect(getWinXinUserInfoUrl).ignoreContentType(true);
            con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36"); 
            Map<String, String> data = new HashMap<String, String>();
            data.put("access_token", accessToken);
            data.put("openid", openId);
            data.put("lang", "zh_CN");
            con.data(data);
            Response doc= con.execute(); 
            return new Gson().fromJson(doc.body(), WeiXinUserRes.class);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
    } 
    
    
    /**
     * getUnionid
     * @param accessToken
     * @param openId
     * @return
     */
	public static WeiXinUserRes getUnionid(String accessToken, String openId) {
    	
        try {
        	
        	Connection con = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/user/info").ignoreContentType(true);
        	con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36"); 
        	Map<String, String> data = new HashMap<String, String>();
            data.put("access_token", accessToken);
            data.put("openid", openId);
            data.put("lang", "zh_CN");
            con.data(data);
        	Response doc= con.execute(); 
            WeiXinUserRes weiXinUserRes = new Gson().fromJson(doc.body(), WeiXinUserRes.class);
            return weiXinUserRes;
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
    } 
    
    /**
     * getPayTokenUrl
     */
    public static WeiXinRes getPayTokenUrl() {
    	
        try {
        	String url = String.format( tokenUrl ,GameStatus.Pay_APPID, GameStatus.Pay_APPSECRET );
        	Connection con = Jsoup.connect(url).ignoreContentType(true);
        	con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36"); 
        	Response doc= con.execute(); 
            return new Gson().fromJson(doc.body(), WeiXinRes.class);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
    } 
    
    
    /**
     * getUserLoginTokenUrl
     */
    public static WeiXinRes getUserLoginTokenUrl() {
    	
        try {
        	String url = String.format( tokenUrl ,GameStatus.UserAPPID, GameStatus.UserAPPSECRET );
        	Connection con = Jsoup.connect(url).ignoreContentType(true);
        	con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36"); 
        	Response doc= con.execute(); 
            return new Gson().fromJson(doc.body(), WeiXinRes.class);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
    } 
    
    public static TemplateData getTemplateData( String value , String color ) {
    	// 封装模板数据
		TemplateData first = new TemplateData();
		first.setValue(value);
		first.setColor(color);
		return first;
    }
    
    /**
	 * 模板消息1
	 */
	public static void registTemplate( String templateId , String openId , String first , String ... keyword ) {
		
		try {
			
			// 发送模板消息
			String resultUrl2 = weiXinMessage + CacheDate.getWeiXinUserLoginAccessToken();
			// 封装基础数据
			WechatTemplate wechatTemplate = new WechatTemplate();
			wechatTemplate.setTemplate_id(templateId);
			wechatTemplate.setTouser(openId);
			wechatTemplate.setUrl( GameStatus.gameClientUrl );
			Map<String, TemplateData> mapdata = new HashMap<String, TemplateData>();
			
			String color = "#173177";
			if( first != null ) {
				mapdata.put("first",  getTemplateData(first , color ) );
			}
			mapdata.put("remark", getTemplateData("感谢您对本游戏的大力支持，如有疑问请咨询游戏客服", color ));
			for( int i=0; i< keyword.length; i++) {
				if( keyword[i] != null && ""!= keyword[i] ) {
					mapdata.put("keyword"+(i+1), getTemplateData(keyword[i] , color ));
				}
			}
			wechatTemplate.setData(mapdata);
			String toString = new Gson().toJson(wechatTemplate).toString();
	    	Connection con = Jsoup.connect(resultUrl2).ignoreContentType(true).method(Connection.Method.POST);
	    	con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36"); 
	    	con.requestBody(toString);
	    	Response doc= con.execute(); 
	    	MesStatus mesStatus = new Gson().fromJson(doc.body(), MesStatus.class);
	    	if( mesStatus == null || !mesStatus.getErrmsg().equals("ok") ) {
	    		if( !mesStatus.getErrcode().equals("43004")) {
//	    			LogAdminLoginStatus logAdminLoginStatus = new LogAdminLoginStatus();
//					logAdminLoginStatus.setLogin_at(CommonUtil.getByTimestamp());
//					logAdminLoginStatus.setUsercity(doc.body());
//					logAdminLoginStatus.setUserip("registTemplate" );
//					logAdminLoginStatus.save();
	    		}
				if( mesStatus != null && mesStatus.getErrcode().equals("42001") ) {
					CacheDate.getWeiXinUserLoginAccessToken();
				}
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 模板消息2
	 */
	public static void registTemplate2(String templateId, String openId, String first, String account , String number
			, String amount , String result ) {

		try {

			// 发送模板消息
			String resultUrl2 = weiXinMessage + CacheDate.getWeiXinUserLoginAccessToken();
			// 封装基础数据
			WechatTemplate wechatTemplate = new WechatTemplate();
			wechatTemplate.setTemplate_id(templateId);
			wechatTemplate.setTouser(openId);
			wechatTemplate.setUrl(GameStatus.gameClientUrl);
			Map<String, TemplateData> mapdata = new HashMap<String, TemplateData>();

			String color = "#173177";
			if (first != null) {
				mapdata.put("first", getTemplateData(first, color));
			}
			mapdata.put("remark", getTemplateData("感谢您对本游戏的大力支持，如有疑问请咨询游戏客服", color));
			mapdata.put("accountType", getTemplateData( "充值账户id" , color));
			mapdata.put("productType", getTemplateData( "充值鱼饼数" , color));
			
			mapdata.put("account", getTemplateData( account , color));
			mapdata.put("number", getTemplateData( number , color));
			
			mapdata.put("amount", getTemplateData( amount , color));
			mapdata.put("result", getTemplateData( result , color));
			
			
			wechatTemplate.setData(mapdata);
			String toString = new Gson().toJson(wechatTemplate).toString();
			Connection con = Jsoup.connect(resultUrl2).ignoreContentType(true).method(Connection.Method.POST);
			con.header("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");
			con.requestBody(toString);
			Response doc = con.execute();
			MesStatus mesStatus = new Gson().fromJson(doc.body(), MesStatus.class);
			if( mesStatus == null || !mesStatus.getErrmsg().equals("ok") ) {
//	    		LogAdminLoginStatus logAdminLoginStatus = new LogAdminLoginStatus();
//				logAdminLoginStatus.setLogin_at(CommonUtil.getByTimestamp());
//				logAdminLoginStatus.setUsercity(doc.body());
//				logAdminLoginStatus.setUserip("registTemplate" );
//				logAdminLoginStatus.save();
				if( mesStatus != null && mesStatus.getErrcode().equals("42001") ) {
//					CacheDate.getNewWeiXinAccessToken();
					CacheDate.getWeiXinUserLoginAccessToken();
				}
	    	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		
    public static void main(String[] args) {
    	try {
//        	WeiXinRes weiXinRes2 = getPayTokenUrl();
//        	System.out.println( new Gson().toJson(tokenUrl()));
        	WeiXinRes weiXinRes =  getUserInfoAccessToken("001sv1n00EmoBI1SSBp00i13n00sv1nv", 1);
        	if( weiXinRes != null && weiXinRes.getAccess_token() != null ){
        		System.out.println( "weiXinRes--->"+ new Gson().toJson( weiXinRes ) );
//        		System.out.println( new Gson().toJson( getUnionid(weiXinRes2.getAccess_token(), weiXinRes.getOpenid())));
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.out.println( new Gson().toJson( getUnionid("9_cDLq0cVg_Z0PnaNkGM-JqIU4fyL6sSP_JrvB1FtkLXNYu_f2FKcakhlwjcAL6OgZoWy-GE1zgfaS81LRqASV2Q", "ob_qw1GpCR_YPZnTtBEziLpf-EEU")));
	}
}
