package com.vendingmachine.invetory;

import com.vendingmachine.enums.Coin;

import java.util.HashMap;
import java.util.Map;

public class CoinInventory {

    private Map<Coin,Integer> coins;
    private int totalAmount ;
    public CoinInventory(){
        coins = new HashMap<>();
        totalAmount = 0;
    }

    public void addCoinsToInventory(Map<Coin,Integer> inserted){
        for(Coin coin : inserted.keySet()){
            coins.put(coin,coins.getOrDefault(coin,0)+inserted.get(coin));
            totalAmount += coin.getCashValue()*inserted.get(coin);
        }
    }

    //need to do calculation for getting for simplicity logic not written
    public void takeCoinsFromInventory(Map<Coin,Integer> inserted){
        for(Coin coin : inserted.keySet()){
            coins.put(coin,coins.getOrDefault(coin,0)-inserted.get(coin));
            totalAmount = coin.getCashValue()*inserted.get(coin);
        }
    }

    public int getTotalAmount(){
        return totalAmount;
    }
}
