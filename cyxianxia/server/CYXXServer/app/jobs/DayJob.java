package jobs;

import play.db.jpa.JPA;
import play.jobs.Job;
import play.jobs.On;

@On("0 0 0 ? * *")
public class DayJob  extends Job{

	
	@Override
	public void doJob(){
		
		try {
			JPA.em().createNativeQuery("UPDATE `player` set `lottery_count`=? ").setParameter(1, 3 ).executeUpdate();
			
//			//修改每天排名的数据
//			JPA.em().createNativeQuery("UPDATE `player_day_ranking` set `type`=`type`+1").executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
