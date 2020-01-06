package nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import enu.ServerErrorCodeEnu;

/**
 * 逻辑服务数据类。
 * 主要功能：逻辑服务通道的数据报文编码和解码封装。
 * @author try
 *
 */
public class LogicServiceData {

	// 缓冲区
	private ByteBuf dataBuffer;
	// 服务类型码
	private int apiType;
	//请求序号(也就是哪个handle)
	private int handle;
	//服务器返回的状态
	private int error;
	
	/**
	 * 构造函数
	 */
	public LogicServiceData(){
		
		this.dataBuffer = Unpooled.buffer();
		this.apiType = -1;
		//设置默认的状态为成功
		this.error = ServerErrorCodeEnu.code_2000.getValue();
	}
	
	/**
	 * 带数据缓冲区参数的构造函数。
	 * @param buffer
	 */
	public LogicServiceData(ByteBuf buffer){
		
		this.dataBuffer = buffer;
		buffer.readInt(); // 跳过数据总长度字段
		this.apiType = buffer.readInt();
		this.handle = buffer.readInt();
		this.error = buffer.readInt();
//		this.dataBuffer.clear();
	}

	/**
	 * 获取数据缓冲区。
	 * @return
	 */
	public ByteBuf getDataBuffer() {
		return dataBuffer;
	}
	
	/**
	 * 获取逻辑服务通道类型
	 * @return
	 */
	public int getApiType() {
		return this.apiType;
	}

	/**
	 * 设置逻辑服务类型标识
	 * @param serviceType
	 */
	public void setApiType(int apiType) {
		this.apiType = apiType;
	}

	public int getHandle() {
		return this.handle;
	}

	public void setHandle(int handle) {
		this.handle = handle;
	}
	
	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	/**
	 * 写入字符串
	 * @throws Exception 
	 */
	public void writeString(String str) throws Exception{
		if(str == null || str.length() == 0){
			this.dataBuffer.writeInt(0);
			return;
		}
		byte[] buff = str.getBytes("UTF-8");
		this.dataBuffer.writeInt(buff.length);
		this.dataBuffer.writeBytes(buff);
	}
	
	/**
	 * 读取字符串
	 * @return
	 * @throws Exception 
	 */
	public String readString() throws Exception{
		
		String str = null;
		int len = this.dataBuffer.readInt();
		if(len <= 0){
			System.out.println("len <= 0");
			this.dataBuffer.clear();
			return str;
		}
		byte[] tempBuf = new byte[len];
		this.dataBuffer.readBytes(tempBuf, 0, len);
		str = new String(tempBuf, "UTF-8");
		this.dataBuffer.clear();
		return str;
	}
	
	/**
	 * 写入整数
	 * @param vale
	 */
	public void writeInt(int value){
		this.dataBuffer.writeInt(value);
	}
	
	/**
	 * 读取整数
	 * @return
	 */
	public int readInt(){
		return this.dataBuffer.readInt();
	}
	
	public void writeShort(short value){
		this.dataBuffer.writeShort(value);
	}
	
	public short readShort(){
		return this.dataBuffer.readShort();
	}
	
	public void writeByte(byte value){
		this.dataBuffer.writeByte(value);
	}
	
	public byte readByte(){
		return this.dataBuffer.readByte();
	}
	
	public void writeBoolean(boolean value){
		this.dataBuffer.writeBoolean(value);
	}
	
	public boolean readBoolean(){
		return this.dataBuffer.readBoolean();
	}
	
	/**
	 * 写入两个字节的char
	 * @param value
	 */
	public void writeChar(int value){
		this.dataBuffer.writeChar(value);
	}
	
	public char readChar(){
		return this.dataBuffer.readChar();
	}
	
	/**
	 * 写入8个字节的double
	 * @param value
	 */
	public void writeDouble(double value){
		this.dataBuffer.writeDouble(value);
	}
	
	public double readDouble(){
		return this.dataBuffer.readDouble();
	}
	
	/**
	 * 写入4个字节的float
	 * @param value
	 */
	public void writeFloat(float value){
		this.dataBuffer.writeFloat(value);
	}
	
	public float readFloat(){
		return this.dataBuffer.readFloat();
	}
	
	/**
	 * 写入8个字节的long
	 * @param value
	 */
	public void writeLong(long value){
		this.dataBuffer.writeLong(value);
	}
	
	public long readLong(){
		return this.dataBuffer.readLong();
	}
	
	/**
	 * 写入3个字节的int
	 * @param value
	 */
	public void writeMedium(int value){
		this.dataBuffer.writeMedium(value);
	}
	
	public int readMedium(){
		return this.dataBuffer.readMedium();
	}
	
	/**
	 * 写入一个byte数组chunk
	 * @param src
	 */
	public void writeBytesChunk(byte[] src){
		this.dataBuffer.writeInt(src.length);
		this.dataBuffer.writeBytes(src);
	}
	
	public byte[] readBytesChunk(){
		int len = this.readInt();
		byte[] buff = new byte[len];
		this.dataBuffer.readBytes(buff, 0, len);
		this.dataBuffer.clear();
		return buff;
	}
	
	/**
	 * 写入一个对象
	 * @param obj
	 * @throws Exception 
	 */
	public void writeObject(ISerialize obj) throws Exception{
		
		this.writeString(obj.getClass().getName());
		obj.serialize(this);
	}
	
	/**
	 * 读取一个对象
	 * @return
	 * @throws Exception 
	 */
	public ISerialize readObject() throws Exception{
		
		Class<?> t = Class.forName(this.readString());getClass();
		ISerialize obj = (ISerialize)t.newInstance();
		obj.deserialize(this);
		this.dataBuffer.clear();
		return obj;
	}
}
