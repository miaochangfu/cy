package service.api;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.google.gson.Gson;

import cache.CacheDate;
import cache.CacheKey;
import cache.RemoteCache;
import config.GameStatus;
import message.APIResponse;
import message.ResultByJson;
import message.SystemError;
import models.MastShop;
import models.Player;
import play.db.jpa.Transactional;
import service.bean.PlayerStatusServiceBean;
import utils.CommonUtil;
import weixin.vo.WeiXinMsgRes;
import weixin.vo.WeiXinUserRes;


@Transactional
public class PlayerStatusService {

	/**
	 * 注册
	 * @return
	 */
	public static ResultByJson userInsert( WeiXinUserRes weiXinUserRes , Long selfPlayerId ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
			
    		//根据Openid查找
    		Player player =  Player.find("openid=?", weiXinUserRes.getOpenid() ).first();
    		if( player != null ) {
    			resultByJson.openid = player.getOpenid();
    			resultByJson.playerId = player.id;
    			boolean flag = false;
    			
    			if( GameStatus.isWeiXinGZH ) {
    				if( !player.getHeadimgurl().equals( weiXinUserRes.getAvatarUrl() ) ) {
        				flag = true;
        				player.setHeadimgurl(weiXinUserRes.getAvatarUrl());
        			}
        			if( !player.getNickname().equals(weiXinUserRes.getNickName()) ) {
        				flag = true;
        				player.setNickname(weiXinUserRes.getNickName());
        			}
    			}else {
    				if( weiXinUserRes.getHeadimgurl() != null  && !player.getHeadimgurl().equals( weiXinUserRes.getHeadimgurl() ) ) {
        				flag = true;
        				player.setHeadimgurl(weiXinUserRes.getHeadimgurl());
        			}
        			if(  weiXinUserRes.getNickname() != null  && !player.getNickname().equals(weiXinUserRes.getNickname()) ) {
        				flag = true;
        				player.setNickname(weiXinUserRes.getNickname());
        			}
				}
    			
    			if( flag ) {
    				player.save();
    			}
	    		return resultByJson;
    		}
    		
    		player = new Player();
    		player.setUnionid( weiXinUserRes.getUnionid() );
    		if( GameStatus.isWeiXinGZH ) {
    			player.setNickname(weiXinUserRes.getNickName());
    			player.setHeadimgurl(weiXinUserRes.getAvatarUrl());
    		}else {
    			player.setNickname(weiXinUserRes.getNickname());
    			player.setHeadimgurl(weiXinUserRes.getHeadimgurl());
			}
			player.setOpenid(weiXinUserRes.getOpenid());
			player.setMoney(0);
			player.setScore(0);
			player.setSound_set("");
			player.setMusic_set("");
			player.setStamina( GameStatus.stamina_max );
			
			if( weiXinUserRes.getGender() != null ) {
				player.setSex( Integer.valueOf(weiXinUserRes.getGender()) );
			}
			player.setAddress( (weiXinUserRes.getProvince() == null ?"":weiXinUserRes.getProvince() ) + weiXinUserRes.getCity());
			
    		Timestamp timestamp = CommonUtil.getByTimestamp();
    		/** 注册时间 */
    		player.setCreate_time(timestamp);
			/** 玩家等级  **/
			player.setLevel(1);
    		player = player.save();
    		
    		//返回数据
    		resultByJson.openid = player.getOpenid();
    		resultByJson.playerId = player.id;
    		
    		List<MastShop> list = MastShop.findAll();
    		if( list != null ) {
    			resultByJson.listMastShop = list;
    		}
    		
            return resultByJson;
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
			return resultByJson;
		}
    	
	}

    /**
	 * 登录
	 * @return
	 */
	public static ResultByJson playerUserLogin( String openid , Long playerId  ){
		
		ResultByJson resultByJson = new ResultByJson() ;
		
    	try {
    		
    		if( "".equals( openid ) || "".equals(playerId) ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.PARAMETERS_DATA_ERROR,SystemError.PARAMETERS_DATA_ERROR_VALUE,null);
    			return resultByJson;
    		}
    		Player player =  Player.find("openid=? and id=?", openid , playerId ).first();
    		if( player == null ) {
    			resultByJson.status = APIResponse.STATUS_NG;
    			resultByJson.systemError = SystemError.getErrorFlag(SystemError.USER_NOT_EXIST,SystemError.USER_NOT_EXIST_VALUE,null);
    			return resultByJson;
    		}
    		//用户数据
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player );
    		
    		resultByJson.openid = player.getOpenid();
    		
    		List<MastShop> list = MastShop.findAll();
    		if( list != null ) {
    			resultByJson.listMastShop = list;
    		}
    		
    		CacheDate.getCacheUserStatus( player.id );
			
		} catch (Exception e) {
			e.printStackTrace();
			resultByJson.status = APIResponse.STATUS_NG;
			resultByJson.systemError = SystemError.getErrorFlag(SystemError.SYS_ERROR,SystemError.SYS_ERROR_VALUE,null);
		}
		return resultByJson;
	}
	
	
	/**
	 * 0表示消耗了体力  1 表示没有恢复的体力点数  2  体力不足
	 * @return
	 */
	public static Player getMagicRefresh( Player player , int magicCost ) {
		
		int currMagicEnergy = 0;
		
		try {
			
			//玩家当前的体力
			currMagicEnergy = player.getStamina();
			//最大的体力
			int maxMagicEnergy = GameStatus.stamina_max;
			//最后消耗体力时间到现在当前时间间隔秒数
			int durationTime = (int) ((CommonUtil.getByTimestamp().getTime() - player.getLast_magic_at().getTime()) / 1000);
			//计算出恢复的点数
			int huifuyaoli = durationTime / (GameStatus.stamina_time*60);
			if (huifuyaoli < 0) {
				return player;
			}
			//计算回复以后的点数
			currMagicEnergy += huifuyaoli;
			//判断是否达到max的体力
			if (currMagicEnergy >= maxMagicEnergy) {
				currMagicEnergy = maxMagicEnergy;
			}
			//消耗的点数如果大于当前剩余的点数 表示体力值不够
			if (magicCost > currMagicEnergy) {
				return player;
			}
			
			//当前的体力减去花费的体力
			currMagicEnergy = currMagicEnergy - magicCost;
			//修改最后消耗体力的时间
			player.setLast_magic_at(CommonUtil.getByTimestamp());
			if (currMagicEnergy <= 0) {
				player.setStamina(0);
			} else {
				//修改消耗以后的体力值
				player.setStamina(currMagicEnergy);
			}
			player = player.save();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}
	
	
	public static WeiXinMsgRes getWeiXinMsgRes( String mesage ) {
		try {
			
			String accessToken = (String) RemoteCache.get( CacheKey.getWeiXinUserLoginAccessTokenCacheKey() );
    		if( accessToken == null ) {
    			return null;
    		}
    		Connection con = Jsoup.connect("https://api.weixin.qq.com/wxa/msg_sec_check?access_token="+accessToken).ignoreContentType(true).method(Connection.Method.POST);
	    	con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36"); 
	    	con.header("Content-Type", "multipart/form-data");
	    	Map<String, String> data = new HashMap<String, String>();
            data.put("content", mesage);
            String toString = new Gson().toJson(data).toString();
            con.requestBody(toString);
        	Response doc= con.execute(); 
        	WeiXinMsgRes weiXinMsgRes = new Gson().fromJson(doc.body(), WeiXinMsgRes.class);
        	return weiXinMsgRes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
