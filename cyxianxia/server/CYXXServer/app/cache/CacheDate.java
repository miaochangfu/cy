package cache;

import java.io.File;
import java.util.List;

import config.GameStatus;
import models.MastQuestionLevel;
import models.MastTask;
import models.Player;
import play.Logger;
import play.Play;
import play.i18n.Messages;
import service.api.WeiXingStatusService;
import weixin.WinXinUserH5Util;
import weixin.vo.WeiXinRes;

public class CacheDate {

	public static boolean isInited = false;
	
	public static  boolean startJob( ){
		
		try {
			
			String star = Play.configuration.getProperty("application.mode", "dev");
			
			Logger.info("Play.mode--->"+star);
			
			GameStatus.UserAPPID = Messages.getMessage(star, "UserAPPID", "");
			GameStatus.UserAPPSECRET = Messages.getMessage(star, "UserAPPSECRET", "");
			
			GameStatus.zhuan_zhang_appid = Messages.getMessage(star, "zhuan_zhang_appid", "");
			GameStatus.zhuan_zhang_slcert_password = Messages.getMessage(star, "zhuan_zhang_slcert_password", "");
			
			GameStatus.Pay_APPID = Messages.getMessage(star, "Pay_APPID", "");
			GameStatus.Pay_APPSECRET = Messages.getMessage(star, "Pay_APPSECRET", "");
			
			
			Logger.info("UserAPPID-->"+GameStatus.UserAPPID);
			Logger.info("UserAPPSECRET-->"+GameStatus.UserAPPSECRET);
			
			if( star.equals("prod") ) {
				GameStatus.isSecret = true;
			}
			Logger.info("isSecret--->"+GameStatus.isSecret);
			GameStatus.P12_PATH1 = System.getProperty("user.dir")+File.separator+"CYXXServer"+File.separator+"app"+File.separator+"apiclient_cert_"+star+".p12";
			GameStatus.P12_PATH2 = System.getProperty("user.dir")+File.separator+"app"+File.separator+"apiclient_cert_"+star+".p12";
			
			isInited = true;
			
//			List<MastNotice> listMastNotice = new MastNoticeXls().readXls();
//			if( listMastNotice != null && listMastNotice.size() > 0 ) {
//				System.out.println( "listMastNotice-->"+listMastNotice.size() );
//				Logger.info("listMastNotice-->"+listMastNotice.size());
//				RemoteCache.safeSet( CacheKey.getMastNoticeResAllCacheKey(), listMastNotice , null);
//			}
			
			Logger.info("------初始缓存数据完成------");
			System.out.println("------初始缓存数据完成------");
			
			
			List<MastQuestionLevel> listQuestionLevel = MastQuestionLevel.findAll();
			
			if( listQuestionLevel != null && listQuestionLevel.size() > 0 ) {
				RemoteCache.safeSet( CacheKey.getMastQuestionLevelAllCacheKey(), listQuestionLevel , null);
				for ( MastQuestionLevel mastQuestionLevel : listQuestionLevel ) {
					RemoteCache.safeSet( CacheKey.getMastQuestionLevelCacheKey( mastQuestionLevel.getId() ), mastQuestionLevel , null);
				}
			}
			
			List<MastTask> typeList = MastTask.findAll();
    		if( typeList != null &&  typeList.size() > 0  ) {
    			RemoteCache.safeSet( CacheKey.getMastTaskAllCacheKey() , typeList, null);
    			for ( MastTask mastTask : typeList ) {
    				RemoteCache.safeSet( CacheKey.getMastTaskCacheKey( mastTask.getTask_id() ) , mastTask, null);
				}
    		}
    		
    		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 获取 登录 的公众号AccessToken
	 * @return
	 */
	public static String getWeiXinUserLoginAccessToken() {
		String accessToken = (String) RemoteCache.get( CacheKey.getWeiXinUserLoginAccessTokenCacheKey() );
		if( accessToken == null ) {
			WeiXinRes weiXinRes = WinXinUserH5Util.getUserLoginTokenUrl();
			if( weiXinRes == null || weiXinRes.getAccess_token() == null ) {
			}else {
				Logger.info("---getWeiXinUserLoginAccessToken cache init---"+weiXinRes.getAccess_token() , 1 );
				RemoteCache.safeSet( CacheKey.getWeiXinUserLoginAccessTokenCacheKey(), weiXinRes.getAccess_token() , null );
				//设置ticket
				 WeiXingStatusService.getJsapi_ticket( weiXinRes.getAccess_token() );
				return weiXinRes.getAccess_token();
			}
		}
		return accessToken;
	}
	
	

	public static Player getCacheUserStatus( Long playerId ) {
		Player player = (Player) RemoteCache.get( CacheKey.getUserStatusCacheKey(playerId) );
		if( player == null ) {
			player = Player.findById(playerId);
			if( player != null ) {
				RemoteCache.set( CacheKey.getUserStatusCacheKey( player.id ), player );
			}
		}
		return player;
	}
	
}
