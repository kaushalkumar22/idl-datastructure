package com.ds.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a warehouse, there is a row of barcodes, where the i-th barcode is
 * barcodes[i]. Rearrange the barcodes so that no two adjacent barcodes are
 * equal. You may return any answer, and it is guaranteed an answer exists.
 * 
 * Example 1: Input: [1,1,1,2,2,2] Output: [2,1,2,1,2,1] 
 * Example 2: Input:[1,1,1,1,2,2,3,3] Output: [1,3,1,3,2,1,2,1]
 *
 * 
 */
public class DistantBarcodes {

	public static void main(String[] args) {
		//System.out.println(rearrangeBarcodes(1,1,1,1,2,2,3,3)));
	}
	 public static int[] rearrangeBarcodes(int[] barcodes) {
	        Map<Integer, Integer> cnt = new HashMap();
	        for (int i : barcodes) cnt.put(i, cnt.getOrDefault(i, 0) + 1);

	        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(cnt.entrySet());
	        Collections.sort(list, Map.Entry.<Integer, Integer>comparingByValue().reversed());
	        int l = barcodes.length, i = 0;
	        int[] res = new int[l];
	        for (Map.Entry<Integer, Integer> e : list) {
	            int time = e.getValue();
	            while (time-- > 0) {
	                res[i] = e.getKey();
	                i += 2;
	                if (i >= barcodes.length) i = 1;
	            }
	        }
	        return res;
	    }
}
