package service.api;

import java.util.ArrayList;
import java.util.List;

import cache.CacheKey;
import cache.RemoteCache;
import message.APIResponse;
import message.ResultByJson;
import message.SystemError;
import models.MastTask;
import models.Player;
import models.PlayerTask;
import play.db.jpa.Transactional;
import service.bean.PlayerStatusServiceBean;


/**
 * @author try
 *  任务系统
 */
@Transactional
public class PlayerTaskApiService {

	
	/**
	 * 用户领取任务奖励
	 * @return
	 */
	public static ResultByJson getPlayerTaskRewardService( Long playerId , Long task_id ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		PlayerTask playerTask = PlayerTask.find(" player_id =? and task_id=? ", playerId , task_id ).first() ;
    		if( playerTask == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
    		}
    		
    		MastTask mastTaskCache = (MastTask) RemoteCache.get( CacheKey.getMastTaskCacheKey( task_id ));
			if( mastTaskCache == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
			}
			
    		if( playerTask.getStatus() != 1 ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_205_ORDER,SystemError.ERROR_CODE_205_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		playerTask.setStatus(2);
    		playerTask.save();
    		
    		player.setStamina( player.getStamina() + mastTaskCache.getReward_value() );
    		player = player.save();
    		
    		//用户数据
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player );
    		
    		resultByJson.playerTaskList = getPlayerTaskList( playerId );
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	/**
	 * 用户免费体力界面
	 * @return
	 */
	public static ResultByJson getPlayerTaskListService( Long playerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		resultByJson.playerTaskList = getPlayerTaskList( playerId );
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	/**
	 * 用户完成任务
	 * @return
	 */
	public static List<PlayerTask> getPlayerCompleteTask( Long playerId , int type ) throws Exception {
		
		List<PlayerTask> listPlayerTask = getPlayerTaskList( playerId );
		if( listPlayerTask != null ) {
			for ( PlayerTask playerTask : listPlayerTask ) {
				MastTask mastTaskCache = (MastTask) RemoteCache.get( CacheKey.getMastTaskCacheKey( playerTask.getTask_id() ));
				if( mastTaskCache == null ) {
					continue;
				}
				if( playerTask.getStatus() != 0 ) {
					continue;
				}
				playerTask.setCu_number( playerTask.getCu_number() + 1 );
				if( playerTask.getCu_number() >= mastTaskCache.getT_number()  ) {
					playerTask.setCu_number( mastTaskCache.getT_number() );
					if( playerTask.getStatus() == 0 ) {
						playerTask.setStatus( 1 );
					}
				}
				playerTask = playerTask.save();
			}
		}
		return listPlayerTask;
	}
	
	
	 /**
	 * @return
	 */
	public static List<PlayerTask> getPlayerTaskList( Long playerId ) throws Exception {
		
		List<PlayerTask> listPlayerTask = new ArrayList<PlayerTask>();
		
    	try {
    		
    		List<MastTask> typeList = (List<MastTask>) RemoteCache.get( CacheKey.getMastTaskAllCacheKey( ) );
    		if( typeList == null || typeList.size() <= 0 ) {
    			typeList = MastTask.findAll();
    			RemoteCache.safeSet( CacheKey.getMastTaskAllCacheKey() , typeList, null);
    			for ( MastTask mastTask : typeList ) {
    				RemoteCache.safeSet( CacheKey.getMastTaskCacheKey( mastTask.getTask_id() ) , mastTask, null);
				}
    		}
    		
    		if( typeList != null && typeList.size() > 0 ) {
    			for ( MastTask mastTask : typeList ) {
    				PlayerTask playerTask = PlayerTask.find(" player_id=? and task_id=? ", playerId , mastTask.getTask_id() ).first();
    				if( playerTask == null ) {
    					playerTask = new PlayerTask();
    					playerTask.setCu_number( 0 );
    					playerTask.setPlayer_id(playerId);
    					playerTask.setStatus(0);
    					playerTask.setTask_id( mastTask.getTask_id() );
    					playerTask = playerTask.save();
    					
    					MastTask mastTaskCache = (MastTask) RemoteCache.get( CacheKey.getMastTaskCacheKey( mastTask.getTask_id() ));
    					if( mastTaskCache != null ) {
    						playerTask.setReward_value( mastTaskCache.getReward_value() );
    						playerTask.setT_number( mastTaskCache.getT_number() );
    						playerTask.setTask_name( mastTaskCache.getName() );
    						playerTask.setMoney_type( mastTaskCache.getMoney_type() );
    					}
    					listPlayerTask.add(playerTask);
    				}else {
    					MastTask mastTaskCache = (MastTask) RemoteCache.get( CacheKey.getMastTaskCacheKey( mastTask.getTask_id() ));
    					if( mastTaskCache != null ) {
    						playerTask.setReward_value( mastTaskCache.getReward_value() );
    						playerTask.setT_number( mastTaskCache.getT_number() );
    						playerTask.setTask_name( mastTaskCache.getName() );
    						playerTask.setMoney_type( mastTaskCache.getMoney_type() );
    					}
    					listPlayerTask.add(playerTask);
					}
				}
    		}
    		
    		return listPlayerTask;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPlayerTask;
	}

}
