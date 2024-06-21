package com.devromaomoura.dynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.devromaomoura.dynamodb.controller", exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.devromaomoura.dynamodb"})
public class DynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamodbApplication.class, args);
	}
}
