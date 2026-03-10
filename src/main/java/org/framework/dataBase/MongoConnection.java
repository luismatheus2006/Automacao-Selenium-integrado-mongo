package org.framework.dataBase;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

   // private static final String URI = System.getenv("MONGO_URI");
    //private static final String DB = System.getenv("MONGO_DB");
 private static final String URI = "mongodb://expertostech:%40mongo123@localhost:27017";
 private static final String DB = "MONGO_DB";
    private static MongoClient client;

    public static MongoDatabase getDatabase(){

        if(client == null){
            client = MongoClients.create(URI);
        }

        return client.getDatabase(DB);
    }

}