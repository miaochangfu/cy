package protobuf.res;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2016年7月30日上午1:29:15
 */
public class AuthLoginVo {

	/**  注册帐号（手机号）  **/
	private String mobile;
	
	/**  登录密码   **/
	private String password;
	
	/**  设备ID  **/
	private String uuid;
	
	/**  位置经度  **/
	private Double lon;
	
	/**  位置纬度 **/
	private Double lat;

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

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}
	
}
