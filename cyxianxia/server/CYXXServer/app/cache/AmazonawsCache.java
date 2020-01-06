package cache;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Future;

import javax.naming.ConfigurationException;


import config.GameStatus;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.MemcachedClient;
import play.Logger;
import play.Play;
import play.exceptions.CacheException;
import play.libs.Time;
import utils.CustomSerializingTranscoder;

/**
 * @author:try
 * @version:1.0
 * @Description:亚马逊缓存
 * @Date:2017年1月4日下午11:34:18
 */
public abstract class AmazonawsCache implements Serializable {

	public static  MemcachedClient amazonawsCache;
	
	public static void init() {
		
    	if ( amazonawsCache != null )
    		return;
    	
        if (Play.configuration.getProperty("amazonawsCache", "disabled").equals("enabled")) {
            try {
            	List<InetSocketAddress> addrs;
                if (Play.configuration.containsKey("amazonaws.host")) {
                    addrs = AddrUtil.getAddresses(Play.configuration.getProperty("amazonaws.host"));
                } else if (Play.configuration.containsKey("amazonaws.1.host")) {
                    int nb = 1;
                    String addresses = "";
                    while (Play.configuration.containsKey("amazonaws." + nb + ".host")) {
                        addresses += Play.configuration.get("amazonaws." + nb + ".host") + " ";
                        nb++;
                    }
                    addrs = AddrUtil.getAddresses(addresses);
                } else {
                    throw new ConfigurationException("Bad configuration for memcached: missing host(s)");
                }
                amazonawsCache = new MemcachedClient(new ConnectionFactoryBuilder().setTranscoder(new CustomSerializingTranscoder()).setProtocol(Protocol.BINARY).build(), addrs);
                amazonawsCache.flush();
                Logger.info("Connected to AmazonawsCache");
                GameStatus.isUseAmazonawsCache = true;
            } catch (Exception e) {
            	Logger.info("Error while connecting to memcached");
                Logger.warn("Fallback to local cache");
                GameStatus.isUseAmazonawsCache = false;
                e.printStackTrace();
            }
        }else{
        	 GameStatus.isUseAmazonawsCache = false;
        }
    }
	
	  /**
	   * <p>Description: 缓存信息 有时间限制的方法</p>
	   * <p>Company: dark </p>
	   * @author try
	   * @date 2014-4-11-下午02:12:13
	   * @version 1.0
	   * @param key
	   * @param value
	   * @param expiration
	   * @return
	   */
    public static boolean safeSet(String key, Object value, String expiration) {
    	
    	if( value == null ){
    		return false;
    	}
    	
        checkSerializable(value);
        int nTimes = 0;
        
		while(true){
			//亚马逊
			if( GameStatus.isUseAmazonawsCache ){
				Future isBoFuture = amazonawsCache.set(key, Time.parseDuration(expiration), value);
				if ( isBoFuture != null ){
					//保存成功
					break;
				}	
	        }else {
	          //其他缓存
	        	if (RemoteCache.cacheImpl.safeSet(key, value, Time.parseDuration(expiration))){
					//保存成功
					break;
				}
			}
			
			if ( nTimes >= 5 ){
				Logger.error("safeSet::" + value.toString());
				break;
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nTimes++;
			
			Logger.info("memcached add error ");
		}

        return true;
    }
    
    
    /**
     * Delete an element from the cache.
     * @param key The element key
     */
    public static void delete(String key) {
    	if( GameStatus.isUseAmazonawsCache ){
    		amazonawsCache.delete(key);
    	}else {
    		RemoteCache.cacheImpl.delete(key);
		}
    }
    
    
    /**
     * Retrieve an object.
     * @param key The element key
     * @return The element value or null
     */
    public static Object get(String key) {
    	if( GameStatus.isUseAmazonawsCache ){
    		return amazonawsCache.get(key);
    	}else {
    		return RemoteCache.cacheImpl.get(key);
		}
    }
    
    /**
     * Utility that check that an object is serializable.
     */
    static void checkSerializable(Object value) {
        if(value != null && !(value instanceof Serializable)) {
            throw new CacheException("Cannot cache a non-serializable value of type " + value.getClass().getName(), new NotSerializableException(value.getClass().getName()));
        }
    }
    
}
