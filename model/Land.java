
package com.ams.model;

import java.util.ArrayList;
import java.util.List;

public class Land {
    private String landId;
    private double area;
    private String location;
    private String soilType;
    private List<Crop> crops;

    public Land(String landId, double area, String location, String soilType) {
        this.landId = landId;
        this.area = area;
        this.location = location;
        this.soilType = soilType;
        this.crops = new ArrayList<>();
    }


}
