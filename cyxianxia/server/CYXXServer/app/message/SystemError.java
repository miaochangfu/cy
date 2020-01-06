package message;

import java.io.Serializable;

import play.Logger;

/**
 * <p>Title: SystemError</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2018年4月10日-下午12:29:58</p>
 * <p>version 1.0</p>
 * <p>Description: 错误信息</p>
 */
public class SystemError  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 系统错误 **/
	public static final String SYS_ERROR="101";
	public static final String SYS_ERROR_VALUE="系统错误";
	
	/** 数据异常 **/
	public static final String DATA_ERROR="102";
	public static final String DATA_ERROR_VALUE="数据异常";
	
	/** 参数错误 **/
	public static final String PARAMETERS_DATA_ERROR = "103";
	public static final String PARAMETERS_DATA_ERROR_VALUE = "参数错误";
	
	/** 解析错误 **/
	public static final String RESOLVING_DATA_ERROR = "104";
	public static final String RESOLVING_DATA_ERROR_VALUE = "解析错误";
	
	/** user 不存在 **/
	public static final String USER_NOT_EXIST="105";
	public static final String USER_NOT_EXIST_VALUE="用户不存在";
	
	/** user存在 **/
	public static final String USER_IS_EXIST="106";
	public static final String USER_IS_EXIST_VALUE="用户已经注册";
	
	/** 账户或者密码错误  **/
	public static final String USER_PASSWORD_ERROR="107";
	public static final String USER_PASSWORD_ERROR_VALUE="账户或者密码错误";
	
	/** user hiragana_name 存在 **/
	public static final String USER_HIRAGANA_NAME_EXIST ="108";
	public static final String USER_HIRAGANA_NAME_EXIST_VALUE="昵称存在";
	
	/** 签名错误 **/
	public static final String sign_is_error ="109";
	public static final String sign_is_error_value="签名错误";
	
	/** 已经领取  **/
	public static final String IS_GET_REDS_ORDER ="110";
	public static final String IS_GET_REDS_ORDER_VALUE="已经领取";
	
	/** 已经链接  **/
	public static final String ALREADY_CONNECTED_ORDER ="111";
	public static final String ALREADY_CONNECTED_ORDER_VALUE="已经链接";
	
	/** 注册失败  **/
	public static final String USER_INSERT_ORDER ="112";
	public static final String USER_INSERT_ORDER_VALUE="注册失败";
	
	/** 领取失败  **/
	public static final String IS_GET_ORDER ="113";
	public static final String IS_GET_ORDER_VALUE="领取失败";
	
	/** 请登录帐号 **/
	public static final String USER_IS_NOT_LOGIN_ORDER="115";
	public static final String USER_IS_NOT_LOGIN_ORDER_VALUE="请登录帐号";
	
	/** 发送短信间隔太短 **/
	public static final String REQUEST_BINDING_ORDER="116";
	public static final String REQUEST_BINDING_ORDER_VALUE="发送短信间隔太短";
	
	/** 短信失效 **/
	public static final String MOBILE_INVALID_ORDER="117";
	public static final String MOBILE_INVALID_ORDER_VALUE="短信失效";
	
	/** 验证码错误 **/
	public static final String VERIFICATION_CODE_ORDER="118";
	public static final String VERIFICATION_CODE_ORDER_VALUE="验证码错误";
	
	/** 该用户已绑定  **/
	public static final String IS_BANGDING_CODE_ORDER="119";
	public static final String IS_BANGDING_CODE_ORDER_VALUE="该用户已绑定";
	
	/** 密码错误   **/
	public static final String ROOM_PASSRORD_ORDER="129";
	public static final String ROOM_PASSRORD_ORDER_VALUE="密码错误";
	
	/** 物品不存在   **/
	public static final String GOODS_IS_NOT_FOND_ORDER="130";
	public static final String GOODS_IS_NOT_FOND_ORDER_VALUE="物品不存在";
	
	/** 物品已卖完,请刷新数据   **/
	public static final String GOODS_NOT_ENOUGH_ORDER="131";
	public static final String GOODS_NOT_ENOUGH_ORDER_VALUE="物品已卖完,请刷新数据";
	
	/** 请绑定手机   **/
	public static final String TELEPHONE_NO_BANGDING_ORDER="135";
	public static final String TELEPHONE_NO_BANGDING_ORDER_VALUE="请绑定手机";
	
	/** 充值失败   **/
	public static final String BUY_ORDER="136";
	public static final String BUY_ORDER_VALUE="充值失败";
	
	/** 该手机充值失败,请切换金额！   **/
	public static final String BUY_TELEPHONE_ORDER="137";
	public static final String BUY_TELEPHONE_ORDER_VALUE="该手机充值失败,请切换金额！";
	
	/** 你已经申请  **/
	public static final String FRIEND_REQUEST_ORDER="141";
	public static final String FRIEND_REQUEST_ORDER_VALUE="你已经申请";
	
	/** 我的好友达到上线  **/
	public static final String MY_FRIEND_MAX_ORDER="142";
	public static final String MY_FRIEND_MAX_ORDER_VALUE="我的好友达到上线";
	
	/** 购买好友卡槽位达到已满  **/
	public static final String BUY_FRIEND_MAX_ORDER="143";
	public static final String BUY_FRIEND_MAX_ORDER_VALUE="购买好友卡槽位达到已满";
	
	/** 你被封号  请联系管理员  **/
	public static final String KICK_ORDER="144";
	public static final String KICK_ORDER_VALUE="你被封号  请联系管理员";
	
	/** 手机号码不正确  **/
	public static final String MOBILE_ORDER="145";
	public static final String MOBILE_ORDER_VALUE="手机号码不正确";
	
	/** 今天短信数量达到上线  **/
	public static final String MOBILE_COUNT_ORDER="146";
	public static final String MOBILE_COUNT_ORDER_VALUE="今天短信数量达到上线";
	
	/** 暂时没开放  **/
	public static final String GAME_STOP_ORDER="147";
	public static final String GAME_STOP_ORDER_VALUE="暂时没开放";
	
	/** 你们已经是好友  **/
	public static final String IS_FRIEND_ORDER="148";
	public static final String IS_FRIEND_ORDER_VALUE="你们已经是好友";
	
	/** 兑换达到上线 **/
	public static final String DUI_HUAN_IS_MAX="149";
	public static final String DUI_HUAN_IS_MAX_VALUE="兑换达到上线";
	
	/** 该手机已绑定  **/
	public static final String IS_TELEPHONE_CODE_ORDER="150";
	public static final String IS_TELEPHONE_CODE_ORDER_VALUE="该手机已绑定";
	
	/** 抽奖不足  **/
	public static final String ERROR_CODE_200_ORDER="200";
	public static final String ERROR_CODE_200_ORDER_VALUE="抽奖不足";
	
	/** 提示不足  **/
	public static final String ERROR_CODE_201_ORDER="201";
	public static final String ERROR_CODE_201_ORDER_VALUE="提示次数不足";
	
	/** 复活次数不足  **/
	public static final String ERROR_CODE_202_ORDER="202";
	public static final String ERROR_CODE_202_ORDER_VALUE="复活次数不足";
	
	/** 银币不足  **/
	public static final String ERROR_CODE_203_ORDER="203";
	public static final String ERROR_CODE_203_ORDER_VALUE="银币不足";
	
	/** 你已购买  **/
	public static final String ERROR_CODE_204_ORDER="204";
	public static final String ERROR_CODE_204_ORDER_VALUE="你已购买";
	
	/** 未完成  **/
	public static final String ERROR_CODE_205_ORDER="205";
	public static final String ERROR_CODE_205_ORDER_VALUE="未完成";
	
	/** 该用户不是你好友  **/
	public static final String ERROR_CODE_206_ORDER="206";
	public static final String ERROR_CODE_206_ORDER_VALUE="该用户不是你好友";
	
	/** 好友取消了对战  **/
	public static final String ERROR_CODE_207_ORDER="207";
	public static final String ERROR_CODE_207_ORDER_VALUE="好友取消了对战";
	
	
	public SystemError() {
	}

	String code;
	
	String message;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	/***
	 * 公共的error输出
	 * @param errorCode
	 * @param errorMessage
	 * @return APIResponse
	 */
	public static SystemError getErrorFlag(String errorCode, String errorMessage,Exception e){
		SystemError errorFlag=new SystemError();
		errorFlag.setCode(errorCode);
		errorFlag.setMessage(errorMessage);
		if(e != null){
			Logger.error("",e);
		}
		return errorFlag;
	}
}
