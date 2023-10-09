package com.vendingmachine.context;

import com.vendingmachine.enums.Coin;
import com.vendingmachine.enums.Item;
import com.vendingmachine.invetory.CoinInventory;
import com.vendingmachine.invetory.ItemInventory;
import com.vendingmachine.state.InsertMoneyState;
import com.vendingmachine.state.SelectItemState;
import com.vendingmachine.state.VendingMachineState;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private VendingMachineState state;
    private ItemInventory itemInventory;
    private CoinInventory cashInventory;
    private int totalAmount =0;
    private Map<Coin,Integer> coinCache;

    private Item selectedItem ;

    public VendingMachine(){
        state = new InsertMoneyState();
        itemInventory = new ItemInventory();
        cashInventory = new CoinInventory();
        coinCache = new HashMap<>();
    }

    public void setState(VendingMachineState state){
        this.state = state;
    }

    public void insertMoney(Coin coin) {
        totalAmount += coin.getCashValue();
        coinCache.put(coin,coinCache.getOrDefault(coin,0)+1);
    }

    //manually user has to select then system will process this request.
    public void selectItem(int itemCode) {
        setState(new SelectItemState());
        state.selectItem(this,itemCode);
    }

    public void processRequest( ) {
        state.processRequest(this);
    }
    public void dispenseItem() {
        state.dispenseItem(this);
    }

    public  void returnChange() {
        state.returnChange(this);
    }

    public void rejectRequest(VendingMachine machine) {
        state.rejectRequest(this);
    }

    public VendingMachineState getState() {
        return state;
    }

    public ItemInventory getItemInventory() {
        return itemInventory;
    }

    public CoinInventory getCashInventory() {
        return cashInventory;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void refund() {
        System.out.println("Total "+totalAmount + " Amount Refunded");
        totalAmount = 0;
        coinCache.clear();
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item item) {
        this.selectedItem = item;
    }
    public void setMachineInReadyState() {
        totalAmount = 0;
        coinCache.clear();
        selectedItem = null;
    }

    public void updateCoinInventory() {
        cashInventory.addCoinsToInventory(coinCache);
        setMachineInReadyState();
    }
}
