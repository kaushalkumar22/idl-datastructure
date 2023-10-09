package com.lowlevelsystemdesign.parkinglot.vehicle;

public abstract class Vehicle {
    String regisNumber;
    VehicleType type;

    public Vehicle(String regisNumber, VehicleType type) {
        this.regisNumber = regisNumber;
        this.type = type;
    }

    public String getRegisNumber() {
        return regisNumber;
    }

    public VehicleType getType() {
        return type;
    }
}
