package nio.handler;

import com.google.gson.Gson;

import config.GameStatus;
import enu.NettyHandleEnu;
import enu.ServerAPICodeEnu;
import enu.ServerErrorCodeEnu;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import message.ResultByJson;
import models.Player;
import nio.LogicServiceData;
import play.Logger;
import play.db.jpa.JPAPlugin;
import play.db.jpa.Transactional;
import protobuf.GameInitBuf;
import protobuf.ResultByJsonBuf;
import service.bean.PlayerStatusServiceBean;

/**
 * <p>Title: GameHandlerService</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年12月19日-下午2:55:28</p>
 * <p>version 1.0</p>
 * <p>Description: game </p>
 */
public class GameHandlerService extends BaseHandlerService{
	
	private NettyHandleEnu handleEnu ;
	
	//实现声明自己是属于什么handler
	public GameHandlerService(){
		handleEnu = NettyHandleEnu.GAME;
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
			System.out.println("GameHandlerService-->");	
			if( data == null || ctx == null ){
				ackData.setHandle(this.handleEnu.getValue());
				ackData.setError(ServerErrorCodeEnu.code_2001.getValue());
				super.sendAckMessage( ackData , ctx );
				// 释放资源
				ReferenceCountUtil.release(msg);
				return;
			}
			
			NettyHandleEnu enu = NettyHandleEnu.valueOf(data.getHandle());
			
			ServerAPICodeEnu serverAPICodeEnu = ServerAPICodeEnu.valueOf( data.getApiType() );
			
			if( enu == null || serverAPICodeEnu == null ){
				Logger.info(" is not handle ");
				ackData.setHandle(this.handleEnu.getValue());
				ackData.setError(ServerErrorCodeEnu.code_2002.getValue());
				super.sendAckMessage( ackData , ctx );
				// 释放资源
				ReferenceCountUtil.release(msg);
				return;
			}
			
			//处理是否向下面的Handler走
			if( enu.getValue() != handleEnu.getValue() ){
				//向下找
				ctx.fireChannelRead(msg);
				return;
			}
			
			byte[] buf =  data.readBytesChunk();
			switch ( serverAPICodeEnu ) {
			case GAME_API_2000:
				GameInitBuf.GameInitVo gameInitBuf = GameInitBuf.GameInitVo.parseFrom(buf);
				Logger.info("GameHandlerService-->");
				gameInit( gameInitBuf , ctx );
				break;
			default:
				ackData.setHandle(this.handleEnu.getValue());
				ackData.setError(ServerErrorCodeEnu.code_2002.getValue());
				super.sendAckMessage( ackData , ctx );
				break;
			}
			// 释放资源
			ReferenceCountUtil.release(msg);
			System.out.println("释放资源----");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if( isRelease ) {
				System.out.println("GameHandlerService finally");
				ReferenceCountUtil.release(msg);
			}
		}
	}
	
	
	/**
	 * GAME_API_2000  游戏初始化 
	 * @param authSmsCodeBuf
	 * @param ctx
	 * @throws Exception
	 */
	@Transactional
    public void gameInit( GameInitBuf.GameInitVo gameInitBuf , ChannelHandlerContext ctx ) throws Exception {
    	
    	LogicServiceData ackData = new LogicServiceData();
		ackData.setApiType(ServerAPICodeEnu.GAME_API_2000.getValue());
		//设置错误信息,默认成功
		ackData.setError(ServerErrorCodeEnu.code_2000.getValue());
		ackData.setHandle(this.handleEnu.getValue());
		
    	try {
    		
    		if( gameInitBuf == null || gameInitBuf.getLevel() <= 0 || gameInitBuf.getGameType() <= 0  
    				|| gameInitBuf.getPlayerId() <= 0   ){
    			ackData.setError(ServerErrorCodeEnu.code_2002.getValue());
    			super.sendAckMessage( ackData , ctx );
        		return;
    		}
    		JPAPlugin.startTx(false);
    		
    		Player player = Player.findById( gameInitBuf.getPlayerId() );
    		if( player == null ) {
    			ackData.setError(ServerErrorCodeEnu.code_2003.getValue());
    			super.sendAckMessage( ackData , ctx );
        		return;
    		}
    		
    		if( player.getStamina() < GameStatus.stamina_use ) {
    			ackData.setError(ServerErrorCodeEnu.code_2011.getValue());
    			super.sendAckMessage( ackData , ctx );
        		return;
    		}
    		
    		System.out.println("gameInit");
			
    		ResultByJson resultByJson = new ResultByJson() ; 
    		resultByJson.playerRes = PlayerStatusServiceBean.userLoginRes( player ); 
    		ResultByJsonBuf.ResultByJsonVo resultByJsonBuf = ResultByJsonBuf.ResultByJsonVo.newBuilder()
    				.setMeaasge(new Gson().toJson(resultByJson)).setSign("sign").build();
    		ackData.writeBytesChunk( resultByJsonBuf.toByteArray() );
    		super.sendAckMessage( ackData , ctx );
    		JPAPlugin.closeTx(false);
		} catch (Exception e) {
			ackData.setError(ServerErrorCodeEnu.code_2002.getValue());
			super.sendAckMessage( ackData , ctx );
			e.printStackTrace();
		}
    }
    
}