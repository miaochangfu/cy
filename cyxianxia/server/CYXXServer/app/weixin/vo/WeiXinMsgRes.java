package weixin.vo;

import java.io.Serializable;

public class WeiXinMsgRes implements Serializable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;

	private int errcode;
	
	private String errMsg;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
}
