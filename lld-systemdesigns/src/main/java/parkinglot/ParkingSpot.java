package parkinglot;

public class ParkingSpot  {

private int id ;
private ParkingSpotType spotType;
private String vehicleRegNumber;
private boolean isAFree;

    public ParkingSpot(int id, ParkingSpotType spotType) {
        this.id = id;
        this.spotType = spotType;
        this.isAFree = true;
        vehicleRegNumber = null;

    }

    public int getId() {
        return id;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public boolean isAFree() {
        return isAFree;
    }

    public void setAFree(boolean AFree) {
        isAFree = AFree;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }
}
