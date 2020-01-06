package service.websocket;

import java.io.Serializable;

public class PlayerRoomBean implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 用户ID  **/
	private Long playerId;

	/** 创建者昵称  **/
	private String name;
	
	/** 创建者头像  **/
	private String img;
	
	/** 房间编号ID  **/
	private String roomId;
	
	/** 房间类型    1随机匹配   2好友战斗  **/
	private int type;
	
	/** 房间人数  **/
	private int playerNum;
	
	/** 是否准备 **/
	private int is_ready;
	
	/** 积分  */
	private int score;

	/** 是否答题   0 默认没有答题   1为已答对  */
	private int is_dati;
	
	/** 创建时间  **/
	private Long cretat_at;
	
	
	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getIs_ready() {
		return is_ready;
	}

	public void setIs_ready(int is_ready) {
		this.is_ready = is_ready;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Long getCretat_at() {
		return cretat_at;
	}

	public void setCretat_at(Long cretat_at) {
		this.cretat_at = cretat_at;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public int getIs_dati() {
		return is_dati;
	}

	public void setIs_dati(int is_dati) {
		this.is_dati = is_dati;
	}
	
}
