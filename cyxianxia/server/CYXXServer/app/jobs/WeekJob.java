package jobs;


import config.GameStatus;
import play.db.jpa.JPA;
import play.jobs.Job;
import play.jobs.On;

@On("59 59 23 ? * Sun")
public class WeekJob extends Job{

	@Override
	public void doJob() {
		
		try {
			
			JPA.em().createNativeQuery("UPDATE `player` set `my_score`=0 ").executeUpdate();
			
			GameStatus.LOG_BATCH_PARAMETERS_LOGGER.info("WeekJob Job");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
