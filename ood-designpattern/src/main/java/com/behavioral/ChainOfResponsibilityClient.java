package com.behavioral;

public class ChainOfResponsibilityClient {
    public static void main(String[] args) {
        // Create handlers
        ProcurementHandler managerHandler = new ManagerProcurementHandler();
        ProcurementHandler directorHandler = new DirectorProcurementHandler();
        ProcurementHandler ceoHandler = new CEOProcurementHandler();

        // Set up the chain
        managerHandler.setNextHandler(directorHandler);
        directorHandler.setNextHandler(ceoHandler);

        // Create Procurement requests
        ProcurementRequest request1 = new ProcurementRequest(800);    // Manager can approve
        ProcurementRequest request2 = new ProcurementRequest(4500);   // Director can approve
        ProcurementRequest request3 = new ProcurementRequest(15000);  // No one can approve

        // Process the requests through the chain
        managerHandler.processRequest(request1);
        managerHandler.processRequest(request2);
        managerHandler.processRequest(request3);
    }
}
//handler interface:
interface ProcurementHandler {
    void setNextHandler(ProcurementHandler nextHandler);
    void processRequest(ProcurementRequest request);
}
//concrete handler ManagerProcurementHandler
class ManagerProcurementHandler implements ProcurementHandler {
    private ProcurementHandler nextHandler;
    @Override
    public void setNextHandler(ProcurementHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void processRequest(ProcurementRequest request) {
        if (request.getAmount() <= 1000) {
            System.out.println("Manager can approve the Procurement of $" + request.getAmount());
        } else if (nextHandler != null) {
            nextHandler.processRequest(request);
        } else {
            System.out.println("No one can approve the Procurement of $" + request.getAmount());
        }
    }
}
//concrete handler DirectorProcurementHandler
class DirectorProcurementHandler implements ProcurementHandler {
    private ProcurementHandler nextHandler;
    @Override
    public void setNextHandler(ProcurementHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void processRequest(ProcurementRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("Director can approve the Procurement of $" + request.getAmount());
        } else if (nextHandler != null) {
            nextHandler.processRequest(request);
        } else {
            System.out.println("No one can approve the Procurement of $" + request.getAmount());
        }
    }
}
//concrete handler CEOProcurementHandler
class CEOProcurementHandler implements ProcurementHandler {
    @Override
    public void setNextHandler(ProcurementHandler nextHandler) {
        // CEO is the last in the chain, so we can leave this empty
    }
    @Override
    public void processRequest(ProcurementRequest request) {
        if (request.getAmount() <= 10000) {
            System.out.println("CEO can approve the Procurement of $" + request.getAmount());
        } else {
            System.out.println("No one can approve the Procurement of $" + request.getAmount());
        }
    }
}
//ProcurementRequest class to represent the Procurement requests
class ProcurementRequest {
    private double amount;
    public ProcurementRequest(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
}
