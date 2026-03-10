package org.framework.config;


import java.util.UUID;

public class ExecutionContext {

    private static final String executionId = UUID.randomUUID().toString();

    public static String getExecutionId(){
        return executionId;
    }

}