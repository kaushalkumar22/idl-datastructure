package com.creational;

import java.util.HashMap;
import java.util.Map;

public class PrototypeClient {
    public static void main(String[] args) {
        Shape circle1 = ShapeRegistry.getShape("Circle");
        Shape rectangle1 = ShapeRegistry.getShape("Rectangle");
        System.out.println(circle1.getType());
        System.out.println(rectangle1.getType());
    }
}
// Prototype: Shape
abstract class Shape implements Cloneable {
    private String type;
    public Shape(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    abstract void draw();
    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
// Concrete Prototypes: Circle and Rectangle
class Circle extends Shape {
    public Circle() {
        super("Circle");
    }
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        super("Rectangle");
    }
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Prototype Registry
class ShapeRegistry {
    private static Map<String, Shape> shapeMap = new HashMap<>()
    {{
        put("Circle", new Circle());
        put("Rectangle", new Rectangle());
    }};
    public static Shape getShape(String type) {
        Shape shape = shapeMap.get(type);
        if (shape != null) {
            return shape.clone();
        }
        return null;
    }
}

