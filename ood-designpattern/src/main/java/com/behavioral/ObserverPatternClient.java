package com.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternClient {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        WeatherDisplay display1 = new WeatherDisplay();
        WeatherDisplay display2 = new WeatherDisplay();
        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);
        // Simulate a change in temperature
        weatherStation.setTemperature(25);
    }
}
// Subject (Observable) interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private int temperature;
    private List<Observer> observers = new ArrayList<>();
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
// Observer interface
interface Observer {
    void update(int temperature);
}

// Concrete Observer
class WeatherDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Temperature is now " + temperature + " degrees Celsius.");
    }
}


