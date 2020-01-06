package utils.juhe;

import java.io.Serializable;

public class TelcheckResultVo implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	 /** 充值的卡类ID*/
	private String cardid;
	
	/**数量*/
	private String cardnum;
	
	/**进货价格*/
	private String ordercash;
	
	/**充值名称*/
	private String cardname;
	
	/**聚合订单号*/
	private String sporder_id;
	
	/**商户自定的订单号*/
	private String uorderid;
	
	/**充值的手机号码*/
	private String game_userid;
	
	/** 充值状态:0充值中 1成功 9撤销，刚提交都返回0 */
	private Integer game_state;

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getOrdercash() {
		return ordercash;
	}

	public void setOrdercash(String ordercash) {
		this.ordercash = ordercash;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getSporder_id() {
		return sporder_id;
	}

	public void setSporder_id(String sporder_id) {
		this.sporder_id = sporder_id;
	}

	public String getUorderid() {
		return uorderid;
	}

	public void setUorderid(String uorderid) {
		this.uorderid = uorderid;
	}

	public String getGame_userid() {
		return game_userid;
	}

	public void setGame_userid(String game_userid) {
		this.game_userid = game_userid;
	}

	public Integer getGame_state() {
		return game_state;
	}

	public void setGame_state(Integer game_state) {
		this.game_state = game_state;
	}
	
	
}
