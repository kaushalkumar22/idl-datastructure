package com.lowlevelsystemdesign.vendingmachine.state;
import com.lowlevelsystemdesign.vendingmachine.Coin;
import com.lowlevelsystemdesign.vendingmachine.VendingMachine;

import java.util.List;

public class DispensingState implements VendingMachineState {

    private VendingMachine vendingMachine;
    private List<Coin> change;

    public DispensingState(VendingMachine vendingMachine, List<Coin> change) {
        this.vendingMachine = vendingMachine;
        this.change = change;
    }

    @Override
    public void dispenseItemAndCash() {

        if(vendingMachine.getSelectedItem() != null) {
            System.out.println("Dispensed item is : "+ vendingMachine.getSelectedItem().getName());
        }

        if(change != null) {
            for(Coin cash : change) {
                vendingMachine.deductCash(cash);
                System.out.println("Dispensed cash is : "+ cash.getCashValue());
            }
        }

        vendingMachine.setState(new ReadyState(vendingMachine));
    }
}
