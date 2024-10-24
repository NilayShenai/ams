
package com.ams.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseHandler {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void initializeDatabase() {
        mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDatabase("ams_db");
    }

    public static MongoCollection<Document> getFarmersCollection() {
        return database.getCollection("farmers");
    }

    public static void closeDatabase() {
        mongoClient.close();
    }
}
