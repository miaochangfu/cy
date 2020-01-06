package plugins;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.sql.Timestamp;

import cache.AmazonawsCache;
import cache.RemoteCache;
import config.GameStatus;
import play.Logger;
import play.PlayPlugin;
import play.mvc.Http;
import utils.CommonUtil;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:43:15
 *///JPAPlugin
public class LocalCachePlugin extends PlayPlugin {

	public Timestamp newTimestamp;
	
	public Long startTime;
	
	/**
	 * Called after the application start.
	 */
	public void afterApplicationStart() {
		Logger.info("------调用方法afterApplicationStart缓存-----start------");
		System.out.println("------调用方法afterApplicationStart缓存-----start------");
		AmazonawsCache.init();
		RemoteCache.init();
		Logger.info("------调用方法afterApplicationStart缓存-----end------");
		System.out.println("------调用方法afterApplicationStart缓存-----end------");
		
		startTime = System.currentTimeMillis();
		
	}

	/**
	 * Called at application stop (and before each reloading) Time to shutdown
	 * stateful things.
	 */
	public void onApplicationStop() {
		Logger.info("STOP!!!!!!!!!");
		try {
			RemoteCache.stop();
		} catch (Exception err) {
			err.printStackTrace();
		}
		Logger.info("OVER!!!!!!!!!");
	}

	public void onConfigurationRead() {
		Logger.info("onConfigurationRead!!!!!!!!!");
		try {
			Logger.info("update cycleTimeReward !!!!!!!!!");
			AmazonawsCache.amazonawsCache = null;
			RemoteCache.cacheImpl = null;
			Logger.info("stop memcached!!!!!!!!!");
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
    /**
     * Called before a Play! invocation.
     * Time to prepare request specific things.
     */
    public void beforeInvocation() {
    	if(  Http.Request.current() != null ){
    		newTimestamp = CommonUtil.getByTimestamp();
    	}
    }
    
    /**
     * Called after an invocation.
     * (unless an excetion has been thrown).
     * Time to close request specific things.
     */
    public void afterInvocation() {
    	if(newTimestamp!=null && Http.Request.current() != null ){
    		long date = CommonUtil.getByTimestamp().getTime()-newTimestamp.getTime();
    		GameStatus.LOG_REQUEST_PARAMETERS_LOGGER.info(date+"ms::" + 
    				Http.Request.current().getBase() + Http.Request.current().url);
    	}
    }
    
    
    /** Get CPU time in nanoseconds. */
    public long getCpuTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ? bean.getCurrentThreadCpuTime( ) : 0L;
    }
     
    /** Get user time in nanoseconds. */
    public long getUserTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?bean.getCurrentThreadUserTime( ) : 0L;
    }

}
