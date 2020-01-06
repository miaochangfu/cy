package nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

/**
 * 基础协议编码解码类。
 * 主要功能：完成最底层的传输协议，识别来自不同服务通道的数据，
 * 并完成路由。
 * 基础协议包含三个字段：报文总长度、sessionID、逻辑服务通道类型
 * @author try
 *
 */
public class BaseProtocolCodec extends ByteToMessageCodec<LogicServiceData>{

	/**
	 * 编码函数。
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, LogicServiceData msg, ByteBuf out) throws Exception {
		// 编码的过程就是加入报文头部的过程
		out.writeInt(msg.getDataBuffer().readableBytes() + 8);
		out.writeInt(msg.getApiType());
		out.writeInt(msg.getHandle());
		out.writeInt(msg.getError());
		out.writeBytes(msg.getDataBuffer());
	}

	/**
	 * 解码函数。
	 */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// 解码，首先取四字节的报文总长度字段，不足则返回
		if(in.readableBytes() < 4){
			return;
		}
		// 读取数据长度，如果错误则表示网络连接发生了问题，关闭连接
		int dataLength = in.getInt(0);
		if(dataLength < 0){
			System.out.println("协议出错");
			// 打印一条错误信息并关闭信道
			ByteBuf buf = Unpooled.buffer();
			buf.writeBytes("protocol error\r\n".getBytes("UTF-8"));
			ctx.writeAndFlush(buf);
			ctx.close();
		}
//		System.out.println("dataLength = " + dataLength + " and readable = " + in.readableBytes());
		// 如果可读取的数据长度小于获取到的包数据长度，则返回.
		if(in.readableBytes() < dataLength){
			return;
		}
		// 否则，直接用输入ByteBuf作为参数创建输出报文对象，这里是共享缓冲区。所以服务器端逻辑服务通道解码的时候
		// 必须把read指针移动当前报文总长度的距离，但是write指针不能动。
		LogicServiceData data = new LogicServiceData(in);
		out.add(data);
	}

}
