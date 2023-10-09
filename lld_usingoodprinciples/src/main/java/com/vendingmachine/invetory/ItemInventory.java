package com.vendingmachine.invetory;

import com.vendingmachine.enums.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemInventory {
    Map<Item,Integer> inventory;
    public ItemInventory(){
        initItemInventory();
    }
    private void initItemInventory(){
        inventory = new HashMap<>();
        inventory.put(Item.CHOCOLATE,0) ;
        inventory.put(Item.CAKE,0) ;
        inventory.put(Item.COKE,0) ;
    }
    public boolean isItInStock(Item item){
        return inventory.getOrDefault(item,0) > 0 ? true : false;
    }
    public void addItem(Item item){
         inventory.put(item, inventory.getOrDefault(item,0)+1);
    }

    public String getItem(Item item){
        if(isItInStock(item)) {
            inventory.put(item, inventory.get(item)-1);
        }
       return item.getName();
    }
}
