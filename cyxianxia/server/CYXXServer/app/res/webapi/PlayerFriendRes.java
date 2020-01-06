package res.webapi;

import java.io.Serializable;

/**
 * @author try
 *  好友数据
 */
public class PlayerFriendRes implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** friend_id  **/
	private Long friend_id;
	
	/** 昵称   **/
	private String name;

	/** 头像   **/
	private String img;
	
	/** score   */
	private int score;
	
	/** 是否在线  0没在线  1在线    */
	private int online;
	
	/** 称号  */
	private String title;

	public Long getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(Long friend_id) {
		this.friend_id = friend_id;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
