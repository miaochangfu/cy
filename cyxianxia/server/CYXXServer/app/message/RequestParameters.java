package message;

/**
 * <p>Title: RequestParameters</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月10日-下午5:09:32</p>
 * <p>version 1.0</p>
 * <p>Description: 访问接口对象数据解析对象 </p>
 */
public class RequestParameters extends RequestParametersBase {
	
	
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**  **/
	public Long pkId;
	
	/**  **/
	public String code;
	
	/**  **/
	public Integer type;
	
	/**  **/
	public Integer expense;
	
	/**  **/
	public Integer status;
	
	/**  **/
	public Integer page;
	
	/**  **/
	public Integer expend;
	
	/** 手机  **/
	public String mobile;
	
	/** 手机短信  **/
	public String mobileCode;
	
	/** 地址   **/
	public String address;

	/** 联系电话 **/
	public String phone;

	/** 收货人  **/
	public String name;
	
	/** 游模式   1随机匹配   2好友战斗    3 个人闯关模式  **/
	public Integer game_type;
	
	/** 游戏人数   **/
	public Integer game_count;
	
	/** 房间ID数据  **/
	public String roomId;
	
	/** message  **/
	public String message;
	
}
