package com.vendingmachine.state;

import com.vendingmachine.enums.Coin;
import com.vendingmachine.context.VendingMachine;

public class InsertMoneyState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine machine, Coin coin) {
        System.out.println("$ "+ coin.getCashValue() + " Coin is inserted");
        machine.insertMoney(coin);
    }
}
