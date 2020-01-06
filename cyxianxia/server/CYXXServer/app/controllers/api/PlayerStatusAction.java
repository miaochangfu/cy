package controllers.api;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import cache.CacheDate;
import config.GameStatus;
import controllers.BaseController;
import message.APIResponse;
import message.ResultByJson;
import message.SystemError;
import models.Player;
import play.Logger;
import play.db.jpa.Transactional;
import service.api.PlayerStatusService;
import weixin.WinXinUserH5Util;
import weixin.vo.WeiXinRes;
import weixin.vo.WeiXinUserRes;

/**
 * <p>Title: PlayerStatusAction</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年2月26日-下午3:40:03</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
@Transactional
public class PlayerStatusAction  extends BaseController{
    
	
	 /** h5 注册  **/
	 public static void getWeiXinInsert( JsonObject body ) {
	    	
    	ResultByJson resultByJson = new ResultByJson() ;
    	
    	try {
//    		WeiXinUserRes weiXinUserRes = WinXinUserH5Util.getUserInfo(weiXinRes.getAccess_token(), openId);// 使用access_token获取用户信息
    		if ( body  == null || body.get("openId") == null  || body.get("img")  == null  || body.get("name")  == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
    		
    		String openId = ( body.get("openId")  == JsonNull.INSTANCE || body.get("openId") == null) ?null:body.get("openId").getAsString();
    		String img = ( body.get("img")  == JsonNull.INSTANCE || body.get("img") == null) ?null:body.get("img").getAsString();
    		String name = ( body.get("name")  == JsonNull.INSTANCE || body.get("name") == null) ?null:body.get("name").getAsString();
    		
    		WeiXinUserRes weiXinUserRes = new WeiXinUserRes();
    		weiXinUserRes.setOpenid( openId );
    		weiXinUserRes.setHeadimgurl( img);
    		weiXinUserRes.setAvatarUrl(  img );
    		weiXinUserRes.setNickname(name);
    		weiXinUserRes.setNickName(name);
    		
			Logger.info("weiXinUserRes--->"+ new Gson().toJson(weiXinUserRes));
			resultByJson = PlayerStatusService.userInsert(  weiXinUserRes , null );
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
			 outputJSON( resultByJson );
		}
    	outputJSON( resultByJson );
    }
	 
	 
	 public static void getWeiXinUrl( String callbackUrl  , Long type_code ) {
	    	
    	ResultByJson resultByJson = new ResultByJson() ;
    	
    	try {
    		int typeCode = type_code.intValue();
    		
    		String urlRes ="";
    		typeCode = typeCode==0?1:typeCode;
    		if( typeCode == 1 ){//用户登录授权
    			String scope = "snsapi_userinfo";
    			urlRes =  String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect", GameStatus.UserAPPID, callbackUrl, scope, "xxxx_state");
    		}
    		resultByJson.weiXinUrl = urlRes;
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
			 outputJSON( resultByJson );
		}
    	outputJSON( resultByJson );
    }
    
    
    public static void refreshCache() {
    	
    	ResultByJson resultByJson = new ResultByJson() ;
    	
    	try {
    		CacheDate.startJob();
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
			 outputJSON( resultByJson );
		}
    	 outputJSON( resultByJson );
    }
	    
	    
	public static void getWeiXinOpenid( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson() ;
    	
    	try {
    		
    		if ( body  == null || body.get("code") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
    		
			String code = ( body.get("code")  == JsonNull.INSTANCE || body.get("code") == null) ?"":body.get("code").getAsString();
			
			WeiXinRes weiXinRes  = WinXinUserH5Util.getUserInfoAccessToken(code , 1 );// 通过这个code获取access_toke(访问令牌)
    		if( weiXinRes.getErrcode() != null && "" != weiXinRes.getErrcode() ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(weiXinRes.getErrcode() ,weiXinRes.getErrmsg(),null);
    			outputJSON( resultByJson );
    		}
    		
    		String openId = weiXinRes.getOpenid();
    		if( openId == null || "".equals(openId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(openId , openId ,null);
    			outputJSON( resultByJson );
    		}
    		
    		resultByJson.openid = weiXinRes.getOpenid();
    		resultByJson.session_key = weiXinRes.getSession_key();
    		resultByJson.unionid = weiXinRes.getUnionid();
    		
    		Player player =  Player.find("openid=?", openId ).first();
    		if( player != null ) {
    			resultByJson.playerId = player.id;
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
			 outputJSON( resultByJson );
		}
    	outputJSON( resultByJson );
    }



	
//	public static void getWeiXinUrl(  JsonObject body) {
//    	
//    	ResultByJson resultByJson = new ResultByJson() ;
//    	
//    	try {
//    		
//			String callbackUrl = ( body.get("callbackUrl")  == JsonNull.INSTANCE || body.get("callbackUrl") == null) ?"":body.get("callbackUrl").getAsString();
//			int type_code = ( body.get("type_code")  == JsonNull.INSTANCE || body.get("type_code") == null) ?1:body.get("type_code").getAsInt();
//    		
//    		String urlRes ="";
//    		if( type_code == 1 ){//用户登录授权
//    			String scope = "snsapi_userinfo";
//    			urlRes =  String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect", GameStatus.UserAPPID, callbackUrl, scope, "xxxx_state");
//    		}
//    		resultByJson.weiXinUrl = urlRes;
//		} catch (Exception e) {
//			e.printStackTrace();
//			resultByJson.status = APIResponse.STATUS_NG;
//			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
//			 outputJSON( resultByJson );
//		}
//    	outputJSON( resultByJson );
//    }

    
    /**
     * 用户注册
     */
    public static void getUserInsertAPI( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {
    		
    		String openid = ( body.get("openid")  == JsonNull.INSTANCE || body.get("openid") == null) ?null:body.get("openid").getAsString();
    		String unionid = ( body.get("unionid")  == JsonNull.INSTANCE || body.get("unionid") == null) ?null:body.get("unionid").getAsString();
    		String code = ( body.get("code")  == JsonNull.INSTANCE || body.get("code") == null) ?null:body.get("code").getAsString();
    		String userInfo = ( body.get("userInfo")  == JsonNull.INSTANCE || body.get("userInfo") == null) ?null:body.get("userInfo").getAsString();
    		Long selfPlayerId = ( body.get("selfPlayerId")  == JsonNull.INSTANCE || body.get("selfPlayerId") == null) ?null:body.get("selfPlayerId").getAsLong();
			
    		if( GameStatus.isWeiXinGZH ) {
    			if ( openid  == null || userInfo == null ) {
    				resultByJson.status = APIResponse.STATUS_NG;
    				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    				outputJSON(resultByJson);
    			}
        		String info = userInfo.replace("\\", "");
        		Logger.info("info-->"+info);
        		WeiXinUserRes weiXinUserRes = new Gson().fromJson(info, WeiXinUserRes.class);
        		if( weiXinUserRes == null ){
        			resultByJson.status = APIResponse.STATUS_NG;
        			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
        			outputJSON( resultByJson );
        		}
        		weiXinUserRes.setUnionid(unionid);
        		weiXinUserRes.setOpenid(openid);
        		
        		Logger.info("weiXinUserRes--->"+ new Gson().toJson(weiXinUserRes));
    			resultByJson = PlayerStatusService.userInsert(  weiXinUserRes , selfPlayerId );
        		
    	    	outputJSON(resultByJson);
    		}else {
    			if ( code  == null ) {
    				resultByJson.status = APIResponse.STATUS_NG;
    				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    				outputJSON(resultByJson);
    			}
        	    		
        		WeiXinRes weiXinRes  = WinXinUserH5Util.getUserInfoAccessToken(code , 1 );// 通过这个code获取access_toke(访问令牌)
        		if( weiXinRes.getErrcode() != null && "" != weiXinRes.getErrcode() ) {
        			resultByJson.status = APIResponse.STATUS_NG;
        			resultByJson.systemError = SystemError.getErrorFlag(weiXinRes.getErrcode() ,weiXinRes.getErrmsg(),null);
        			outputJSON( resultByJson );
        		}
        		
        		String openId = weiXinRes.getOpenid();
        		if( openId == null || "".equals(openId) ) {
        			resultByJson.status = APIResponse.STATUS_NG;
        			resultByJson.systemError = SystemError.getErrorFlag(openId , openId ,null);
        			outputJSON( resultByJson );
        		}
        		
    			WeiXinUserRes weiXinUserRes = WinXinUserH5Util.getUserInfo(weiXinRes.getAccess_token(), openId);// 使用access_token获取用户信息
    			if( weiXinUserRes.getErrcode() != null && "" != weiXinUserRes.getErrcode() ) {
        			resultByJson.status = APIResponse.STATUS_NG;
        			resultByJson.systemError = SystemError.getErrorFlag(weiXinUserRes.getErrcode() ,weiXinUserRes.getErrmsg(),null);
        			outputJSON( resultByJson );
        		}
    			Logger.info("weiXinUserRes--->"+ new Gson().toJson(weiXinUserRes));
    			resultByJson = PlayerStatusService.userInsert(  weiXinUserRes , null );
			}
	    	
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
 
    /**
     * 用户登录
     */
    public static void getPlayerUserLoginAPI( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("openid")  == null  || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			
			String openid = ( body.get("openid")  == JsonNull.INSTANCE || body.get("openid") == null) ?"":body.get("openid").getAsString();
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			
			resultByJson = PlayerStatusService.playerUserLogin( openid , playerId);
    		
	    	outputJSON(resultByJson);
	    	
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
}
            
