package org.framework.utils;


import org.framework.dataBase.MongoConnection;
import org.framework.config.ExecutionContext;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoUtils {

    private static final String COLLECTION = "test_users";

    private static MongoCollection<Document> getCollection(){

        return MongoConnection
                .getDatabase()
                .getCollection(COLLECTION);
    }

    public static void setField(String field, String value){

        String executionId = ExecutionContext.getExecutionId();

        Document filter = new Document("executionId", executionId);

        Document update = new Document("$set",
                new Document(field, value));

        getCollection().updateOne(filter, update,
                new com.mongodb.client.model.UpdateOptions().upsert(true));
    }

    public static String getField(String field){

        String executionId = ExecutionContext.getExecutionId();

        Document filter = new Document("executionId", executionId);

        Document result = getCollection().find(filter).first();

        if(result == null) return null;

        return result.getString(field);
    }

}