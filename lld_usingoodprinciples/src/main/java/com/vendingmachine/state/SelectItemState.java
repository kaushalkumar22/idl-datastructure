package com.vendingmachine.state;

import com.vendingmachine.enums.Item;
import com.vendingmachine.context.VendingMachine;

public class SelectItemState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, int itemCode) {

        Item item = getItemByCode(itemCode);
        System.out.println("User has selected " + item.getName());
        if(!machine.getItemInventory().isItInStock(item)
                || item.getPrice() > machine.getTotalAmount()){
            //initialize the refund and set status as inset coin
            machine.refund();
            machine.setState(new InsertMoneyState());
        }else{
            machine.setState(new ProcessRequestState());
            machine.setSelectedItem(item);
            machine.processRequest();
        }
    }

    private Item getItemByCode(int itemCode){

        switch (itemCode){
            case  100 : return Item.CHOCOLATE;
            case  200 :return Item.CAKE;
            case  300 :return Item.COKE;
            default: throw new RuntimeException("Item not available");
        }
    }
}
