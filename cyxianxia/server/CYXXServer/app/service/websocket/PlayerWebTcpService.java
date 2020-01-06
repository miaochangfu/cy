package service.websocket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cache.CacheKey;
import cache.RemoteCache;
import enu.GameMethodEnum;
import enu.PlayerCoinTypeEnum;
import message.APIResponse;
import message.ChatRoom;
import message.RequestParameters;
import message.ResultByJson;
import message.SystemError;
import models.MastQuestionLevel;
import models.Player;
import play.Logger;
import play.mvc.Http;
import res.webapi.PlayerGameOverRes;
import res.webapi.PlayerGameQuestionItemRes;
import service.api.PlayerGameApiService;
import service.bean.PlayerStatusServiceBean;
import utils.CommonUtil;
import utils.SYSRandom;

public class PlayerWebTcpService {

	
	/**
	 * playerId
	 * @return
	 */
	public synchronized ResultByJson gameCall( RequestParameters json ){
		
		ResultByJson resultByJson = new ResultByJson( GameMethodEnum.method_game_call.getLabel() ) ;
		
    	try {
    		
    		if( json == null || json.playerId == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		PlayerRoomBean playerRoomBean = (PlayerRoomBean) RemoteCache.get(CacheKey.getPlayerRoomBeanCacheKey( json.playerId ) ); 
    		if( playerRoomBean == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		SystemRoomBean systemRoomBean = (SystemRoomBean) RemoteCache.get( CacheKey.getSystemRoomBeanCacheKey( json.roomId )  );
    		if( systemRoomBean == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		List<Long> longs = new ArrayList<Long>();
    		for ( PlayerRoomBean sysRoomBean : systemRoomBean.getPlayerRooms() ) {
				if( sysRoomBean.getPlayerId().equals(json.playerId) ) {
					sysRoomBean.setScore( sysRoomBean.getScore() + 1 );
					sysRoomBean.setIs_dati(1);
				}else {
					longs.add( sysRoomBean.getPlayerId() );
				}
			}
    		RemoteCache.safeSet( CacheKey.getSystemRoomBeanCacheKey( json.roomId ) , systemRoomBean, null);
    		//通知对手说已答题
			pushGameSatrt( longs , 4 , json.playerId , null );
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
    	
	}
	
	
	
	
	/**
	 * playerId
	 * @return
	 */
	public ResultByJson gameExit( RequestParameters json ){
		
		ResultByJson resultByJson = new ResultByJson( GameMethodEnum.method_game_leave.getLabel() ) ;
		
    	try {
    		
    		if( json == null || json.playerId == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		PlayerRoomBean playerRoomBean = (PlayerRoomBean) RemoteCache.get(CacheKey.getPlayerRoomBeanCacheKey( json.playerId ) ); 
    		if( playerRoomBean != null ) {
    			//处理用户list
    			List<PlayerRoomBean> roomPlayerList = getSysTemRoomBeanList( playerRoomBean.getType() );
    			if( roomPlayerList != null && roomPlayerList.size() > 0 ) {
    				for (int i = 0; i < roomPlayerList.size(); i++) {
    					if( roomPlayerList.get(i).getPlayerId().equals( playerRoomBean.getPlayerId() ) ) {
							roomPlayerList.remove( roomPlayerList.get(i) );
							i--;
						}
					}
    				setSysTemRoomBeanList( roomPlayerList , playerRoomBean.getType() );
    			}
    			List<SystemRoomBean> listSystem = (List<SystemRoomBean>) RemoteCache.get( CacheKey.getSystemRoomBeanAllCacheKey( playerRoomBean.getType() ) );
    			if( listSystem != null && listSystem.size() > 0 ) {
    				boolean isUpdate = false;
    				for ( SystemRoomBean systemRoomBean : listSystem ) {
						if( systemRoomBean.getStart_at() != null ) {//表示已开始
							continue;
						}
						List<PlayerRoomBean> playerRooms = systemRoomBean.getPlayerRooms();
						if( playerRooms != null ) {
							for (int i = 0; i < playerRooms.size(); i++) {
								if( playerRooms.get(i).getPlayerId().equals(json.playerId) ) {
									playerRooms.remove( playerRooms.get(i) );
									i--;
								}
							}
							List<Long> longs = new ArrayList<Long>();
							if( playerRooms != null && playerRooms.size() > 0 ) {
								for (int i = 0; i < playerRooms.size(); i++) {
									longs.add( playerRooms.get(i).getPlayerId()  );
								}
								//通知对手说已经离开
								pushGameSatrt( longs , 3 , json.playerId , null );
							}
						}
					}
    				if( isUpdate ) {
    					RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( playerRoomBean.getType() ), listSystem, null);
    				}
    			}
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
    	
	}
	
	
	/**
	 * playerId
	 * @return
	 */
	public ResultByJson gameInit( RequestParameters json ){
		
		ResultByJson resultByJson = new ResultByJson( GameMethodEnum.method_game_init.getLabel() ) ;
		
    	try {
    		
    		if( json == null || json.playerId == null || json.game_count == null || json.game_type == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		Player player =  Player.findById(json.playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		List<PlayerRoomBean> roomPlayerList = getSysTemRoomBeanList( json.game_type );
    		if( roomPlayerList == null ) {
    			roomPlayerList = new ArrayList<PlayerRoomBean>();
    		}
    		gameExit( json );
    		
    		PlayerRoomBean playerRoomBean = new PlayerRoomBean();
    		playerRoomBean.setCretat_at( CommonUtil.getByTimestamp().getTime() );
    		playerRoomBean.setImg( player.getHeadimgurl() );
    		playerRoomBean.setIs_ready(1);
    		playerRoomBean.setName( player.getNickname() );
    		playerRoomBean.setPlayerId( json.playerId );
    		playerRoomBean.setPlayerNum( json.game_count );
    		playerRoomBean.setRoomId("");
    		playerRoomBean.setScore(0 );
    		playerRoomBean.setType( json.game_type );
    		
    		RemoteCache.safeSet(CacheKey.getPlayerRoomBeanCacheKey( json.playerId ), playerRoomBean, null); 
    			
    		roomPlayerList.add( playerRoomBean );
    		
    		setSysTemRoomBeanList( roomPlayerList , json.game_type );
    		//用户数据
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player );
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
    	
	}
	
	
	/**
	 * 获取系统匹配房间信息
	 * @return
	 */
	public static synchronized List<PlayerRoomBean>  getSysTemRoomBeanList( int type ) {
		return (List<PlayerRoomBean>) RemoteCache.get(CacheKey.getPlayerRoomBeanListCacheKey( type ));
	}
	
	/**
	 * 获取系统匹配房间信息
	 * @return
	 */
	public static synchronized boolean setSysTemRoomBeanList( List<PlayerRoomBean> list , int type ) {
		RemoteCache.safeSet(CacheKey.getPlayerRoomBeanListCacheKey( type ), list , null );
		return true;
	}
	
	
	public static SystemRoomBean getNewSystemRoomBean( PlayerRoomBean playerRoomBean ) {
		
		SystemRoomBean systemRoomBean = new SystemRoomBean();
		systemRoomBean.getPlayerRooms().add( playerRoomBean );
		systemRoomBean.setAddNeedMoney(0);
		systemRoomBean.setCount_down(0);
		systemRoomBean.setCreatePlayerId( playerRoomBean.getPlayerId() );
		systemRoomBean.setCretat_at( playerRoomBean.getCretat_at() );
		systemRoomBean.setPlayerNum( playerRoomBean.getPlayerNum() );
		systemRoomBean.setRoomId("");
		systemRoomBean.setRoomMatchingTime( CommonUtil.getByTimestamp().getTime() + 1000 * 60  );
		systemRoomBean.setType( playerRoomBean.getType() );
//		systemRoomBean.setStart_at(null);
		return systemRoomBean;
	}
	
	
	/** ping房间  **/
	public static boolean pingRoomClose() {
		
		Long newTime = CommonUtil.getByTimestamp().getTime();
		
		for (int gameType = 1; gameType < 3; gameType++) {
			List<PlayerRoomBean> roomPlayerList = getSysTemRoomBeanList( gameType );
			List<SystemRoomBean> listSystem = (List<SystemRoomBean>) RemoteCache.get( CacheKey.getSystemRoomBeanAllCacheKey( gameType ) );
			if( listSystem == null || listSystem.size() <= 0 ) {
				listSystem = new ArrayList<SystemRoomBean>();
				if( roomPlayerList != null && roomPlayerList.size() > 0 ) {
					PlayerRoomBean playerRoomBean = roomPlayerList.get(0);
					//创建房间
					listSystem.add( getNewSystemRoomBean( playerRoomBean ) );
					//删除排队队列
					roomPlayerList.remove( playerRoomBean );
					//保存数据到缓存
					RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( gameType ), listSystem, null);
					//修改保存用户排队数据
					setSysTemRoomBeanList( roomPlayerList , gameType );
				}
			}else {
				Logger.info("listSystem-->"+listSystem.size() );
				if( listSystem.size() > 0 && ( roomPlayerList == null || roomPlayerList.size() < 0) ) {
					//表示有空房间，没得人
					for ( SystemRoomBean systemRoomBean : listSystem ) {//循环房间
						if( systemRoomBean.getStart_at() == null && ( systemRoomBean.getPlayerRooms() == null || systemRoomBean.getPlayerRooms().size() <= 0) ) {
							//删除房间List数据
							listSystem.remove( systemRoomBean );
							//根据房间类型进行保存
							RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( gameType ), listSystem, null);
							Logger.info("---------delete listSystem 1----------------");
							break;
						}
					}
				}
			}
			
			if( roomPlayerList != null && roomPlayerList.size() > 0 ) {
				Logger.info( "roomPlayerList-->"+roomPlayerList.size() );
				System.out.println( "roomPlayerList-->"+roomPlayerList.size() );
				for ( SystemRoomBean systemRoomBean : listSystem ) {//循环房间
					if( roomPlayerList != null && roomPlayerList.size() > 0 ) {
						boolean isUpdate = false;
						for (int i = 0; i < roomPlayerList.size(); i++) { //循环排队的人
							PlayerRoomBean playerRoomBean = roomPlayerList.get(i);
							Long myPlayerId = null;
							//判断人数   战斗模式是不是一样
							if( playerRoomBean.getType() == systemRoomBean.getType() 
									&& systemRoomBean.getPlayerNum() == playerRoomBean.getPlayerNum() ) {
								systemRoomBean.getPlayerRooms().add(playerRoomBean);
								roomPlayerList.remove( playerRoomBean );
								isUpdate = true;
								myPlayerId = playerRoomBean.getPlayerId();
								
								//通知有人加入战斗
								List<Long> listLong = new ArrayList<Long>();
								for ( PlayerRoomBean pushBeanId : systemRoomBean.getPlayerRooms() ) {
									if( pushBeanId.getPlayerId().equals(myPlayerId) ) {//排除自己
										continue;
									}
									listLong.add( pushBeanId.getPlayerId() );
								}
								pushGameSatrt( listLong , 1 , myPlayerId , null );
								//推送自己那些人在房间里。
								ResultByJson resultByJson = new ResultByJson( GameMethodEnum.method_game_ready.getLabel() ) ;
								resultByJson.systemRoomBean = systemRoomBean;
								ChatRoom.sendMessage( myPlayerId , resultByJson  );
								
								if( systemRoomBean.getPlayerRooms().size() >= systemRoomBean.getPlayerNum() ) {
									//人数够了 开始战斗
									systemRoomBean.setCount_down(20);
									systemRoomBean.setStart_at( newTime );
									systemRoomBean.setQuestionItems( getPVPQuestionItem() );
									systemRoomBean.setRoomId( CommonUtil.getCharString( new Long( SYSRandom.getRandom(1000000) ) ) );
									
									setSysTemRoomBeanList( roomPlayerList , gameType );
									//根据房间ID保存房间信息
									RemoteCache.safeSet(CacheKey.getSystemRoomBeanCacheKey( systemRoomBean.getRoomId() ) , systemRoomBean , null );
									
									for (Long long1 : listLong) {
										PlayerRoomBean roomBean = (PlayerRoomBean) RemoteCache.get( CacheKey.getPlayerRoomBeanCacheKey( long1 ) );
										if( roomBean != null ) {
											roomBean.setRoomId( systemRoomBean.getRoomId() );
											RemoteCache.safeSet(CacheKey.getPlayerRoomBeanCacheKey( long1 ), roomBean, null );
										}
									}
									listLong.add( myPlayerId );
									pushGameSatrt( listLong , 2 , null , systemRoomBean.getRoomId() );
									break;
								}
							}else if ( playerRoomBean.getType() == systemRoomBean.getType() 
									&& systemRoomBean.getPlayerNum() != playerRoomBean.getPlayerNum() ) {//模式一样 人数不一样情况
								//创建房间
								listSystem.add( getNewSystemRoomBean( playerRoomBean ) );
								//删除排队队列
								roomPlayerList.remove( playerRoomBean );
								//保存数据到缓存
								RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( gameType ), listSystem, null);
								//修改保存用户排队数据
								setSysTemRoomBeanList( roomPlayerList , gameType );
							}
						}
						if( isUpdate ) {
							RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( gameType ), listSystem, null);
						}
					}
				}
			}
			
			if( listSystem != null && listSystem.size() > 0 ) {
				for ( SystemRoomBean systemRoomBean : listSystem ) {//循环房间
					if( systemRoomBean.getStart_at() != null ) {//已开始
						//处理倒计时
						if( newTime - systemRoomBean.getStart_at() >= (systemRoomBean.getCount_down() * 1000)  ) {
							//时间到处理结果
							boolean isOver = true;
							List<Long> listLong = new ArrayList<Long>();
							
							for ( PlayerRoomBean playerRoomBean : systemRoomBean.getPlayerRooms() ) {
								listLong.add( playerRoomBean.getPlayerId() );
								if( playerRoomBean.getIs_dati() == 1 ) {
									isOver = false;
								}
							}
							if( isOver ) {
								//结算
								ResultByJson resultByJson = new ResultByJson( GameMethodEnum.method_game_over.getLabel()  ) ;
								resultByJson.listGameOverRes = getPlayerGameOverRes( systemRoomBean.getPlayerRooms() );
								for ( Long long1 : listLong ) {
									ChatRoom.sendMessage( long1 , resultByJson  );
								}
								//删除房间编号对应的房间数据
								RemoteCache.delete( CacheKey.getSystemRoomBeanCacheKey( systemRoomBean.getRoomId() )  );
								
								//删除个人房间数据
								for ( PlayerRoomBean playerRoomBean : systemRoomBean.getPlayerRooms() ) {
									RemoteCache.delete(CacheKey.getPlayerRoomBeanCacheKey( playerRoomBean.getPlayerId() )); 
								}
								//删除房间List数据
								listSystem.remove( systemRoomBean );
								//根据房间类型进行保存
								RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( gameType ), listSystem, null);
								break;
							}else {
								//设置没有答题状态
								for ( PlayerRoomBean playerRoomBean : systemRoomBean.getPlayerRooms() ) {
									playerRoomBean.setIs_dati(0);
								}
								//设置下一题
								systemRoomBean.setStart_at( newTime );
								systemRoomBean.setQuestionItems( getPVPQuestionItem() );
								
								//根据房间类型进行保存
								RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( gameType ), listSystem, null);
								
								//推送题
								ResultByJson resultByJson = new ResultByJson( GameMethodEnum.method_game_add_question.getLabel()  ) ;
								resultByJson.questionItems = systemRoomBean.getQuestionItems();
								for ( Long long1 : listLong ) {
									ChatRoom.sendMessage( long1 , resultByJson  );
								}
							}
						}
					}else {
						//处理房间数据
						if( systemRoomBean.getPlayerRooms()  != null ) {
							for (int i = 0; i < systemRoomBean.getPlayerRooms().size(); i++) {
								Long playerId = systemRoomBean.getPlayerRooms().get(i).getPlayerId();
								Http.Outbound outbound = ChatRoom.map.get(playerId);
								if( outbound == null || ChatRoom.map.get(playerId) == null ) {
									systemRoomBean.getPlayerRooms().remove(i);
									i--;
								}
							}
							if( systemRoomBean.getPlayerRooms().size() <= 0 ) {
								//删除房间List数据
								listSystem.remove( systemRoomBean );
								//根据房间类型进行保存
								RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( gameType ), listSystem, null);
								Logger.info("---------delete listSystem 2----------------");
								break;
							}
						}
					}
				}
			}else {
				listSystem = new ArrayList<SystemRoomBean>();
				//保存数据到缓存
				RemoteCache.safeSet(CacheKey.getSystemRoomBeanAllCacheKey( gameType ), listSystem, null);
			}
			
			
		}
		return false;
	}
	
	public static List<PlayerGameOverRes> getPlayerGameOverRes( List<PlayerRoomBean> playerRooms ){
		List<PlayerGameOverRes> list = new ArrayList<PlayerGameOverRes>();
		 // 按点击数倒序  
        Collections.sort( playerRooms , new Comparator<PlayerRoomBean>() {  
            public int compare(PlayerRoomBean arg0, PlayerRoomBean arg1) {  
                int hits0 = arg0.getScore();  
                int hits1 = arg1.getScore();  
                if (hits1 > hits0) {  
                    return 1;  
                } else if (hits1 == hits0) {  
                    return 0;  
                } else {  
                    return -1;  
                }  
            }  
        }); 
        int gameType = 1;
        if( playerRooms.size() == 4 ) {
        	gameType = 1;
        }else if ( playerRooms.size() == 6 ) {
        	gameType = 2;
		}else if ( playerRooms.size() == 8 ) {
			gameType = 3;
		}
        int index = 1;
		for ( PlayerRoomBean playerRoomBean : playerRooms ) {
			PlayerGameOverRes playerGameOverRes = new PlayerGameOverRes();
			int coin = 0;
			int score = 0;
			Player player = Player.findById( playerRoomBean.getPlayerId() );
			if( gameType == 1 && index == 1 ) {
				coin = 40;
				score = 10;
				player.setCoin( player.getCoin() + coin , PlayerCoinTypeEnum.type_4.getValue() );
				player.setScore( player.getScore() + score );
				player.save();
			}
			if( gameType == 2 && ( index == 1 || index == 2 ) ) {
				if( index == 1 ) {
					coin = 40;
					score = 15;
				}else if ( index == 2 ) {
					coin = 20;
					score = 10;
				}
				player.setCoin( player.getCoin() + coin , PlayerCoinTypeEnum.type_4.getValue() );
				player.setScore( player.getScore() + score );
				player.save();
			}
			
			if( gameType == 3 && ( index == 1 || index == 2  || index == 3 ) ) {
				if( index == 1 ) {
					coin = 40;
					score = 20;
				}else if ( index == 2 ) {
					coin = 25;
					score = 15;
				}else if ( index == 3 ) {
					coin = 15;
					score = 10;
				}
				player.setCoin( player.getCoin() + coin , PlayerCoinTypeEnum.type_4.getValue() );
				player.setScore( player.getScore() + score );
				player.save();
			}
			playerGameOverRes.setCoin(coin);
			playerGameOverRes.setScore(score);
			playerGameOverRes.setIndex(index);
			playerGameOverRes.setPlayerId( playerRoomBean.getPlayerId() );
			playerGameOverRes.setMoney(0);
			playerGameOverRes.setName( player.getNickname() );
			list.add( playerGameOverRes );
			index ++;
		}
		return list;
	}
	
	
	
	public static List<PlayerGameQuestionItemRes> getPVPQuestionItem(){
		
		List<PlayerGameQuestionItemRes> listRes = new ArrayList<PlayerGameQuestionItemRes>();
		
		List<MastQuestionLevel> list =  (List<MastQuestionLevel>) RemoteCache.get( CacheKey.getMastQuestionLevelAllCacheKey() );
		if( list != null ) {
			 Collections.shuffle(list);
			 PlayerGameQuestionItemRes gameQuestionItemRes = new PlayerGameQuestionItemRes();
			 gameQuestionItemRes.setName( list.get(0).getWord() );
			 try {
				gameQuestionItemRes.setRandom_text( PlayerGameApiService.strRandomText( gameQuestionItemRes.getName() ) );
			} catch (Exception e) {
				e.printStackTrace();
			}
			 listRes.add( gameQuestionItemRes ); 
			 return listRes;
		}
		return null;
	}
	/**
	 * 用户闯关
	 * @return
	 */
	public ResultByJson playerGameLevelInit( RequestParameters json ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( json == null || json.playerId == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		gameExit(json);
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	/**
	 * 用户聊天
	 * @return
	 */
	public ResultByJson playerGameSayMeaage( RequestParameters json ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( json == null || json.playerId == null   || json.message == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		
    		PlayerRoomBean playerRoom = (PlayerRoomBean) RemoteCache.get(CacheKey.getPlayerRoomBeanCacheKey( json.playerId ) ); 
    		if( playerRoom == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		
    		SystemRoomBean systemRoomBean = (SystemRoomBean) RemoteCache.get(CacheKey.getSystemRoomBeanCacheKey( playerRoom.getRoomId() ) );
    		if( systemRoomBean != null ) {
    			for (PlayerRoomBean playerRoomBean : systemRoomBean.getPlayerRooms() ) {
    				//推送题
					ResultByJson resultByJsonPush = new ResultByJson( GameMethodEnum.method_game_meaasge.getLabel()  ) ;
					resultByJsonPush.message = json.message;
					resultByJsonPush.playerId = json.playerId;
					ChatRoom.sendMessage( playerRoomBean.getPlayerId() , resultByJsonPush  );
				}
    		}
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	public static boolean pushGameSatrt( List<Long> pushPlayers , int type , Long playerId , String roomId ) {
		String method = GameMethodEnum.method_game_join.getLabel();
		if( type == 1 ) {//加入房间 
			method = GameMethodEnum.method_game_join.getLabel();
		}else if ( type == 2) {//开始战斗
			method = GameMethodEnum.method_game_start.getLabel();
		}else if ( type == 3 ) {//离开房间 
			method = GameMethodEnum.method_game_leave.getLabel();
		}else if ( type == 4 ) {//已答题 
			method = GameMethodEnum.method_game_call.getLabel();
		}
		PlayerRoomBean roomBean = null;
		if( playerId != null ) {
			roomBean = (PlayerRoomBean) RemoteCache.get( CacheKey.getPlayerRoomBeanCacheKey( playerId ) ); 
		}
		ResultByJson resultByJson = new ResultByJson( method ) ;
		for ( Long long1 : pushPlayers) {
			if( type == 1 ) {//加入房间 
				if( roomBean != null ) {
					resultByJson.roomBean = roomBean; 
				}
				resultByJson.playerId = playerId;
			}else if ( type == 2) {//开始战斗
				SystemRoomBean systemRoomBean = (SystemRoomBean) RemoteCache.get(CacheKey.getSystemRoomBeanCacheKey( roomId )  );
				if( systemRoomBean != null ) {
					resultByJson.systemRoomBean = systemRoomBean;
				}
			}else if ( type == 3 ) {//离开房间 
				resultByJson.playerId = playerId;
			}else if ( type == 4 ) {//已答题
				resultByJson.playerId = playerId;
			}
			ChatRoom.sendMessage( long1 , resultByJson  );
		}
		return false;
	}
	
	
}
