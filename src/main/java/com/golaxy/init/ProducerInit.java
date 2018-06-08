package com.golaxy.init;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import com.golaxy.util.ConfigData;

/**
 * kafka生产者初始化
 * @author lx
 *
 */
public class ProducerInit {
	public static Properties init() {
		Properties props2 = new Properties();
		props2.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigData.kafkaBoostrap);
		props2.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props2.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

		props2.setProperty("security.protocol", "SASL_PLAINTEXT");
		props2.setProperty("sasl.mechanism", "PLAIN");
		props2.setProperty("sasl.kerberos.service.name", "kafka");
		System.setProperty("java.security.auth.login.config", "./conf/kafka_client_jaas.conf");
		return props2;
	}

	public static KafkaProducer<String, String> getProducer() {
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(ProducerInit.init());
		return producer;
	}

}