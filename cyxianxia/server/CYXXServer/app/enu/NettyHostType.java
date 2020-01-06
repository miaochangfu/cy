package enu;

/**
 * <p>Title: ServerNettyType.java</p>
 * <p>Description: Netty 服务器地址配置 </p>
 * @author try
 * @date 2015-5-12-下午03:26:31
 * @version 1.0
 */
public enum NettyHostType {

	/** Netty服务器地址   **/
	ServerNetty_1(1,"localhost"),ServerNetty_2(2,"192.168.1.1"),ServerNetty_3(3,"192.168.1.2");
	
	private int value;
	
	private String label;
	
	private NettyHostType(int value, String label){
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
	public static NettyHostType valueOf(int value) {
		for (NettyHostType enums : NettyHostType.values()) {
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
	public static NettyHostType getByLabel(String str) {
		for (NettyHostType enums : NettyHostType.values()) {
			if (enums.label.equalsIgnoreCase(str)) {
				return enums;
			}
		}
		return null;
	}
}