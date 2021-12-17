package com.example.retrofit_sullivana6;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("name")
    public String superName;

    @SerializedName("description")
    private final String superDesc;

    @SerializedName("vehicle_class")
    private final String superVehicleClass;

    @SerializedName("length")
    private final String superLength;

    @SerializedName("pilot")
    private final String superPilot;





    public Results(String name, String desc, String vehicleClass,
                   String length, String pilot) {
        this.superName = name;
        this.superDesc = desc;
        this.superVehicleClass = vehicleClass;
        this.superLength = length;
        this.superPilot = pilot;

    }

    public String getName() {
        return superName;
    }

    public String getDesc() {
        return superDesc;
    }

    public String getVehicleClass() {
        return superVehicleClass;
    }

    public String getLength() {
        return superLength;
    }

    public String getPilot() {
        return superPilot;
    }

}
