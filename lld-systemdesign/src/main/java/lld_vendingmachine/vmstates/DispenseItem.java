package lld_vendingmachine.vmstates;

import lld_vendingmachine.vmmodel.Item;
import lld_vendingmachine.vmservice.VendingMachine;

public class DispenseItem extends VendingMachineState{
    public DispenseItem(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void pressButton(VendingMachine machine) {
        machine.setMachineState(new DispenseCoins(machine));
        System.out.println("Machine in dispensing Coin State");
    }

    @Override
    public Item dispenseItem(VendingMachine machine)  {
        System.out.println("Currently Vending machine is dispensing item");
        if (machine.getRefundCoins() == null) {
            machine.setMachineState(new ReadyState(machine));
        } else{
            pressButton(machine);
        }
        return machine.getSelectedItem();
    }
}
