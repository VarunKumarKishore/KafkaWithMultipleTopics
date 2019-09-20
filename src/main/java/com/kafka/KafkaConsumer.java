package com.kafka;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@Configuration
public class KafkaConsumer {

	@KafkaHandler
	public void handle() {
		System.out.println("inside handler");
	}

	@KafkaListener(id = "fooGroup", topics = "Test1")
	public void listner(String data) throws InterruptedException {
		//System.out.println("inside kfaka lsitner    "+data);
		//System.out.println(" Thread in test-default : "+Thread.currentThread().getName());
		System.out.println("Thread started in Test1 with data :"+data);

		long start = System.currentTimeMillis();
		Thread.sleep(60000);
		System.out.println("Thread ended in Test1");
	}

	@KafkaListener(id = "fooGroup1", topics = "Test2")
	public void listner1(String data) throws InterruptedException {
		//System.out.println("inside kfaka lsitner 1    "+data + " Thread in test-default1 : "+Thread.currentThread());

		System.out.println("Thread started in Test2 with data :"+data);
		long start = System.currentTimeMillis();
		Thread.sleep(60000);
		//System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
		System.out.println("Thread ended in Test2");

	}
}
