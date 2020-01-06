package service.bean;

import java.io.Serializable;

public class LayuiDate  implements Serializable{

	private int code=0;
	
	private String msg;
	
	private long count;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
	
}
