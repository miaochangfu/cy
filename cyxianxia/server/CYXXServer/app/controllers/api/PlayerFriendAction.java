package controllers.api;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import controllers.BaseController;
import message.APIResponse;
import message.ResultByJson;
import message.SystemError;
import play.db.jpa.Transactional;
import service.api.PlayerFriendApiService;

/**
 * @author try
 * 好友系统
 */
@Transactional
public class PlayerFriendAction  extends BaseController{
    
	
	/**
     * 用户好友界面
     */
    public static void getPlayerFriendList( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			resultByJson = PlayerFriendApiService.getPlayerFriendListService( playerId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     * 用户申请加好友
     */
    public static void getPlayerFriendRequest( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("self_player_Id") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long self_player_Id = ( body.get("self_player_Id")  == JsonNull.INSTANCE || body.get("self_player_Id") == null) ?0L:body.get("self_player_Id").getAsLong();
			resultByJson = PlayerFriendApiService.getPlayerFriendRequestService( playerId , self_player_Id  );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     * 用户邀请List
     */
    public static void getPlayerFriendRequestList( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			resultByJson = PlayerFriendApiService.getPlayerFriendRequestListService( playerId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    /**
     * 用户拒绝好友邀请
     */
    public static void getPlayerFriendRefuse( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("self_player_Id") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long self_player_Id = ( body.get("self_player_Id")  == JsonNull.INSTANCE || body.get("self_player_Id") == null) ?0L:body.get("self_player_Id").getAsLong();
			resultByJson = PlayerFriendApiService.getPlayerFriendRefuseService( playerId , self_player_Id  );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    /**
     * 用户同意好友邀请
     */
    public static void getPlayerFriendAgree( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("self_player_Id") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long self_player_Id = ( body.get("self_player_Id")  == JsonNull.INSTANCE || body.get("self_player_Id") == null) ?0L:body.get("self_player_Id").getAsLong();
			resultByJson = PlayerFriendApiService.getPlayerFriendAgreeService( playerId , self_player_Id  );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     * 用户邀请好友pk
     */
    public static void getPlayerFriendInvitePvp( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("game_count") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long friend_Id1 = ( body.get("friend_Id1")  == JsonNull.INSTANCE || body.get("friend_Id1") == null) ?null:body.get("friend_Id1").getAsLong();
			Long friend_Id2 = ( body.get("friend_Id2")  == JsonNull.INSTANCE || body.get("friend_Id2") == null) ?null:body.get("friend_Id2").getAsLong();
			int game_count = ( body.get("game_count")  == JsonNull.INSTANCE || body.get("game_count") == null) ?2:body.get("game_count").getAsInt();
			resultByJson = PlayerFriendApiService.getPlayerFriendInvitePvpService( playerId , friend_Id1 , friend_Id2  , game_count , 2 );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    /**
     * 用户邀请好友pk
     */
    public static void getPlayerFriendAgreePvp( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("friend_Id") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
			Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			Long friend_Id = ( body.get("friend_Id")  == JsonNull.INSTANCE || body.get("friend_Id") == null) ?null:body.get("friend_Id").getAsLong();
			resultByJson = PlayerFriendApiService.getPlayerFriendAgreePvpService( playerId , friend_Id );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    
}
            
