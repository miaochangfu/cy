package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * <p>Title: MastLevel</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年11月12日-下午5:41:37</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
@Entity 
@Table(name="mast_level")
public class MastLevel  extends Model implements Serializable ,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**    */
	private String name;
	
	/** 分数   */
	private int min_score;
	
	/** 分数   */
	private int max_score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMin_score() {
		return min_score;
	}

	public void setMin_score(int min_score) {
		this.min_score = min_score;
	}

	public int getMax_score() {
		return max_score;
	}

	public void setMax_score(int max_score) {
		this.max_score = max_score;
	}
	
	
}