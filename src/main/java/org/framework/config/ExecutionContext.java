package org.framework.config;


import java.util.UUID;

public class ExecutionContext {

    private static final String executionId;

    static {

        String paramExecution = System.getProperty("executionId");

        if(paramExecution == null || paramExecution.isEmpty()){

            executionId = UUID.randomUUID().toString();

        } else {

            executionId = paramExecution;

        }

        System.out.println("Execution ID: " + executionId);

    }

    public static String getExecutionId(){

        return executionId;

    }

}