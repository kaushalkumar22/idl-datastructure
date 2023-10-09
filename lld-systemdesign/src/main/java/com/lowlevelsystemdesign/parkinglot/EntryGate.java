package com.lowlevelsystemdesign.parkinglot;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class EntryGate {
    // Data members
    private int id;
    // Member function
    public Ticket getTicket(ParkingSpot spotType ){
        return new Ticket(new Random().nextInt(),LocalDateTime.now(),spotType);
    }

}
