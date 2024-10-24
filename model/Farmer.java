
package com.ams.model;

import java.util.ArrayList;
import java.util.List;

public class Farmer {
    private String farmerId;
    private String name;
    private String address;
    private String contact;
    private String email;
    private List<Land> lands;
    private List<Subsidy> subsidies;

    public Farmer(String farmerId, String name, String address, String contact, String email) {
        this.farmerId = farmerId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.lands = new ArrayList<>();
        this.subsidies = new ArrayList<>();
    }


}
