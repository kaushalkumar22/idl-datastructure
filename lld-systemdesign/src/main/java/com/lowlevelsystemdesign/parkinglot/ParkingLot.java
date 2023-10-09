package com.lowlevelsystemdesign.parkinglot;

import java.util.List;

public class ParkingLot {

    private List<ParkingLevel> parkingLevels;
    private ParkingRate parkingRate;
    private Ticket ticket;
    private List<EntryGate> entryGates;
    private List<EntryGate> exitGates;
    private Payment payment;
    private DisplayBoard displayBoard;
    private ParkingSpot parkingSpot;

    public ParkingLot(List<ParkingLevel> parkingLevels, ParkingRate parkingRate, Ticket ticket, List<EntryGate> entryGates, List<EntryGate> exitGates, Payment payment, DisplayBoard displayBoard) {
        this.parkingLevels = parkingLevels;
        this.parkingRate = parkingRate;
        this.ticket = ticket;
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        this.payment = payment;
        this.displayBoard = displayBoard;
        this.parkingSpot =null;
    }

    public ParkingLot(ParkingRate parkingRate, Ticket ticket, List<EntryGate> entryGates, List<EntryGate> exitGates, Payment payment, DisplayBoard displayBoard, ParkingSpot parkingSpot) {
        this.parkingRate = parkingRate;
        this.ticket = ticket;
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        this.payment = payment;
        this.displayBoard = displayBoard;
        this.parkingSpot = parkingSpot;
        this.parkingLevels = null;
    }

    public List<ParkingLevel> getParkingLevels() {
        return parkingLevels;
    }

    public ParkingRate getParkingRate() {
        return parkingRate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<EntryGate> getExitGates() {
        return exitGates;
    }

    public Payment getPayment() {
        return payment;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
