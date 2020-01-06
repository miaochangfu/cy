package weixin.vo;

import java.io.Serializable;

public class WeiXinJsapiTicket implements Serializable{

	
	/** 错误码  **/
	private int errcode;
	
	/** 错误信息  **/
    private String errmsg;
    
    /** 临时票据，用于在获取授权链接时作为参数传入 **/
    private String ticket;
    
    /** ticket 的有效期，一般为 7200 秒 **/
    private int expires_in;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
    
    
}
