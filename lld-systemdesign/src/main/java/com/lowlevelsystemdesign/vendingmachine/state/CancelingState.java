package com.lowlevelsystemdesign.vendingmachine.state;

import com.lowlevelsystemdesign.vendingmachine.VendingMachine;

public class CancelingState implements VendingMachineState {

    private VendingMachine vendingMachine;

    public CancelingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void cancelRequest() {
        int remainingBalance = vendingMachine.getEnteredCashValue();
        vendingMachine.restSelectedItem();
        vendingMachine.resetEnteredCashValue();
        System.out.println("Request canceled successfully");
        vendingMachine.setState(new DispensingState(vendingMachine, vendingMachine.getChange(remainingBalance)));
        vendingMachine.dispenseItemAndCash();

    }
}
