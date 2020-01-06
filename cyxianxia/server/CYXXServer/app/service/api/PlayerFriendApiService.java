package service.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cache.CacheDate;
import cache.CacheKey;
import cache.RemoteCache;
import config.GameStatus;
import enu.GameMethodEnum;
import message.APIResponse;
import message.ChatRoom;
import message.ResultByJson;
import message.SystemError;
import models.Player;
import models.PlayerFriendRequest;
import models.PlayerFriendStatus;
import play.db.jpa.Transactional;
import res.webapi.PlayerFriendRequestRes;
import res.webapi.PlayerFriendRes;
import service.websocket.PlayerRoomBean;
import service.websocket.PlayerWebTcpService;
import service.websocket.SystemRoomBean;
import utils.CommonUtil;
import utils.DateUtil;
import utils.SYSRandom;


/**
 * @author try
 *  好友系统
 */
@Transactional
public class PlayerFriendApiService {

	
	/**
	 * 用户好友界面
	 * @return
	 */
	public static ResultByJson getPlayerFriendListService( Long playerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		List<PlayerFriendRes> listRes = new ArrayList<PlayerFriendRes>();
    		
    		List<PlayerFriendStatus> listFriend = PlayerFriendStatus.find(" player_id=?", playerId ).query.getResultList() ;
    		if( listFriend != null && listFriend.size() > 0 ) {
    			for (PlayerFriendStatus playerFriendStatus : listFriend) {
    				listRes.add( getPlayerFriendRes( playerFriendStatus ) );
				}
    		}
    		resultByJson.listFriendListRes = listRes;
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}

