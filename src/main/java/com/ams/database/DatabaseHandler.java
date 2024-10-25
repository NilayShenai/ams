package com.ams.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseHandler {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void initializeDatabase() {
        // Create a new client and connect to MongoDB
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("ams_db");
        System.out.println("Connected to MongoDB");
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    // Method to get the Farmers collection
    public static MongoCollection<Document> getFarmersCollection() {
        return database.getCollection("farmers");
    }

    public static void closeDatabase() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
