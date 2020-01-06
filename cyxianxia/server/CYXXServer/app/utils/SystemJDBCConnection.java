package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.transaction.SystemException;

import message.SystemError;
import play.Logger;
import play.db.DB;

/**
 * 
 * <p>Title: SystemJDBCConnection.java</p>
 * <p>Description: </p>
 * @author try
 * @date 2017-2-17-下午01:32:56
 * @version 1.0
 */
public class SystemJDBCConnection {

	
	public static void updatePlayerFinance()  throws SystemException {
		
		Connection conn = DB.getConnection();
		PreparedStatement stmt = null; // 数据库的操作对象
		String sql = "update player_finance set number=0";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			Logger.error("updatePlayerTaskWeek---->"+sql);
		} catch (Exception e) {
			e.printStackTrace();
			SystemError.getErrorFlag(SystemError.SYS_ERROR, SystemError.SYS_ERROR_VALUE, e);
			throw new SystemException();
		}
	}

	public static void updatePlayerTaskWeek()  throws SystemException {
		
		Connection conn = DB.getConnection();
		PreparedStatement stmt = null; // 数据库的操作对象
		String sql = "update player_task_week set currnumber=0 , status=0";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			Logger.error("updatePlayerTaskWeek---->"+sql);
		} catch (Exception e) {
			e.printStackTrace();
			SystemError.getErrorFlag(SystemError.SYS_ERROR, SystemError.SYS_ERROR_VALUE, e);
			throw new SystemException();
		}
	}


}