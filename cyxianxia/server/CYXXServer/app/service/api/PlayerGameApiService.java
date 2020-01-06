package service.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import cache.CacheKey;
import cache.RemoteCache;
import config.GameStatus;
import enu.PlayerCoinTypeEnum;
import enu.PlayerGmaeLevelTypeEnum;
import jobs.SysRangingJob;
import message.APIResponse;
import message.ResultByJson;
import message.SystemError;
import models.LogPlayerCoinStatus;
import models.LogPlayerScoreStatus;
import models.MastLottery;
import models.MastQuestionLevel;
import models.MastShop;
import models.Player;
import models.PlayerFriendStatus;
import models.PlayerGameQuestion;
import models.PlayerShop;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import res.webapi.PlayerGameQuestionItemRes;
import res.webapi.PlayerGameQuestionRes;
import res.webapi.PlayerRankingRes;
import service.bean.PlayerStatusServiceBean;
import utils.CommonUtil;
import utils.SYSRandom;


@Transactional
public class PlayerGameApiService {

	
	
	/**
	 * 用户抽奖初始界面
	 * @return
	 */
	public static ResultByJson getPlayerLotteryInitService( Long playerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
			List<MastLottery> list = MastLottery.findAll();
			if( list != null && list.size() > 0 ) {
				resultByJson.listMastLottery = list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	/**
	 * 用户抽奖
	 * @return
	 */
	public static ResultByJson getPlayerLotteryService( Long playerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		if( player.getLottery_count() <= 0 ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_200_ORDER,SystemError.ERROR_CODE_200_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		
			List<MastLottery> list = MastLottery.findAll();
			if( list != null && list.size() > 0 ) {
				//处理各自的所有概率
				int number = 0;
				for ( int i = 0; i < list.size(); i++ ) {
					//计算总的概率
					number += list.get(i).getProbability();
				}
				int randomNumbr = number;
				int rand = SYSRandom.getRandom(randomNumbr);
				MastLottery mastLottery = null;
				int maxRandomNumber = 0;
				for (int j = 0; j < list.size(); j++) {
					maxRandomNumber += list.get(j).getProbability(); 
					if( rand <= maxRandomNumber && randomNumbr >= rand ){
						mastLottery = list.get(j);
						break;
					}	
				}
				if( mastLottery != null ){
					resultByJson.mastLottery = mastLottery;
					int g_value = mastLottery.getG_value();
					//1为体力  2为铜币  3为复活卡   4 提示卡    5 元宝   6为什么都没得
					switch ( mastLottery.getType() ) {
					case 1:
						player.setStamina( player.getStamina() + g_value );
						break;
					case 2:
						player.setCoin( player.getCoin() + g_value , PlayerCoinTypeEnum.type_6.getValue() );
						break;
					case 3:
						player.setRevive_count( player.getRevive_count() + g_value );
						break;
					case 4:
						player.setTips_count( player.getTips_count() + g_value );
						break;
					case 5:
						player.setMoney( player.getMoney() + g_value );
						break;
					default:
						break;
					}
					player.setLottery_count( player.getLottery_count() - 1 );
					player = player.save();
				}
			}
			
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
	 * 用户上传分数
	 * @return
	 */
	public static ResultByJson getPlayerUpdateScoreService( Long playerId , int score    ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		boolean isUpdate = false;
    		if( score > player.getScore() ) {
    			player.setScore( score ); 
    			isUpdate = true;
    		}
    		if( score > player.getMy_score() ) {
    			player.setMy_score( score ); 
    			isUpdate = true;
    		}
    		if( isUpdate ) {
    			player = player.save();
    		}
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
	 * 用户设置数据
	 * @return
	 */
	public static ResultByJson getPlayerSetInfoService( Long playerId , String music_set , String sound_set ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		boolean isUpdate = false ;
    		if( music_set != null ) {
    			player.setMusic_set(music_set);
    			isUpdate = true;
    		}
    		if( sound_set != null ) {
    			player.setSound_set(sound_set);
    			isUpdate = true;
    		}
    		if( isUpdate ) {
    			player = player.save();
    		}
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
	 * 用户排名数据
	 * @return
	 */
	public static ResultByJson getPlayerPlayerRankingService( Long playerId , int type , int page ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		List<PlayerRankingRes> listRes = new ArrayList<PlayerRankingRes>();
    		if( type == 1 ) {//个人排名
    			int myIndex = 0;
    			Player myPlayer = null;
    			List<Player> myList = Player.find(" my_score>0 order by my_score desc " ).query.getResultList();
    			for ( Player player2 : myList ) {
    				myIndex ++;
					if( player2.getId().equals( playerId ) ) {
						myPlayer = player2;
						break;
					}
				}
    			if( myPlayer != null ) {
    				resultByJson.myPlayerRankingRes = SysRangingJob.getPlayerRankingRes( myPlayer , myIndex, myPlayer.getMy_score() );
    			}
    			
    			List<Player> list = Player.find(" my_score>0 order by my_score desc " ).query.setFirstResult( (page-1) *  GameStatus.pageSize ).setMaxResults(5).getResultList();
    			if( list != null && list.size() > 0 ) {
    				int countAll = (int) Player.count("my_score>0");
    				resultByJson.page = (countAll + GameStatus.pageSize - 1) / GameStatus.pageSize;
    				for (int i = 0; i < list.size(); i++) {
    					int index = ( (page-1) *  GameStatus.pageSize ) + i + 1;
    					listRes.add( SysRangingJob.getPlayerRankingRes( list.get(i), index, list.get(i).getMy_score() ) );
					}
    			}
    		}else if ( type == 2 ) {//世界排名
    			List<Player> list = Player.find(" score>0 order by score desc " ).query.setFirstResult( (page-1) *  GameStatus.pageSize ).setMaxResults(5).getResultList();
    			if( list != null && list.size() > 0 ) {
    				int countAll = (int) Player.count("score>0");
    				resultByJson.page = (countAll + GameStatus.pageSize - 1) / GameStatus.pageSize;
    				for (int i = 0; i < list.size(); i++) {
    					int index = ( (page-1) *  GameStatus.pageSize ) + i + 1;
    					listRes.add( SysRangingJob.getPlayerRankingRes( list.get(i), index, list.get(i).getScore() ) );
					}
    				
    				int myIndex = 0;
        			Player myPlayer = null;
        			List<Player> myList = Player.find(" score>0 order by score desc " ).query.getResultList();
        			for ( Player player2 : myList ) {
        				myIndex ++;
    					if( player2.getId().equals( playerId ) ) {
    						myPlayer = player2;
    						break;
    					}
    				}
        			if( myPlayer != null ) {
        				resultByJson.myPlayerRankingRes = SysRangingJob.getPlayerRankingRes( myPlayer , myIndex, myPlayer.getScore() );
        			}
    				
    			}
			}else if ( type == 3 ) {//好友排名
				List<PlayerFriendStatus> listFriend = PlayerFriendStatus.find(" player_id=?", playerId ).query.getResultList() ;
				if( listFriend != null && listFriend.size() > 0 ) {
//					List<Player> friendPlayerList = new ArrayList<Player>();
//					for ( PlayerFriendStatus playerFriendStatus : listFriend) {
//						Player friendPlayer = CacheDate.getCacheUserStatus(  playerFriendStatus.getSelf_player_id() );
//						if( friendPlayer != null ) {
//							friendPlayerList.add(friendPlayer);
//						}
//					}
//					// 按点击数倒序  
//			        Collections.sort(friendPlayerList, new Comparator<Player>() {  
//			            public int compare(Player arg0, Player arg1) {  
//			                int hits0 = arg0.getScore();  
//			                int hits1 = arg1.getScore();  
//			                if (hits1 > hits0) {  
//			                    return 1;  
//			                } else if (hits1 == hits0) {  
//			                    return 0; 
//			                } else {  
//			                    return -1;  
//			                }  
//			            }  
//			        });
			        
			        Query  query = JPA.em().createQuery("SELECT  pl FROM Player as pl"
			        		+ " WHERE id in(SELECT player_id FROM PlayerFriendStatus AS fr WHERE "
			        		+ "fr.player_id=? OR fr.self_player_id=?) ORDER BY score desc ").setParameter(1, playerId ).setParameter(2, playerId);
			        List<Player> listFriend2 = query.getResultList();
			        System.out.println( listFriend2.size() );
			        int myIndex = 0;
        			Player myPlayer = null;
        			for ( Player player2 : listFriend2 ) {
        				myIndex ++;
    					if( player2.getId().equals( playerId ) ) {
    						myPlayer = player2;
    						break;
    					}
    				}
        			if( myPlayer != null ) {
        				resultByJson.myPlayerRankingRes = SysRangingJob.getPlayerRankingRes( myPlayer , myIndex, myPlayer.getScore() );
        			}
        			
			        if( listFriend2 != null && listFriend2.size() > 0 ) {
			        	resultByJson.page = (listFriend2.size() + GameStatus.pageSize - 1) / GameStatus.pageSize;
	    				for (int i = 0; i < listFriend2.size(); i++) {
	    					int index = ( (page-1) *  GameStatus.pageSize ) + i + 1;
	    					listRes.add( SysRangingJob.getPlayerRankingRes( listFriend2.get(i), index, listFriend2.get(i).getScore() ) );
						}
	    			}
			        
			        
				}
			}
    		
    		resultByJson.playerRankingListRes = listRes;
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}	
	
	
	
	/**
	 * 用户关卡数据
	 * @return
	 */
	public static ResultByJson getPlayerQuestionListService( Long playerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		
    		List<PlayerGameQuestionRes> listRes = new ArrayList<PlayerGameQuestionRes>();
    		for (int i = 1; i <= PlayerGmaeLevelTypeEnum.values().length; i++) {
    			PlayerGameQuestion playerGameQuestion1 = getPlayerGameQuestion( playerId );
    			if( playerGameQuestion1 != null ) {
    				MastQuestionLevel mastQuestionLevel = (MastQuestionLevel) RemoteCache.get( CacheKey.getMastQuestionLevelCacheKey( playerGameQuestion1.getQuestion_id() ));
    				if( mastQuestionLevel == null ) {
    					continue;
    				}
    				PlayerGameQuestionRes playerGameQuestionRes = new PlayerGameQuestionRes();
    				playerGameQuestionRes.setCoin("50~88");
    				playerGameQuestionRes.setFinish_count(0);
    				playerGameQuestionRes.setName( PlayerGmaeLevelTypeEnum.valueOf( mastQuestionLevel.getType()).getLabel() );
    				playerGameQuestionRes.setQuestion_id( mastQuestionLevel.getId() );
    				playerGameQuestionRes.setScore( mastQuestionLevel.getScore() );
    				playerGameQuestionRes.setStamina( mastQuestionLevel.getStamina() );
    				playerGameQuestionRes.setType( mastQuestionLevel.getType()  );
    				listRes.add(playerGameQuestionRes);
        		}
			}
    		resultByJson.listPlayerQuestion = listRes;
    		
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player ); 
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	/**
	 * 用户开始关卡游戏
	 * @return
	 */
	public static ResultByJson getPlayerQuestionSatrtService( Long playerId , int game_type ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		
    		PlayerGameQuestion playerGameQuestion1 = getPlayerGameQuestion( playerId );
    		if( playerGameQuestion1 == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
    		}
    		
    		MastQuestionLevel mastQuestionLevel = (MastQuestionLevel) RemoteCache.get( CacheKey.getMastQuestionLevelCacheKey( playerGameQuestion1.getQuestion_id() ));
			if( mastQuestionLevel == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
			}
			
			PlayerGameQuestionRes playerGameQuestionRes = new PlayerGameQuestionRes();
			playerGameQuestionRes.setCoin("50~88");
			playerGameQuestionRes.setFinish_count(0);
			playerGameQuestionRes.setName( PlayerGmaeLevelTypeEnum.valueOf( mastQuestionLevel.getType()).getLabel() );
			playerGameQuestionRes.setQuestion_id( mastQuestionLevel.getId() );
			playerGameQuestionRes.setScore( mastQuestionLevel.getScore() );
			playerGameQuestionRes.setStamina( mastQuestionLevel.getStamina() );
			playerGameQuestionRes.setType( mastQuestionLevel.getType()  );
    		
			List<PlayerGameQuestionItemRes> listItemRes = new ArrayList<PlayerGameQuestionItemRes>();
			
			PlayerGameQuestionItemRes playerGameQuestionItemRes = new PlayerGameQuestionItemRes();
			playerGameQuestionItemRes.setName( mastQuestionLevel.getWord() );
			playerGameQuestionItemRes.setRandom_text( strRandomText( playerGameQuestionItemRes.getName() ) );
			
			listItemRes.add( playerGameQuestionItemRes );
			
			resultByJson.listItemRes = listItemRes;
			
    		resultByJson.gameQuestionRes = playerGameQuestionRes;
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println( strRandomText("新年快乐") );
	}
	
	public static String strRandomText( String name ) throws Exception {
		char[] strChar = name.toCharArray();
		String resStr = "";
		List<String> list = new ArrayList<String>();
		for ( char c : strChar ) {
			list.add( c+"" );
			System.out.println( c );
		}
		for (int i = 0; i < 2; i++) {
			list.add( getRandomChar()+"" );
		}
		Collections.shuffle(list);
		for ( String string : list ) {
			resStr += string+",";
		}
		return resStr;
	}
	
	
	public static String getRandomChar() throws Exception {
		String str = null; 
		int hightPos, lowPos; // 定义高低位 
		Random random = new Random(); 
		hightPos = (176 + Math.abs(random.nextInt(39)));//获取高位值 
		lowPos = (161 + Math.abs(random.nextInt(93)));//获取低位值 
		byte[] b = new byte[2]; 
		b[0] = (new Integer(hightPos).byteValue()); 
		b[1] = (new Integer(lowPos).byteValue()); 
		str = new String(b, "GBk");//转成中文 
        return str;
    }
	
	
	/**
	 * 用户结算关卡游戏
	 * @return
	 */
	public static ResultByJson getPlayerQuestionGameOverService( Long playerId , int game_type , Long question_id , int is_finish ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		
    		PlayerGameQuestion playerGameQuestion1 = getPlayerGameQuestion( playerId );
    		if( playerGameQuestion1 == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
    		}
    		if( !question_id.equals(playerGameQuestion1.getQuestion_id()) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
    		}
    		
    		MastQuestionLevel mastQuestionLevel = (MastQuestionLevel) RemoteCache.get( CacheKey.getMastQuestionLevelCacheKey( playerGameQuestion1.getQuestion_id() ));
			if( mastQuestionLevel == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
			}
			
    		if( is_finish == 1 ) {//表示完成
    			playerGameQuestion1.setCreate_at( CommonUtil.getByTimestamp() );
    			playerGameQuestion1.setFinish_count( playerGameQuestion1.getFinish_count() + 1 );
    		}
    		MastQuestionLevel nextLevel = (MastQuestionLevel) RemoteCache.get( CacheKey.getMastQuestionLevelCacheKey( new Long( playerGameQuestion1.getQuestion_id()+1 ) ));
			if( nextLevel != null ) {
				playerGameQuestion1.setQuestion_id( nextLevel.getId() );
				
				PlayerGameQuestionRes playerGameQuestionRes = new PlayerGameQuestionRes();
				playerGameQuestionRes.setCoin("50~88");
				playerGameQuestionRes.setFinish_count(0);
				playerGameQuestionRes.setName( PlayerGmaeLevelTypeEnum.valueOf( nextLevel.getType()).getLabel() );
				playerGameQuestionRes.setQuestion_id( nextLevel.getId() );
				playerGameQuestionRes.setScore( nextLevel.getScore() );
				playerGameQuestionRes.setStamina( nextLevel.getStamina() );
				playerGameQuestionRes.setType( nextLevel.getType()  );
	    		
	    		resultByJson.gameQuestionRes = playerGameQuestionRes;
			}
			playerGameQuestion1 = playerGameQuestion1.save();
    		
    		//给用户分数
    		player.setScore( player.getScore() + mastQuestionLevel.getScore() );
    		player.setCoin( player.getCoin() + SYSRandom.getRandomIndex(50, 88) , PlayerCoinTypeEnum.type_2.getValue() );
    		player = player.save();
    		
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player ); 
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	/**
	 * 用户跳过关卡游戏
	 * @return
	 */
	public static ResultByJson getPlayerQuestionSkipService( Long playerId , int game_type , Long question_id ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		
    		PlayerGameQuestion playerGameQuestion1 = getPlayerGameQuestion( playerId );
    		if( playerGameQuestion1 == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
    		}
    		if( !question_id.equals(playerGameQuestion1.getQuestion_id()) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
    		}
    		
    		MastQuestionLevel mastQuestionLevel = (MastQuestionLevel) RemoteCache.get( CacheKey.getMastQuestionLevelCacheKey( playerGameQuestion1.getQuestion_id() ));
			if( mastQuestionLevel == null ) {
				resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
			}
			
    		MastQuestionLevel nextLevel = (MastQuestionLevel) RemoteCache.get( CacheKey.getMastQuestionLevelCacheKey( new Long( playerGameQuestion1.getQuestion_id()+1 ) ));
			if( nextLevel != null ) {
				playerGameQuestion1.setQuestion_id( nextLevel.getId() );
				playerGameQuestion1 = playerGameQuestion1.save();
				
				PlayerGameQuestionRes playerGameQuestionRes = new PlayerGameQuestionRes();
				playerGameQuestionRes.setCoin("50~88");
				playerGameQuestionRes.setFinish_count(0);
				playerGameQuestionRes.setName( PlayerGmaeLevelTypeEnum.valueOf( nextLevel.getType()).getLabel() );
				playerGameQuestionRes.setQuestion_id( nextLevel.getId() );
				playerGameQuestionRes.setScore( nextLevel.getScore() );
				playerGameQuestionRes.setStamina( nextLevel.getStamina() );
				playerGameQuestionRes.setType( nextLevel.getType()  );
	    		
	    		resultByJson.gameQuestionRes = playerGameQuestionRes;
	    		
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	/**
	 * 用户提示
	 * @return
	 */
	/**
	 * @param playerId
	 * @return
	 */
	public static ResultByJson getPlayerQuestionTipsService( Long playerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		if( player.getTips_count() <= 0  ){
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_201_ORDER,SystemError.ERROR_CODE_201_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		player.setTips_count( player.getTips_count() - 1 );
    		player = player.save();
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player ); 
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}	
		return resultByJson;
	}
	
	
	/**
	 * 用户复活
	 * @return
	 */
	public static ResultByJson getPlayerQuestionReviveService( Long playerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		if( player.getRevive_count() <= 0  ){
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_202_ORDER,SystemError.ERROR_CODE_202_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		player.setRevive_count( player.getRevive_count() - 1 );
    		player = player.save();
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player ); 
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	/**
	 * 用户商城数据
	 * @return
	 */
	public static ResultByJson getPlayerMastShopListService( Long playerId , int type ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		List<MastShop> list = null;
    		if( type == 1 ) {
    			list = MastShop.find(" type=? and sex=? ", type , player.getSex() ).query.getResultList() ;
    		}else {
    			list = MastShop.find(" type=? ", type ).query.getResultList() ;
			}
    		if( list != null ) {
    			for ( MastShop mastShop : list ) {
    				PlayerShop playerShop = PlayerShop.find(" player_id=? and mast_shop_id=? ", playerId , mastShop.getId() ).first();
    				if( playerShop != null ) {
    					mastShop.setStatus( playerShop.getStatus() );
    				}
				}
    			resultByJson.listMastShop = list;
    		}
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player ); 
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	/**
	 * 用户购买
	 * @return
	 */
	public static ResultByJson getPlayerBuyMastShopService( Long playerId , Long pkId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		
    		MastShop mastShop = MastShop.findById( pkId );
    		if( mastShop == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
    		}
    		
    		if( player.getCoin() < mastShop.getMoney() ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_203_ORDER,SystemError.ERROR_CODE_203_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		
    		PlayerShop playerShop = PlayerShop.find(" player_id=? and mast_shop_id=? ", playerId , pkId ).first();
    		if( playerShop != null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.ERROR_CODE_204_ORDER,SystemError.ERROR_CODE_204_ORDER_VALUE,null);
    			return resultByJson;
    		}
    		
    		player.setCoin( player.getCoin() - mastShop.getMoney()  ,  PlayerCoinTypeEnum.type_3.getValue() );
    		player = player.save();
    		
    		playerShop = new PlayerShop();
    		playerShop.setCreate_at( CommonUtil.getByTimestamp() );
    		playerShop.setMast_shop_id( mastShop.getId() );
    		playerShop.setPlayer_id( playerId );
    		playerShop.setStatus(1);
    		playerShop.setType( mastShop.getType() );
    		playerShop.save();
    		
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player ); 
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	/**
	 * 用户银币流水数据
	 * @return
	 */
	public static ResultByJson getLogPlayerCoinStatusListService( Long playerId , int page ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		List<LogPlayerCoinStatus> list = LogPlayerCoinStatus.find(" playerid=? ", playerId ).query.setFirstResult( (page-1) *  GameStatus.pageSize ).setMaxResults( GameStatus.pageSize ).getResultList();
    		Long countAll = LogPlayerCoinStatus.count(" playerid=? ", playerId );
    		if( countAll != null ) {
    			resultByJson.page = (countAll.intValue() + GameStatus.pageSize - 1) / GameStatus.pageSize;
    		}
    		if( list != null ) {
    			resultByJson.listLogPlayerCoin = list;
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	/**
	 * 用户积分流水数据
	 * @return
	 */
	public static ResultByJson getLogPlayerScoreStatusListService( Long playerId , int page ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		List<LogPlayerScoreStatus> list = LogPlayerScoreStatus.find(" playerid=? ", playerId ).query.setFirstResult( (page-1) *  GameStatus.pageSize ).setMaxResults( GameStatus.pageSize ).getResultList();
    		Long countAll = LogPlayerScoreStatus.count(" playerid=? ", playerId );
    		if( countAll != null ) {
    			resultByJson.page = (countAll.intValue() + GameStatus.pageSize - 1) / GameStatus.pageSize;
    		}
    		if( list != null ) {
    			resultByJson.listLogPlayerScore = list;
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	/**
	 * 用户设置装备跟宠物
	 * @return
	 */
	public static ResultByJson getSavePlayerItemService( Long playerId , Long  pkId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		Player player =  Player.findById(playerId);
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		
    		MastShop mastShop = MastShop.findById( pkId );
    		if( mastShop == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			return resultByJson;
    		}
    		if( mastShop.getType() == 1 ) {
    			player.setItem_id(pkId);
    		}else {
    			player.setPets_id(pkId);
			}
    		player = player.save();
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player ); 
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	
	public static PlayerGameQuestion getPlayerGameQuestion( Long playerId ) {
		
		PlayerGameQuestion playerGameQuestion = PlayerGameQuestion.find(" player_id =? order by id desc ", playerId ).first();
		if( playerGameQuestion == null ) {
			List<MastQuestionLevel> listMast = (List<MastQuestionLevel>) RemoteCache.get( CacheKey.getMastQuestionLevelAllCacheKey());
			if( listMast == null ) {
				return null;
			}
			playerGameQuestion = new PlayerGameQuestion();
			playerGameQuestion.setCreate_at( CommonUtil.getByTimestamp() );
			playerGameQuestion.setFinish_count(0);
			playerGameQuestion.setPlayer_id( playerId );
			playerGameQuestion.setQuestion_id( listMast.get(0).getId() );
			playerGameQuestion.setType(0);
			playerGameQuestion = playerGameQuestion.save();
		}
		return playerGameQuestion;
	}
}
