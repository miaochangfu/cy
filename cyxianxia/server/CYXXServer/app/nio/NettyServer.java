package nio;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;

import config.GameStatus;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import nio.handler.AuthHandlerService;
import nio.handler.BaseHandlerService;
import nio.handler.GameHandlerService;
import play.Logger;

/**
 * 通信服务器类。
 * @author bofeng
 *
 */
public class NettyServer {
	// 全局唯一实例
	private static NettyServer _instance = null;
	
	public static EntityManager em;
	
	// 会话集合管理
	private ConcurrentHashMap<Integer, UserSession> userSessions;
	
	
	/**
	 * 初始化netty服务器计数器
	 */
	public static Map<String, Integer> initNettyIndexMap(){
		
		Map<String, Integer> nettyIndexMap = new HashMap<String, Integer>();
		if (GameStatus.nettyServiceIP_1 != null && !"".equals(GameStatus.nettyServiceIP_1)) {
			nettyIndexMap.put(GameStatus.nettyServiceIP_1, 0);
		}
		if (GameStatus.nettyServiceIP_2 != null && !"".equals(GameStatus.nettyServiceIP_2)) {
			nettyIndexMap.put(GameStatus.nettyServiceIP_2, 0);
		}
		if (GameStatus.nettyServiceIP_3 != null && !"".equals(GameStatus.nettyServiceIP_3)) {
			nettyIndexMap.put(GameStatus.nettyServiceIP_3, 0);
		}
		return nettyIndexMap;
	}
	
	/**
	 * 获取server实例
	 * @return
	 */
	public static NettyServer getServerInstance(){
		if(_instance == null){
			_instance = new NettyServer();
		}
		return _instance;
	}
	
	/**
	 * 构造函数
	 * @param port
	 */
	private NettyServer(){
		this.userSessions = new ConcurrentHashMap<Integer, UserSession>();
	}
	
	public Class<?> findById( Long id ){
		return null;
	}
	
	public Class<?> find( Long id , String str ){
		return null;
	}
	
	
	
	
	/**
	 * 网络服务运行函数
	 * @throws Exception
	 */
	
	public void bind(){
		
		new Thread(new Runnable() {
			
			public void run() {
				
				EventLoopGroup bossGroup = new NioEventLoopGroup();
				EventLoopGroup workGroup = new NioEventLoopGroup();
				
				Logger.info("------netty--start----"+ GameStatus.PORT + "端口上监听");
				System.out.println("------netty--start----"+ GameStatus.PORT + "端口上监听");
				
				try{
					
					ServerBootstrap b = new ServerBootstrap();
					b.group(bossGroup, workGroup);
					// 定义主信道所使用的类型 --也就是监听信道
					b.channel(NioServerSocketChannel.class);
					// 定义子信道的handler，构造函数传入一个ChannelInitializer的泛型类对象。
					// 这个类用匿名方式定义。
					// 这里定义子信道，也就是通信信道为SocketChanel类型，并在初始化中添加了一个
					// 编码解码器和一个服务器Handler。
					b.childHandler(new ChannelInitializer<SocketChannel>(){

						@Override
						protected void initChannel(SocketChannel arg0) throws Exception {
							
							// 添加逻辑信道协议编码解码器
							arg0.pipeline().addLast("codec", new BaseProtocolCodec());
							// 然后添加服务器handler
							arg0.pipeline().addLast("base", new BaseHandlerService());
							arg0.pipeline().addLast("auth", new AuthHandlerService());
							arg0.pipeline().addLast("game", new GameHandlerService());
//							// 超时检测
//							arg0.pipeline().addLast("timer", new IdleStateHandler(0, 0, NettyStatus.OFF_TIME ));
//							arg0.pipeline().addLast("timeout", new ChannelHandlerAdapter(){
//								
//								/**
//								 * 在指定的时间内没有事件，就关闭信道
//								 */
//								@Override
//								public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//									if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {
//										IdleStateEvent event = (IdleStateEvent) evt;
//										if (event.state() == IdleState.ALL_IDLE){
//											// 打印一条超时信息并关闭信道
////											ByteBuf buf = Unpooled.buffer();
////											buf.writeBytes("time out\r\n".getBytes("UTF-8"));
////											ctx.writeAndFlush(buf);
//											ctx.close();
//										}
//									}
//								}
//							});
						}
					});
					
					b.option(ChannelOption.SO_BACKLOG, 2048);//serverSocketchannel的设置，链接缓冲池的大小
					b.childOption(ChannelOption.SO_KEEPALIVE, true);//socketchannel的设置,维持链接的活跃，清除死链接
//					b.childOption(ChannelOption.TCP_NODELAY, true);//socketchannel的设置,关闭延迟发送
					
					// 绑定端口，并启动开始监听连接到达
					ChannelFuture cf = b.bind(GameStatus.PORT);
					
					Logger.info("------netty--end----"+ GameStatus.PORT + "端口上监听");
					System.out.println("------netty--end----"+ GameStatus.PORT + "端口上监听");
					
					// 阻塞等待，直到socket关闭为止。也就是同步等待信道关闭事件。
					cf.channel().closeFuture().sync();
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					
					// 优雅关闭
					workGroup.shutdownGracefully();
					bossGroup.shutdownGracefully();
				}
			}
		}).start();
	}

	/**
	 * 返回session集合
	 * @return
	 */
	public ConcurrentHashMap<Integer, UserSession> getUserSessions() {
		return userSessions;
	}
	
}
