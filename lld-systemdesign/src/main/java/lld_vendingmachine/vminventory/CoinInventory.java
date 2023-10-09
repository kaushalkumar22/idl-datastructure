package lld_vendingmachine.vminventory;

import lld_vendingmachine.vmmodel.Coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinInventory {
    private Map<Integer, Integer> valueVScount;
    private Map<Integer, Coin> valueVScoin;

    public CoinInventory(){
        valueVScount = new HashMap<>();
        valueVScoin = new HashMap<>();
    }

    private Coin getCoin(int value) {
        if(valueVScount.get(value)>0){
            valueVScount.put(value,valueVScount.get(value)-1);
            return valueVScoin.get(value);
        }
        return null;
    }
    public void deductCash(Coin cash) {
        getCoin( cash.getValue());
    }
    public void addCoins(Coin coin) {
        int value = coin.getValue();
        valueVScoin.put(value,coin);
        valueVScount.put(value,valueVScount.getOrDefault(value,0)+1);
    }

    public List<Coin> getChange(int remainingBalance) {
        List<Coin> change = new ArrayList<>();
        int balance = remainingBalance;
        while(balance > 0) {
            if(balance >= Coin.QUARTER.getValue() && getCoin(Coin.QUARTER.getValue())!=null) {
                change.add(Coin.QUARTER);
                balance = balance - Coin.QUARTER.getValue();
            } else if(balance >= Coin.DIME.getValue() && getCoin(Coin.DIME.getValue()) != null) {
                change.add(Coin.DIME);
                balance = balance - Coin.DIME.getValue();
            } else if(balance >= Coin.NICKEL.getValue() && getCoin(Coin.NICKEL.getValue()) != null) {
                change.add(Coin.NICKEL);
                balance = balance - Coin.NICKEL.getValue();
            } else if(balance >= Coin.PENNY.getValue() && getCoin(Coin.PENNY.getValue()) != null) {
                change.add(Coin.PENNY);
                balance = balance - Coin.PENNY.getValue();
            } else {
                for(Coin coin : change){
                    addCoins(coin);
                }
                return null;
            }
        }
        return change;
    }
}
