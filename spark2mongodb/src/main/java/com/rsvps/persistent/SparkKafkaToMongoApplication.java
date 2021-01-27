package com.rsvps.persistent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparkKafkaToMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparkKafkaToMongoApplication.class, args);
	}

}
