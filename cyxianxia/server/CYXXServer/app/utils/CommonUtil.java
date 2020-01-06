package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import play.Play;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:43:37
 */
public class CommonUtil {

	/**
	 * 得到文件下的子文
	 * 
	 * @param String
	 * @return String
	 */

	public static Set<String> getATypeFileOfFoder(File forder, String prefix,
			String suffix) {
		if (!forder.isDirectory()) {
			return null;
		}
		Set<String> set = new HashSet<String>();
		for (File file : forder.listFiles()) {
			if (file.isFile()) {
				String fileName = file.getName();
				if (fileName.startsWith(prefix) && fileName.endsWith(suffix)) {
					set.add(fileName);
				}
			}
		}
		return set;
	}

	/**
	 * ISO8859转GBK
	 * @return String
	 */
	public static String getISOByGBK(String iso) throws Exception{
		String itemname = null;
		if(iso==null){
			return itemname;
		}
		itemname = new String(iso.getBytes("ISO8859-1"),"GBK");	
		return itemname;
	}
	
	/**
	 * <p>Description: </p>
	 * <p>Company: dark </p>
	 * @author try
	 * @date 2013-4-16-上午10:32:37
	 * @version 1.0
	 * @param plainText
	 * @return Byte
	 */
	public static String encodePasswordByte(String plainText) throws Exception{
			MessageDigest alga = MessageDigest.getInstance("MD5");
			alga.update(plainText.getBytes());
			return byteToString(alga.digest());
	}

	
	/**
	 * 对字符传进行MD5 加密
	 * @param String
	 * @return String
	 */
	public static String encodePassword(String plainText) throws Exception{
			String str = "";
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
			return str;		
	}
	
	/**
	 * 验证密码
	 * 
	 * @param sourcePassword(原始密码),newPsssword(新密
	 * @return boolean
	 */
	public static boolean validatePassword(String sourcePassword,
			String newPassword) throws Exception{
		MessageDigest algb = MessageDigest.getInstance("MD5");
		algb.update(newPassword.getBytes());
		if (MessageDigest.isEqual(stringToByte(sourcePassword), algb
				.digest())) {
			return true;
		}	
		return false;
	}

