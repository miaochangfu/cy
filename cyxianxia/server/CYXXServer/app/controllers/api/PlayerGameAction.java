package controllers.api;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import controllers.BaseController;
import message.APIResponse;
import message.ResultByJson;
import message.SystemError;
import play.Logger;
import play.db.jpa.Transactional;
import service.api.PlayerGameApiService;

/**
 * <p>Title: PlayerGameAction</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年8月12日-下午4:04:25</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
@Transactional
public class PlayerGameAction  extends BaseController{
    
	
	/**
     * 用户抽奖
     */
    public static void getPlayerLottery( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			resultByJson = PlayerGameApiService.getPlayerLotteryService( playerId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     * 用户抽奖初始界面
     */
    public static void getPlayerLotteryInit( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			resultByJson = PlayerGameApiService.getPlayerLotteryInitService( playerId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    
	/**
     * 用户上传分数
     */
    public static void getPlayerUpdateScore( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("score") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			int score = ( body.get("score")  == JsonNull.INSTANCE || body.get("score") == null) ?1:body.get("score").getAsInt();
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
    		resultByJson = PlayerGameApiService.getPlayerUpdateScoreService( playerId , score  );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     * 用户设置数据
     */
    public static void getPlayerSetInfo( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
    		String music_set = ( body.get("music_set")  == JsonNull.INSTANCE || body.get("music_set") == null) ?null:body.get("music_set").getAsString();
    		String sound_set = ( body.get("sound_set")  == JsonNull.INSTANCE || body.get("sound_set") == null) ?null:body.get("sound_set").getAsString();
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
    		resultByJson = PlayerGameApiService.getPlayerSetInfoService( playerId , music_set , sound_set  );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     * 用户排名数据
     */
    public static void getPlayerPlayerRanking( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			int type = ( body.get("type")  == JsonNull.INSTANCE || body.get("type") == null) ?1:body.get("type").getAsInt();
			int page = ( body.get("page")  == JsonNull.INSTANCE || body.get("page") == null) ?1:body.get("page").getAsInt();
			
			resultByJson = PlayerGameApiService.getPlayerPlayerRankingService( playerId , type , page  );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     *  用户初始化关卡
     */
    public static void getPlayerQuestionList( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			resultByJson = PlayerGameApiService.getPlayerQuestionListService( playerId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     *  用户开始关卡游戏
     */
    public static void getPlayerQuestionSatrt( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null  || body.get("game_type") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			int game_type = ( body.get("game_type")  == JsonNull.INSTANCE || body.get("game_type") == null) ?1:body.get("game_type").getAsInt();
			resultByJson = PlayerGameApiService.getPlayerQuestionSatrtService( playerId , game_type );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     *  用户结算关卡游戏
     */
    public static void getPlayerQuestionGameOver( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("question_id") == null || body.get("game_type") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long question_id = ( body.get("question_id")  == JsonNull.INSTANCE || body.get("question_id") == null) ?0L:body.get("question_id").getAsLong();
			int game_type = ( body.get("game_type")  == JsonNull.INSTANCE || body.get("game_type") == null) ?1:body.get("game_type").getAsInt();
			int is_win = ( body.get("is_win")  == JsonNull.INSTANCE || body.get("is_win") == null) ?0:body.get("is_win").getAsInt();
			resultByJson = PlayerGameApiService.getPlayerQuestionGameOverService( playerId , game_type , question_id , is_win );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     *  用户跳过关卡
     */
    public static void getPlayerQuestionSkip( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("question_id") == null || body.get("game_type") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long question_id = ( body.get("question_id")  == JsonNull.INSTANCE || body.get("question_id") == null) ?0L:body.get("question_id").getAsLong();
			int game_type = ( body.get("game_type")  == JsonNull.INSTANCE || body.get("game_type") == null) ?1:body.get("game_type").getAsInt();
			resultByJson = PlayerGameApiService.getPlayerQuestionSkipService( playerId , game_type , question_id );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     *  用户提示
     */
    public static void getPlayerQuestionTips( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			resultByJson = PlayerGameApiService.getPlayerQuestionTipsService( playerId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     *  用户复活
     */
    public static void getPlayerQuestionRevive( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			resultByJson = PlayerGameApiService.getPlayerQuestionReviveService( playerId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    
    /**
     * 用户商城数据
     */
    public static void getPlayerMastShopList( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("type") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			int type = ( body.get("type")  == JsonNull.INSTANCE || body.get("type") == null) ?1:body.get("type").getAsInt();
			
			resultByJson = PlayerGameApiService.getPlayerMastShopListService( playerId , type  );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    
    /**
     *  用户购买
     */
    public static void getPlayerBuyMastShop( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null  || body.get("pkId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long pkId = ( body.get("pkId")  == JsonNull.INSTANCE || body.get("pkId") == null) ?0L:body.get("pkId").getAsLong();
			
			resultByJson = PlayerGameApiService.getPlayerBuyMastShopService( playerId , pkId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     *  用户银币流水数据
     */
    public static void getLogPlayerCoinStatusList( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null  || body.get("page") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			int page = ( body.get("page")  == JsonNull.INSTANCE || body.get("page") == null) ?1:body.get("page").getAsInt();
			resultByJson = PlayerGameApiService.getLogPlayerCoinStatusListService( playerId , page );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     *  用户积分流水数据
     */
    public static void getLogPlayerScoreStatusList( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null  || body.get("page") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			int page = ( body.get("page")  == JsonNull.INSTANCE || body.get("page") == null) ?1:body.get("page").getAsInt();
			resultByJson = PlayerGameApiService.getLogPlayerScoreStatusListService( playerId , page );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    
    /**
     *  用户设置装备跟宠物
     */
    public static void getSavePlayerItem( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null  || body.get("pkId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long pkId = ( body.get("pkId")  == JsonNull.INSTANCE || body.get("pkId") == null) ?0L:body.get("pkId").getAsLong();
			resultByJson = PlayerGameApiService.getSavePlayerItemService( playerId , pkId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    
	/**
     * 微信回调数据
     */
    public static void getMessagePushSataus( String signature , String echostr , String timestamp  , String nonce ) {

    	try {
    		
    		if ( signature  == null ||  echostr  == null  ||  timestamp  == null ||  nonce  == null) {
    			outputJSON("success");
			}
    		Logger.info("signature:"+signature+"\t echostr"+echostr+ "\t timestamp"+timestamp+"\t nonce"+nonce );
		} catch (Exception e) {
			e.printStackTrace();
		}
    	outputJSON("success");
    }
    
    
}
            
