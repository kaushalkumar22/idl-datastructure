package com.behavioral;

public class CommandPatternClient {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command turnOnCommand = new TurnOnLightCommand(livingRoomLight);
        Command turnOffCommand = new TurnOffLightCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnCommand);
        remote.pressButton(); // Turns on the light

        remote.setCommand(turnOffCommand);
        remote.pressButton(); // Turns off the light
    }
}
// Command interface
interface Command {
    void execute();
}

// Receiver
class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }

    void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Commands
class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker
class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}
