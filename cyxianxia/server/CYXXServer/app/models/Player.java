package models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import cache.CacheKey;
import cache.RemoteCache;
import play.db.jpa.JPABase;
import play.db.jpa.Model;
import service.api.PlayerLogService;

/**
 * <p>Title: TblPlayer</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月10日-上午11:00:44</p>
 * <p>version 1.0</p>
 * <p>Description: 玩家表</p>
 */
@Entity 
@Table(name="player")
public class Player  extends Model implements Serializable ,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**  元宝  */
	private int money;
	
	/** 积分  */
	private int score;
	
	/** 个人积分每个星期一清理数据  */
	private int my_score;
	
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
	
	/** 上次消耗体力时间 **/
	private java.sql.Timestamp last_magic_at;
	
	/** 玩家等级  **/
	private int level;
	
	/** 用户已装备的ID  **/
	private Long item_id;
	
	/**  宠物ID   **/
	private Long pets_id;
	
	/** 电话 */
	private String telephone;
	
	/** 微信openid  */
	private String openid;
	
	/** 微信unionid  */
	private String unionid;
	
	/** 昵称  */
	private String nickname;

	/** 头像  */
	private String headimgurl;

	/** 地址  */
	private String address;

	/** 性别   */
	private int sex;
	
	/** 音乐设置  */
	private String music_set;
	
	/** 音效设置  */
	private String sound_set;
	
	/** 注册时间 */
	private java.sql.Timestamp create_time;
	
	
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
		if( score < 0 ){
			score = 0;
		}
		int getMoney = score>=this.score?score-this.score:this.score - score;
		int usetype = score > this.score?1:2;
		PlayerLogService.saveLogPlayerScoreStatus(this.id , 1 , getMoney , this.score , score , usetype );
		this.score = score;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
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



	public String getUnionid() {
		return unionid;
	}



	public void setUnionid(String unionid) {
		this.unionid = unionid;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getSex() {
		return sex;
	}



	public void setSex(int sex) {
		this.sex = sex;
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



	public java.sql.Timestamp getCreate_time() {
		return create_time;
	}



	public void setCreate_time(java.sql.Timestamp create_time) {
		this.create_time = create_time;
	}


	public java.sql.Timestamp getLast_magic_at() {
		return last_magic_at;
	}

	public void setLast_magic_at(java.sql.Timestamp last_magic_at) {
		this.last_magic_at = last_magic_at;
	}

	
	public int getCoin() {
		return coin;
	}

	public void setCoin( int coin , int type ) {
		
		if( coin < 0 ){
			coin = 0;
		}
		int getMoney = coin>=this.coin?coin-this.coin:this.coin - coin;
		int usetype = coin > this.coin?1:2;
		PlayerLogService.saveLogPlayerCoinStatus(this.id , type , getMoney , this.coin , coin , usetype );
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

	public int getMy_score() {
		return my_score;
	}

	public void setMy_score(int my_score) {
		this.my_score = my_score;
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

	@Override
	public <T extends JPABase> T save() {
		RemoteCache.safeSet( CacheKey.getUserStatusCacheKey( this.id ), this , "24h" );
		return super.save();
	}
	
	
}