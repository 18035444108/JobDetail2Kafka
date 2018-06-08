package com.golaxy.main;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

import com.golaxy.entity.JobDetail;
import com.golaxy.init.ProducerInit;
import com.golaxy.util.CommonUtils;
import com.golaxy.util.ConfigData;
import com.golaxy.util.ConfirmCallback;
import com.golaxy.util.SqlSessionUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MysqlToKafka {
	private static final Logger logger = Logger.getLogger(MysqlToKafka.class);
	private static SqlSession sqlSession = SqlSessionUtil.getSqlSession();
	private static KafkaProducer<String, String> producer = ProducerInit.getProducer();
	private List<JobDetail> jobDetail ;
	
	public void run(int from) throws IOException{
		final Gson gson = new GsonBuilder().serializeNulls().create();
		int id =from;
		int sizeJob = ConfigData.jobDetailPageSize;
		try {
			while(true){
				int params[]={id,sizeJob};
				try {
					jobDetail = sqlSession.selectList("findAllJob",params);
				} catch (Exception e) {
					logger.error(e.getMessage());
					throw new RuntimeException("查询或链接出现错误!");
				}
				if(jobDetail.size()!=0){
					for (JobDetail jobTerm : jobDetail) {
						id = Integer.parseInt(jobTerm.getId());
						logger.info("id:"+jobTerm.getId()+"    jobid:"+jobTerm.getJid());
						String _id = jobTerm.getCh()+jobTerm.getJid();
						if(jobTerm.getPt()<0){
							logger.error("时间错误，过滤掉!"+jobTerm.getPt()+"  jobid:"+jobTerm.getJid());
							continue;
						}
						jobTerm.setId(_id);
						jobTerm.setSn(ConfigData.chSnMap.get(jobTerm.getCh()));
						jobTerm.setRnum_n(CommonUtils.getRc(jobTerm.getRnum_s()));
						jobTerm.setCsize_n(CommonUtils.getComSize(jobTerm.getCsize_s()));
						ProducerRecord<String, String> recordTarget = new ProducerRecord<>("recruit_doc",_id,
								gson.toJson(jobTerm));
						producer.send(recordTarget,new ConfirmCallback());
					}
				}else{
					logger.info("jobdetail表剩余数据为0，当前id为："+id);
					sqlSession.close();
					sqlSession = SqlSessionUtil.getSqlSession();
					try {
						Thread.sleep(600000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage()+"id:"+id);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		new MysqlToKafka().run(Integer.parseInt(args[0]));
	}
}
