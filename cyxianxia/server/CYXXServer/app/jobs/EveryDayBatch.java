package jobs;

import config.GameStatus;
import play.db.jpa.JPA;
import play.jobs.Job;
import play.jobs.On;

/**
 * @author:try
 * @version:1.0
 * @Description:每天0点job
 * @Date:2017年1月4日下午11:42:34
 */
@On("0 0 0 ? * *")
public class EveryDayBatch extends Job{
	
   @Override
   public void doJob(){
	   
		//判断配置 如果为false就直接return
	    if( !GameStatus.isInitCache ){
			return;
		}
	    try {
	    	JPA.em().createNativeQuery("UPDATE `player` set `my_score`=0 ").executeUpdate();
	    	GameStatus.LOG_BATCH_PARAMETERS_LOGGER.info("EveryDayBatch Job");
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
	
}