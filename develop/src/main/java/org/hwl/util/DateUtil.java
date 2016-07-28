package org.hwl.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 
	 * @param date
	 * @param pattern yyyy-MM-dd EE HH:mm:ss
	 * @return
	 */
	public static String dateString(Date date,String pattern){
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	/**
	 * 
	 * @param date
	 * @param pattern yyyy-MM-dd EE HH:mm:ss
	 * @return
	 */
	public static Date strToDate(String date,String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static Date incr(Date date,int incr,int field){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(field,calendar.get(field)+incr);
		return calendar.getTime();
	}
}
