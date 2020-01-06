package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * @author try
 */
@Entity 
@Table(name="mast_question_level")
public class MastQuestionLevel  extends Model implements Serializable ,Cloneable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 成语  */
	private String word;
	
	/** 游戏玩法1 玩法2  玩法3  玩法4 */
	private int type;
	
	/** 挑战成功获得分数  */
	private int score;
	
	/** 体力值   */
	private int stamina;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
}