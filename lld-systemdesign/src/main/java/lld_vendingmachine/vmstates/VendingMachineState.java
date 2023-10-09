package lld_vendingmachine.vmstates;

import lld_vendingmachine.vmmodel.Coin;
import lld_vendingmachine.vmmodel.Item;
import lld_vendingmachine.vmservice.VendingMachine;

import java.util.List;

public abstract class VendingMachineState {

    private VendingMachine machine;
    public VendingMachineState(VendingMachine machine){
        this.machine = machine;
    }
    public abstract void pressButton(VendingMachine machine);

    public void insertCoin(VendingMachine machine, Coin cash) {
        throw new RuntimeException("Vending machine is in " +  machine.getMachineState() + "., hence unable to add the cash");
    }

    public void selectItem(VendingMachine machine,int itemCode) {
        throw new RuntimeException("Vending machine is in " +  machine.getMachineState() + "., hence unable to select a product");
    }

    public Item dispenseItem(VendingMachine machine) {
        throw new RuntimeException("Vending machine is in " + machine.getMachineState() + "., hence unable to process request");
    }

    public List<Coin> dispenseCoins(VendingMachine machine) {
        throw new RuntimeException("Vending machine is in " + machine.getMachineState() + "., hence unable to dispense");
    }

    public void cancelRequest(VendingMachine machine) {
        throw new RuntimeException("Vending machine is in " + machine.getMachineState() + "., hence unable to cancel the current request");
    }

}
