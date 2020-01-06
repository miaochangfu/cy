package cache;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Map;

import play.Logger;
import play.Play;
import play.cache.Cache;
import play.cache.CacheImpl;
import play.cache.MemcachedImpl;
import play.exceptions.CacheException;
import play.libs.Time;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:36:36
 */
public abstract class RemoteCache {

    /**
     * The underlying cache implementation
     */
    public static CacheImpl cacheImpl;
    
    /**
     * Add an element only if it doesn't exist.
     * @param key Element key
     * @param value Element value
     * @param expiration Ex: 10s, 3mn, 8h
     */
    public static void add(String key, Object value, String expiration) {
        checkSerializable(value);
        cacheImpl.add(key, value, Time.parseDuration(expiration));
    }

    /**
     * Add an element only if it doesn't exist, and return only when 
     * the element is effectively cached.
     * @param key Element key
     * @param value Element value
     * @param expiration Ex: 10s, 3mn, 8h
     * @return If the element an eventually been cached
     */
    public static boolean safeAdd(String key, Object value, String expiration) {
        checkSerializable(value);
        return cacheImpl.safeAdd(key, value, Time.parseDuration(expiration));
    }

    /**
     * Add an element only if it doesn't exist and store it indefinitely.
     * @param key Element key
     * @param value Element value
     */
    public static void add(String key, Object value) {
        checkSerializable(value);
        cacheImpl.add(key, value, Time.parseDuration(null));
    }

    /**
     * Set an element.
     * @param key Element key
     * @param value Element value
     * @param expiration Ex: 10s, 3mn, 8h
     */
    public static void set(String key, Object value, String expiration) {
        checkSerializable(value);
        cacheImpl.set(key, value, Time.parseDuration(expiration));
    }

    /**
     * Set an element and return only when the element is effectively cached.
     * @param key Element key
     * @param value Element value
     * @param expiration Ex: 10s, 3mn, 8h
     * @return If the element an eventually been cached
     */
    public static boolean safeSet(String key, Object value, String expiration) {
    	
        checkSerializable(value);

        int nTimes = 0;
		while(true){
			if (cacheImpl.safeSet(key, value, Time.parseDuration(expiration)))
				break;
			
			if ( nTimes >= 10 ){
				Logger.error("safeSet::" + value.toString());
				break;
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nTimes++;
		}

        return true;
    }

    /**
     * Set an element and store it indefinitely.
     * @param key Element key
     * @param value Element value
     */
    public static void set(String key, Object value) {
        checkSerializable(value);
        cacheImpl.set(key, value, Time.parseDuration(null));
    }

    /**
     * Replace an element only if it already exists.
     * @param key Element key
     * @param value Element value
     * @param expiration Ex: 10s, 3mn, 8h
     */
    public static void replace(String key, Object value, String expiration) {
        checkSerializable(value);
        cacheImpl.replace(key, value, Time.parseDuration(expiration));
    }

    /**
     * Replace an element only if it already exists and return only when the 
     * element is effectively cached.
     * @param key Element key
     * @param value Element value
     * @param expiration Ex: 10s, 3mn, 8h
     * @return If the element an eventually been cached
     */
    public static boolean safeReplace(String key, Object value, String expiration) {
        checkSerializable(value);
        return cacheImpl.safeReplace(key, value, Time.parseDuration(expiration));
    }

    /**
     * Replace an element only if it already exists and store it indefinitely.
     * @param key Element key
     * @param value Element value
     */
    public static void replace(String key, Object value) {
        checkSerializable(value);
        cacheImpl.replace(key, value, Time.parseDuration(null));
    }

    /**
     * Increment the element value (must be a Number).
     * @param key Element key 
     * @param by The incr value
     * @return The new value
     */
    public static long incr(String key, int by) {
        return cacheImpl.incr(key, by);
    }

    /**
     * Increment the element value (must be a Number) by 1.
     * @param key Element key 
     * @return The new value
     */
    public static long incr(String key) {
        return cacheImpl.incr(key, 1);
    }

    /**
     * Decrement the element value (must be a Number).
     * @param key Element key 
     * @param by The decr value
     * @return The new value
     */
    public static long decr(String key, int by) {
        return cacheImpl.decr(key, by);
    }

    /**
     * Decrement the element value (must be a Number) by 1.
     * @param key Element key 
     * @return The new value
     */
    public static long decr(String key) {
        return cacheImpl.decr(key, 1);
    }

    /**
     * Retrieve an object.
     * @param key The element key
     * @return The element value or null
     */
    public static Object get(String key) {
        return cacheImpl.get(key);
    }

    /**
     * Bulk retrieve.
     * @param key List of keys
     * @return Map of keys & values
     */
    public static Map<String, Object> get(String... key) {
        return cacheImpl.get(key);
    }

    /**
     * Delete an element from the cache.
     * @param key The element key
     */
    public static void delete(String key) {
        cacheImpl.delete(key);
    }

    /**
     * Delete an element from the cache and return only when the 
     * element is effectively removed.
     * @param key The element key
     * @return If the element an eventually been deleted
     */
    public static boolean safeDelete(String key) {
        return cacheImpl.safeDelete(key);
    }

    /**
     * Clear all data from cache.
     */
    public static void clear() {
        cacheImpl.clear();
    }

    /**
     * Convenient clazz to get a value a class type;
     * @param <T> The needed type
     * @param key The element key
     * @param clazz The type class
     * @return The element value or null
     */
    @SuppressWarnings("unchecked")
	public static <T> T get(String key, Class<T> clazz) {
        return (T) cacheImpl.get(key);
    }

    /**
     * Initialize the cache system.
     */
    public static void init() {
    	if ( cacheImpl != null )
    		return;
    	
    	//remoteCache
        if (Play.configuration.getProperty("remoteCache", "disabled").equals("enabled")) {
            try {
                cacheImpl = MemcachedImpl.getInstance(true);
                //TODO
                cacheImpl.clear();
                Logger.info("Connected to memcached");
                System.out.println("Connected to memcached");
            } catch (Exception e) {
            	Logger.info("Error while connecting to memcached");
                Logger.warn("Fallback to local cache");
                cacheImpl = Cache.cacheImpl;
            }
        }else{
            cacheImpl = Cache.cacheImpl;
        }
    }
    
    /**
     * Stop the cache system.
     */
    public static void stop() {
    	if (cacheImpl != null )
    		cacheImpl.stop();
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


