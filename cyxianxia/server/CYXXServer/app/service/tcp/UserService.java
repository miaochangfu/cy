package service.tcp;


import java.beans.Transient;

import models.PlayerStatus;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import utils.CommonUtil;
import utils.SYSRandom;


/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:42:03
 */

public class UserService{
	
	@Transient
	public static PlayerStatus getSavePlayerStatus( String mobile ){
		try {
			 
			System.out.println("getSavePlayerStatus");
			Long id = new Long( SYSRandom.getRandom(10000000) );
			
			JPAPlugin.startTx(false);
			PlayerStatus playerStatus = PlayerStatus.find("id=?", id).first();
			if( playerStatus == null ){
				playerStatus = new PlayerStatus();
				playerStatus.setName(id+"");
				playerStatus.setCoin(0);
				playerStatus.setContinuous_login_count(0);
				playerStatus.setLevel(0);
				playerStatus.setMoney(0);
				playerStatus.setPassword(""+CommonUtil.getByTimestamp());
				playerStatus = playerStatus.save();
			}
			
			if( playerStatus != null ) {
				playerStatus.setName( playerStatus.getName() + "update is ok ");
			}
			playerStatus = playerStatus.save();
			
			playerStatus.delete();
			
			JPAPlugin.closeTx(false);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	
	
	public static PlayerStatus getUpdatePlayerStatus( Long id ){
		try {
			 
//			System.out.println("getUpdatePlayerStatus");
//			
//	        PlayerStatus playerStatus =  PlayerStatus.findById(id);
//	        
//			if( playerStatus != null ){
//				playerStatus.setLogin_datetime(CommonUtil.getByTimestamp());
//				playerStatus.setLevel(playerStatus.getId().intValue());
//				playerStatus.setAccumulate_money(100);
//				playerStatus = playerStatus.save();
//			}
			
			
//			return playerStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static PlayerStatus getDeletePlayerStatus( Long id ){
		try {
			 
//			System.out.println("getDeletePlayerStatus");
//			
//			
//			if( !JPA.em().getTransaction().isActive() ){
//				JPA.em().getTransaction().begin();
//			}
//	        
//	        PlayerStatus playerStatus =  JPA.em().find(PlayerStatus.class, id);
//	        
//			if( playerStatus != null ){
//				JPA.em().remove(playerStatus);
//			}
//			
//			if( JPA.em().getTransaction().isActive() ){
//				JPA.em().getTransaction().commit();
//			}
		} catch (Exception e) {
			e.printStackTrace();
			if( JPA.em().getTransaction().isActive() ){
				JPA.em().getTransaction().setRollbackOnly();
			}
		}
		return null;
	}
	
}
