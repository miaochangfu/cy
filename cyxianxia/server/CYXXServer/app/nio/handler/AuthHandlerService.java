package nio.handler;

import enu.NettyHandleEnu;
import enu.ServerAPICodeEnu;
import enu.ServerErrorCodeEnu;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import models.PlayerStatus;
import nio.LogicServiceData;
import play.Logger;
import play.db.jpa.Transactional;
import protobuf.AuthSmsCodeBuf;
import service.tcp.UserService;

/**
 * @author:try
 * @version:1.0
 * @Description:认证Handler
 * @Date:2016年7月28日下午11:39:32
 */
public class AuthHandlerService extends BaseHandlerService{
	
	private NettyHandleEnu handleEnu ;
	
	//实现声明自己是属于什么handler
	public AuthHandlerService(){
		handleEnu = NettyHandleEnu.Auth;
	}
	
	/**
	 * 重载信道读取方法。协议定义：
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg) {
		
		boolean isRelease = true ;
		
		try {
			
			LogicServiceData ackData = new LogicServiceData();
			ackData.setApiType(ServerAPICodeEnu.API_0.getValue());
			LogicServiceData data = (LogicServiceData) msg;
			
			if( data == null || ctx == null ){
				ackData.setHandle(this.handleEnu.getValue());
				ackData.setError(ServerErrorCodeEnu.code_2001.getValue());
				super.sendAckMessage( ackData , ctx );
				return;
			}
			
			NettyHandleEnu enu = NettyHandleEnu.valueOf(data.getHandle());
			
			ServerAPICodeEnu serverAPICodeEnu = ServerAPICodeEnu.valueOf( data.getApiType() );
			
			if( enu == null || serverAPICodeEnu == null ){
				Logger.info(" is not handle ");
				ackData.setHandle(this.handleEnu.getValue());
				ackData.setError(ServerErrorCodeEnu.code_2002.getValue());
				super.sendAckMessage( ackData , ctx );
				return;
			}
			//处理是否向下面的Handler走
			if( enu.getValue() != handleEnu.getValue() ){
				//向下找
				ctx.fireChannelRead(msg);
				isRelease = false;
				return;
			}
			
			System.out.println("AuthHandlerService-->");	
			
			byte[] buf =  data.readBytesChunk();
			
			switch ( serverAPICodeEnu ) {
			case API_0:
				ackData.setHandle(this.handleEnu.getValue());
				ackData.setError(ServerErrorCodeEnu.code_2000.getValue());
				super.sendAckMessage( ackData , ctx );
				break;
			case API_100:
				AuthSmsCodeBuf.AuthSmsCodeVo authSmsCodeBuf = AuthSmsCodeBuf.AuthSmsCodeVo.parseFrom(buf);
				couSms( authSmsCodeBuf , ctx );
				break;
			default:
				ackData.setHandle(this.handleEnu.getValue());
				ackData.setError(ServerErrorCodeEnu.code_2002.getValue());
				super.sendAckMessage( ackData , ctx );
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if( isRelease ) {
				System.out.println("AuthHandlerService finally");
				ReferenceCountUtil.release(msg);
			}
		}
					
	}
	
	
	/**
	 * API_100
	 * @author:try
	 * @Description:创建或更新短信验证码数据
	 * @Date:2016年7月31日上午1:05:19
	 * @return: void
	 */
	@Transactional
    public void couSms( AuthSmsCodeBuf.AuthSmsCodeVo authSmsCodeBuf , ChannelHandlerContext ctx ) throws Exception {
    	
    	LogicServiceData ackData = new LogicServiceData();
		ackData.setApiType(ServerAPICodeEnu.API_100.getValue());
		//设置错误信息,默认成功
		ackData.setError(ServerErrorCodeEnu.code_2000.getValue());
		ackData.setHandle(this.handleEnu.getValue());
		
    	try {
    		
    		if( authSmsCodeBuf == null ){
    			ackData.setError(ServerErrorCodeEnu.code_2002.getValue());
    			super.sendAckMessage( ackData , ctx );
        		return;
    		}
    		
    		//验证手机是否合法
        	if (!authSmsCodeBuf.getMobile().matches("1\\d{10}")) {
        		ackData.setError(ServerErrorCodeEnu.code_2010.getValue());
    			super.sendAckMessage( ackData , ctx );
        		return;
            }
        	
        	//根据手机号查找是否该手机已存在
//            PlayerStatus hasUser = UserService.getSavePlayerStatus( authSmsCodeBuf.getMobile() );
//            if ( hasUser  != null ) {
//            	UserService.getUpdatePlayerStatus(hasUser.getId());
//            	ackData.setError(ServerErrorCodeEnu.code_2009.getValue());
//    			super.sendAckMessage( ackData , ctx );
//            	return;
//            }
//            
//    		Long smsOldCode = (Long) RemoteCache.get(CacheKey.getUserSmsCacheKey(mobile));
//        	
//        	Timestamp newTimestamp = CommonUtil.getByTimestamp();
        	
        	super.sendAckMessage( ackData , ctx );
		} catch (Exception e) {
			ackData.setError(ServerErrorCodeEnu.code_2002.getValue());
			super.sendAckMessage( ackData , ctx );
			e.printStackTrace();
		}
    }
    
}