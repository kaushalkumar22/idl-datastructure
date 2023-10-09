package com.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositePatternClient {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(circle);
        compositeGraphic.add(rectangle);

        // Drawing individual shapes
        System.out.println("Drawing individual shapes:");
        circle.draw();
        rectangle.draw();

        // Drawing the composite graphic
        System.out.println("\nDrawing the composite graphic:");
        compositeGraphic.draw();
    }
}
// Component
interface Graphic {
    void draw();
}

// Leaf
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
// Leaf
class Rectangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
// Composite
class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();
    public void add(Graphic graphic) {
        graphics.add(graphic);
    }
    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}
