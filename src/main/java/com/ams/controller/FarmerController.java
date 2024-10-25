package com.ams.controller;

import com.ams.database.DatabaseHandler;
import com.ams.model.Farmer;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;

public class FarmerController {

    public boolean registerFarmer(Farmer farmer) {
        MongoCollection<Document> farmersCollection = DatabaseHandler.getFarmersCollection();

        // Convert Farmer object to a MongoDB Document
        Document doc = new Document("farmerId", farmer.getFarmerId())
                .append("name", farmer.getName())
                .append("address", farmer.getAddress())
                .append("contact", farmer.getContact())
                .append("email", farmer.getEmail());

        // Insert the document into the farmers collection
        farmersCollection.insertOne(doc);
        return true;
    }

    public List<Farmer> getAllFarmers() {
        List<Farmer> farmers = new ArrayList<>();
        MongoCollection<Document> farmersCollection = DatabaseHandler.getFarmersCollection();

        // Retrieve all documents from the farmers collection
        for (Document doc : farmersCollection.find()) {
            Farmer farmer = new Farmer(
                    doc.getString("farmerId"),
                    doc.getString("name"),
                    doc.getString("address"),
                    doc.getString("contact"),
                    doc.getString("email")
            );
            farmers.add(farmer);
        }

        return farmers;
    }
}
