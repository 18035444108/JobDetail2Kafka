package com.golaxy.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

public class TimeUtil {
	private static final Logger logger = Logger.getLogger(TimeUtil.class); 
	public static long getTime(String date){
		if("".equals(date)){
			return 0l;
		}
		try {
			String format = "yyyy-MM-dd HH:mm:ss";
			if (date.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
				format = "yyyy-MM-dd";
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			java.util.Date dateTime = dateFormat.parse(date);
			return dateTime.getTime();
		}catch (Exception e) {
			logger.error("日期格式错误！:"+date);
		}
		return -1l;
	}
	public static void main(String[] args) {
		System.out.println(getTime("2013-01-01 00:00:00"));
	}
}
