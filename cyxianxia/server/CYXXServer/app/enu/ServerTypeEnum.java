package enu;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:41:51
 */
public enum ServerTypeEnum {
	
	/** 服务器地址选择注册那个区  **/
	serverUrl1(1,"http://172.16.1.88:9000/"),serverUrl2(2,"http://172.16.1.88:9000/"),serverUrl3(3,"http://172.16.1.88:9000/");
	
	private int value;
	
	private String label;
	
	private ServerTypeEnum(int value, String label){
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
	public static ServerTypeEnum valueOf(int value) {
		for (ServerTypeEnum enums : ServerTypeEnum.values()) {
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
	public static ServerTypeEnum getByLabel(String str) {
		for (ServerTypeEnum enums : ServerTypeEnum.values()) {
			if (enums.label.equalsIgnoreCase(str)) {
				return enums;
			}
		}
		return null;
	}
}
