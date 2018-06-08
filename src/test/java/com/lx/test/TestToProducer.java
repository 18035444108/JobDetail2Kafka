package com.lx.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.golaxy.init.ProducerInit;
import com.golaxy.util.ConfirmCallback;

public class TestToProducer {
	public static void main(String[] args) {
		KafkaProducer<String, String> producer = ProducerInit.getProducer();
		ProducerRecord<String, String> recordTarget = new ProducerRecord<>("nihao1", "222",
				"hhah");
		producer.send(recordTarget,new ConfirmCallback());
		producer.close();
	}
}
