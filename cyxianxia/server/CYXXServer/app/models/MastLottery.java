package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * @author try
 * 抽奖配置
 */
@Entity 
@Table(name="mast_lottery")
public class MastLottery  extends Model implements Serializable ,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**  名字  */
	private String name;
	
	/** 奖品类型  1为体力  2为铜币  3为复活卡   4 提示卡    5 元宝   6 什么都没得   */
	private int type;
	
	/** 概率   */
	private int probability;

	/** 获得   */
	private int g_value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}

	public int getG_value() {
		return g_value;
	}

	public void setG_value(int g_value) {
		this.g_value = g_value;
	}
	
}