package enu;

/**
 * <p>Title: NettyHandleEnu.java</p>
 * <p>Description: handle对应的编码 </p>
 * @author try
 * @date 2016-7-29-下午02:51:14
 * @version 1.0
 */
public enum NettyHandleEnu {

	/**  **/
	Auth(1,"Auth"),
	Skill(2,"Skill"),
	GAME(3,"game");
	
	private int value;
	
	private String label;
	
	private NettyHandleEnu(int value, String label){
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
	public static NettyHandleEnu valueOf(int value) {
		for (NettyHandleEnu enums : NettyHandleEnu.values()) {
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
	public static NettyHandleEnu getByLabel(String str) {
		for (NettyHandleEnu enums : NettyHandleEnu.values()) {
			if (enums.label.equalsIgnoreCase(str)) {
				return enums;
			}
		}
		return null;
	}
	
}
