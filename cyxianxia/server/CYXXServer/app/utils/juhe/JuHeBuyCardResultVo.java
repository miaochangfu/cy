package utils.juhe;

import java.io.Serializable;
import java.util.List;

public class JuHeBuyCardResultVo implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**聚合订单号*/
	private String juheOrderId;
	
	 /**您的订单号*/
	private String userOrderId;
	
	/**本次发货数量*/
	private String num;
	
	/**最终扣费总额*/
	private String deduction;
	
	private List<JuHeBuyCards> cards;

	public String getJuheOrderId() {
		return juheOrderId;
	}

	public void setJuheOrderId(String juheOrderId) {
		this.juheOrderId = juheOrderId;
	}

	public String getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(String userOrderId) {
		this.userOrderId = userOrderId;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDeduction() {
		return deduction;
	}

	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}

	public List<JuHeBuyCards> getCards() {
		return cards;
	}

	public void setCards(List<JuHeBuyCards> cards) {
		this.cards = cards;
	}

	
	
}
