package com.lowlevelsystemdesign.vendingmachine;

import com.lowlevelsystemdesign.vendingmachine.inventory.CashInventory;
import com.lowlevelsystemdesign.vendingmachine.inventory.ItemInventory;
import com.lowlevelsystemdesign.vendingmachine.state.ReadyState;
import com.lowlevelsystemdesign.vendingmachine.state.VendingMachineState;

import java.util.List;

public class VendingMachine {

    private VendingMachineState vendingMachineState;
    private ItemInventory itemInventory;
    private CashInventory cashInventory ;
    private Item selectedItem = null;
    private int enteredCashValue = 0;

    public VendingMachine() {
        vendingMachineState = new ReadyState(this);
        itemInventory = new ItemInventory();
        cashInventory = new CashInventory();
    }
    public void addCash(Coin cash) {
        enteredCashValue += cash.getCashValue();
        cashInventory.addCash(cash);
    }

    public void deductCash(Coin cash) {
        cashInventory.deductCash(cash);
    }

    public void addItem(Item item) {
        itemInventory.addItem(item);
    }

    public void deductItem(Item item) {
        itemInventory.removeItem(item);
    }

    public int getEnteredCashValue() {
        return this.enteredCashValue;
    }

    public void resetEnteredCashValue() {
        this.enteredCashValue = 0;
    }

    public Item getSelectedItem() {
        return this.selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void restSelectedItem() {
        this.selectedItem = null;
    }

    public boolean isSelectedItemAvailable() {
        return itemInventory.isItemAvailable(selectedItem);
    }

    public boolean isChangeAvailableForEnteredCash() {
        int remainingBalance = enteredCashValue - selectedItem.getPrice();
        if(remainingBalance != 0) {
            List<Coin> change = cashInventory.getChange(remainingBalance);
            return change != null ? true : false;
        }
        return true;
    }

    public boolean isSufficientCashInserted() {
        return enteredCashValue >= selectedItem.getPrice();
    }

    public List<Coin> getChange(int remainingBalance) {
        return cashInventory.getChange(remainingBalance);
    }

    public void setState(VendingMachineState state) {
        this.vendingMachineState = state;
    }


    //vending machine state related methods starts here

    public void insertCash(Coin cash) {
        vendingMachineState.insertCash(cash);
    }
    public void selectItem(int itemCode) {
        vendingMachineState.selectItem(itemCode);
    }

    public void processRequest() {
        vendingMachineState.processRequest();
    }

    public void dispenseItemAndCash() {
        vendingMachineState.dispenseItemAndCash();
    }

    public void cancelRequest() {
        vendingMachineState.cancelRequest();
    }

}
