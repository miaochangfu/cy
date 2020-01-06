package service.api;

import enu.PlayerCoinTypeEnum;
import models.LogPlayerCoinStatus;
import models.LogPlayerScoreStatus;
import play.db.jpa.Transactional;
import utils.CommonUtil;


/**
 * @author try
 */
@Transactional
public class PlayerLogService {
	
	public static boolean saveLogPlayerCoinStatus ( Long playerId , int type ,  int useMoney , int useStart  , int useEnd , int useType ){
		
		try {
			
			LogPlayerCoinStatus logPlayerCoinStatus = new LogPlayerCoinStatus();
			logPlayerCoinStatus.setCreated_at(CommonUtil.getByTimestamp());
			logPlayerCoinStatus.setPlayerid(playerId);
			PlayerCoinTypeEnum playerCoinTypeEnum = PlayerCoinTypeEnum.valueOf( type );
			if( playerCoinTypeEnum != null ) {
				logPlayerCoinStatus.setType( playerCoinTypeEnum.getValue() );
			}else {
				logPlayerCoinStatus.setType( 1 );
			}
			logPlayerCoinStatus.setUse_type(useType);
			logPlayerCoinStatus.setUse_count(useMoney);
			logPlayerCoinStatus.setUse_start(useStart);
			logPlayerCoinStatus.setUse_end(useEnd);
			logPlayerCoinStatus.save();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public static boolean saveLogPlayerScoreStatus ( Long playerId , int type ,  int useMoney , int useStart  , int useEnd , int useType ){
		
		try {
			
			LogPlayerScoreStatus logPlayerCoinStatus = new LogPlayerScoreStatus();
			logPlayerCoinStatus.setCreated_at(CommonUtil.getByTimestamp());
			logPlayerCoinStatus.setPlayerid(playerId);
			logPlayerCoinStatus.setType( type );
			logPlayerCoinStatus.setUse_type(useType);
			logPlayerCoinStatus.setUse_count(useMoney);
			logPlayerCoinStatus.setUse_start(useStart);
			logPlayerCoinStatus.setUse_end(useEnd);
			logPlayerCoinStatus.save();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



}
