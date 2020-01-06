package weixin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.google.gson.Gson;

import config.GameStatus;
import utils.CommonUtil;
import weixin.vo.MchPayInfo;
import weixin.vo.WinXinCompanyRes;

/**
 * <p>Title: SignUtils</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月17日-下午5:56:24</p>
 * <p>version 1.0</p>
 * <p>Description:签名工具类 </p>
 */
public class CompanyWinXinSignUtils {

	
    /**
     * @param characterEncoding 编码格式 utf-8
     */
    @SuppressWarnings("rawtypes")
	public static String creatSign(SortedMap<Object, Object> parameters) throws Exception {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + GameStatus.zhuan_zhang_appid);
        String sign = CommonUtil.encodePassword(sb.toString()).toUpperCase();
        return sign;
    }
    
    /**
     * 将Map转换为XML格式的字符串
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
        try {
            writer.close();
        }
        catch (Exception ex) {
        }
        return output;
    }
    
    
    /*
     * 将SortedMap<Object,Object> 集合转化成 xml格式
     */
    @SuppressWarnings("rawtypes")
    public static String getRequestXml(SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if ("attach".equalsIgnoreCase(k)||"body".equalsIgnoreCase(k)||"sign".equalsIgnoreCase(k)) {
                sb.append("<"+k+">"+"<![CDATA["+v+"]]></"+k+">");
            }else {
                sb.append("<"+k+">"+v+"</"+k+">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }
    
    
    	/**
        * XML格式字符串转换为Map
        * @param strXML XML字符串
        * @return XML数据转换后的Map
        * @throws Exception
        */
       public static Map<String, String> xmlToMap(String strXML) throws Exception {
           try {
               Map<String, String> data = new HashMap<String, String>();
               DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
               DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
               InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
               org.w3c.dom.Document doc = documentBuilder.parse(stream);
               doc.getDocumentElement().normalize();
               NodeList nodeList = doc.getDocumentElement().getChildNodes();
               for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                   Node node = nodeList.item(idx);
                   if (node.getNodeType() == Node.ELEMENT_NODE) {
                       org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                       data.put(element.getNodeName(), element.getTextContent());
                   }
               }
               try {
                   stream.close();
               } catch (Exception ex) {
            	   throw ex;
               }
               return data;
           } catch (Exception ex) {
               throw ex;
           }

       }
       
       
       /** 
       	下面是需要通过跟节点，找找到对应的类属性，手动把它set进去。因此API返回的参数不一样
       * 解析企业支付申请 
       * 解析的时候自动去掉CDMA 
       * @param xml 
       */ 
       @SuppressWarnings("unchecked") 
       public static WinXinCompanyRes parseXmlToMapEnterpriceToCustomer(String xml){
    	   
           WinXinCompanyRes enterpriceToCustomer = new WinXinCompanyRes(); 
             
           try { 
                   StringReader read = new StringReader(xml); 
                   // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入 
                   InputSource source = new InputSource(read); 
                   // 创建一个新的SAXBuilder 
                   SAXBuilder sb = new SAXBuilder(); 
                   // 通过输入源构造一个Document 
                   Document doc = (Document) sb.build(source); 

                   Element root = doc.getRootElement();// 指向根节点 
                   List<Element> list = root.getChildren(); 

                   if(list!=null&&list.size()>0){ 
                   for (Element element : list) { 
                       if("return_code".equals(element.getName())){ 
                               enterpriceToCustomer.setReturn_code(element.getText()); 
                           } 

                       if("return_msg".equals(element.getName())){ 
                               enterpriceToCustomer.setReturn_msg(element.getText()); 
                           } 

                       if("mchid".equals(element.getName())){ 
                           enterpriceToCustomer.setMchid(element.getText()); 
                       }

                       if("nonce_str".equals(element.getName())){ 
                           enterpriceToCustomer.setNonce_str(element.getText()); 
                       }
                       if("result_code".equals(element.getName())){ 
                           enterpriceToCustomer.setResult_code(element.getText()); 
                       }
                       if("partner_trade_no".equals(element.getName())){ 
                           enterpriceToCustomer.setPartner_trade_no(element.getText()); 
                       }
                       if("payment_no".equals(element.getName())){ 
                           enterpriceToCustomer.setPayment_no(element.getText()); 
                       }
                       if("payment_time".equals(element.getName())){ 
                           enterpriceToCustomer.setPayment_time(element.getText()); 
                       }   
                       if("err_code".equals(element.getName())){ 
                           enterpriceToCustomer.setErr_code(element.getText()); 
                       }
                       if("err_code_des".equals(element.getName())){ 
                           enterpriceToCustomer.setErr_code_des(element.getText()); 
                       }   
                   }
               }

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return enterpriceToCustomer;
	} 
       
    public static void main(String[] args) {
    	
    	try {
    		
    		MchPayInfo mchPayInfo = new MchPayInfo();
    		mchPayInfo.setMch_appid("wx3d9136dc3b0b1479");
    		mchPayInfo.setMchid("1495465532");
    		mchPayInfo.setOpenid("ob_qw1O7Yok8QdFz4ego3-4G522s");
    		//商户key用的pODdzdasReweNNMAseeRdLIisrCkbXUy
    		
    		mchPayInfo.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
    		mchPayInfo.setPartner_trade_no(UUID.randomUUID().toString().replace("-", ""));
    		mchPayInfo.setAmount("100");
    		mchPayInfo.setCheck_name("NO_CHECK");
    		mchPayInfo.setDesc("测试开发，稍后会还给公司的");
    		mchPayInfo.setRe_user_name("鲁锐兵");
    		mchPayInfo.setSpbill_create_ip("192.168.1.88");
//    		mchPayInfo.setSign(sign);
    		
    		//1.0 拼凑企业支付需要的参数
//            String mch_appid = "wx3d9136dc3b0b1479";  //微信公众号的appid
//            String mch_id = "1495465532"; //商户号
//            String nonce_str = "2ab40f1d91ce40d58a8d4c0c34d97a32";//UUID.randomUUID().toString().replace("-", ""); //生成随机数
//            String partner_trade_no = "30bc3a04d7934cceb348880b47f9f74a";// UUID.randomUUID().toString().replace("-", ""); //生成商户订单号
//            String openid = "ouaMn1H2KPGdBEk68IB_z8tb4H8E"; // 支付给用户openid
//            String check_name = "NO_CHECK"; //是否验证真实姓名呢
//            String re_user_name = "鲁锐兵";   //收款用户姓名
//            String amount = "100";          //企业付款金额，单位为分
//            String desc = "测试开发，稍后会还给公司的";   //企业付款操作说明信息。必填。
//            String spbill_create_ip = "192.168.1.88";

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
            
            System.out.println(new Gson().toJson(packageParams));
            //3.0 生成自己的签名
            String sign  = CompanyWinXinSignUtils.creatSign(packageParams);
            System.out.println("creatSign--->"+sign);
            //4.0 封装退款对象
            packageParams.put("sign", sign);

            //5.0将当前的map结合转化成xml格式
            String reuqestXml = CompanyWinXinSignUtils.getRequestXml(packageParams);

            //6.0获取需要发送的url地址
            String wxUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"; //获取退款的api接口

            try {
            	System.out.println("reuqestXml-->"+reuqestXml);
                String weixinPost = CompanyWinXinSSL.doRefund(wxUrl, reuqestXml).toString();
                //7.0 解析返回的xml数据
                WinXinCompanyRes refundResult = CompanyWinXinSignUtils.parseXmlToMapEnterpriceToCustomer(weixinPost);
                if("SUCCESS".equalsIgnoreCase(refundResult.getResult_code()) && "SUCCESS".equalsIgnoreCase(refundResult.getReturn_code())){
                    //8表示退款成功
                    // 执行成功付款后的业务逻辑
                    //return successPayMoneyByBankCard(submitMoney,cmms_amt,enterpriceToCustomerByCard,applyId,companyId);
                }else{
                    //9 表示退款失败
                    // 调用service的方法 ，存储失败提现的记录咯
                    //failToPayMoneyByBankCard(enterpriceToCustomerByCard,applyId);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
     *  利用java原生的摘要实现SHA256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256StrJava(String str){
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
    
}