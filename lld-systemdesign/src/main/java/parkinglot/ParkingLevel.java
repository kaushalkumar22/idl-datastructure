package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private int levelNumber;
    private List<ParkingSpot> spaces;

    public ParkingLevel(int levelNumber, int numberOfSpaces) {
        this.levelNumber = levelNumber;
        spaces = new ArrayList<>();
    }

    public List<ParkingSpot> getSpaces() {
        return spaces;
    }
}
