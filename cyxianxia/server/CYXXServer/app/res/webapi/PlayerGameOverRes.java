package res.webapi;

import java.io.Serializable;

/**
 * @author try
 */
public class PlayerGameOverRes implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** playerId    **/
	private Long playerId;
	
	/** 名字   **/
	private String name;

	/** 获得分数  */
	private int score;
	
	/** 获得元宝   */
	private int money;
	
	/** 铜币  */
	private int coin;

	/** 排名  */
	private int index;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	
}