	/**
	 * 用户申请加好友
	 * @return
	 */
	public static ResultByJson getPlayerFriendRequestService( Long playerId , Long  self_player_Id ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		PlayerFriendRequest playerFriendRequest1 = PlayerFriendRequest.find("player_id=? and self_player_id=?", playerId , self_player_Id ).first();
    		if( playerFriendRequest1 == null ) {
    			playerFriendRequest1 = new PlayerFriendRequest();
    			playerFriendRequest1.setPlayer_id( playerId );
    			playerFriendRequest1.setSelf_player_id( self_player_Id );
    			Timestamp newTimestamp = CommonUtil.getByTimestamp();
    			playerFriendRequest1.setCreated_at( newTimestamp );
    			playerFriendRequest1.setDelete_at( DateUtil.getAfterThrityDate( newTimestamp  , 30 ));
    			playerFriendRequest1.save();
    			
    			PlayerFriendRequest playerFriendRequest2 = new PlayerFriendRequest();
    			playerFriendRequest2.setPlayer_id( self_player_Id );
    			playerFriendRequest2.setSelf_player_id( playerId );
    			playerFriendRequest2.setCreated_at( newTimestamp );
    			playerFriendRequest2.setDelete_at( DateUtil.getAfterThrityDate( newTimestamp , 30 ));
    			playerFriendRequest2.save();
    			
    			resultByJson.pkId = self_player_Id;
    		}
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	/**
	 * 用户邀请List
	 * @return
	 */
	public static ResultByJson getPlayerFriendRequestListService( Long playerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		List<PlayerFriendRequestRes> listRes = new ArrayList<PlayerFriendRequestRes>();
    		
    		List<PlayerFriendRequest> list = PlayerFriendRequest.find(" self_player_id=?", playerId ).query.getResultList();
    		if( list != null && list.size() > 0 ) {
    			for ( PlayerFriendRequest playerFriendRequest : list ) {
    				listRes.add( getPlayerFriendRequestRes( playerFriendRequest ) );
				}
    		}
    		resultByJson.listFriendRequestRes = listRes;
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	/**
	 * 用户同意好友邀请
	 * @return
	 */
	public static ResultByJson getPlayerFriendAgreeService( Long playerId , Long self_player_id ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		PlayerFriendRequest playerFriendRequest1 = PlayerFriendRequest.find(" player_id=? and self_player_id=? ", self_player_id , playerId ).first();
    		PlayerFriendRequest playerFriendRequest2 = PlayerFriendRequest.find(" player_id=? and self_player_id=? ", playerId , self_player_id ).first();
    		if( playerFriendRequest1 != null && playerFriendRequest2 != null ) {
    			PlayerFriendStatus playerFriendStatus1 = new PlayerFriendStatus();
    			playerFriendStatus1.setCreated_at( CommonUtil.getByTimestamp() );
    			playerFriendStatus1.setPlayer_id( playerId );
    			playerFriendStatus1.setSelf_player_id(self_player_id);
    			playerFriendStatus1.save();
    			
    			PlayerFriendStatus playerFriendStatus2 = new PlayerFriendStatus();
    			playerFriendStatus2.setCreated_at( CommonUtil.getByTimestamp() );
    			playerFriendStatus2.setPlayer_id( self_player_id );
    			playerFriendStatus2.setSelf_player_id( playerId );
    			playerFriendStatus2.save();
    			
    			playerFriendRequest1.delete();
    			playerFriendRequest2.delete();
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	/**
	 * 用户拒绝好友邀请
	 * @return
	 */
	public static ResultByJson getPlayerFriendRefuseService( Long playerId , Long self_player_id ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		PlayerFriendRequest playerFriendRequest1 = PlayerFriendRequest.find(" player_id=? and self_player_id=? ", self_player_id , playerId ).first();
    		PlayerFriendRequest playerFriendRequest2 = PlayerFriendRequest.find(" player_id=? and self_player_id=? ", playerId , self_player_id ).first();
    		if( playerFriendRequest1 != null ) {
    			playerFriendRequest1.delete();
    		}
    		if( playerFriendRequest2 != null ) {
    			playerFriendRequest2.delete();
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	/**
	 * 用户邀请好友pk
	 * @return
	 */
	public static ResultByJson getPlayerFriendInvitePvpService( Long playerId , Long friend_Id1 , Long friend_Id2 ,  int game_count  ,  int game_type ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		List<PlayerFriendStatus> listFriend = PlayerFriendStatus.find(" player_id=?", playerId ).query.getResultList() ;
    		if( listFriend == null || listFriend.size() <= 0 ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_206_ORDER,SystemError.ERROR_CODE_206_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		
    		Long friend_id_pvp  = (Long) RemoteCache.get(CacheKey.getFriendPVPCacheKey( playerId ));
    		if( friend_id_pvp != null ) {
    			//有人邀请自己战斗
    			//调用加入好友战斗
    			getPlayerFriendAgreePvpService( playerId ,  friend_id_pvp );
    			return resultByJson;
    		}
    		
    		for ( PlayerFriendStatus playerFriendStatus : listFriend ) {
				if( friend_Id1 != null && !playerFriendStatus.getSelf_player_id().equals( friend_Id1 ) ) {
					resultByJson.status = APIResponse.STATUS_NG;
	    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_206_ORDER,SystemError.ERROR_CODE_206_ORDER_VALUE,null);
	    			return resultByJson;
				}
				
				if( friend_Id2 != null && !playerFriendStatus.getSelf_player_id().equals( friend_Id2 ) ) {
					resultByJson.status = APIResponse.STATUS_NG;
	    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_206_ORDER,SystemError.ERROR_CODE_206_ORDER_VALUE,null);
	    			return resultByJson;
				}
			}
    		
    		ResultByJson resultByJson2 = new ResultByJson( GameMethodEnum.method_game_friend_invite.getLabel() ) ;
    		resultByJson2.playerId = playerId;
    		
    		Map<Long, List<PlayerRoomBean> > listMap = GameStatus.friendInviteMap;
    		if( listMap == null ) {
    			listMap = new HashMap<Long, List<PlayerRoomBean>>();
    		}
    		List<PlayerRoomBean> listPlayerRoomBean = new ArrayList<PlayerRoomBean>();
    		
    		//生成自己的数据
    		PlayerRoomBean myPlayerRoomBean = getNewPlayerRoomBean( playerId , game_count , game_type );
    		myPlayerRoomBean.setIs_ready(1);
    		listPlayerRoomBean.add( myPlayerRoomBean );
    		
    		if( friend_Id1 != null ) {
    			listPlayerRoomBean.add( getNewPlayerRoomBean( friend_Id1 , game_count , game_type ) );
				RemoteCache.safeSet(CacheKey.getFriendPVPCacheKey( friend_Id1 ), playerId, "10mn");
				ChatRoom.sendMessage( friend_Id1 , resultByJson2  );
    		}
    		if( friend_Id2 != null ) {
    			listPlayerRoomBean.add( getNewPlayerRoomBean( friend_Id2 , game_count , game_type ) );
    			RemoteCache.safeSet(CacheKey.getFriendPVPCacheKey( friend_Id2 ), playerId, "10mn");
    			ChatRoom.sendMessage( friend_Id2 , resultByJson2  );
    		}
    		listMap.put( playerId , listPlayerRoomBean );
    		
    		GameStatus.friendInviteMap = listMap;
    		
    		resultByJson.listFriendRoomBean = listPlayerRoomBean;
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	
	/**
	 * 用户同意好友pk
	 * @return
	 */
	public static ResultByJson getPlayerFriendAgreePvpService( Long playerId , Long friend_Id ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		int game_type = 2;
    		
    		Map<Long, List<PlayerRoomBean> > listMap = GameStatus.friendInviteMap;
    		if( listMap == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_207_ORDER,SystemError.ERROR_CODE_207_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		
    		if( listMap.get(friend_Id) == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_207_ORDER,SystemError.ERROR_CODE_207_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		
    		boolean isStart = true;
    		List<PlayerRoomBean> list = listMap.get(friend_Id);
    		//通知有人加入战斗
			List<Long> listLong = new ArrayList<Long>();
			
    		for ( PlayerRoomBean playerRoomBean : list ) {
				if( playerRoomBean.getPlayerId().equals(playerId) ) {
					playerRoomBean.setIs_ready(1);
					RemoteCache.safeSet(CacheKey.getPlayerRoomBeanCacheKey( playerRoomBean.getPlayerId() ), playerRoomBean , "10mn" );
				}
				if( playerRoomBean.getIs_ready() == 0 ) {
					isStart = false;
				}
				listLong.add( playerRoomBean.getPlayerId() );
			}
    		GameStatus.friendInviteMap.put(friend_Id, list);
    		if( isStart ) {
    			//开始战斗
    			List<SystemRoomBean> listSystem = (List<SystemRoomBean>) RemoteCache.get( CacheKey.getSystemRoomBeanAllCacheKey( game_type ) );
    			if( listSystem == null || listSystem.size() <= 0 ) {
    				listSystem = new ArrayList<SystemRoomBean>();
    			}
				
    			//创建房间
				SystemRoomBean systemRoomBean = PlayerWebTcpService.getNewSystemRoomBean( getNewPlayerRoomBean( playerId , list.size() , game_type ) );
				systemRoomBean.setCount_down(20);
				systemRoomBean.setStart_at( CommonUtil.getByTimestamp().getTime() );
				systemRoomBean.setQuestionItems( PlayerWebTcpService.getPVPQuestionItem() );
				systemRoomBean.setRoomId( CommonUtil.getCharString( new Long( SYSRandom.getRandom(1000000) ) ) );
				systemRoomBean.setPlayerRooms(list);
				
				listSystem.add( systemRoomBean );
				//保存数据到缓存
				RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( game_type ), listSystem, null);
				
				//根据房间ID保存房间信息
				RemoteCache.safeSet(CacheKey.getSystemRoomBeanCacheKey( systemRoomBean.getRoomId() ) , systemRoomBean , null );
				
				for ( PlayerRoomBean playerRoomBean : list ) {
					playerRoomBean.setRoomId( systemRoomBean.getRoomId() );
					RemoteCache.safeSet(CacheKey.getPlayerRoomBeanCacheKey( playerRoomBean.getPlayerId() ), playerRoomBean , "10mn" );
				}
				PlayerWebTcpService.pushGameSatrt( listLong , 2 , null , systemRoomBean.getRoomId() );
    		}else {
    			//推送加入
        		PlayerWebTcpService.pushGameSatrt( listLong , 1 , playerId , null );
			}
    		resultByJson.listFriendRoomBean = list;
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	public static PlayerRoomBean getNewPlayerRoomBean( Long playerId , int game_count , int game_type ) {
		
		Player player = Player.findById(playerId);
		if( player != null ) {
			PlayerRoomBean playerRoomBean = new PlayerRoomBean();
			playerRoomBean.setCretat_at( CommonUtil.getByTimestamp().getTime() );
			playerRoomBean.setImg( player.getHeadimgurl() );
			playerRoomBean.setIs_ready(0);
			playerRoomBean.setName( player.getNickname() );
			playerRoomBean.setPlayerId( playerId );
			playerRoomBean.setPlayerNum( game_count );
			playerRoomBean.setRoomId("");
			playerRoomBean.setScore(0 );
			playerRoomBean.setType( game_type );
			return playerRoomBean;
		}
		return null;
	}
	
	public static PlayerFriendRequestRes getPlayerFriendRequestRes( PlayerFriendRequest playerFriendRequest ) {
		
		PlayerFriendRequestRes payerFriendRequestRes = new PlayerFriendRequestRes();
		payerFriendRequestRes.setFriend_id( playerFriendRequest.getPlayer_id() );
		Player player = CacheDate.getCacheUserStatus(  playerFriendRequest.getPlayer_id() );
		if( player != null ) {
			payerFriendRequestRes.setImg( player.getHeadimgurl() );
			payerFriendRequestRes.setName( player.getNickname() );
		}
		payerFriendRequestRes.setOnline(0);
		
//		payerFriendRequestRes.setScore(score);
//		payerFriendRequestRes.setTitle(title);
		
		return  payerFriendRequestRes ;
	}
	
	
	public static PlayerFriendRes getPlayerFriendRes( PlayerFriendStatus playerFriendStatus ) {
		
		PlayerFriendRes playerFriendRes = new PlayerFriendRes();
		playerFriendRes.setFriend_id( playerFriendStatus.getSelf_player_id() );
		Player player = CacheDate.getCacheUserStatus(  playerFriendStatus.getSelf_player_id() );
		if( player != null ) {
			playerFriendRes.setImg( player.getHeadimgurl() );
			playerFriendRes.setName( player.getNickname() );
		}
		playerFriendRes.setOnline(0);
		
//		playerFriendRes.setScore(score);
//		playerFriendRes.setTitle(title);
		
		return  playerFriendRes ;
	}
}
