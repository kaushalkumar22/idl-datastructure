package vendingmachine.inventory;

import vendingmachine.Coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashInventory {

    private Map<Coin, Integer> cash = new HashMap<>();

    public void addCash(Coin cash) {
        this.cash.put(cash, this.cash.getOrDefault(cash, 0) + 1);
    }

    public void deductCash(Coin cash) {
        Integer existingCash = this.cash.get(cash);
        if( existingCash != null) {
            this.cash.put(cash, this.cash.get(cash) - 1);
            if(this.cash.get(cash) == 0) {
                this.cash.remove(cash);
            }
        }
    }

    public List<Coin> getChange(int remainingBalance) {
        List<Coin> change = new ArrayList<>();
        int balance = remainingBalance;
        while(balance > 0) {
            if(balance >= Coin.QUARTER.getCashValue() && cash.get(Coin.QUARTER) != null) {
                change.add(Coin.QUARTER);
                balance = balance - Coin.QUARTER.getCashValue();
            } else if(balance >= Coin.DIME.getCashValue() && cash.get(Coin.DIME) != null) {
                change.add(Coin.DIME);
                balance = balance - Coin.DIME.getCashValue();
            } else if(balance >= Coin.NICKEL.getCashValue() && cash.get(Coin.NICKEL) != null) {
                change.add(Coin.NICKEL);
                balance = balance - Coin.NICKEL.getCashValue();
            } else if(balance >= Coin.PENNY.getCashValue() && cash.get(Coin.PENNY) != null) {
                change.add(Coin.PENNY);
                balance = balance - Coin.PENNY.getCashValue();
            } else {
                return null;
            }
        }
        return change;
    }
}
