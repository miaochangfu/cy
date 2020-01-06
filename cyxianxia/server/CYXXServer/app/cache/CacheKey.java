package cache;


/**
 * <p>Title: CacheKey</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年2月26日-下午3:40:50</p>
 * <p>version 1.0</p>
 * <p>Description: </p>
 */
public class CacheKey extends BaseCacheKey {
	
	
	/***
	 * getMastLevelAllCacheKey
	 * @param id
	 * @return
	 */
	public static String getMastLevelAllCacheKey(){
		return "getMastLevelAllCacheKey";
	}
	
	
	/***
	 * getSystemRoomBeanAllCacheKey
	 * @param id
	 * @return
	 */
	public static String getSystemRoomBeanAllCacheKey( int type ){
		return "getSystemRoomBeanAllCacheKey_"+type;
	}
	
	
	/***
	 * getSystemRoomBeanCacheKey
	 * @param id
	 * @return
	 */
	public static String getSystemRoomBeanCacheKey( String  roomId ){
		return "getSystemRoomBeanCacheKey_"+roomId;
	}
	
	
	/***
	 * getPlayerRoomBeanCacheKey
	 * @param id
	 * @return
	 */
	public static String getPlayerRoomBeanCacheKey( Long playerId ){
		return "getPlayerRoomBeanCacheKey_"+playerId;
	}
	
	
	/***
	 * getPlayerRoomBeanCacheKey
	 * @param id
	 * @return
	 */
	public static String getPlayerRoomBeanListCacheKey( int type ){
		return "getPlayerRoomBeanListCacheKey_"+type;
	}
	
	/***
	 * getMastQuestionLevelCacheKey
	 * @param id
	 * @return
	 */
	public static String getMastQuestionLevelCacheKey( Long pkId ){
		return "getMastQuestionLevelCacheKey_"+pkId;
	}
	
	
	/***
	 * getMastQuestionLevelTypeCacheKey
	 * @param id
	 * @return
	 */
	public static String getMastQuestionLevelAllCacheKey(){
		return "getMastQuestionLevelAllCacheKey";
	}
	
	/***
	 * getFriendPVPCacheKey
	 * @param id
	 * @return
	 */
	public static String getFriendPVPCacheKey( Long friendId ){
		return "getFriendPVPCacheKey_"+friendId;
	}
	
	
}
