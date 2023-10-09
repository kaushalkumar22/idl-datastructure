package lld_vendingmachine.vmstates;

import lld_vendingmachine.vmmodel.Coin;
import lld_vendingmachine.vmservice.VendingMachine;

public class InsertCoins extends VendingMachineState {
    public InsertCoins(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void pressButton(VendingMachine machine) {
        machine.setMachineState(new SelectItem(machine));
        System.out.println("Machine in ready for selecting item");
    }

    @Override
    public void insertCoin(VendingMachine machine , Coin coin){
        System.out.println("Accepting the coin "+ coin.name());
        machine.getInsetedCoins().add(coin);
    }

}


