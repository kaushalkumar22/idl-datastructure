package com.creational;

public class AbstractFactoryClient {
    private static void createUI(GUIFactory factory) {
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.render();
        checkbox.render();
    }

    public static void main(String[] args) {
        System.out.println("Creating a Windows-style UI:");
        createUI(new WindowsFactory());
        System.out.println("\nCreating a macOS-style UI:");
        createUI(new MacOSFactory());
    }
}
// Abstract Product: Button
interface Button {
    void render();
}
// Concrete Product: WindowsButton
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows button.");
    }
}
// Concrete Product: MacOSButton
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a macOS button.");
    }
}
// Abstract Product: Checkbox
interface Checkbox {
    void render();
}
// Concrete Product: WindowsCheckbox
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox.");
    }
}
// Concrete Product: MacOSCheckbox
class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a macOS checkbox.");
    }
}
// Abstract Factory: GUIFactory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
// Concrete Factory: WindowsFactory
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
// Concrete Factory: MacOSFactory
class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

