
package com.ams.controller;

import com.ams.database.DatabaseHandler;
import com.ams.model.Farmer;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class FarmerController {
    
    public boolean registerFarmer(Farmer farmer) {
        try {
            Document doc = new Document("farmerId", farmer.getFarmerId())
                    .append("name", farmer.getName())
                    .append("address", farmer.getAddress())
                    .append("contact", farmer.getContact())
                    .append("email", farmer.getEmail());

            DatabaseHandler.getFarmersCollection().insertOne(doc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Farmer> getAllFarmers() {
        List<Farmer> farmers = new ArrayList<>();
        for (Document doc : DatabaseHandler.getFarmersCollection().find()) {
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
