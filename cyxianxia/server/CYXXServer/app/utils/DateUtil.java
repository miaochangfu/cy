package utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:43:45
 */
public class DateUtil {

	public final static String ORACLE_DATE_PATTERN = "YYYY-MM-DD HH24MISS";

	public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HHmmss";

	public final static String FULL_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public final static String FULL_DATE_PATTERN_MM = "yyyy-MM-dd HH:mm";
	
	public final static String LONG_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss:SSS";
	public final static String LONG_DATE_PATTERN_2 = "yyyy-MM-dd HH:mm:ss.SSS";

	public final static String SHORT_DATE_PATTERN = "yyyy-MM-dd";

	public final static String DATE_PATTERN = "yyyyMMddHHmmss";

//	private final static Log logger = LogFactory.getLog(DateUtil.class);

	/**
	 * 
	 */
	public DateUtil() {
	}

	// 用来全局控制 上一周，本周，下一周的周数变化
	private static int weeks = 0;

	// 获得当前日期与本周一相差的天数
	public static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return -6;
		} else {
			return 2 - dayOfWeek;
		}
	}

	// 获得上周星期一的日期
	public static String getPreviousMonday() {
		weeks--;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得上周星期一的日期
	public static String getNextPreviousMonday() {
		weeks--;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus - 7 * weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}
	
	// 当前周   星期一的日期
	public static String getCurrentMonday() {
		weeks = 0;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}
	
	
	// 当前周   星期五的日期
	public static String getCurrentFirday() {
		Calendar cal=new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 4);
        Date last=cal.getTime();
        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
		return formater.format(last);
	}
	

	// 下一周    星期一的日期
	public static String getNextMonday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * 1);
		Date monday = currentDate.getTime();
		return getDayByDate(monday);
	}

	// 获得相应周的周日的日期
	public static String getSunday() {
//		int mondayPlus = getMondayPlus();
//		GregorianCalendar currentDate = new GregorianCalendar();
//		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
//		Date monday = currentDate.getTime();
//		DateFormat df = DateFormat.getDateInstance();
//		String preMonday = df.format(monday);
		
		Calendar date=Calendar.getInstance(Locale.CHINA);
	    date.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
	    date.add(Calendar.WEEK_OF_MONTH,0);//周数减一，即上周
	    date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//日子设为星期天
	    
		return getDayByDate(date.getTime())+"";
	}

	/**
	 * 返回日期中的年份
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @param strFormat
	 *            格式串
	 * @return
	 */
	public static int getInt(Date date, String strFormat) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);

	}

	/**
	 * 返回给定日期的格式化串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param timeStamp
	 *            时间对像
	 * @return 返回格式为yyyy年MM月dd日 HH时mm分ss秒
	 */
	public static String getFormatDate(Timestamp timeStamp) {
		String strRet = null;
		if (timeStamp == null)
			return strRet = "&nbsp;";
		SimpleDateFormat simple = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		if (simple != null)
			strRet = simple.format(timeStamp);
		return strRet;
	}

	/**
	 * 返回给定日期的格式化串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期对像
	 * @return 返回yyyy年MM月dd日 HH时mm分ss秒
	 */
	public static String getFormatDate(java.sql.Date date) {

		String strRet = null;
		if (date == null) {
			return strRet = "&nbsp;";
		}
		SimpleDateFormat simple = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		if (simple != null)
			strRet = simple.format(date);
		return strRet;
	}

	
	/**
	 * 返回当日日期的格式化串,格式为format
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param format
	 *            格式化串
	 * @return 返回被格式化的当日日期
	 */
	public static String getTodayDate(String format) {
		String strRet = null;
		SimpleDateFormat simple = new SimpleDateFormat(format);
		if (simple != null)
			strRet = simple.format(new Date());
		return strRet;
	}

	/**
	 * 返回当日日期的格式化串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 格式为yyyy-MM-dd
	 */
	public static String getTodayDay() {
		String strRet = null;
		SimpleDateFormat simple = new SimpleDateFormat(SHORT_DATE_PATTERN);
		if (simple != null)
			strRet = simple.format(new Date());
		return strRet;
	}

	/**
	 * 日期的格式化串 yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static String getTodayDay(String dataTime) {
		String strRet = null;
		SimpleDateFormat simple = new SimpleDateFormat(LONG_DATE_PATTERN);
		if (simple != null)
			strRet = simple.format(dataTime);
		return strRet;
	}

	/**
	 * <p>Description: </p>
	 * <p>Company: dark </p>
	 * @author try
	 * @date 2014-6-17-下午03:52:04
	 * @version 1.0
	 * @param dataTime
	 * @return
	 */
	public static String getYYYY_MM_DD(String dataTime) {
		String strRet = null;
		SimpleDateFormat simple = new SimpleDateFormat(SHORT_DATE_PATTERN);
		if (simple != null)
			try {
				strRet = simple.format(DateFormat.getDateInstance().parse(dataTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return strRet;
	}
	
	/**
	 * 返回昨日日期的格式化串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 格式为yyyy-MM-dd
	 */
	public static String getYesterDay() {
		String strRet = null;
		SimpleDateFormat simple = new SimpleDateFormat(SHORT_DATE_PATTERN);
		if (simple != null)
			strRet = simple.format(addDateByDay(new Date(), -1));
		return strRet;
	}

	/**
	 * 返回给定日期的格式化串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @return 格式为yyyy-MM-dd
	 */
	public static String getDayByDate(Date date) {
		String strRet = null;
		SimpleDateFormat simple = new SimpleDateFormat(SHORT_DATE_PATTERN);
		if (simple != null)
			strRet = simple.format(date);
		return strRet;
	}

	/**
	 * 格式化日期,去掉日期中的时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @return 返回忽略日期中的时间部分的日期
	 */
	public static Date getDay(java.util.Date date) {
		String strDate = getFormatDate(date, SHORT_DATE_PATTERN);
		return getDate(strDate, SHORT_DATE_PATTERN);
	}

	/**
	 * 获取给定日期的格式化串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @param strFormat
	 *            格式化串
	 * @return 返回被格式化的日期串，如果日期参数为空返回&nbsp;
	 */
	public static String getFormatDate(java.sql.Date date, String strFormat) {
		String strRet = null;
		if (date == null) {
			return strRet = "&nbsp;";
		}
		SimpleDateFormat simple = new SimpleDateFormat(strFormat);
		if (simple != null)
			strRet = simple.format(date);
		return strRet;
	}

	/**
	 * 对给定日期按格式strFormat进行格式化串处理，并将处理结果按格式toFromat转为日期(如把日期格式化为串yyyy-MM-dd
	 * 23:59:59,再接着把串变为日期)
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @param strFormat
	 *            日期格式化串
	 * @param toFromat
	 *            日期格式化串
	 * @return 格式化好的日期
	 */
	public static Date getDate(Date date, String strFormat, String toFromat) {
		String strRet = null;
		Date rtnDate = null;
		SimpleDateFormat simple = new SimpleDateFormat(strFormat);
		if (simple != null) {
			strRet = simple.format(date);
		}
		simple = new SimpleDateFormat(toFromat);
		if (simple != null) {
			try {
				rtnDate = simple.parse(strRet);
			} catch (ParseException e) {
			}
		}
		return rtnDate;
	}

	/**
	 * 获取某个日期(格式必须为yyyy-MM-dd)的起始时间(时间精确到00:00:00)
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期串,格式为yyyy-MM-dd
	 * @return 起始日期
	 */
	public static Date getBeginDate(String date) {
		if (date != null && !"".equals(date)) {
			String beginDate = date + " 00:00:00";
			return DateUtil.getDate(beginDate, FULL_DATE_PATTERN);
		}
		return null;
	}

	/**
	 * 获取某个日期的结束时间(时间精确到23:59:59:999)
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期串,格式为yyyy-MM-dd
	 * @return 结束时间
	 */
	public static Date getEndDate(String date) {
		if (date != null && !"".equals(date)) {
			String beginDate = date + " 23:59:59:999";
			return DateUtil.getDate(beginDate, LONG_DATE_PATTERN);
		}
		return null;
	}

	/**
	 * 返回当天的起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return
	 */
	public static Date getStartCurrentDay() {
		String date = getFormatDate(new Date(), "yyyy-MM-dd 00:00:00");
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 返回当天的结束时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return
	 */
	public static Date getEndCurrentDay() {
		String date = getFormatDate(new Date(), "yyyy-MM-dd 23:59:59:999");
		return getDate(date, "yyyy-MM-dd HH:mm:ss:SSS");
	}

	/**
	 * 获取某个日期累加指定天数后的起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param day
	 *            日期参数
	 * @param i
	 *            累加天数
	 * @return 起始时间
	 */
	public static Date getStartDay(Date day, int i) {
		String date = getFormatDate(addDateByDay(day, i), "yyyy-MM-dd 00:00:00");
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取某个日期累加指定天数后的结束时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param day
	 *            日期参数
	 * @param i
	 *            累加天数
	 * @return 结束时间
	 */
	public static Date getEndDay(Date day, int i) {
		String date = getFormatDate(addDateByDay(day, i),
				"yyyy-MM-dd 23:59:59:999");
		return getDate(date, "yyyy-MM-dd HH:mm:ss:SSS");
	}

	/**
	 * 获取明日的起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 起始时间
	 */
	public static Date getStartNextDay() {
		String date = getFormatDate(addDateByDay(new Date(), 1),
				"yyyy-MM-dd 00:00:00");
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取本周的第一天
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 本周的第一天
	 */
	public static Date getWeekFirstDay() {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.getDay(c.getTime()));
		c.set(Calendar.DAY_OF_WEEK, 1);
		return c.getTime();
	}

	/**
	 * 获取当前日期累加指定天数后的起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param i
	 *            累加天数
	 * @return
	 */
	public static Date getNextDay(int i) {
		String date = getFormatDate(addDateByDay(new Date(), i),
				"yyyy-MM-dd 00:00:00");
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当前日期累加指定天数的格式化时间(例:可以直接获取明天的12:30:00的时间)
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param i
	 *            累加天数
	 * @param strFormat
	 *            格式化串(如yyyy-MM-dd 12:30:00)
	 * @return 时间
	 */
	public static Date getNextDay(int i, String strFormat) {
		String date = getFormatDate(addDateByDay(new Date(), i), strFormat);
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获取某个日期某个格式化的时间(例:可以获取某个日期的12:30:00的时间)
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param cdate
	 *            日期参数
	 * @param strFormat
	 *            格式化串(如yyyy-MM-dd 12:30:00)
	 * @return 时间
	 */
	public static Date getDate(Date cdate, String strFormat) {
		String date = getFormatDate(cdate, strFormat);
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 返回某个日期的格式化串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @param strFormat
	 *            格式化串
	 * @return 格式化串(如果参数为空返回空串)
	 */
	public static String getFormatDate(Date date, String strFormat) {
		String strRet = null;
		if (date == null) {
			return strRet = "";
		}
		SimpleDateFormat simple = new SimpleDateFormat(strFormat);
		if (simple != null)
			strRet = simple.format(date);
		return strRet;
	}

	/**
	 * 返回某个时间的格式化串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param timeStamp
	 *            时间参数
	 * @param strFormat
	 *            格式化串
	 * @return 格式化串(如果参数为空返回&nbsp;)
	 */
	public static String getFormatDate(Timestamp timeStamp, String strFormat) {
		String strRet = null;
		if (timeStamp == null)
		return strRet = "";
		SimpleDateFormat simple = new SimpleDateFormat(strFormat);
		if (simple != null) {
			strRet = simple.format(timeStamp);
		}
		return strRet;
	}

	/**
	 * 返回当天的年月日串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 返回格式化串(yyMMdd)
	 */
	public static String yyMMdd() {
		SimpleDateFormat simple = new SimpleDateFormat("yyMMdd");
		Date date = new Date();
		return simple.format(date);
	}

	/**
	 * 返回当天的年月串
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 返回格式化串(yyMM)
	 */
	public static String yyMM() {
		SimpleDateFormat simple = new SimpleDateFormat("yyMM");
		Date date = new Date();
		return simple.format(date);
	}

	/**
	 * 是否同一个月
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameMonth(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		Calendar c = Calendar.getInstance();
		int m1, m2;
		c.setTime(date1);
		m1 = c.get(Calendar.MONTH);
		c.setTime(date2);
		m2 = c.get(Calendar.MONTH);
		return m1 == m2;
	}

	/**
	 * 是否同一个小时
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameHour(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		Calendar c = Calendar.getInstance();
		int m1, m2;
		c.setTime(date1);
		m1 = c.get(Calendar.HOUR_OF_DAY);
		c.setTime(date2);
		m2 = c.get(Calendar.HOUR_OF_DAY);
		return m1 == m2;
	}

	/**
	 * 是否同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		String str1 = DateUtil.getDayByDate(date1);
		String str2 = DateUtil.getDayByDate(date2);
		return str1.equals(str2);
	}

	/**
	 * 获取下月的每一天
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 日期
	 */
	public static Date getNextMonthDay() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
	
	/**
	 * <p>Description: 返回格式化的地图时间解析</p>
	 */
	public static Long getDateFormatDay(String str) {
		//取出分钟以后的
		
		String str1 = CommonUtil.getByTimestamp().toString().split(" ")[0];
		str1 += " "+ str +":00.000";
		Timestamp newTimestamp;
		try {
			newTimestamp = CommonUtil.string2Time(str1);
			return newTimestamp.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1L;
	}
	
	/**
	 * 获取上月的第一天起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 日期
	 */
	public static Date getPreviousMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * 获取上月第一天的结束时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return
	 */
	public static Date getPreviousMonthLastDay() {
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.DAY_OF_MONTH, 0);
		cl.set(Calendar.HOUR_OF_DAY, 23);
		cl.set(Calendar.MINUTE, 59);
		cl.set(Calendar.SECOND, 59);
		return cl.getTime();
	}

	/**
	 * 获取本月的第一天
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return
	 */
	public static Date getDateByCurrentMonth() {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.getDay(c.getTime()));
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * 获取指定日期当月的每一天日期
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param currentDate
	 * @return
	 */
	public static Date getNextMonthDay(Date currentDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * 日期是否是当前月
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date) {
		if (date == null) {
			return false;
		}
		Calendar c = Calendar.getInstance();
		int m1 = c.get(Calendar.MONTH);
		c.setTime(date);
		int m2 = c.get(Calendar.MONTH);
		return m1 == m2;
	}

	/**
	 * 获取当天是周的第几天减1
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return
	 */
	public static int getWeekDay() {
		int weekday;
		Calendar tmp = Calendar.getInstance();
		weekday = tmp.get(Calendar.DAY_OF_WEEK) - 1;
		return weekday;
	}

	/**
	 * 获取当前日期是星期几的文字描述
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return
	 */
	public static String getWeekText() {
		String txt = "星期";
		int weekday;
		Calendar tmp = Calendar.getInstance();
		weekday = tmp.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekday) {
		case 1:
			txt += "一";
			break;
		case 2:
			txt += "二";
			break;
		case 3:
			txt += "三";
			break;
		case 4:
			txt += "四";
			break;
		case 5:
			txt += "五";
			break;
		case 6:
			txt += "六";
			break;
		case 0:
			txt += "日";
			break;
		}
		return txt;
	}
	
	/**
	 * 获取当前日期是星期几的文字描述
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return
	 */
	public static int getWeekInt() {
		Calendar tmp = Calendar.getInstance();
		int weekday = tmp.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekday) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		case 5:
			return 5;
		case 6:
			return 6;
		case 0:
			return 7;
		}
		return 0;
	}
	
	
	/**
	 * 返回国际时间的星期
	 * @return
	 */
	public static int getWeekIntByHTC() {
		Calendar tmp = Calendar.getInstance();
		int weekday = tmp.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekday) {
		case 1:
			return 2;
		case 2:
			return 3;
		case 3:
			return 4;
		case 4:
			return 5;
		case 5:
			return 6;
		case 6:
			return 7;
		case 0:
			return 1;
		}
		return 0;
	}
	
	/**
	 * 获取格式化日期
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param time
	 * @param 格式化串
	 * @return
	 */
	public static Date getDate(String time, String strFormat) {
		Date date = null;
		if (time == null || time.equals("")) {
			return date = null;
		}
		if (strFormat == null || strFormat.equals("")) {
			strFormat = SHORT_DATE_PATTERN;
		}
		SimpleDateFormat simple = new SimpleDateFormat(strFormat);
		try {
			date = simple.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		return date;
	}

	/**
	 * 更新日期的日分秒
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @param hh
	 *            小时
	 * @param mm
	 *            分数
	 * @param ss
	 *            秒
	 * @return
	 */
	public static Date getDate(Date date, int hh, int mm, int ss) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hh);
		cal.set(Calendar.MINUTE, mm);
		cal.set(Calendar.SECOND, ss);
		return cal.getTime();
	}

	/**
	 * 给日期累加指定天数并返回累加后的日期
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @param day
	 *            累加天数
	 * @return 返回累加后的日期
	 */
	public static Date absoluteDate(Date date, int day) {
		if (date == null) {
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, day);
		return cal.getTime();
	}

	/**
	 * 给当天日期累加指定天数并返回累加后的日期
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param day
	 *            累加天数
	 * @return 返回累加后的日期
	 */
	public static Date absoluteDate(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_YEAR, day);
		return cal.getTime();
	}

	/**
	 * 给日期累加指定天数并返回累加后的日期
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param time
	 *            日期参数
	 * @param add_day
	 *            累加天数
	 * @return 累加后的日期
	 */
	public static Date addDateByDay(Date time, int add_day) {

		if (time == null) {
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, add_day);
		return cal.getTime();
	}

	/**
	 * 给日期累加指定周数并返回累加后的日期
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param time
	 *            日期参数
	 * @param add_week
	 *            累加周数
	 * @return 累加后的日期
	 */
	public static Date addDateByWeek(Date time, int add_week) {

		if (time == null) {
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.WEEK_OF_MONTH, add_week);
		return cal.getTime();
	}

	/**
	 * 给日期累加指定天数并返回累加后的日期
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param time
	 *            日期参数
	 * @param add_day
	 *            累加天数
	 * @return
	 */
	public static Date addDateByDay(Timestamp time, int add_day) {

		if (time == null) {
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, add_day);
		return cal.getTime();
	}

	/**
	 * 给日期累加指定天数并返回累加并去掉时分秒后的日期
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param date
	 *            日期参数
	 * @param add_day
	 *            累回天数
	 * @return
	 */
	public static Date getRollDay(Date date, int add_day) {
		return getDay(addDateByDay(date, add_day));
	}

	/**
	 * 返回两个日期相差的秒数
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param begin
	 * @param end
	 * @return 相差的秒数
	 */
	public static long between(Date begin, Date end) {
		if (begin == null || end == null) {
			return 0;
		}
		return (end.getTime() - begin.getTime()) / 1000;
	}

	/**
	 * 给指定日期累加上指定的月数
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param time
	 *            日期参数
	 * @param add_month
	 *            累加月数
	 * @return 累加后的日期
	 */
	public static Date addDateByMonth(Date time, int add_month) {
		if (time == null) {
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.MONTH, add_month);
		return cal.getTime();
	}

	/**
	 * 给指定日期累加上指定的小时数
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param time
	 *            日期参数
	 * @param add_Hour
	 *            累加小时数
	 * @return 累加后的日期
	 */
	public static Date addHourByDay(Date time, int add_Hour) {

		if (time == null) {
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.HOUR_OF_DAY, add_Hour);
		return cal.getTime();
	}

	/**
	 * 给指定日期累加上指定的分钟数
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param time
	 *            日期参数
	 * @param add_minute
	 *            分钟数
	 * @return 累加后的日期
	 */
	public static Date addHourByMinute(Date time, int add_minute) {
		if (time == null) {
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.MINUTE, add_minute);
		return cal.getTime();
	}

	/**
	 * 给指定日期累加上指定的秒数
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param time
	 *            日期参数
	 * @param add_second
	 *            秒数
	 * @return 累加后的日期
	 */
	public static Date addHourBySecond(Date time, int add_second) {
		if (time == null) {
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.SECOND, add_second);
		return cal.getTime();
	}

	/**
	 * 获取本周一起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 周一起始时间
	 */
	public static Date getThisWeekFirstDay() {
		Calendar cl = Calendar.getInstance();
		cl.roll(Calendar.DAY_OF_YEAR, -cl.get(Calendar.DAY_OF_WEEK) + 2);
		String date = getFormatDate(cl.getTime(), "yyyy-MM-dd 00:00:00");
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取本周日结束时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 周日结束时间
	 */
	public static Date getThisWeekLastDay() {
		Calendar cl = Calendar.getInstance();
		cl.roll(Calendar.DAY_OF_YEAR, -cl.get(Calendar.DAY_OF_WEEK) + 8);
		String date = getFormatDate(cl.getTime(), "yyyy-MM-dd 23:59:59:999");
		return getDate(date, "yyyy-MM-dd HH:mm:ss:SSS");
	}

	/**
	 * 获取上周一起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 上周一起始时间
	 */
	public static Date getPreviousWeekFirstDay() {
		Calendar cl = Calendar.getInstance();
		cl.roll(Calendar.DAY_OF_YEAR, -cl.get(Calendar.DAY_OF_WEEK) - 5);
		String date = getFormatDate(cl.getTime(), "yyyy-MM-dd 00:00:00");
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取上周日结束时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 上周日结束时间
	 */
	public static Date getPreviousWeekLastDay() {
		Calendar cl = Calendar.getInstance();
		cl.roll(Calendar.DAY_OF_YEAR, -cl.get(Calendar.DAY_OF_WEEK) + 1);
		String date = getFormatDate(cl.getTime(), "yyyy-MM-dd 23:59:59:999");
		return getDate(date, "yyyy-MM-dd HH:mm:ss:SSS");
	}

	/**
	 * 获取本月第一天的起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 本月第一天的起始时间
	 */
	public static Date getThisMonthFirstDay() {
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.DAY_OF_MONTH, 1);
		String date = getFormatDate(cl.getTime(), "yyyy-MM-dd 00:00:00");
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取本月最后一天的起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @return 本月最后一天的起始时间
	 */
	public static Date getThisMonthLastDay() {
		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.MONTH, 1);
		cl.set(Calendar.DATE, 0);
		String date = getFormatDate(cl.getTime(), "yyyy-MM-dd 23:59:59:999");
		return getDate(date, "yyyy-MM-dd HH:mm:ss:SSS");
	}

	/**
	 * 当月最后一天
	 * @return
	 */
	public static Timestamp getThisMonthLastByDay() {
		// 获取Calendar  
		Calendar calendar = Calendar.getInstance();  
		// 设置时间,当前时间不用设置  
		// calendar.setTime(new Date());  
		// 设置日期为本月最大日期  
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));  
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59.000");  
		return getTimestamp( format.format(calendar.getTime()) );
	}
	
	
	/**
	 * 获取指定日期当月第一天的起始时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param now
	 *            日期参数
	 * @return 当月第一天的起始时间
	 */
	public static Date getMonthFirstDay(Date now) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(now);
		cl.set(Calendar.DAY_OF_MONTH, 1);
		String date = getFormatDate(cl.getTime(), "yyyy-MM-dd 00:00:00");
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取指定日期当月最后一天的结束时间
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param now
	 *            日期参数
	 * @return 当月最后一天的结束时间
	 */
	public static Date getMonthLastDay(Date now) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(now);
		cl.add(Calendar.MONTH, 1);
		cl.set(Calendar.DATE, 0);
		String date = getFormatDate(cl.getTime(), "yyyy-MM-dd 23:59:59:999");
		return getDate(date, "yyyy-MM-dd HH:mm:ss:SSS");
	}

	/**
	 * 获取给定年月的最后一天
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return 给定年月的最后一天
	 */
	public static int getMonthOfLastDay(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

	}

	/**
	 * 获取给定年月的第一天
	 * 
	 * @author cui
	 * @date Jun 26, 2009
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return 给定年月的第一天
	 */
	public static int getMonthOfFirstDay(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 判断一个日期是否在两个日期之间
	 * 
	 * @author 滕辉
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static boolean between(Date startDate, Date endDate, Date date) {
		if (startDate == null && endDate == null) {
			return true;
		} else if (startDate != null && startDate.getTime() <= date.getTime()
				&& endDate == null) {
			return true;
		} else if (endDate != null && endDate.getTime() >= date.getTime()
				&& startDate == null) {
			return true;
		} else if (startDate != null && endDate != null
				&& startDate.getTime() <= date.getTime()
				&& endDate.getTime() >= date.getTime()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得指定日期的前一天的数据
	 * 
	 * @author caoxian
	 * @param dateStr
	 * @return
	 */
	public static Date getBeforeToday(String dateStr) {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day - 1);
		dateStr = getFormatDate(calendar.getTime(), "yyyy-MM-dd 23:59:59:999");
		return getDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获得指定日期的前30天的数据
	 * 
	 * @author caoxian
	 * @param dateStr
	 * @return
	 */
	public static Date getBeforeThrityTody(String dateStr, Integer i) {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day - i);
		dateStr = getFormatDate(calendar.getTime(), "yyyy-MM-dd 00:00:00");
		return getDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	/***
	 * 获得指定日期30天后的日期
	 * 
	 * @param created_at
	 * @param i
	 * @return
	 */
	public static Timestamp getAfterThrityDate(Timestamp created_at, Integer i) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(created_at);
		calendar.add(Calendar.DATE, i);
		Date date = calendar.getTime();
		return new Timestamp(date.getTime());
	}

	public static int getDaysBetweenDate(Timestamp dateTo, Timestamp dateFrom) {
		if (dateTo == null) {
			dateTo = DateUtil.getAfterThrityDate(CommonUtil.getByTimestamp(),
					-30);
		}
		Calendar calendarFrom = Calendar.getInstance();
		Calendar calendarTo = Calendar.getInstance();
		calendarFrom.setTimeInMillis(dateFrom.getTime());
		calendarTo.setTimeInMillis(dateTo.getTime());
		// 先判断是否同年
		int y1 = calendarFrom.get(Calendar.YEAR);
		int y2 = calendarTo.get(Calendar.YEAR);

		int d1 = calendarFrom.get(Calendar.DAY_OF_YEAR);
		int d2 = calendarTo.get(Calendar.DAY_OF_YEAR);
		int maxDays = 0;
		int day = 0;
		if (y1 - y2 > 0) {
			day = numerical(maxDays, d1, d2, y1, y2, calendarTo);
		} else {
			day = d1 - d2;
		}
		return day;
	}

	/**
	 * 获得两个日期相隔的天数
	 * 
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	public static int getDaysBetweenDates(Timestamp startday, Timestamp endday) {
		int days = (int) ((endday.getTime() - startday.getTime()) / (3600 * 24 * 1000));
		return days;

	}

	/**
	 * 日期间隔计算 计算公式(示例): 20121230 - 20071001 取出20121230这一年过了多少天 d1 = 365
	 * 取出20071001这一年过了多少天 d2 = 274 如果2007年这一年有366天就要让间隔的天数+1，因为2月份有29日。
	 * 
	 * @param maxDays
	 *            用于记录一年中有365天还是366天
	 * @param d1
	 *            表示在这年中过了多少天
	 * @param d2
	 *            表示在这年中过了多少天
	 * @param y1
	 *            当前为2010年
	 * @param y2
	 *            当前为2012年
	 * @param calendar
	 *            根据日历对象来获取一年中有多少天
	 * @return 计算后日期间隔的天数
	 */
	public static int numerical(int maxDays, int d1, int d2, int y1, int y2,
			Calendar calendar) {
		int day = d1 - d2;
		int betweenYears = y1 - y2;
		List<Integer> d366 = new ArrayList<Integer>();

		if (calendar.getActualMaximum(Calendar.DAY_OF_YEAR) == 366) {
			day += 1;
		}

		for (int i = 0; i < betweenYears; i++) {
			// 当年 + 1 设置下一年中有多少天
			calendar.set(Calendar.YEAR, (calendar.get(Calendar.YEAR)) + 1);
			maxDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
			// 第一个 366 天不用 + 1 将所有366记录，先不进行加入然后再少加一个
			if (maxDays != 366) {
				day += maxDays;
			} else {
				d366.add(maxDays);
			}
			// 如果最后一个 maxDays 等于366 day - 1
			if (i == betweenYears - 1 && betweenYears > 1 && maxDays == 366) {
				day -= 1;
			}
		}

		for (int i = 0; i < d366.size(); i++) {
			// 一个或一个以上的366天
			if (d366.size() >= 1) {
				day += d366.get(i);
			}
			// else{
			// day -= 1;
			// }
		}
		return day;
	}

	public static Calendar getCalendar(String dateTime) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateTime);
		Calendar cal_start = Calendar.getInstance();
		cal_start.setTime(date);
		return cal_start;

	}

	public static Timestamp getTimestamp(String dateTime) {
		return Timestamp.valueOf(dateTime);
	}

	// 比较2个时间的大小
	public static int compareDate(String DATE1, String DATE2) {
		//
		java.text.DateFormat df = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		try {
			c1.setTime(df.parse(DATE1));
			c2.setTime(df.parse(DATE2));
		} catch (java.text.ParseException e) {
		}
		// 0时间相等 小于0 c1<c2
		return c1.compareTo(c2);

	}

	public static String getTime(Timestamp time) {
		if( time == null ){
			return null;
		}
		return new SimpleDateFormat(FULL_DATE_PATTERN).format(time);
	}
	
	/**
	 * 获取当前时间，格式化输出
	 * @author:GOUPAN
	 * @time:2017年2月14日 下午4:26:28
	 * @param date 当前时间（默认：现在）
	 * @param format 格式（默认：yyyy-MM-dd HH:mm:ss）
	 * @return
	 */
	public static String getCurrentTime(Date date, String format){
		if (date == null) {
			date = new Date();
		}
		if (format == null || "".equals(format.trim())) {
			format = FULL_DATE_PATTERN;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}


}