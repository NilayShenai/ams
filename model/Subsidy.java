
package com.ams.model;

import java.time.LocalDateTime;

public class Subsidy {
    private String subsidyId;
    private String name;
    private double amount;
    private String status;
    private LocalDateTime applicationDate;
    private LocalDateTime approvalDate;

    public Subsidy(String subsidyId, String name, double amount) {
        this.subsidyId = subsidyId;
        this.name = name;
        this.amount = amount;
        this.status = "Pending";
        this.applicationDate = LocalDateTime.now();
    }

}
