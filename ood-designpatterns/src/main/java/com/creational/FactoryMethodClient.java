package com.creational;
public class FactoryMethodClient {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle(VehicleType.Car);
        car.start();
        car.stop();

        Vehicle motorcycle = VehicleFactory.getVehicle(VehicleType.Motorcycle);
        motorcycle.start();
        motorcycle.stop();
    }
}
interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started.");
    }
    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle started.");
    }
    @Override
    public void stop() {
        System.out.println("Motorcycle stopped.");
    }
}

enum VehicleType{
    Car,
    Motorcycle
}
class VehicleFactory{
    public static Vehicle getVehicle(VehicleType type) {
        switch (type){
            case Car:
                return new Car();
            case Motorcycle:
                return new Motorcycle();
            default:
                throw new RuntimeException("exception");
        }
    }
}
