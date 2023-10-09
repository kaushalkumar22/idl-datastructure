package com.behavioral;

public class TemplateMethodPatternClient {
    public static void main(String[] args) {
        CoffeeTemplate coffee = new Coffee();
        CoffeeTemplate tea = new Tea();

        System.out.println("Making coffee:");
        coffee.prepareCoffee();

        System.out.println("\nMaking tea:");
        tea.prepareCoffee();
    }
}
// Abstract Template
abstract class CoffeeTemplate {
    // Template method that defines the algorithm
    final void prepareCoffee() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addCondiments();
    }

    // Concrete methods (common to all coffee types)
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring coffee into cup");
    }

    // Abstract methods (to be implemented by subclasses)
    abstract void brewCoffeeGrinds();
    abstract void addCondiments();
}

// Concrete Template (Coffee)
class Coffee extends CoffeeTemplate {
    @Override
    void brewCoffeeGrinds() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// Concrete Template (Tea)
class Tea extends CoffeeTemplate {
    @Override
    void brewCoffeeGrinds() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}