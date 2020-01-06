package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * <p>Title: PlayerStatus.java</p>
 * <p>Description: 玩家信息表</p>
 * <p>Company: dark </p>
 * @author try
 * @date 2013-4-16-上午11:21:59
 * @version 1.0
 */
@Entity
@Table(name="player_status")
public class PlayerStatus extends Model  implements Serializable ,Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/** 用户  **/
	private String name;

	/** google账户  **/
	private String google_name;
	
	/** gameCenter注册  **/
	private String game_center_name;

	/** 密码  **/
	private String password;
	
	/** 玩家的头像 **/
	private String base_images;
	
	/**  玩家昵称 **/
	private String hiragana_name;
	
	/**  千寻userId **/
	private String qianxunuser;
	
	/**  玩家email **/
	private String email;
	
	/** level **/
	private Integer level;
	
	/**  玩家qq **/
	private String qq;
	
	/**平台返回的id**/
	private String platform_id;
	
	/** 性别  **/
	private String sex;
	
	/** 玩家key **/
	private String session_key;
	
	/** 钱 **/
	private Integer money;
	
	/** 游戏币 **/
	private int coin;
	
	/**  连续登录次数 **/
	private Integer continuous_login_count;
	
	/**  token_id  **/
	private String token_id; 
	
	/** 游戏生成的 唯一标识码 **/
	private String uuid;
	
	/** 设备唯一码 **/
	private String udid;
	
	/** 用户对应的MD5编码  **/
	private String udidMd;
	
	/** 玩家累积充值的钱 **/
	private int accumulate_money;
	
	/** 国际   **/
	private String language;
	
	/** userip   **/
	private String userip;
	
	/** usercity   **/
	private String usercity;
	
	/** 玩家今天是否已经签到  0为初始化, 1为已领取   **/
	private int isLogin;
	
	/** 是否使用其他帐号 **/
	private Long nextPlayerId;
	
	/** 广告次数领取1  **/
	private int advertCount1;
	
	/** 广告次数领取2  **/
	private int advertCount2;
	
	/** 每天最多点广告次数  **/
	private int maxAdvertCount;
	
	/** 广告点击全部次数  **/
	private int allAdvertCount;
	
	/** 修改玩家昵称次数  **/
	private int updNameCt;
	
	/** 上次登陆时间 **/
	private java.sql.Timestamp login_datetime;
	
	/** 创建时间  **/
	private java.sql.Timestamp created_at;
	
	public static PlayerStatus getUserByUdid( String udid ) {
        return PlayerStatus.find("udid=?", udid).first();
    }
	
	public static PlayerStatus getUserByQianXunUserId( String userId ) {
        return PlayerStatus.find("qianxunuser=?", userId).first();
    }
	
	public static PlayerStatus authenticateByUser(String name, String password) {
        return PlayerStatus.find("name=? and password=? ", name , password ).first();
    }
	
	public static PlayerStatus authenticateByName(String name ) {
        return PlayerStatus.find("name=?", name).first();
    }
	
	public static List<PlayerStatus> playerRankingByLevel( int page, int pageSize ) {
		List<PlayerStatus> list = PlayerStatus.find(" order by level desc ").query.setFirstResult(0).setMaxResults(pageSize).getResultList();
		return list;
    }
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGoogle_name() {
		return google_name;
	}


	public void setGoogle_name(String google_name) {
		this.google_name = google_name;
	}


	public String getGame_center_name() {
		return game_center_name;
	}


	public void setGame_center_name(String game_center_name) {
		this.game_center_name = game_center_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBase_images() {
		return base_images;
	}


	public void setBase_images(String base_images) {
		this.base_images = base_images;
	}


	public String getHiragana_name() {
		return hiragana_name;
	}


	public void setHiragana_name(String hiragana_name) {
		this.hiragana_name = hiragana_name;
	}


	public String getQianxunuser() {
		return qianxunuser;
	}


	public void setQianxunuser(String qianxunuser) {
		this.qianxunuser = qianxunuser;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getPlatform_id() {
		return platform_id;
	}


	public void setPlatform_id(String platform_id) {
		this.platform_id = platform_id;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getSession_key() {
		return session_key;
	}


	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}


	public Integer getMoney() {
		return money;
	}


	public void setMoney(Integer money) {
		this.money = money;
	}

	public void setSaveMoney(Integer money) {
		this.money = money;
	}


	public int getCoin() {
		return coin;
	}


	public void setCoin(int coin) {
		this.coin = coin;
	}


	public Integer getContinuous_login_count() {
		return continuous_login_count;
	}


	public void setContinuous_login_count(Integer continuous_login_count) {
		this.continuous_login_count = continuous_login_count;
	}


	public String getToken_id() {
		return token_id;
	}


	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getUdid() {
		return udid;
	}


	public void setUdid(String udid) {
		this.udid = udid;
	}


	public int getAccumulate_money() {
		return accumulate_money;
	}


	public void setAccumulate_money(int accumulate_money) {
		this.accumulate_money = accumulate_money;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public java.sql.Timestamp getLogin_datetime() {
		return login_datetime;
	}


	public void setLogin_datetime(java.sql.Timestamp login_datetime) {
		this.login_datetime = login_datetime;
	}


	public java.sql.Timestamp getCreated_at() {
		return created_at;
	}


	public void setCreated_at(java.sql.Timestamp created_at) {
		this.created_at = created_at;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public String getUsercity() {
		return usercity;
	}

	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}

	public int getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}

	public Long getNextPlayerId() {
		return nextPlayerId;
	}

	public void setNextPlayerId(Long nextPlayerId) {
		this.nextPlayerId = nextPlayerId;
	}

	public int getAdvertCount1() {
		return advertCount1;
	}

	public void setAdvertCount1(int advertCount1) {
		this.advertCount1 = advertCount1;
	}

	public int getAdvertCount2() {
		return advertCount2;
	}

	public void setAdvertCount2(int advertCount2) {
		this.advertCount2 = advertCount2;
	}

	public int getUpdNameCt() {
		return updNameCt;
	}

	public void setUpdNameCt(int updNameCt) {
		this.updNameCt = updNameCt;
	}

	public int getMaxAdvertCount() {
		return maxAdvertCount;
	}

	public void setMaxAdvertCount(int maxAdvertCount) {
		this.maxAdvertCount = maxAdvertCount;
	}

	public int getAllAdvertCount() {
		return allAdvertCount;
	}

	public void setAllAdvertCount(int allAdvertCount) {
		this.allAdvertCount = allAdvertCount;
	}

	public String getUdidMd() {
		return udidMd;
	}

	public void setUdidMd(String udidMd) {
		this.udidMd = udidMd;
	}
	
}
