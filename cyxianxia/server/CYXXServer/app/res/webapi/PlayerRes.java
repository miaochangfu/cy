package res.webapi;

import java.io.Serializable;

/**
 * <p>Title: PlayerRes</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月12日-下午1:38:20</p>
 * <p>version 1.0</p>
 * <p>Description: 注册成功返回用户对象 </p>
 */
public class PlayerRes implements Serializable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;

	public Long id;
	
	/**  元宝  */
	private int money;
	
	/** 积分  */
	private int score;
	
	/** 称号  */
	private String title;
	
	/** 性别   */
	private int sex;
	
	/** 体力值  */
	private int stamina;
	
	/** 铜币  */
	private int coin;
	
	/** 每日抽奖次数  */
	private int lottery_count;
	
	/** 复活次数  */
	private int revive_count;
	
	/** 提示次数  */
	private int tips_count;
	
	/** 音乐设置  */
	private String music_set;
	
	/** 音乐设置  */
	private String sound_set;
	
	/** 电话 */
	private String telephone;
	
	/** 微信openid  */
	private String openid;
	
	/** 昵称  */
	private String nickname;

	/** 头像  */
	private String headimgurl;

	/** 用户已装备的ID  **/
	private Long item_id;
	
	/**  宠物ID   **/
	private Long pets_id;
	
	/** 当前关卡ID   **/
	private Long question_id;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMusic_set() {
		return music_set;
	}

	public void setMusic_set(String music_set) {
		this.music_set = music_set;
	}

	public String getSound_set() {
		return sound_set;
	}

	public void setSound_set(String sound_set) {
		this.sound_set = sound_set;
	}
	

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getLottery_count() {
		return lottery_count;
	}

	public void setLottery_count(int lottery_count) {
		this.lottery_count = lottery_count;
	}

	public int getRevive_count() {
		return revive_count;
	}

	public void setRevive_count(int revive_count) {
		this.revive_count = revive_count;
	}

	public int getTips_count() {
		return tips_count;
	}

	public void setTips_count(int tips_count) {
		this.tips_count = tips_count;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Long getPets_id() {
		return pets_id;
	}

	public void setPets_id(Long pets_id) {
		this.pets_id = pets_id;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	
}
