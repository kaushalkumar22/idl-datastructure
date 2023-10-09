package com.vendingmachine.client;

import com.vendingmachine.enums.Coin;
import com.vendingmachine.enums.Item;
import com.vendingmachine.context.VendingMachine;
import com.vendingmachine.state.VendingMachineState;

import java.util.Date;

public class TestVendingMachine {
    public static void main(String[] args) {
        System.out.println(new Date());
        VendingMachine machine = new VendingMachine();
        addItem( machine);
        VendingMachineState state = machine.getState();
        state.insertMoney(machine, Coin.DIME);
      //  state.insertMoney(machine,Coin.NICKEL);
        //state.insertMoney(machine,Coin.PENNY);
       // state.insertMoney(machine,Coin.QUARTER);
        machine.selectItem(100);

        state = machine.getState();
        state.insertMoney(machine, Coin.QUARTER);
        //  state.insertMoney(machine,Coin.NICKEL);
        //state.insertMoney(machine,Coin.PENNY);
        // state.insertMoney(machine,Coin.QUARTER);
        machine.selectItem(200);
    }
    private static void addItem( VendingMachine machine){
        machine.getItemInventory().addItem(Item.CAKE);
        machine.getItemInventory().addItem(Item.CAKE);
        machine.getItemInventory().addItem(Item.CHOCOLATE);
        machine.getItemInventory().addItem(Item.COKE);
        machine.getItemInventory().addItem(Item.CHOCOLATE);
        machine.getItemInventory().addItem(Item.COKE);
    }


}
