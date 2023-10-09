package com.creational;

public class ComputerBuilderClient {
    public static void main(String[] args) {

        Computer computer = new ComputerBuilder()
                .setCpu("Intel i7")
                .setStorage(1000)
                .setGpu("NVIDIA GTX 3080")
                .setRam(32)
                .build();

        System.out.println("Computer configuration:");
        System.out.println("CPU: " + computer.getCpu());
        System.out.println("GPU: " + computer.getGpu());
        System.out.println("RAM: " + computer.getRam() + "GB");
        System.out.println("Storage: " + computer.getStorage() + "GB");
    }
}
// Product: Computer
class Computer {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;

    public Computer(String cpu, String gpu, int ram, int storage) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
    }
    public String getCpu() {
        return cpu;
    }
    public String getGpu() {
        return gpu;
    }
    public int getRam() {
        return ram;
    }
    public int getStorage() {
        return storage;
    }
}

class ComputerBuilder {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }
    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }
    public ComputerBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }
    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }
    public Computer build() {
        return new Computer(cpu, gpu, ram, storage);
    }
}
