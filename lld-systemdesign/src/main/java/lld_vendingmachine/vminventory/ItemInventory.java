package lld_vendingmachine.vminventory;


import lld_vendingmachine.vmmodel.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemInventory {
    private Map<Integer, Integer> itemCodeVSCount;
    private Map<Integer,Item> idVSItem;

    public ItemInventory(){
        itemCodeVSCount = new HashMap<>();
        idVSItem = new HashMap<>();
    }
    public Item getItem(int itemCode) {
        if(itemCodeVSCount.get(itemCode)>0){
            itemCodeVSCount.put(itemCode,itemCodeVSCount.get(itemCode)-1);
            return idVSItem.get(itemCode);
        }
        return null;
    }

    public void addItems(Item item) {
        int itemCode = item.getCode();
        idVSItem.put(itemCode,item);
        itemCodeVSCount.put(itemCode,itemCodeVSCount.getOrDefault(itemCode,0)+1);
    }

    public void deductItem(Item item) {
    }
}
