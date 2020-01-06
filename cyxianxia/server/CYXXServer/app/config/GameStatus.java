package config;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import play.i18n.Messages;
import service.websocket.PlayerRoomBean;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:37:17
 */
public class GameStatus implements Serializable{
	
	/** 是否是微信公众号   **/
	public static boolean isWeiXinGZH = true;
	
	/** 是否数据加密   **/
	public static boolean isSecret = false;
	
	public static final org.apache.log4j.Logger LOG_BATCH_PARAMETERS_LOGGER = org.apache.log4j.Logger.getLogger("logRequestBatchParameter");
	
	public static final org.apache.log4j.Logger LOG_REQUEST_PARAMETERS_LOGGER = org.apache.log4j.Logger.getLogger("logRequestParameter");
	
	public static final org.apache.log4j.Logger LOG_CHAT = org.apache.log4j.Logger.getLogger("chatLog");
	
	//取得文件路径
	public static String url1 = ""+File.separator+"CYXXServer"+File.separator+"public"+File.separator+"file"+File.separator;
	public static String url2 = ""+File.separator+"public"+File.separator+"file"+File.separator;
		
	//Netty本地服务器端口号
    public static final int PORT = 9999;

	// netty本地服务器地址
	public static final String nettyServiceIP_1 = "localhost";

	// netty服务器地址2
	public static final String nettyServiceIP_2 = "127.0.0.1";

	// netty服务器地址3
	public static final String nettyServiceIP_3 = "localhost";
	
	/** 苹果购买是否是正式环境   **/
	public static boolean isItunes = true;
	
	/** 是否初始化缓存信息   **/
	public static boolean isInitCache = true;
	
	/** 是否用亚马逊缓存   **/
	public static boolean isUseAmazonawsCache = false;
	
	//全局money锁
	public static Object lock = new Object();
	
	public static String SYS_ITEM_DELETE = Messages.get("SYS.ITEM.DELETE");
	
	public static String serverUrl ="";
	
	public static String gameClientUrl = "";
	
	public static String TemplateAPPID = "";//
	public static String TemplateAPPSECRET = "";//
	
	
	public static String UserAPPID = "";//
	public static String UserAPPSECRET = "";//
	
	public static String Pay_APPID = "";//
	public static String Pay_APPSECRET = "";//

	public static String mch_id = "1534779941";//支付的mch_id
	  
	public static String zhuan_zhang_appid = "";//
	public static String zhuan_zhang_slcert_password = "";//
	
	public static String  P12_PATH1 = "";
	public static String  P12_PATH2 = "";
	
	public static String api_md5_key="sdf@23s34@!ds42345";
	
	/** 每页数量   **/
	public static final int pageSize = 5;
	
	public static boolean isLog = true;
	
	public static boolean isCache = true;
	
	/** 最多体力值   **/
	public static final int stamina_max = 10;
	
	/** 体力值恢复时间   **/
	public static final int stamina_time = 10;
	
	/** 体力每场消耗多少  **/
	public static final int stamina_use = 5;
	
	/** 用户邀请了那些好友PK  **/
	public static Map<Long, List<PlayerRoomBean> > friendInviteMap = null;
	
}
