package parkinglot;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketNumber;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;

    public Ticket(int ticketNumber, LocalDateTime entryTime, ParkingSpot parkingSpot) {
        this.ticketNumber = ticketNumber;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
    }

}
