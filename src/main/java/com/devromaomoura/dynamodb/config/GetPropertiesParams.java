package com.devromaomoura.dynamodb.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class GetPropertiesParams {
    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    @Value("${aws.secretKey}")
    private String secretAccessKey;
    @Value("${aws.region}")
    private String region;
    @Value("${aws.dynamodb.endpoint}")
    private String dynamoDBEndpoint;
}