	/**
	 * 二进制转字符
	 * 
	 * @param byte[]
	 * @return String
	 */
	public static String byteToString(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toString(b[n]));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
			if (n < b.length - 1) {
				hs = hs + ":";
			}
		}
		return hs.toUpperCase();
	}

	/**
	 * 字符串转二进
	 * 
	 * @param str
	 * @return byte []
	 */
	public static byte[] stringToByte(String str) {
		String[] ss = str.split("::");
		byte[] bs = new byte[ss.length];
		for (int i = 0; i < ss.length; i++) {
			bs[i] = Byte.parseByte(ss[i]);
		}
		return bs;
	}

	/**
	 * 日期转为字符
	 * 
	 * @param date，pattern
	 * @return string
	 */
	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 把对象的前一个字母转化成小写
	 * 
	 * @param name
	 * @return
	 */
	public static String startNameLowerCase(String name) {
		if (name == null) {
			return "";
		}
		if (name.length() <= 1) {
			return name.toLowerCase();
		}
		StringBuffer bufferDomainName = new StringBuffer();
		bufferDomainName.append(name.substring(0, 1).toLowerCase());
		bufferDomainName.append(name.substring(1));
		return bufferDomainName.toString();
	}

	/**
	 * 把对象的前一个字母转化成大写
	 * 
	 * @param name
	 * @return
	 */
	public static String startNameUpperCase(String name) {
		if (name == null) {
			return "";
		}
		if (name.length() <= 1) {
			return name.toUpperCase();
		}
		StringBuffer bufferDomainName = new StringBuffer();
		bufferDomainName.append(name.substring(0, 1).toUpperCase());
		bufferDomainName.append(name.substring(1));
		return bufferDomainName.toString();
	}

	/**
	 * 从路径中获得的Object
	 * 
	 * @param objName
	 * @return
	 */
	public static Object readObjectFromClassResource(String path) {
		try {
			InputStream in = CommonUtil.class.getClassLoader()
					.getResource(path).openConnection().getInputStream();
			ObjectInputStream inobj = new ObjectInputStream(in);
			Object obj = inobj.readObject();
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将对象中的带name 的属性把pinyin属自动生成 如果没这两个属会报异常
	 * @param obj
	 * @return
	 */
	public static Object setPinyinCode(Object obj) {
		try {
			obj.getClass().getMethod("setPinyin", String.class).invoke(
					obj,
					getPYString((String) obj.getClass().getMethod("getName")
							.invoke(obj)));
			return obj;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return obj;
	}

	private static Map<String, String> map = null;

	/**
	 * 得到拼音字符
	 * 
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getPYString(String str) {
		if (str == null) {
			return "";
		}
		if (map == null) {
			map = (Map<String, String>) CommonUtil
					.readObjectFromClassResource("org/lrb/util/py.map");
		}
		String tempStr = "";
		for (int i = 0; i < str.length(); i++) {
			String buf = null;
			try {
				buf = GetPYChar(str.charAt(i) + "");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (buf == null || buf.equals("")) {
				buf = map.get(str.charAt(i) + "");
			}
			if (buf == null) {
				tempStr += str.charAt(i);
			} else {
				tempStr += buf;
			}
		}
		return tempStr;
	}

	/**
	 * 得到拼音的字
	 * 
	 * @param 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String GetPYChar(String c)
			throws UnsupportedEncodingException {
		byte[] array;
		array = c.getBytes("GBK");
		if (array.length < 2) {
			return c;
		}
		int i = (short) (array[0]) * 256 + ((short) (array[1]));

		if (i < -20575) {
			return c;
		} else if (i < -20539) {
			return "a";
		} else if (i < -20031) {
			return "b";
		} else if (i < -19474) {
			return "c";
		} else if (i < -18966) {
			return "d";
		} else if (i < -18782) {
			return "e";
		} else if (i < -18495) {
			return "f";
		} else if (i < -18178) {
			return "g";
		} else if (i < -17673) {
			return "h";
		} else if (i < -16730) {
			return "j";
		} else if (i < -16468) {
			return "k";
		} else if (i < -15896) {
			return "l";
		} else if (i < -15421) {
			return "m";
		} else if (i < -15178) {
			return "n";
		} else if (i < -15170) {
			return "o";
		} else if (i < -14886) {
			return "p";
		} else if (i < -14405) {
			return "q";
		} else if (i < -14346) {
			return "r";
		} else if (i < -13574) {
			return "s";
		} else if (i < -13094) {
			return "t";
		} else if (i < -12812) {
			return "w";
		} else if (i < -12103) {
			return "x";
		} else if (i < -11311) {
			return "y";
		} else if (i <= -10503) {
			return "z";
		}
		return "";
	}

	/**
	 * 日期转换为字符串
	 * @param date
	 * @return
	 */

	public static String dateToString(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}


	
	/**
	 * 数字格式
	 * @param type
	 * @param value
	 * @return
	 */
	public static String numberFormat(String type, Object value) {
		DecimalFormat formatter = new DecimalFormat(type);
		if (value instanceof Float || value instanceof Double
				|| value instanceof BigDecimal) {
			return formatter.format(((Number) value).doubleValue());
		} else {
			return value.toString();
		}
	}
	/**
	 *  将数字填零补齐为字符
	 * @param num
	 * @param no
	 * @return
	 */
	
	public static String fillZero(long num, int no) {
		StringBuffer numstr = new StringBuffer(num + "");
		while (numstr.length() < no) {
			numstr.insert(0, "0");
		}
		return numstr.toString();
	}

	@SuppressWarnings("unchecked")
	public static void setBeanProperty(Object beanobj, String propername, String propervalue) {
		if(propervalue != null && propervalue.equals("undefined")) {
			propervalue = null;
		}
		try {
			String[] propnames = propername.split("\\.");
			Class paramclass = null;
			String propName = null;
			// 初始化bean非基本对
			for (int i = 0; i < propnames.length - 1; i++) {
				String buf = propnames[i];
				Method[] methods = beanobj.getClass().getMethods();
				Object o = getGetMethod(methods, buf).invoke(beanobj, (Object[]) null);
				Method method = getSetMethod(methods, buf);
				Type type = method.getGenericParameterTypes()[0];
				String typename = type.toString().substring(6);
				paramclass = Class.forName(typename);
				if (o == null) {
					if (!paramclass.getSuperclass().equals(Number.class) && !(paramclass.equals(Date.class) || paramclass.getSuperclass().equals(Date.class)) && !paramclass.equals(String.class)
							&& !paramclass.equals(Boolean.class)) {
						o = paramclass.newInstance();
						method.invoke(beanobj, new Object[] { o });
					}
				}
				beanobj = o;
				propName = buf;
			}
			Method[] methods = beanobj.getClass().getMethods();
			propName = propnames[propnames.length - 1];
			Method method = getSetMethod(methods, propName);
			Type type = method.getGenericParameterTypes()[0];
			String typename = type.toString().substring(6);
			paramclass = Class.forName(typename);
			if (paramclass.getSuperclass().equals(Number.class)) {
				if (isNumber(propervalue)) {
					Object o = paramclass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { propervalue });
					method.invoke(beanobj, new Object[] { o });
				}
			} else if (paramclass.equals(Date.class) || paramclass.getSuperclass().equals(Date.class)) {
				if (propervalue != null && !propervalue.equals("")) {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						method.invoke(beanobj, new Object[] { df.parse(propervalue) });
					} catch (ParseException e) {
						df = new SimpleDateFormat("yyyy-MM-dd");
						try {
							method.invoke(beanobj, new Object[] { df.parse(propervalue) });
						} catch (ParseException e1) {
						}
					}
				}
			} else if (paramclass.equals(String.class)) {
				method.invoke(beanobj, new Object[] { propervalue });
			} else if (paramclass.equals(Boolean.class)) {
				if (propervalue.toLowerCase().equals("true") || propervalue.equals("1") || propervalue.toLowerCase().equals("yes")) {
					method.invoke(beanobj, new Object[] { new Boolean(true) });
				} else if (propervalue.toLowerCase().equals("false") || propervalue.equals("0") || propervalue.toLowerCase().equals("no")) {
					method.invoke(beanobj, new Object[] { new Boolean(false) });
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	private static Method getSetMethod(Method[] methods, String propername) throws NoSuchMethodException {
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().toLowerCase().equals(("set" + propername).toLowerCase())) {
				return methods[i];
			}
		}
		throw new NoSuchMethodException(propername);
	}
	
	private static Method getGetMethod(Method[] methods, String propername) throws NoSuchMethodException {
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().toLowerCase().equals(("get" + propername).toLowerCase())) {
				return methods[i];
			} else if (methods[i].getName().toLowerCase().equals(("is" + propername).toLowerCase())) {
				return methods[i];
			}
		}
		throw new NoSuchMethodException(propername);
	}
	
	public static boolean isNumber(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			int mm = (int) str.charAt(i);
			if ((mm < 48 && mm != 45 && mm != 46) || mm > 57) {
				return false;
			}
		}
		return true;
	}
	 /**
	  *method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
	  *@param dateString 需要转换为timestamp的字符串
	  *@return dataTime timestamp
	  */
	 public  static java.sql.Timestamp string2Time(String dateString) 
	  throws java.text.ParseException {
	   Timestamp ts = Timestamp.valueOf(dateString);
	  return ts;
	 }
	 
	 /**
	  *method 将字符串类型的日期转换为一个Date（java.sql.Date）
	  *@param dateString 需要转换为Date的字符串
	  *@return dataTime Date
	  */
	 public  static java.sql.Date string2Date(String dateString)
	  throws java.lang.Exception {
	  DateFormat dateFormat;
	  dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	  dateFormat.setLenient(false);
	  java.util.Date timeDate = dateFormat.parse(dateString);//util类型
	  java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());//sql类型
	  return dateTime;
	 }
	
	 /***
	  * 注意传入的时间格式为2011-05-09 11:49:45
	  * Timestamp ->   转String 
	  * @param timestamp
	  * @return String
	  */
	 public static String timestampToString(Timestamp timestamp){
		 Timestamp ts = new Timestamp(System.currentTimeMillis());  
		   String tsStr = "";  
		   DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		   try {  
		       //方法一  
		      tsStr = sdf.format(ts);  
//		           //方法二  
//		            tsStr = ts.toString();  
		    } catch (Exception e) {  
		       e.printStackTrace();  
		    }
		return tsStr;  

	 }
	
	 
	 /***
	  * 注意传入的时间格式为2011-05-09 11:49:45
	  * Timestamp ->   转String 
	  * @param timestamp
	  * @return String
	  */
	 public static String timestampToyyyy_MM_dd_HH_mm(Timestamp timestamp){
		   String tsStr = "";  
		   DateFormat sdf = new SimpleDateFormat(DateUtil.FULL_DATE_PATTERN_MM);  
		   try {  
		       //方法一  
		      tsStr = sdf.format(timestamp);  
//		           //方法二  
//		            tsStr = ts.toString();  
		    } catch (Exception e) {  
		       e.printStackTrace();  
		    }
		return tsStr;  
	 }
	 
	 /***
	  * 处理数组  返回Long List
	  * @param str
	  * @return
	  */
	 public static List<Long> getByLongList(String str){
		 List<Long> sublong  =  new ArrayList<Long>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.replace("'", "").split(",");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Long.valueOf(bustr[i]));
		 }		
		return sublong;
	}
	 /***
	  * 根据,裁分
	  * @param str
	  * @return
	  */
	 public static List<String> getByStringList(String str){
		 List<String> subString  =  new ArrayList<String>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split(",");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   subString.add(String.valueOf(bustr[i]));
		 }		
		return subString;
	}
	 
	 /***
	  * 根据&裁分
	  * @param str
	  * @return
	  */
	 public static List<String> getStringList(String str){
		 List<String> subString  =  new ArrayList<String>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split("&");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   subString.add(String.valueOf(bustr[i]));
		 }		
		return subString;
	}
	 
	 /***
	  * 处理数组  返回Integer List
	  * @param str
	  * @return
	  */
	 public static List<Integer> getByIntegerList(String str){
		 List<Integer> sublong  =  new ArrayList<Integer>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.replace("'", "").split(",");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Integer.valueOf(bustr[i]));
		 }		
		return sublong;
	}
	 
	 
	 /***
	  * 根据_裁分
	  * @param str
	  * @return
	  */
	 public static List<Integer> getByIntegerList_(String str){
		 List<Integer> sublong  =  new ArrayList<Integer>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split("_");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Integer.valueOf(bustr[i]));
		 }		
		return sublong;
	}
	 /**
	  * 根据-裁分
	  * @param str
	  * @return
	  */
	 public static List<Long> getlongList(String str){
		 List<Long> sublong  =  new ArrayList<Long>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split("-");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Long.valueOf(bustr[i]));
		 }		
		return sublong;
	}
	 
	 /**
	  * 根据:裁分
	  * @param str
	  * @return
	  */
	 public static List<Long> getMapLongs(String str){
		 List<Long> sublong  =  new ArrayList<Long>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split(":");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Long.valueOf(bustr[i]));
		 }		
		return sublong;
	}
	 /**
	  * 根据,裁分
	  * @param str
	  * @return
	  */
	 public static List<Long> getLongList(String str){
		 List<Long> sublong  =  new ArrayList<Long>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split(",");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Long.valueOf(bustr[i]));
		 }		
		return sublong;
	}
	 
	 /**
	  * 根据;裁分
	  * <p>Description: ; </p>
	  * <p>Company: dark </p>
	  * @return
	  */
	 public static List<Long> getLongLists(String str){
		 List<Long> sublong  =  new ArrayList<Long>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split(";");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
			 sublong.add(Long.valueOf(bustr[i]));
		 }			
		return sublong;
	}
	 
	 
	 /**
	  * 根据;裁分
	  * <p>Description: ; </p>
	  * <p>Company: dark </p>
	  * @return
	  */
	 public static List<String> getStringLists(String str){
		 List<String> sublong  =  new ArrayList<String>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 str = str.replace(" ", "");
		 String bustr[] = str.split(";");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
			 sublong.add(bustr[i]);
		 }		 	
		return sublong;
	}
	 
	 /**
	  * <p>Description: : </p>
	  * <p>Company: dark </p>
	  * @return
	  */
	 public static List<String> getStringListsTwo(String str){
		 List<String> sublong  =  new ArrayList<String>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split("-");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(bustr[i]);
		 }			
		return sublong;
	}
	 
	 /**
	  * <p>Description: ; </p>
	  * <p>Company: dark </p>
	  * @return
	  */
	 public static List<Integer> getIntegerLists(String str){
		 List<Integer> sublong  =  new ArrayList<Integer>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split(";");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Integer.valueOf(bustr[i]));
		 }			
		return sublong;
	}
	
	 /**
	  * <p>Description: ; </p>
	  * <p>Company: dark </p>
	  * @return
	  */
	 public static List<Float> getFloatLists(String str){
		 List<Float> sublong  =  new ArrayList<Float>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split(";");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Float.valueOf(bustr[i]));
		 }			
		return sublong;
	}
	 
	 /**
	  * <p>Description: ; </p>
	  * <p>Company: dark </p>
	  * @return
	  */
	 public static List<String> getStringLists_(String str){
		 List<String> sublong  =  new ArrayList<String>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split(";");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(bustr[i]);
		 }			
		return sublong;
	}
	 
	 /**
	  * <p>Description: , </p>
	  * <p>Company: dark </p>
	  * @return
	  */
	 public static List<Integer> getIntegerListsBy(String str){
		 List<Integer> integers  =  new ArrayList<Integer>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split(",");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
			 integers.add(Integer.valueOf(bustr[i]));
		 }			
		return integers;
	}
	 
	 /**
	  * <p>Description:~ </p>
	  * <p>Company: dark </p>
	  * @return
	  */
	 public static List<Integer> getIntegerLists_(String str){
		 List<Integer> sublong  =  new ArrayList<Integer>();
		 if(str==null||"".equals(str)){
			 return null;
		 }
		 String bustr[] = str.split("~");
		 for (int i = 0; i<bustr.length; i++) {
			 if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
		   sublong.add(Integer.valueOf(bustr[i]));
		 }		
		return sublong;
	}
	 
	 
	 /***
	  * 处理数组  返回Int List
	  * @param str
	  * @return
	  */
	 public static List<Integer> getByIntList(String str){
		List<Integer> sublong  =  new ArrayList<Integer>();
		String bustr[] = str.replace("'", "").split(",");
	    for (int i = 0; i<bustr.length; i++) {
	    	if( "".equals(bustr[i]) || bustr[i] == null || bustr[i] == ""){
				 continue;
			 }
	    	sublong.add(Integer.valueOf(bustr[i]));
		}
		return sublong;
	}
	 /***
	  * 得到Timestamp时间
	  * @return Timestamp
	  */
	 public static Timestamp getByTimestamp(){
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}

	 
	 public static String getCharString(Long playerId){
			
		char str [] = {'Q', '3', 'W', 'E', '2', 'R', '6', 'T', 'Y', '5', 'U', 'I', '4', 'O',
				'P', 'G', '8', 'F', 'D', 'A', 'S', 'H', '9', 'J', 'K', 'L', '7', 'M', 
				'N', 'B', 'V', '0', 'C', 'X', '1', 'Z'};
		Integer devision = Integer.valueOf(playerId.toString());
		Integer a = 0;
		String getStr = "";
		while (devision>0) {
			a = devision%str.length;
			devision = devision/str.length;
			getStr = str[a]+getStr;
		}
		List<String> strList = new  ArrayList<String>();
		
		int length = getStr.length();
		if(length<6)
		{
			for(int j = length ;j<6 ;  j++)
			{
				getStr = str[j - length]+getStr;
			}
		}
		for (int i = 0; i < getStr.length(); i++) {
			if(i == 1){
				strList.add(str[SYSRandom.getRandom(str.length-1)]+"");
			}
			if(i == 4){
				strList.add(str[SYSRandom.getRandom(str.length-1)]+"");
			}
			strList.add(getStr.substring(i, i+1));
		}
		getStr = "";
		for (int i = 0; i < strList.size(); i++) {
			getStr+=strList.get(i);
		}
		return getStr;
	}
	
	 
	 public static String getChar(Long playerId){
			
			char str [] = {'3', '2',  '6', '5', '8',  '9', '7', '0', '1', '4'};
			Integer devision = Integer.valueOf(playerId.toString());
			Integer a = 0;
			String getStr = "";
			while (devision>0) {
				a = devision%str.length;
				devision = devision/str.length;
				getStr = str[a]+getStr;
			}
			List<String> strList = new  ArrayList<String>();
			
			int length = getStr.length();
			if(length<6)
			{
				for(int j = length ;j<6 ;  j++)
				{
					getStr = str[j - length]+getStr;
				}
			}
			for (int i = 0; i < getStr.length(); i++) {
				if(i == 1){
					strList.add(str[SYSRandom.getRandom(str.length-1)]+"");
				}
				if(i == 4){
					strList.add(str[SYSRandom.getRandom(str.length-1)]+"");
				}
				strList.add(getStr.substring(i, i+1));
			}
			getStr = "";
			for (int i = 0; i < strList.size(); i++) {
				getStr+=strList.get(i);
			}
			return getStr;
		}
	 
		/***
		 * 取得系统的资源文件目录
		 * @param nameProperty
		 * @return
		 */
		public static String getSystemProperty(String nameProperty){
			String strPath = null;
			strPath  =  Play.configuration.getProperty(nameProperty);
			return strPath;
		}
		/**
		 * list集合转数组
		 * @param cls    数组类型
		 * @param items  数据集合
		 * @return  数组
		 */
		public static <T> T[] toArray(Class<?> cls, List<T> items) {
			if (items == null || items.size() == 0) {
				return (T[]) Array.newInstance(cls, 0);
			}
			return items.toArray((T[]) Array.newInstance(cls, items.size()));
		}
		
		
		public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(src);

			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			ObjectInputStream in = new ObjectInputStream(byteIn);
			@SuppressWarnings("unchecked")
			List<T> dest = (List<T>) in.readObject();
			return dest;
		}
		
		

		/** 
	     * 检测邮箱地址是否合法 
	     * @param email 
	     * @return true合法 false不合法 
	     */  
	    public static  boolean isEmail(String email){  
	          if (null==email || "".equals(email)) return false;    
	          Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配  
	          Matcher m = p.matcher(email);  
	          return m.matches();  
	    }  
		
	    
}
