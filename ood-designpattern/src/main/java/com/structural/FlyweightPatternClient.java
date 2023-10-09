package com.structural;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPatternClient {
    public static void main(String[] args) {
        CoffeeOrderContext context = new CoffeeOrderContext();

        context.takeOrder("Cappuccino", 1).serveCoffee("A");
        context.takeOrder("Espresso", 2).serveCoffee("B");
        context.takeOrder("Cappuccino", 3).serveCoffee("C");
        context.takeOrder("Latte", 4).serveCoffee("D");
        context.takeOrder("Espresso", 5).serveCoffee("E");

        // Here, "Cappuccino" and "Espresso" flavors are shared among multiple tables.
    }
}
// Flyweight interface
interface CoffeeOrder {
    void serveCoffee(String table);
}

// Concrete Flyweight
class CoffeeFlavor implements CoffeeOrder {
    private final String flavor;

    public CoffeeFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public void serveCoffee(String table) {
        System.out.println("Serving " + flavor + " coffee to table " + table);
    }
}

// Flyweight Factory
class CoffeeOrderContext {
    private final CoffeeFlavorFactory factory;

    public CoffeeOrderContext() {
        this.factory = new CoffeeFlavorFactory();
    }

    public CoffeeOrder takeOrder(String flavor, int table) {
        return factory.getCoffeeFlavor(flavor);
    }
}

// Flyweight Factory (with caching)
class CoffeeFlavorFactory {
    private final Map<String, CoffeeFlavor> flavors = new HashMap<>();

    public CoffeeOrder getCoffeeFlavor(String flavorName) {
        CoffeeFlavor flavor = flavors.get(flavorName);

        if (flavor == null) {
            flavor = new CoffeeFlavor(flavorName);
            flavors.put(flavorName, flavor);
        }

        return flavor;
    }
}
