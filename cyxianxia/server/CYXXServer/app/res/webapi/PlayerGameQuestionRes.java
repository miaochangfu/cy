package res.webapi;

import java.io.Serializable;

/**
 * @author try
 */
public class PlayerGameQuestionRes implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 模式名字   **/
	private String name;

	/** 当前关卡ID   **/
	private Long question_id;
	
	/** 游戏模式  */
	private int type;
	
	/** 该模式完成多少   */
	private int finish_count;
	
	/** 挑战成功获得分数  */
	private int score;
	
	/** 体力值   */
	private int stamina;
	
	/** 铜币  */
	private String coin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
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

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}
	
}
