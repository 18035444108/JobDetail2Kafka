package com.golaxy.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class ConfigData {
	public static final int jobDetailPageSize;
	public static final String kafkaBoostrap;
	public static final Map<Integer, String> chSnMap;
	static {
			Properties prop = new Properties();
			try {
				prop.load(Resources.getResourceAsReader("config.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			jobDetailPageSize = Integer.parseInt(prop.getProperty("jobdetail_page_size"));
			kafkaBoostrap = prop.getProperty("kafka.boostrap");
			chSnMap = new HashMap<>();
			String chSn =  prop.getProperty("ch.sitename");
			String chs[] = chSn.split(",");
			for (String term : chs) {
				int ch = Integer.parseInt(term.split(":")[0]); 
				String sn = term.split(":")[1];
				chSnMap.put(ch, sn);
 			}
	}
	public static void main(String[] args) {
		System.out.println(chSnMap);
	}
}
