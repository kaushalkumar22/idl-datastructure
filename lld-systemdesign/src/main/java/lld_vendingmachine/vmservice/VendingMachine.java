package lld_vendingmachine.vmservice;

import lld_vendingmachine.vminventory.CoinInventory;
import lld_vendingmachine.vminventory.ItemInventory;
import lld_vendingmachine.vmmodel.Coin;
import lld_vendingmachine.vmmodel.Item;
import lld_vendingmachine.vmstates.InsertCoins;
import lld_vendingmachine.vmstates.ReadyState;
import lld_vendingmachine.vmstates.SelectItem;
import lld_vendingmachine.vmstates.VendingMachineState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private VendingMachineState machineState;
    private ItemInventory itemInventory;
    private CoinInventory coinInventory;
    private List<Coin>   insetedCoins;

    private List<Coin> refundCoins;

    private int insetedCoinsValue ;

    private Item selectedItem;

    //if there is refund need to refund after item dispense


    public VendingMachine() {
        machineState  = new ReadyState(this);
        itemInventory = new ItemInventory();
        coinInventory = new CoinInventory();
        insetedCoins  = new ArrayList<>();
    }
    //this button need to press for next step
    public void pressButton() {
        machineState.pressButton(this);
    }
    public void setMachineState(VendingMachineState machineState) {
        this.machineState = machineState;
    }

    public VendingMachineState getMachineState() {
        return machineState;
    }

    public ItemInventory getItemInventory() {
        return itemInventory;
    }
    public CoinInventory getCoinInventory() {
        return coinInventory;
    }
    public void addCash(Coin coin) {
        coinInventory.addCoins(coin);
    }
    public void deductCoin(Coin coin) {
        coinInventory.deductCash(coin);
    }


    public void addItem(Item item) {
        itemInventory.addItems(item);
    }

    public void deductItem(Item item) {
        itemInventory.deductItem(item);
    }

    public int getEnteredCashValue() {
        for (Coin c :insetedCoins){
            insetedCoinsValue += c.getValue();
        }
        return insetedCoinsValue;
    }

    public void resetEnteredCashValue() {
        insetedCoins.clear();
        this.insetedCoinsValue = 0;
    }

    public Item getSelectedItem(int itemCode) {
        selectedItem = itemInventory.getItem(itemCode);
        return selectedItem;
    }

    public int getRemainingBalance(){
        return insetedCoinsValue - selectedItem.getPrice();
    }

    public boolean isChangeAvailableForRemainingBalance(int remainingBalance) {
        if(remainingBalance!=0)
            refundCoins = coinInventory.getChange(remainingBalance);

        return refundCoins == null ? false :true;
    }

    public boolean isSufficientCashInserted() {
        return insetedCoinsValue >= selectedItem.getPrice();
    }

    public List<Coin> getChange(int remainingBalance) {
        return refundCoins;
    }

    public List<Coin> getInsetedCoins() {
        return insetedCoins;
    }

    public List<Coin> getRefundCoins() {
        return refundCoins;
    }

    public int getInsetedCoinsValue() {
        return insetedCoinsValue;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void insertCoin(Coin coin) {
        setMachineState(new InsertCoins(this));
        machineState.insertCoin(this,coin);
    }

    public void selectItem(int itemCode) {
        setMachineState(new SelectItem(this));
        machineState.selectItem(this, itemCode);
    }

    public Item dispenseItem( ) {
        return machineState.dispenseItem(this);
    }

    public List<Coin> dispenseCoins( ) {
        return machineState.dispenseCoins(this);
    }

    public void cancelRequest( ) {
        machineState.cancelRequest(this);
    }

}
