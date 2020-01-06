package jobs;

import config.GameStatus;
import play.jobs.Every;
import play.jobs.Job;
import service.websocket.PlayerWebTcpService;

/**
 * 每2s就处理一次匹配
 */
@Every("2s")
public class PingRoomJob extends Job{


    @Override
    public void doJob() {
        try {
            if (!GameStatus.isCache) {
                return;
            }
            PlayerWebTcpService.pingRoomClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
