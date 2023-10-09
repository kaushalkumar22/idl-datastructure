package com.vendingmachine.state;

import com.vendingmachine.context.VendingMachine;

public class DispenseItemState implements VendingMachineState {

    @Override
    public void dispenseItem(VendingMachine machine) {
        //if inserted amount is more than item price do refund remaining amount
        if( machine.getTotalAmount()>machine.getSelectedItem().getPrice() ){
            machine.setState(new ReturnChangeState());
            machine.returnChange();
        }else{
            machine.setState(new InsertMoneyState());
            machine.setMachineInReadyState();
        }

    }
}
