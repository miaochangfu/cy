package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * @author try
 */
@Entity 
@Table(name="player_shop")
public class PlayerShop  extends Model implements Serializable ,Cloneable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** player_id   */
	private Long player_id;
	
	/** mast_shop_id   */
	private Long mast_shop_id;
	
	/** 类型 1 装备  2宠物   */
	private int type;
	
	/** 是否穿戴  */
	private int status;
	
	/** 时间 */
	private java.sql.Timestamp create_at;

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public Long getMast_shop_id() {
		return mast_shop_id;
	}

	public void setMast_shop_id(Long mast_shop_id) {
		this.mast_shop_id = mast_shop_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public java.sql.Timestamp getCreate_at() {
		return create_at;
	}

	public void setCreate_at(java.sql.Timestamp create_at) {
		this.create_at = create_at;
	}
	
	
}