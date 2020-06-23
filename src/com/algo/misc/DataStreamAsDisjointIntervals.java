package com.algo.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ...,
 * summarize the numbers seen so far as a list of disjoint intervals. For
 * example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ...,
 * then the summary will be: 
 * [1, 1] 
 * [1, 1], [3, 3] 
 * [1, 1], [3, 3], [7, 7] 
 * [1,3],  [7, 7] 
 * [1, 3], [6, 7]
 * 
 * Follow up: What if there are lots of merges and the number of disjoint
 * intervals are small compared to the data stream's size?
 * 
 *
 */
public class DataStreamAsDisjointIntervals {

	public static void main(String[] args) {
		DataStreamAsDisjointIntervals asDisjointIntervals = new DataStreamAsDisjointIntervals();
		asDisjointIntervals.addNum(4);
	}
	/*
	 * Use TreeMap to easily find the lower and higher keys, the key is the start of
	 * the interval. Merge the lower and higher intervals when necessary. The time
	 * complexity for adding is O(logN) since lowerKey(), higherKey(), put() and
	 * remove() are all O(logN). It would be O(N) if you use an ArrayList and remove
	 * an interval from it.
	 */
	    TreeMap<Integer, int[]> map =new TreeMap<>();

	    public void addNum(int val) {
	        if(map.containsKey(val)) return;
	        Integer lowerKey = map.lowerKey(val);
	        Integer higherKey = map.higherKey(val);
	        if(lowerKey != null && higherKey !=null && val == map.get(lowerKey)[1]+1 
	           && val == map.get(higherKey)[0] -1 ){
	            map.get(lowerKey)[1] = map.get(higherKey)[1];
	            map.remove(higherKey);
	        } else if (lowerKey != null && val <= map.get(lowerKey)[1] +1 ){
	            map.get(lowerKey)[1] = Math.max(val,map.get(lowerKey)[1]);
	        } else if (higherKey != null && val == map.get(higherKey)[0] -1 ){
	            map.put(val,new int[]{val,map.get(higherKey)[1]});
	            map.remove(higherKey);
	        } else {             
	            map.put(val,new int[]{val,val});
	        }  
	    }
	    
	    public int[][] getIntervals() {
	    	
	        int[][] res = new int[map.size()][2];
	        int i = 0;
	        for(int[] a:map.values()){
	            res[i++] = a;
	        }
	        return res;
	    }
}
