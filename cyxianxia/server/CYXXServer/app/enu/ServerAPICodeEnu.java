package enu;

/**
 * <p>Title: NettyServerCodeEnu.java</p>
 * <p>Description: 通讯报文code</p>
 * @author try
 * @date 2016年1月14日-下午3:36:31
 * @version 1.0
 */
public enum ServerAPICodeEnu {

	/** 心跳包或者初始链接 **/
	API_0(0,"0"),
	
	/** 100 **/
	API_100(100,"100"),
	
	/** 2000游戏初始化，用户排队 **/
	GAME_API_2000(2000,"2000");
	
	private int value;
	
	private String label;
	
	private ServerAPICodeEnu(int value, String label){
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
	public static ServerAPICodeEnu valueOf(int value) {
		for (ServerAPICodeEnu enums : ServerAPICodeEnu.values()) {
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
	public static ServerAPICodeEnu getByLabel(String str) {
		for (ServerAPICodeEnu enums : ServerAPICodeEnu.values()) {
			if (enums.label.equalsIgnoreCase(str)) {
				return enums;
			}
		}
		return null;
	}
	
}
