package com.devromaomoura.dynamodb;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.devromaomoura.dynamodb"})
@EnableDynamoDBRepositories(basePackages = "com.devromaomoura.dynamodb.repository")
public class DynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamodbApplication.class, args);
	}
}
