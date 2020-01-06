package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * <p>Title: PlayerSetInfo</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年10月24日-下午4:02:13</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
@Entity 
@Table(name="player_set_info")
public class PlayerSetInfo  extends Model implements Serializable ,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**  用户ID  */
	private Long player_id;
	
	/** 电话 */
	private String telephone;
	
	/** 姓名  */
	private String name;

	/** 工号  */
	private String empno;

	/** 身份  */
	private String city;
	
	/** 区域  */
	private String address;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	
}