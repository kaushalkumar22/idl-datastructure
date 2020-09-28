package com.algo.greedy;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into sets of k consecutive numbers Return True
 * if its possible otherwise return False.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4 Output: true Explanation: Array can be
 * divided into [1,2,3,4] and [3,4,5,6].
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3 Output: true Explanation:
 * Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
 * 
 * Example 3:
 * 
 * Input: nums = [3,3,2,2,1,1], k = 3 Output: true
 * 
 * Example 4:
 * 
 * Input: nums = [1,2,3,4], k = 3 Output: false Explanation: Each array should
 * be divided in subarrays of size 3.
 * 
 * @author IBM
 *
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {
	public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int n : nums)
            m.put(n, 1 + m.getOrDefault(n, 0));
        while (!m.isEmpty()) {
            Map.Entry<Integer, Integer> e = m.pollFirstEntry();
            int key = e.getKey(), val = e.getValue();
            for (int key1 = key + 1; key1 < key + k; ++key1) {
                Integer oldVal = m.put(key1, m.getOrDefault(key1, 0) - val);
                if (oldVal == null || oldVal < val)
                    return false;
                m.remove(key1, 0);
            }
        }
        return true;
    }
}
