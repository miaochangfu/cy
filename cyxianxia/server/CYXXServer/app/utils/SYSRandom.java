package utils;

import java.util.Random;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:43:51
 */
public class SYSRandom {

	/**
	 * 根据传进来的数字从中随机一个[0-intcount]
	 * @param intcount
	 * @return Integer
	 */
	public static Integer getRandomFromZero(Integer intcount) {
		int num = 0;
		try {
			if( intcount != null && intcount == 0 ){
				return num;
			}
			Random ran = new Random();
			num = ran.nextInt(intcount);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	/**
	 * 根据传进来的数字从中随机一个
	 * @param intcount
	 * @return Integer
	 */
	public static Integer getRandom(Integer intcount) {
		int num = 0;
		try {
			if( intcount != null && intcount == 0 ){
				return num;
			}
			Random ran = new Random();
			num = ran.nextInt(intcount)+1;
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	/**
	 * 
	 * @author try
	 * @date  2013-3-4
	 * @version 1.0
	 * @param intcount 总共count
	 * @param indx  取多少条数据
	 * @return 
	 */
	public static Integer getRandomIndex(int intcount,int index) {
		if(intcount <= index){
			return 0;
		}
		return getRandom(intcount-index);
	}
	
		/**
	　　*
	　　* @param start
	　　* @param end
	　　* @return >= start && <=end 的随机数
	　　* end需大于start 否则返回-1
	　　*/

	public static int getRandom(int start, int end) {
		if (start > end || start < 0 || end < 0) {
			return -1;
		}
		return (int) ((Math.random() * (end - start + 1)) + start);
	}
	
}
