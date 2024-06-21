package com.devromaomoura.dynamodb.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DynamoDBInitializer {

    private final AmazonDynamoDB amazonDynamoDB;

    @Autowired
    public DynamoDBInitializer(AmazonDynamoDB amazonDynamoDB) {
        this.amazonDynamoDB = amazonDynamoDB;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing DynamoDB tables...");
        createTableIfNotExists("Person", "id");
    }

    private void createTableIfNotExists(String tableName, String hashKey) {
        if (!isTableExists(tableName)) {
            CreateTableRequest createTableRequest = new CreateTableRequest()
                    .withTableName(tableName)
                    .withKeySchema(new KeySchemaElement(hashKey, KeyType.HASH))
                    .withAttributeDefinitions(new AttributeDefinition(hashKey, ScalarAttributeType.S))
                    .withProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
            amazonDynamoDB.createTable(createTableRequest);
            System.out.println("Table " + tableName + " created successfully.");
        } else {
            System.out.println("Table " + tableName + " already exists.");
        }
    }

    private boolean isTableExists(String tableName) {
        ListTablesRequest request = new ListTablesRequest();
        ListTablesResult result = amazonDynamoDB.listTables(request);
        return result.getTableNames().contains(tableName);
    }
}

