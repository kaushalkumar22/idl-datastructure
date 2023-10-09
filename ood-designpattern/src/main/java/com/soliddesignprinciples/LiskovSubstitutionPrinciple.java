package com.soliddesignprinciples;

public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {

        //Vehicle v = new PetrolCar("Toyota");
        Vehicle v = new ElectricCar("Toyota");
        v.speedUp();
        v.slowDown();
        v.getEngineType();

    }
}
abstract class Vehicle {

    protected String type;

    public Vehicle(String type) {
        this.type = type;
    }

    protected void speedUp() {
        System.out.println("Vehicle is speeding up...");
    }

    protected void slowDown() {
        System.out.println("Vehicle is slowing down...");
    }

    public void getEngineType() {
        System.out.println("Vehicle EngineType...");
    }

}
class ElectricCar extends Vehicle {

    public ElectricCar(String type) {

        super(type);
    }

    @Override
    public void getEngineType() {
        System.out.println("Electric Engine");
    }
}
class PetrolCar extends Vehicle {

    public PetrolCar(String type) {
        super(type);
    }

    @Override
    public void getEngineType() {
        System.out.println("Petrol Engine...");
    }
}