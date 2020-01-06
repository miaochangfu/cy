package service.bean;

import java.io.Serializable;

import cache.CacheKey;
import cache.RemoteCache;
import config.GameStatus;
import models.Player;
import models.PlayerGameQuestion;
import res.webapi.PlayerRes;
import service.api.PlayerGameApiService;
import utils.CommonUtil;

public class PlayerStatusServiceBean implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	public static PlayerRes userLoginRes( Player player ) throws Exception {
		
		PlayerRes playerRes = new PlayerRes();
		if( player == null ) {
			return playerRes;
		}
		playerRes.id = player.id;
		playerRes.setHeadimgurl(player.getHeadimgurl()  );
		playerRes.setNickname(player.getNickname()  );
		playerRes.setMoney( player.getMoney() );
		playerRes.setNickname( player.getNickname() );
		playerRes.setOpenid( player.getOpenid() );
		playerRes.setScore( player.getScore() );
		playerRes.setTelephone( player.getTelephone() );
		playerRes.setStamina( player.getStamina() );
		playerRes.setCoin( player.getCoin() );
		playerRes.setTips_count( player.getTips_count() );
		playerRes.setRevive_count( player.getRevive_count() );
		playerRes.setLottery_count( player.getLottery_count() );
		playerRes.setSound_set( player.getSound_set() );
		playerRes.setMusic_set( player.getMusic_set() );
		playerRes.setSex( player.getSex());
		playerRes.setPets_id( player.getPets_id() );
		playerRes.setItem_id( player.getItem_id() );
		
		PlayerGameQuestion playerGameQuestion1 = PlayerGameApiService.getPlayerGameQuestion( player.id );
		if( playerGameQuestion1 != null ) {
			playerRes.setQuestion_id( playerGameQuestion1.getQuestion_id() );
		}
		
		return playerRes;
	}

	

	/**
	 * 生成用户OauthToken
	 * @return
	 */
	public static String setUserOauthToken( Long playerId ){
 	
		try {
			
			String userOauthToken = CommonUtil.encodePassword( GameStatus.api_md5_key +CommonUtil.getByTimestamp().toString()+ playerId+"" );
			//保存到缓存
			RemoteCache.set( CacheKey.getUserOauthTokenCacheKey( playerId ), userOauthToken );
			return userOauthToken;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 *  得到用户的key
	 * @return
	 */
	public static String getUserOauthToken( Long playerId ){
 	
		try {
			String userOauthToken = (String) RemoteCache.get(CacheKey.getUserOauthTokenCacheKey( playerId ));
			if( userOauthToken == null ){
				return null;
			}
			return userOauthToken;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
