package nio.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import nio.LogicServiceData;
import play.Logger;
import enu.NettyHandleEnu;
import enu.ServerAPICodeEnu;

/**
 * <p>Title: BaseHandlerService.java</p>
 * <p>Description: </p>
 * @author try
 * @date 2016-7-29-上午11:11:42
 * @version 1.0
 */
public class BaseHandlerService extends ChannelInboundHandlerAdapter{

	/**
	 * 第一个被连接的方法
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		
		//给用户发个心跳
		this.sendAckMessage("0", ServerAPICodeEnu.API_0, ctx , null );
		// 打印测试信息
		Logger.info("有玩家来连接了"+ctx.channel().remoteAddress());
		System.out.println("有玩家来连接了"+ctx.channel().remoteAddress());
	}
	
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)  throws Exception{
		System.out.println("SimpleClient:异常");
        ctx.close();
	}
	
	
	@Override  
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {  
        if (evt instanceof IdleStateEvent) {  
            IdleStateEvent e = (IdleStateEvent) evt;  
            if (e.state() == IdleState.READER_IDLE) {  
                ctx.close();  
                System.out.println("READER_IDLE 读超时");  
            } else if (e.state() == IdleState.WRITER_IDLE) {  
                ByteBuf buff = ctx.alloc().buffer();  
                buff.writeBytes("mayi test".getBytes());  
                ctx.writeAndFlush(buff);  
                System.out.println("WRITER_IDLE 写超时");  
            }  
        }  
    }  
	
	/**
	 * 发送应答
	 * @param successful
	 * @param message
	 * @param errorCode
	 * @throws Exception 
	 */
	public void sendAckMessage(String message, ServerAPICodeEnu errorCode, ChannelHandlerContext ctx , Integer error ) throws Exception{
		
		LogicServiceData ackData = new LogicServiceData();
		ackData.setApiType(errorCode.getValue());
		if( error != null ){
			//设置错误信息,默认成功
			ackData.setError(error);
		}
		ackData.setHandle(NettyHandleEnu.Auth.getValue());
		ackData.writeString(message);
		ctx.writeAndFlush(ackData);
	}
	
	
	/**
	 * 发送应答
	 * @param successful
	 * @param message
	 * @param errorCode
	 * @throws Exception 
	 */
	public void sendAckMessage( LogicServiceData ackData , ChannelHandlerContext ctx ) throws Exception{
		ctx.writeAndFlush(ackData);
	}
	
	
	
}