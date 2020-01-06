package jobs;

import cache.CacheDate;
import cache.CacheKey;
import cache.RemoteCache;
import models.Player;
import play.Logger;
import play.jobs.Job;
import play.jobs.On;
import play.jobs.OnApplicationStart;
import res.webapi.PlayerRankingRes;
import service.api.WeiXingStatusService;

@On("0 0/10 * * * ?")
@OnApplicationStart
public class SysRangingJob  extends Job  {

	@Override
	public void doJob() {
		
		try {
			
			if( !CacheDate.isInited ) {
				Logger.info("------执行启动job--start----");
				System.out.println("------执行启动job--start----");
			}
			
			CacheDate.startJob();
			RemoteCache.delete( CacheKey.getWeiXinUserLoginAccessTokenCacheKey() );
			CacheDate.getWeiXinUserLoginAccessToken();
			
			if( !CacheDate.isInited ) {
				Logger.info("------执行启动job--end----");
				System.out.println("------执行启动job--end----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PlayerRankingRes getPlayerRankingRes( Player player , int index , int score ) {
		 PlayerRankingRes playerRankingRes = new PlayerRankingRes();
  		 playerRankingRes.setImg( player.getHeadimgurl() );
  		 playerRankingRes.setIndex( index );
  		 playerRankingRes.setName( player.getNickname() );
  		 playerRankingRes.setPlayer_id( player.getId() );
  		 playerRankingRes.setScore( score ); 
  		 
		return playerRankingRes;
	} 

}
