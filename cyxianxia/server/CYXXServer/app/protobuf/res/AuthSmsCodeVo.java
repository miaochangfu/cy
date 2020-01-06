package protobuf.res;
/**
 * @author:try
 * @version:1.0
 * @Description:给手机发验证码
 * @Date:2016年7月30日上午1:05:11
 */
public class AuthSmsCodeVo {

	private String mobile;
	
	private int type;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
