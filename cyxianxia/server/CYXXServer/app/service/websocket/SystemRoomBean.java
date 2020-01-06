package service.websocket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import res.webapi.PlayerGameQuestionItemRes;

/**
 * <p>Title: PlayerRoomBean</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月18日-上午11:36:15</p>
 * <p>version 1.0</p>
 * <p>Description: 房间信息  </p>
 */
public class SystemRoomBean implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 创建者用户ID  **/
	private Long createPlayerId;

	/** 房间编号ID  **/
	private String roomId;
	
	/** 房间类型    1随机匹配   2好友战斗 **/
	private int type;
	
	/** 房间人数  **/
	private int playerNum;
	
	/** 房间等待时间    **/
	private Long roomMatchingTime;
	
	/** 加入房间需要扣除  **/
	private int addNeedMoney;

	/** 创建时间  **/
	private Long cretat_at;
	
	/** 开始时间  **/
	private Long start_at;
	
	/** 当前答题倒计时 单位秒  **/
	private int count_down;
	
	private List<PlayerRoomBean> playerRooms = new ArrayList<PlayerRoomBean>();

	private List<PlayerGameQuestionItemRes> questionItems= new ArrayList<PlayerGameQuestionItemRes>();
	
	
	public Long getCreatePlayerId() {
		return createPlayerId;
	}

	public void setCreatePlayerId(Long createPlayerId) {
		this.createPlayerId = createPlayerId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getRoomMatchingTime() {
		return roomMatchingTime;
	}

	public void setRoomMatchingTime(Long roomMatchingTime) {
		this.roomMatchingTime = roomMatchingTime;
	}

	public int getAddNeedMoney() {
		return addNeedMoney;
	}

	public void setAddNeedMoney(int addNeedMoney) {
		this.addNeedMoney = addNeedMoney;
	}

	public Long getCretat_at() {
		return cretat_at;
	}

	public void setCretat_at(Long cretat_at) {
		this.cretat_at = cretat_at;
	}

	public Long getStart_at() {
		return start_at;
	}

	public void setStart_at(Long start_at) {
		this.start_at = start_at;
	}

	public int getCount_down() {
		return count_down;
	}

	public void setCount_down(int count_down) {
		this.count_down = count_down;
	}

	public List<PlayerRoomBean> getPlayerRooms() {
		return playerRooms;
	}

	public void setPlayerRooms(List<PlayerRoomBean> playerRooms) {
		this.playerRooms = playerRooms;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public List<PlayerGameQuestionItemRes> getQuestionItems() {
		return questionItems;
	}

	public void setQuestionItems(List<PlayerGameQuestionItemRes> questionItems) {
		this.questionItems = questionItems;
	}
	
}
