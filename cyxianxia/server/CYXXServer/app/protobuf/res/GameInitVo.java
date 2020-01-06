package protobuf.res;

/**
 * <p>Title: GameInitVo</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年12月19日-下午3:05:46</p>
 * <p>version 1.0</p>
 * <p>Description: 初始战斗数据  </p>
 */	
public class GameInitVo {

	/**  用户ID **/
	private Long player_id;
	
	/**  战斗类型    **/
	private int game_type;
	
	/**  邀请的谁  **/
	private Long self_player_id;
	
	/** 游戏关卡     **/
	private int level;
	
	/**  备用字段1  **/
	private String spare1;

	/**  备用字段2  **/
	private String spare2;
	
	/**  备用字段3  **/
	private String spare3;
	
	/**  备用字段4  **/
	private String spare4;
	
	/**  备用字段5  **/
	private String spare5;

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public int getGame_type() {
		return game_type;
	}

	public void setGame_type(int game_type) {
		this.game_type = game_type;
	}

	public Long getSelf_player_id() {
		return self_player_id;
	}

	public void setSelf_player_id(Long self_player_id) {
		this.self_player_id = self_player_id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getSpare1() {
		return spare1;
	}

	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}

	public String getSpare2() {
		return spare2;
	}

	public void setSpare2(String spare2) {
		this.spare2 = spare2;
	}

	public String getSpare3() {
		return spare3;
	}

	public void setSpare3(String spare3) {
		this.spare3 = spare3;
	}

	public String getSpare4() {
		return spare4;
	}

	public void setSpare4(String spare4) {
		this.spare4 = spare4;
	}

	public String getSpare5() {
		return spare5;
	}

	public void setSpare5(String spare5) {
		this.spare5 = spare5;
	}
	
	
}
