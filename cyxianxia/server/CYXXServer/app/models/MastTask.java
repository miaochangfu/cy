package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * @author try
 * 任务配置表
 */
@Entity 
@Table(name="mast_task")
public class MastTask  extends Model implements Serializable ,Cloneable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 任务id  */
	private Long task_id;
	
	/** 任务名称  */
	private String name;
	
	/** 类型   1 每日签到   2 分享给好友（0/10）  3 试玩XX游戏 4  客服对话的体力  5 成功购买宠物  6 成功购买人物  7 闯入排行榜100名  **/
	private int type;
	
	/** 对应任务需要的数量   **/
	private int t_number;
	
	/** 获取奖励类型  1为体力  2为元宝   **/
	private int money_type;
	
	/** 任务奖励 对应得值 */
	private int reward_value;

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

	public Long getTask_id() {
		return task_id;
	}

	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}

	public int getMoney_type() {
		return money_type;
	}

	public void setMoney_type(int money_type) {
		this.money_type = money_type;
	}
	
}