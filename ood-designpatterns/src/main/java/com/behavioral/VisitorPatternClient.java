package com.behavioral;

public class VisitorPatternClient {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator areaCalculator = new AreaCalculator();

        circle.accept(areaCalculator);
        rectangle.accept(areaCalculator);

        System.out.println("Total area: " + areaCalculator.getTotalArea()); // Output: Total area: 83.84956
    }
}
// Visitor interface
interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

// Concrete Visitor
class AreaCalculator implements ShapeVisitor {
    private double totalArea = 0.0;

    public double getTotalArea() {
        return totalArea;
    }

    @Override
    public void visit(Circle circle) {
        totalArea += Math.PI * Math.pow(circle.getRadius(), 2);
    }

    @Override
    public void visit(Rectangle rectangle) {
        totalArea += rectangle.getWidth() * rectangle.getHeight();
    }
}

// Element interface
interface Shape {
    void accept(ShapeVisitor visitor);
}

// Concrete Elements
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
// Visitor interface
interface Visitor {
    void visit(ElementA elementA);
    void visit(ElementB elementB);
}

// Concrete Visitor
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ElementA elementA) {
        System.out.println("Visitor is processing ElementA");
    }

    @Override
    public void visit(ElementB elementB) {
        System.out.println("Visitor is processing ElementB");
    }
}

// Element interface
interface Element {
    void accept(Visitor visitor);
}

// Concrete Element A
class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element B
class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Object Structure
class ObjectStructure {
    private Element[] elements;

    public ObjectStructure() {
        elements = new Element[]{new ElementA(), new ElementB()};
    }

    public void acceptVisitor(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

 class VisitorPatternExample {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.acceptVisitor(visitor);
    }
}