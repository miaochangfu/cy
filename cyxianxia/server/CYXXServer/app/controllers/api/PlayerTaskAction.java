package controllers.api;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import controllers.BaseController;
import message.APIResponse;
import message.ResultByJson;
import message.SystemError;
import play.db.jpa.Transactional;
import service.api.PlayerTaskApiService;

/**
 * @author try
 * 任务系统
 */
@Transactional
public class PlayerTaskAction  extends BaseController{
    
	
	/**
     * 用户免费体力界面
     */
    public static void getPlayerTaskList( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
    		
    		Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
			resultByJson = PlayerTaskApiService.getPlayerTaskListService( playerId );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
    /**
     * 用户领取任务奖励
     */
    public static void getPlayerTaskReward( JsonObject body ) {
    	
    	ResultByJson resultByJson = new ResultByJson();
    	
    	try {

    		if ( body  == null || body.get("playerId") == null || body.get("task_id") == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
				resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
				outputJSON(resultByJson);
			}
    		Long playerId = ( body.get("playerId")  == JsonNull.INSTANCE || body.get("playerId") == null) ?0L:body.get("playerId").getAsLong();
    		Long task_id = ( body.get("task_id")  == JsonNull.INSTANCE || body.get("task_id") == null) ?0L:body.get("task_id").getAsLong();
    		resultByJson = PlayerTaskApiService.getPlayerTaskRewardService( playerId , task_id );
	    	outputJSON(resultByJson);
		} catch (Exception e) {
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,e);
			e.printStackTrace();
		}
    	 outputJSON(resultByJson);
    }
    
    
}
            
