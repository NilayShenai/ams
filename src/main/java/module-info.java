module com.ams {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.mongodb.driver.sync.client; // MongoDB driver
    requires org.mongodb.bson;               // BSON library for MongoDB
    opens com.ams.ui to javafx.fxml;
    exports com.ams.model;
    exports com.ams.database;
    exports com.ams.controller;
    exports com.ams.ui;  // Include this if you have a UI package for JavaFX
}

