package com.algo.lds.slidingwindow;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * 
 * Examples: [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position. Your
 * job is to output the median array for each window in the original array.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6 
 * 
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * 
 * Note: You may assume k is always valid, ie: k is always smaller than input
 * array's size for non-empty array. Answers within 10^-5 of the actual value
 * will be accepted as correct.
 * 
 *
 */
public class SlidingWindowMedian {

	 public double[] medianSlidingWindow(int[] nums, int k) {
	       double[] result = new double[nums.length - k + 1];
	       int j=0;
	       PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
	       PriorityQueue<Integer> hi = new PriorityQueue<>();
	       for (int i = 0; i < nums.length; i++) {
	            lo.add(nums[i]);
	            hi.add(lo.poll());
	            if(hi.size()>lo.size()) lo.add(hi.poll());
	            if (lo.size() + hi.size() == k) {
	                result[j]=lo.size()==hi.size()?(double)((long) lo.peek()+(long)hi.peek())/2:(double) lo.peek();
	                if (!lo.remove(nums[j])) hi.remove(nums[j]);
	                j++;
	            }
	        }
	        return result;
	    }
	 /*public double[] medianSlidingWindow(int[] nums, int k) {
	    multiset<int> window(nums.begin(), nums.begin() + k);
	    auto mid = next(window.begin(), k / 2);
	    vector<double> medians;
	    for (int i=k; ; i++) {

	        // Push the current median.
	        medians.push_back((double(*mid) + *prev(mid, 1 - k%2)) / 2);

	        // If all done, return.
	        if (i == nums.size())
	            return medians;
	            
	        // Insert nums[i].
	        window.insert(nums[i]);
	        if (nums[i] < *mid)
	            mid--;

	        // Erase nums[i-k].
	        if (nums[i-k] <= *mid)
	            mid++;
	        window.erase(window.lower_bound(nums[i-k]));
	    }
	}*/
}
