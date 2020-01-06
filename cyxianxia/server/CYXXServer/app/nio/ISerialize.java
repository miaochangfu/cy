package nio;


/**
 * 序列化和反序列化的接口
 * @author bofeng
 *
 */
public interface ISerialize {

	/**
	 * 序列化函数
	 * @param data
	 * @throws Exception
	 */
	public void serialize(LogicServiceData data) throws Exception;
	/**
	 * 反序列化函数
	 * @param data
	 * @throws Exception
	 */
	public void deserialize(LogicServiceData data) throws Exception;
}
