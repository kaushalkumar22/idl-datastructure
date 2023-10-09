package com.structural;

public class FacadePatternClient {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();

        // Start and shut down the computer using the facade
        computer.startComputer();
        computer.shutdownComputer();
    }
}
// Subsystem classes
class CPU {
    public void start() {
        System.out.println("CPU started");
    }

    public void execute() {
        System.out.println("CPU executing");
    }

    public void shutdown() {
        System.out.println("CPU shut down");
    }
}

class Memory {
    public void load() {
        System.out.println("Memory loaded");
    }

    public void release() {
        System.out.println("Memory released");
    }
}

class HardDrive {
    public void readData() {
        System.out.println("Hard Drive reading data");
    }
}

// Facade class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        System.out.println("Starting computer...");
        cpu.start();
        memory.load();
        hardDrive.readData();
        cpu.execute();
    }

    public void shutdownComputer() {
        System.out.println("Shutting down computer...");
        cpu.shutdown();
        memory.release();
    }
}
