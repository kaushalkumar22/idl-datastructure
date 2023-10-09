package com.creational;

public class Builder {
    public static void main(String[] args) {
       House hs =  new HouseBuilder().setFoundation("F1").setStructure("S1").setRoof("R1").build();
       System.out.println(hs);
    }
}
class House {
    private final String foundation;
    private final String structure;
    private final String roof;
    public House(HouseBuilder houseBuilder){
        this.foundation = houseBuilder.getFoundation();
        this.structure = houseBuilder.getStructure();
        this.roof = houseBuilder.getRoof();
    }

    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public String getRoof() {
        return roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}
class HouseBuilder{
    private  String foundation;
    private  String structure;
    private  String roof;

    public HouseBuilder() {
    }
    public String getFoundation() {
        return foundation;
    }
    public String getStructure() {
        return structure;
    }
    public String getRoof() {
        return roof;
    }
    public HouseBuilder setFoundation(String foundation) {
        this.foundation = foundation;
        return this;
    }
    public HouseBuilder setStructure(String structure) {
        this.structure = structure;
        return this;
    }
    public HouseBuilder setRoof(String roof) {
        this.roof = roof;
        return this;
    }
    public House build(){
        return new House(this);
    }
}