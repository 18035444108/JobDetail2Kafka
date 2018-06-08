package com.golaxy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class CommonUtils {
	private static final Logger logger = Logger.getLogger(CommonUtils.class);
	/**
	 * 将招聘人数按要求转化为数字类型
	 * @param str
	 * @return
	 */
	public static Integer getRc(String str) {
		String regEx = "(\\d+)人";
		if(str.contains("若干")){
			return 1;
		}else if(str.equals("")){
			return 1;
		}
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			return Integer.parseInt(matcher.group(1));
		}else{
			logger.error("招聘人数出错:"+str);
			throw new RuntimeException("招聘人数出错:"+str);
		}
	}
	
	/**
	 * 获取公司规模
	 * @param str
	 * @return
	 */
	public static Integer getComSize(String str) {
		String regEx = "(\\d+)人";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			return Integer.parseInt(matcher.group(1));
		}else{
			return 0;
		}
	}
	
	/**
	 * 获取通道对应网站名称
	 * @param ch
	 * @return
	 */
	public static String getSiteName(int ch){
		
		return null;
	}
}
