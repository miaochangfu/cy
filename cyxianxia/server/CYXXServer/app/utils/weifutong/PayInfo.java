package utils.weifutong;

import java.io.Serializable;

public class PayInfo implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	
	/**  公众号id  **/
	private String appId;
	
	/**  时间戳 **/
	private String timeStamp;
	
	/**  状态   成功为0 **/
	private String status;
	
	/**  签名方式 **/
	private String signType;
	
	/**  订单详情扩展字符串 **/
	private String package_info;
	
	/**  回调地址  **/
	private String callback_url;
	
	/** 随机字符串  **/
	private String nonceStr;
	
	/**  签名 **/
	private String paySign;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPackage_info() {
		return package_info;
	}

	public void setPackage_info(String package_info) {
		this.package_info = package_info;
	}

	public String getCallback_url() {
		return callback_url;
	}

	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	
//	{
//	    "appId": "wx0781c1dea664cd9a",
//	    "timeStamp": "1525844349397",
//	    "status": "0",
//	    "signType": "MD5",
//	    "package": "prepay_id003dwx09133909348467e5ce25b6e73673596576",
//	    "callback_url": null,
//	    "nonceStr": "1525844349397",
//	    "paySign": "3D3D6FB9DB9A96A0A50F8055BC98DD38"
//	}
	
	
}
