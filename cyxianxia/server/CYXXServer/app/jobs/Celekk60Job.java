package jobs;

import config.GameStatus;
import play.Logger;
import play.jobs.Job;
import play.jobs.On;

/**
 * @author:try
 * @version:1.0
 * @Description:每60分钟处理
 * @Date:2017年1月4日下午11:42:15
 */
@On("0 0/60 * * * ?")
public class Celekk60Job  extends Job {

	@Override
	public void doJob() {
		
		try {
			
			if( !GameStatus.isInitCache ){
				return;
			}
			
			Logger.info("======Celekk60Job=====");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
