
package com.ams.model;

import java.time.LocalDateTime;

public class Crop {
    private String cropId;
    private String name;
    private LocalDateTime plantingDate;
    private LocalDateTime expectedHarvestDate;
    private double expectedYield;
    private String status;

    public Crop(String cropId, String name, LocalDateTime plantingDate, LocalDateTime expectedHarvestDate) {
        this.cropId = cropId;
        this.name = name;
        this.plantingDate = plantingDate;
        this.expectedHarvestDate = expectedHarvestDate;
        this.status = "Planted";
    }


}
