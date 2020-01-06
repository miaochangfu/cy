package utils.juhe;

import java.io.Serializable;

public class JuHeCardListResultVo implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	/** 商品ID基本不会变，请做好长期的缓存 */
	private String productId;
	
	/** 商品名 */
	private String name;
	
	/** 商品面值 */
	private double value;
	
	/** 默认折扣，如您需求量较大，可议 */
	private double discount;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
}
