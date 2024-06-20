package com.devromaomoura.dynamodb.exception;

public class DynamoDBDefaultException extends RuntimeException {
    public DynamoDBDefaultException(String msg){
        super(msg);
    }
}
