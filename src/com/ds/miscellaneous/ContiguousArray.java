package com.ds.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1. 
 * Example 1: Input: [0,1] Output: 2 Explanation: [0,
 * 1] is the longest contiguous subarray with equal number of 0 and 1.
 * 
 * Example 2: Input: [0,1,0] Output: 2 Explanation: [0, 1] (or [1, 0]) is a
 * longest contiguous subarray with equal number of 0 and 1.
 * 
 */
public class ContiguousArray {

	/*
	 * My idea is very similar to others, but let me try to explain it more
	 * visually. My thought was inspired by 121. Best Time to Buy and Sell Stock.
	 * 
	 * Let's have a variable count initially equals 0 and traverse through nums.
	 * Every time we meet a 0, we decrease count by 1, and increase count by 1 when
	 * we meet 1. It's pretty easy to conclude that we have a contiguous subarray
	 * with equal number of 0 and 1 when count equals 0.
	 * 
	 * What if we have a sequence [0, 0, 0, 0, 1, 1]? the maximum length is 4, the
	 * count starting from 0, will equal -1, -2, -3, -4, -3, -2, and won't go back
	 * to 0 again. But wait, the longest subarray with equal number of 0 and 1
	 * started and ended when count equals -2. We can plot the changes of count on a
	 * graph, as shown below. Point (0,0) indicates the initial value of count is 0,
	 * so we count the sequence starting from index 1. The longest subarray is from
	 * index 2 to 6.
	 * 
	 * From above illustration, we can easily understand that two points with the
	 * same y-axis value indicates the sequence between these two points has equal
	 * number of 0 and 1.
	 * 
	 * Another example, sequence [0, 0, 1, 0, 0, 0, 1, 1], as shown below,
	 * 
	 * There are 3 points have the same y-axis value -2. So subarray from index 2 to
	 * 4 has equal number of 0 and 1, and subarray from index 4 to 8 has equal
	 * number of 0 and 1. We can add them up to form the longest subarray from index
	 * 2 to 8, so the maximum length of the subarray is 8 - 2 = 6.
	 * 
	 * Yet another example, sequence [0, 1, 1, 0, 1, 1, 1, 0], as shown below. The
	 * longest subarray has the y-axis value of 0.
	 * 
	 * To find the maximum length, we need a dict to store the value of count (as
	 * the key) and its associated index (as the value). We only need to save a
	 * count value and its index at the first time, when the same count values
	 * appear again, we use the new index subtracting the old index to calculate the
	 * length of a subarray. A variable max_length is used to to keep track of the
	 * current maximum length.
	 */
	public static void main(String[] args) {
		int[] nums = {0,1,0,1};
		System.out.println(findMaxLength(nums));
	}
	public static  int findMaxLength(int[] nums) {
        int[] cnt = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(i>0) cnt[i] = cnt[i-1];
            if(nums[i]==1) cnt[i]++;
            else cnt[i]--; 
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0; 
        for(int i = 0; i<cnt.length; i++){
            if(map.containsKey(cnt[i])) max = Math.max(max, i - map.get(cnt[i]));
            if(!map.containsKey(cnt[i])) map.put(cnt[i], i);
        }
        return max; 
    }
	/*
	 * static int findMaxLength(int[] nums) { int count = 0; int max_length=0;
	 * Map<Integer,Integer> table = new HashMap<Integer,Integer>(); int index=0; for
	 * (int num : nums) { index++; if (num == 0) count -= 1; else count += 1;
	 * 
	 * if(table.containsKey(count)) max_length = Math.max(max_length,
	 * table.get(count)); else table.put(count, index); }
	 * 
	 * return max_length; }
	 */
}
