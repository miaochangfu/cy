package enu;

/**
 * <p>Title: NettyServerCodeEnu.java</p>
 * <p>Description: 通讯报文code</p>
 * @author try
 * @date 2016年1月14日-下午3:36:31
 * @version 1.0
 */
public enum ServerErrorCodeEnu {

	/** 2000 = 成功  **/
	code_2000(2000,"2000"),
	
	/** 2001 = 系统错误   **/
	code_2001(2001,"2001"),
	
	/** 2002 = 参数错误   **/
	code_2002(2002,"2002"),
	
	/** 2003 = 帐号不存在   **/
	code_2003(2003,"2003"),
	
	/** 2004 = 账户密码错误   **/
	code_2004(2004,"2004"),
	
	/** 2005 = 帐户锁定   **/
	code_2005(2005,"2005"),
	
	/** 2006 = 登录登录过期   **/
	code_2006(2006,"2006"),
	
	/** 2007 = 用户身份信息无效（Token无效）   **/
	code_2007(2007,"2007"),
	
	/** 2008 = 短信验证码错误   **/
	code_2008(2008,"2008"),
	
	/** 2009 = 账户已存在   **/
	code_2009(2009,"2009"),
	
	/** 2010 = 手机格式不对  **/
	code_2010(2010,"2010"),
	
	/** 2011 = 体力不足  **/
	code_2011(2011,"2011"),
	;
	
	private int value;
	
	private String label;
	
	private ServerErrorCodeEnu(int value, String label){
		this.value = value;
		this.label = label;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @param value
	 * @return ClientType
	 */
	public static ServerErrorCodeEnu valueOf(int value) {
		for (ServerErrorCodeEnu enums : ServerErrorCodeEnu.values()) {
			if (enums.value == value) {
				return enums;
			}
		}
		return null;
	}
	/**
	 * @param l label
	 * @return ClientType
	 */
	public static ServerErrorCodeEnu getByLabel(String str) {
		for (ServerErrorCodeEnu enums : ServerErrorCodeEnu.values()) {
			if (enums.label.equalsIgnoreCase(str)) {
				return enums;
			}
		}
		return null;
	}
	
}
