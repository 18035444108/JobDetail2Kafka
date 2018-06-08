package com.golaxy.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;

import ict.similarity.CosineTextSimilarity;
import ict.similarity.TextSimilarity;

public class JobClass {
	private static List<String> jcList;
	private static TextSimilarity textsimilarity = new CosineTextSimilarity();
	static {
		try {
			jcList = IOUtils.readLines(Resources.getResourceAsReader("jobclass.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getJobClassDetail(String jobClass,String jobName){
		Map<String, Double> scoreJCMap = new HashMap<>();
		if(!jobClass.equals("")){
			if(jobClass.split(" ").length==2){
				String jobC1 = jobClass.split(" ")[0];
				String jobC2 = jobClass.split(" ")[1];
				double similarscoreC1 = textsimilarity.similarScore(jobName, jobC1);
				double similarscoreC2 = textsimilarity.similarScore(jobName, jobC2);
				if(similarscoreC1>similarscoreC2){
					return jobC1;
				}else if(similarscoreC2>similarscoreC1){
					return jobC2;
				}
			}
		}else{
			for (String string : jcList) {
				double similarscoreC = textsimilarity.similarScore(string,jobName);
				scoreJCMap.put(string, similarscoreC);
			}
			List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(scoreJCMap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
				public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			return list.get(1).getKey();
		}
		return jobClass;
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(JobClass.jcList);
		Map<String, Double> scoreJCMap = new HashMap<>();
		for (String string : jcList) {
			double similarscoreC = textsimilarity.similarScore(string,"销售");
			scoreJCMap.put(string, similarscoreC);
		}
		List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(scoreJCMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
	
		String idString = list.get(1).getKey();
		
		
	}
}
