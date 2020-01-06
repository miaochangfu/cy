package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;


/**
 * @author try
 *
 */
@Entity
@Table(name="log_player_coin_status")
public class LogPlayerCoinStatus  extends Model  implements Serializable  ,Cloneable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	
	/** 玩家ID **/
	private  Long playerid;
	
	/** 花费类型 **/
	private int type;
	
	/** 收支类型  1为收入  2为支出 **/
	private int use_type;
	
	/**  花费之前  **/
	private int use_start;
	
	/**  花费多少  **/
	private int use_count;
	
	/**  花费之后  **/
	private int use_end;
	
	/** 创建  **/
	private java.sql.Timestamp created_at;

	public LogPlayerCoinStatus(){}

	public Long getPlayerid() {
		return playerid;
	}


	public void setPlayerid(Long playerid) {
		this.playerid = playerid;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getUse_type() {
		return use_type;
	}


	public void setUse_type(int use_type) {
		this.use_type = use_type;
	}


	public int getUse_start() {
		return use_start;
	}


	public void setUse_start(int use_start) {
		this.use_start = use_start;
	}


	public int getUse_count() {
		return use_count;
	}


	public void setUse_count(int use_count) {
		this.use_count = use_count;
	}


	public int getUse_end() {
		return use_end;
	}


	public void setUse_end(int use_end) {
		this.use_end = use_end;
	}


	public java.sql.Timestamp getCreated_at() {
		return created_at;
	}


	public void setCreated_at(java.sql.Timestamp created_at) {
		this.created_at = created_at;
	}
	
}