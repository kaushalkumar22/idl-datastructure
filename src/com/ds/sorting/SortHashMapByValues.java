package com.ds.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SortHashMapByValues {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		  
		map.put("England", 3);
		map.put("USA", 1);
		map.put("China", 2);
		map.put("Russia", 4);
		map.put("India", 4);
		map.put("Nepal", 5);
		LinkedHashMap<String, Integer> sortedMap =sortHashMapByValues(map);
        System.out.println("2^^^^^^"+sortedMap);
       
	}
	public static LinkedHashMap<String, Integer> sortHashMapByValues(Map<String, Integer> map) {

		List<String> keyList = new ArrayList<String>(map.keySet());
		List<Integer> valueList = new ArrayList<Integer>(map.values());
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		Collections.sort(keyList);
		Collections.sort(valueList);
		
		for (Integer value : valueList) {
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				Integer mValue = entry.getValue();
				if(mValue.equals(value)) {
					sortedMap.put(entry.getKey(), mValue);
					map.remove(entry.getKey());
					break;
				}
			}
		}
		/*for (Integer value : valueList) {
			for (String key : keyList) {
				Integer mValue = map.get(key);
				if(mValue.equals(value)) {
					sortedMap.put(key, mValue);
					keyList.remove(key);
					break;
				}
			}
		}*/
		return sortedMap;
	}
}
