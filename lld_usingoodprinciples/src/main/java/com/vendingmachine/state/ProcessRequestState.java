package com.vendingmachine.state;

import com.vendingmachine.enums.Item;
import com.vendingmachine.invetory.ItemInventory;
import com.vendingmachine.context.VendingMachine;

public class ProcessRequestState implements VendingMachineState {

    @Override
    public void processRequest(VendingMachine machine) {
         Item item = machine.getSelectedItem();
         ItemInventory itemInventory = machine.getItemInventory();
         String itemCode = itemInventory.getItem(item);
         System.out.println(itemCode +" is Dispatched");
         machine.setState(new DispenseItemState());
         machine.dispenseItem();
    }
}
