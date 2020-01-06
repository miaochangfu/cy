package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import play.db.jpa.Model;

/**
 * @author try
 * 用户任务数据
 */
@Entity 
@Table(name="player_task")
public class PlayerTask  extends Model implements Serializable ,Cloneable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 用户ID  */
	private Long player_id;
	
	/** 任务ID   **/
	private Long task_id;
	
	/** 当前完成数量   **/
	private int cu_number;
	
	/** 0为初始化    1为已完成    2为已领取   **/
	private int status;

	/** task_name **/
	@Transient
	private String task_name;
	
	/** 对应任务需要的数量   **/
	@Transient
	private int t_number;
	
	/** 任务奖励 对应得值 */
	@Transient
	private int reward_value;
	
	/** 获取奖励类型  1为体力  2为元宝   **/
	@Transient
	private int money_type;
	
	
	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public Long getTask_id() {
		return task_id;
	}

	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}

	public int getCu_number() {
		return cu_number;
	}

	public void setCu_number(int cu_number) {
		this.cu_number = cu_number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public int getT_number() {
		return t_number;
	}

	public void setT_number(int t_number) {
		this.t_number = t_number;
	}

	public int getReward_value() {
		return reward_value;
	}

	public void setReward_value(int reward_value) {
		this.reward_value = reward_value;
	}

	public int getMoney_type() {
		return money_type;
	}

	public void setMoney_type(int money_type) {
		this.money_type = money_type;
	}
	
}