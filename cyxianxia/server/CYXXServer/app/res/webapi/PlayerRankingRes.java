package res.webapi;

import java.io.Serializable;

/**
 * <p>Title: PlayerRankingRes</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年11月16日-下午4:52:40</p>
 * <p>version 1.0</p>
 * <p>Description: 用户排名数据</p>
 */
public class PlayerRankingRes implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** ID  **/
	private Long id;
	
	/** 用户ID  **/
	private Long player_id;
	
	/** 昵称   **/
	private String name;

	/** 头像   **/
	private String img;
	
	/** score   */
	private int score;
	
	/** 名次    */
	private int index;

	/** 称号  */
	private String title;
	
	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
