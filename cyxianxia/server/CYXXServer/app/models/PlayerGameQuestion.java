package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * @author try
 */
@Entity 
@Table(name="player_game_question")
public class PlayerGameQuestion  extends Model implements Serializable ,Cloneable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 用户ID  */
	private Long player_id;
	
	/** 关卡ID   **/
	private Long question_id;
	
	/** 游戏模式  */
	private int type;
	
	/** 该模式完成多少   */
	private int finish_count;
	
	/** 时间 */
	private java.sql.Timestamp create_at;

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}

	public java.sql.Timestamp getCreate_at() {
		return create_at;
	}

	public void setCreate_at(java.sql.Timestamp create_at) {
		this.create_at = create_at;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFinish_count() {
		return finish_count;
	}

	public void setFinish_count(int finish_count) {
		this.finish_count = finish_count;
	}
	
	
}