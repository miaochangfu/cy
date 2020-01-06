package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * <p>Title: PlayerFriendRequest</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年7月13日-下午2:11:36</p>
 * <p>version 1.0</p>
 * <p>Description: 交友请求</p>
 */
@Entity
@Table(name="player_friend_request_status")
public class PlayerFriendRequest  extends Model  implements Serializable  ,Cloneable {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/** 邀请人 **/
	private Long player_id;
	
	/** 邀请谁   **/
	private Long self_player_id;
	
	/** 创建时间  **/
	private java.sql.Timestamp created_at;
	
	/** 时间时间  **/
	private java.sql.Timestamp delete_at;
	
	
	public PlayerFriendRequest(){}

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

	public java.sql.Timestamp getDelete_at() {
		return delete_at;
	}

	public void setDelete_at(java.sql.Timestamp delete_at) {
		this.delete_at = delete_at;
	}
	
}