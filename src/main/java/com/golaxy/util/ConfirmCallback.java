package com.golaxy.util;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

public class ConfirmCallback implements Callback{

	private static Logger logger = Logger.getLogger(ConfirmCallback.class);
	@Override
	public void onCompletion(RecordMetadata metadata, Exception e) {
		if (e != null) {
			logger.error("Send msg to kafka failure, error msg: " + e.getMessage());
		} else {
			logger.info("Send msg to kafka success, Topic: " 
					+ metadata.topic() + " partition: " + metadata.partition()
					+ " offset: " + metadata.offset());
		}
	}

}
