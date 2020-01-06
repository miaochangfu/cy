package jobs;

import nio.NettyServer;
import play.jobs.Job;

public class NettyInitJob extends Job {

	@Override
	public void doJob() {
		NettyServer.getServerInstance().bind();
	}

}