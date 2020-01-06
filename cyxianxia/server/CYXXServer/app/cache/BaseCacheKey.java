package cache;


/**
 * <p>Title: CacheKey</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年2月26日-下午3:40:50</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public class BaseCacheKey {
	
	/***
	 * getMastTaskCacheKey
	 * @param id
	 * @return
	 */
	public static String getMastTaskCacheKey( Long task_id ){
		return "getMastTaskCacheKey_"+task_id;
	}
	
	/***
	 * getMastTaskAllCacheKey
	 * @param id
	 * @return
	 */
	public static String getMastTaskAllCacheKey(){
		return "getMastTaskAllCacheKey";
	}
	
	
	/***
	 * getWeiXinAccessTokenCacheKey
	 * @param id
	 * @return
	 */
	public static String getWeiXinAccessTokenCacheKey(){
		return "getWeiXinAccessTokenCacheKey";
	}
	
	
	/***
	 * getWeiXinUserLoginAccessTokenCacheKey
	 * @param id
	 * @return
	 */
	public static String getWeiXinUserLoginAccessTokenCacheKey(){
		return "getWeiXinUserLoginAccessTokenCacheKey";
	}
	
	/***
	 * getWeiXinTicketCacheKey
	 * @param id
	 * @return
	 */
	public static String getWeiXinTicketCacheKey(){
		return "getWeiXinTicketCacheKey";
	}
	
	
	
	/***
	 * UserStatusCacheKey
	 * @param id
	 * @return
	 */
	public static String getUserStatusCacheKey( Long playerId ){
		return "UserStatusCacheKey_"+playerId;
	}
	
	/***
	 * getUserOauthTokenCacheKey
	 * @param id
	 * @return
	 */
	public static String getUserOauthTokenCacheKey( Long playerId ){
		return "getUserOauthTokenCacheKey_"+playerId;
	}
	
	
}
