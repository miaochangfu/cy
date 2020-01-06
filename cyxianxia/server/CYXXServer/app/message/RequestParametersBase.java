package message;

import java.io.Serializable;

/**
 * <p>Title: RequestParametersBase</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月10日-下午5:09:42</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public class RequestParametersBase  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 登录请求数据 playerId **/
	public Long playerId;
	
	/**  登录请求数据 openid **/
	public String openid;
    
	/** 用户ID **/
	public Long selfPlayerId;
	
	/** 调用方法 **/
	public String method;
	
	
}
