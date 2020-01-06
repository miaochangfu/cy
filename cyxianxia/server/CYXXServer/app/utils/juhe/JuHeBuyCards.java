package utils.juhe;

import java.io.Serializable;

public class JuHeBuyCards implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**DES加密后的卡号，解密方法见：http://code.juhe.cn/docs/1943、http://code.juhe.cn/docs/1945*/
	private String cardNo;
	
	/**DES加密后的卡密，解密方法见：http://code.juhe.cn/docs/1943、http://code.juhe.cn/docs/1945*/
	private String cardPws;
	
	private String cardNoOk;
	
	private String cardPwsOk;
	
	/**失效时间*/
	private String expireDate;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardPws() {
		return cardPws;
	}

	public void setCardPws(String cardPws) {
		this.cardPws = cardPws;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCardNoOk() {
		return cardNoOk;
	}

	public void setCardNoOk(String cardNoOk) {
		this.cardNoOk = cardNoOk;
	}

	public String getCardPwsOk() {
		return cardPwsOk;
	}

	public void setCardPwsOk(String cardPwsOk) {
		this.cardPwsOk = cardPwsOk;
	}

	
}
