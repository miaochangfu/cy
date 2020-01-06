package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import play.db.jpa.Model;

/**
 * @author try
 */
@Entity 
@Table(name="mast_shop")
public class MastShop  extends Model implements Serializable ,Cloneable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 需要消耗  */
	private int money;
	
	/** 类型 1 装备  2宠物   */
	private int type;
	
	/** 名字 */
	private String name;
	
	/** 描述 */
	private String info;
	
	/** img  */
	private String img;

	/** 性别   **/
	private int sex;
	
	/** 是否已购买 1为已购买   **/
	@Transient
	private int status;
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	
}