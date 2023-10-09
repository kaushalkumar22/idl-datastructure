package lld_vendingmachine.vmstates;

import lld_vendingmachine.vmservice.VendingMachine;

public class ReadyState extends VendingMachineState {

    public ReadyState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void pressButton(VendingMachine machine){
        machine.setMachineState(new InsertCoins(machine));
        System.out.println("Machine in ready for inserting coins");
    }

}
