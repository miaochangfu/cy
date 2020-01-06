package enu;

/**
 * <p>Title: GameMethodEnum</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月12日-下午12:22:23</p>
 * <p>version 1.0</p>
 * <p>Description: 接口定义</p>
 */
public enum GameMethodEnum {
	
	/**
	 * <br>100-->登录  ok 
	 **/
	method_open_card(100,"open_card"),
	
	method_game_init(500,"game_init"),
	
	method_game_start(501,"game_start"),
	
	method_game_ready(502,"game_ready"),
	
	method_game_call(503,"game_call"),
	
	method_game_meaasge(504,"game_meaasge"),
	
	method_game_no_ready(505,"game_no_ready"),
	
	method_game_voice_meaasge(506,"game_voice_meaasge"),
	
	method_game_is_start(507,"game_is_start"),
	
	method_game_over(508,"game_over"),
	
	method_game_leave(509,"game_leave"),
	
	method_game_rock(510,"game_rock"),
	
	method_game_join(511,"game_join"),
	
	method_game_add_question(512,"game_add_question"),
	
	method_game_friend_invite(513,"game_friend_invite"),
	
	method_pingWebSocket(999,"pingWebSocket");
	
	
	private int value;
	
	private String label;
	
	private GameMethodEnum(int value, String label){
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
	public static GameMethodEnum valueOf(int value) {
		for (GameMethodEnum enums : GameMethodEnum.values()) {
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
	public static GameMethodEnum getByLabel(String str) {
		for (GameMethodEnum enums : GameMethodEnum.values()) {
			if (enums.label.equalsIgnoreCase(str)) {
				return enums;
			}
		}
		return null;
	}
}
