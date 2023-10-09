package lld_vendingmachine.vmstates;

import lld_vendingmachine.vmmodel.Coin;
import lld_vendingmachine.vmmodel.Item;
import lld_vendingmachine.vmservice.VendingMachine;

public class SelectItem extends VendingMachineState {
    public SelectItem(VendingMachine machine) {
        super(machine);
    }
    @Override
    public void pressButton(VendingMachine machine) {
        machine.setMachineState(new DispenseItem(machine));
        System.out.println("Machine is ready for Dispensing");
    }

    @Override
    public void selectItem(VendingMachine machine, int itemCode) {
        //1. get item of this codeNumber
        Item item = machine.getSelectedItem(itemCode);

        //2. total coins inseted by User


        for(Coin coin : machine.getInsetedCoins()){
            machine.addCash(coin);
        }

        //3. compare product price and amount paid by user
        if(machine.isSufficientCashInserted()) {
            if(machine.getRemainingBalance()==0 ||
                    machine.isChangeAvailableForRemainingBalance(machine.getRemainingBalance())){
                pressButton(machine);
            }else{
                for(Coin coin : machine.getInsetedCoins()){
                    machine.deductCoin(coin);
                }
                machine.setMachineState(new ReadyState(machine));
                System.out.println("Refunded Change Not Available");
                machine.getInsetedCoins().clear();
                machine.resetEnteredCashValue();
            }
        } else{
            System.out.println("Insufficient Coins inserted by user, Product you selected is for price: " + item.getPrice());
            for(Coin coin : machine.getInsetedCoins()){
                machine.deductCoin(coin);
            }
            machine.setMachineState(new ReadyState(machine));
            System.out.println("Refunded Insufficient Coins inserted for selected item :" + item.getPrice() +" coins " + machine.getInsetedCoinsValue());
            machine.getInsetedCoins().clear();
            machine.resetEnteredCashValue();
        }
    }


}
