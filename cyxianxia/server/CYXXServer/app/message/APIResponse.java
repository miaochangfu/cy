package message;

import java.io.Serializable;

/**
 * <p>Title: APIResponse</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月10日-下午12:28:23</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public class APIResponse implements Serializable{
	
	public static final String STATUS_OK = "SUCCESS"; 
	public static final String STATUS_NG = "ERROR"; 
	
	
	/** API Response Status */
	public String status = STATUS_OK;
	
	public String method = "";
	
	public SystemError systemError;
	
	public APIResponse() {

	}

	public APIResponse(String status) {
		this.status = status;
	}

}