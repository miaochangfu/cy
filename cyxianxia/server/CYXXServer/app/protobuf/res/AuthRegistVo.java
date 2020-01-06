package protobuf.res;
/**
 * @author:try
 * @version:1.0
 * @Description:注册
 * @Date:2016年7月30日上午1:05:11
 */
public class AuthRegistVo {

	/**  注册帐号（手机号）  **/
	private String mobile;
	
	/**  登录密码   **/
	private String password;
	
	/**  短信验证码   **/
	private String validCode;
	
	/**  设备ID  **/
	private String uuid;
	
	/**  位置经度  **/
	private Double lon;
	
	/**  位置纬度 **/
	private Double lat;

	/**  头像  **/
	private String avatar;
	
	/** 玩家昵称 **/
	private String hiName;
	
	/**  token_id **/
	private String token_id;
	
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidCode() {
		return validCode;
	}

	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getHiName() {
		return hiName;
	}

	public void setHiName(String hiName) {
		this.hiName = hiName;
	}

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}

	
	
}
