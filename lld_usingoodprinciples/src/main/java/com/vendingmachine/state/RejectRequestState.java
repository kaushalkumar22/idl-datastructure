package com.vendingmachine.state;

import com.vendingmachine.context.VendingMachine;

public class RejectRequestState implements VendingMachineState {

    @Override
    public void rejectRequest(VendingMachine machine) {
        throw new RuntimeException("Vending machine is unable to reject the current request");
    }
}
