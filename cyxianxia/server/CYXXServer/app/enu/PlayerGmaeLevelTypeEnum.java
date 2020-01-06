package enu;

/**
 * <p>Title: PlayerRedTypeEnum</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月26日-下午2:45:27</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public enum PlayerGmaeLevelTypeEnum {
	
	/**
	 * <br>1-->
	 **/
	game_type_1(1,"基础玩法"),
	game_type_2(2,"其他玩法2"),
	game_type_3(3,"其他玩法3"),
	game_type_4(4,"其他玩法4"),
	game_type_5(5,"其他玩法5");
	
	private int value;
	
	private String label;
	
	private PlayerGmaeLevelTypeEnum(int value, String label){
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
	public static PlayerGmaeLevelTypeEnum valueOf(int value) {
		for (PlayerGmaeLevelTypeEnum enums : PlayerGmaeLevelTypeEnum.values()) {
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
	public static PlayerGmaeLevelTypeEnum getByLabel(String str) {
		for (PlayerGmaeLevelTypeEnum enums : PlayerGmaeLevelTypeEnum.values()) {
			if (enums.label.equalsIgnoreCase(str)) {
				return enums;
			}
		}
		return null;
	}
}
