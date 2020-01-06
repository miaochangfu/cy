package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * <p>Title: PlayerFriendStatus</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年7月13日-下午2:11:45</p>
 * <p>version 1.0</p>
 * <p>Description: 朋友表</p>
 */
@Entity
@Table(name="player_friend_status")
public class PlayerFriendStatus extends Model  implements Serializable  ,Cloneable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 玩家信息外键 **/
	private Long player_id;
	
	/** 好友ID **/
	private Long self_player_id;
	
	/** 创建  **/
	private java.sql.Timestamp created_at;
	
	
	public PlayerFriendStatus(){}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public Long getSelf_player_id() {
		return self_player_id;
	}

	public void setSelf_player_id(Long self_player_id) {
		this.self_player_id = self_player_id;
	}

	public java.sql.Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(java.sql.Timestamp created_at) {
		this.created_at = created_at;
	}

	
}