package enu;

/**
 * <p>Title: PlayerRedTypeEnum</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月26日-下午2:45:27</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public enum PlayerCoinTypeEnum {
	
	/**
	 * <br>1-->
	 **/
	type_1(1,"其他"),
	type_2(2,"关卡"),
	type_3(3,"购买"),
	type_4(4,"战斗"),
	type_5(5,"好友"),
	type_6(6,"抽奖");
	
	private int value;
	
	private String label;
	
	private PlayerCoinTypeEnum(int value, String label){
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
	public static PlayerCoinTypeEnum valueOf(int value) {
		for (PlayerCoinTypeEnum enums : PlayerCoinTypeEnum.values()) {
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
	public static PlayerCoinTypeEnum getByLabel(String str) {
		for (PlayerCoinTypeEnum enums : PlayerCoinTypeEnum.values()) {
			if (enums.label.equalsIgnoreCase(str)) {
				return enums;
			}
		}
		return null;
	}
}
