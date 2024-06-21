package com.devromaomoura.dynamodb.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.devromaomoura.dynamodb.repository")
@PropertySource("classpath:application.properties")
public class DynamoDBConfig {

    @Bean
    public GetPropertiesParams getPropertiesParams() {
        return new GetPropertiesParams();
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB(GetPropertiesParams properties) {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new EndpointConfiguration(properties.getDynamoDBEndpoint(),
                        properties.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(properties.getAccessKeyId(),
                        properties.getSecretAccessKey())))
                .build();
    }

}
