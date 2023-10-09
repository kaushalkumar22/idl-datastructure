package com.vendingmachine.state;

import com.vendingmachine.context.VendingMachine;

public class ReturnChangeState implements VendingMachineState {

    @Override
    public void returnChange(VendingMachine machine) {
        System.out.println("Change Returned!!!!!!!");
        machine.updateCoinInventory();
        machine.setState(new InsertMoneyState());
        machine.setMachineInReadyState();
    }
}
