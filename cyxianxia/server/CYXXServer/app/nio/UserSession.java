package nio;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户会话类。一个会话可以包含多个设备。
 * @author try
 *
 */
public class UserSession {
	
	// global sessionid 
	private static int globalSessionID = 0;
	// session id
	private int sessionID;
	// 物理通道的集合
	private ConcurrentHashMap<String, Channel> channels;
	// 声明attribute key
	public static AttributeKey<UserSession> sessionKey;
	// token
	private String token;
	
	/**
	 * 静态初始化
	 */
	static{
		sessionKey = AttributeKey.valueOf("session");
	}
	
	/**
	 * 构造函数
	 */
	public UserSession() {
		channels = new ConcurrentHashMap<String, Channel>();
		// 自动分配一个session id
		synchronized(UserSession.class){
			this.sessionID = ++globalSessionID;
		}
		Random rad = new Random();
		token = "token" + rad.nextInt(1000000);
	}

	/**
	 * 获取channel.
	 * @return
	 */
	public Channel getChannel(String channelName) {
		return channels.get(channelName);
	}
	
	/**
	 * 新增一个物理channel
	 * @param ch
	 * @param channelName
	 */
	public void putChannel(Channel ch, String channelName){
		channels.put(channelName, ch);
	}
	
	/**
	 * 清空session
	 */
	public void reset(){
		this.channels.clear();
	}

	/**
	 * 获取session id
	 * @return
	 */
	public int getSessionID() {
		return sessionID;
	}
	
	/**
	 * 获取session key
	 * @return
	 */
	public static AttributeKey<UserSession> getSessionKey() {
		return sessionKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
