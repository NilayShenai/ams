
package com.ams.ui;

import com.ams.controller.FarmerController;
import com.ams.model.Farmer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class AMSApplication extends Application {

    private FarmerController farmerController = new FarmerController();

    @FXML
    private TextField farmerIdField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField emailField;
    @FXML
    private ListView<String> farmerListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Agriculture Management System");

        VBox layout = new VBox(10);
        farmerIdField = new TextField();
        nameField = new TextField();
        addressField = new TextField();
        contactField = new TextField();
        emailField = new TextField();

        Button registerButton = new Button("Register Farmer");
        registerButton.setOnAction(e -> registerFarmer());

        Button viewFarmersButton = new Button("View All Farmers");
        viewFarmersButton.setOnAction(e -> viewAllFarmers());

        farmerListView = new ListView<>();

        layout.getChildren().addAll(
                new Label("Farmer ID:"), farmerIdField,
                new Label("Name:"), nameField,
                new Label("Address:"), addressField,
                new Label("Contact:"), contactField,
                new Label("Email:"), emailField,
                registerButton,
                viewFarmersButton,
                farmerListView
        );

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void registerFarmer() {
        String farmerId = farmerIdField.getText();
        String name = nameField.getText();
        String address = addressField.getText();
        String contact = contactField.getText();
        String email = emailField.getText();

        if (farmerId.isEmpty() || name.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty()) {
            System.out.println("All fields must be filled!");
            return;
        }

        Farmer farmer = new Farmer(farmerId, name, address, contact, email);
        boolean result = farmerController.registerFarmer(farmer);

        if (result) {
            System.out.println("Farmer registered successfully.");
        } else {
            System.out.println("Failed to register farmer.");
        }

        clearFields();
    }

    @FXML
    private void viewAllFarmers() {
        List<Farmer> farmers = farmerController.getAllFarmers();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Farmer farmer : farmers) {
            items.add(farmer.getFarmerId() + " - " + farmer.getName());
        }
        farmerListView.setItems(items);
    }

    private void clearFields() {
        farmerIdField.clear();
        nameField.clear();
        addressField.clear();
        contactField.clear();
        emailField.clear();
    }
}
