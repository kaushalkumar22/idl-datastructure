package lld_vendingmachine.vmstates;

import lld_vendingmachine.vmmodel.Coin;
import lld_vendingmachine.vmservice.VendingMachine;

import java.util.List;

public class DispenseCoins extends VendingMachineState{


    public DispenseCoins(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void pressButton(VendingMachine machine) {
        machine.setMachineState(new ReadyState(machine));
        System.out.println("Machine in ready for select an item");
    }
    @Override
    public List<Coin> dispenseCoins(VendingMachine machine){
        System.out.println("Currently Vending machine is dispensing coin");
        System.out.println("Coins are " + machine.getRefundCoins());
        machine.getRefundCoins().clear();
        pressButton(machine);
        return null;
    }
}
