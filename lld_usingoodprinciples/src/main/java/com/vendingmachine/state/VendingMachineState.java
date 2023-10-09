package com.vendingmachine.state;

import com.vendingmachine.enums.Coin;
import com.vendingmachine.context.VendingMachine;

public interface VendingMachineState {

        default void insertMoney(VendingMachine machine, Coin cash) {
            throw new RuntimeException("Vending machine is unable to add the cash");
        }

        default void selectItem(VendingMachine machine,int itemCode) {
            throw new RuntimeException("Vending machine is unable to select a product");
        }

        //also validation will happen whether customer has inserted sufficent coins for selected item
        //or not if not request will be rejected and coins returned back to user.
        default void processRequest(VendingMachine machine) {
            throw new RuntimeException("Vending machine is unable to process request");
        }

        default void dispenseItem(VendingMachine machine) {
            throw new RuntimeException("Vending machine is unable to dispense Coins");
        }

        default void returnChange(VendingMachine machine) {
            throw new RuntimeException("Vending machine is unable to dispense Coins");
        }

        default void rejectRequest(VendingMachine machine) {
            throw new RuntimeException("Vending machine is unable to reject the current request");
        }
    }

