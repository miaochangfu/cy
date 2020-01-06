package res.webapi;

import java.io.Serializable;

/**
 * @author try
 */
public class PlayerGameQuestionItemRes implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/** 单词   **/
	private String name;
	
	/** 随机文字  **/
	private String random_text;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRandom_text() {
		return random_text;
	}

	public void setRandom_text(String random_text) {
		this.random_text = random_text;
	}
	
}
