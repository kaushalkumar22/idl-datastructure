package com.algo.array;

/**
 * Given an integer array nums, return the number of range sums that lie in
 * [lower, upper] inclusive. Range sum S(i, j) is defined as the sum of the
 * elements in nums between indices i and j (i <= j), inclusive. Note: A naive
 * algorithm of O(n2) is trivial. You MUST do better than that. 
 * Example: 
 * Input:nums = [-2,5,-1], lower = -2, upper = 2, Output: 3 Explanation: The three
 * ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
public class CountRangeSum {

	/*
	 * Recall count smaller number after self where we encountered the problem
	 * 
	 * count[i] = count of nums[j] - nums[i] < 0 with j > i
	 * 
	 * Here, after we did the preprocess, we need to solve the problem
	 * 
	 * count[i] = count of a <= S[j] - S[i] <= b with j > i ans = sum(count[:])
	 * 
	 * Therefore the two problems are almost the same. We can use the same technique
	 * used in that problem to solve this problem. One solution is merge sort based;
	 * another one is Balanced BST based. The time complexity are both O(n log n).
	 * 
	 * The merge sort based solution counts the answer while doing the merge. During
	 * the merge stage, we have already sorted the left half [start, mid) and right
	 * half [mid, end). We then iterate through the left half with index i. For each
	 * i, we need to find two indices k and j in the right half where
	 * 
	 * j is the first index satisfy sums[j] - sums[i] > upper and k is the first
	 * index satisfy sums[k] - sums[i] >= lower.
	 * 
	 * Then the number of sums in [lower, upper] is j-k. We also use another index t
	 * to copy the elements satisfy sums[t] < sums[i] to a cache in order to
	 * complete the merge sort.
	 * 
	 * Despite the nested loops, the time complexity of the "merge & count" stage is
	 * still linear. Because the indices k, j, t will only increase but not
	 * decrease, each of them will only traversal the right half once at most. The
	 * total time complexity of this divide and conquer solution is then O(n log n).
	 * 
	 * One other concern is that the sums may overflow integer. So we use long
	 * instead.
     */

	 int count = 0;
	    int lower;
	    int upper;
	    public int countRangeSum(int[] nums, int lower, int upper) {
	        long[] sum = new long[nums.length + 1];
	        long[] temp = new long[nums.length + 1];
	        sum[0] = 0;
	        this.lower = lower;
	        this.upper = upper;
	        for (int i = 1; i <= nums.length; i++) {
	            sum[i] = sum[i - 1] + (long) nums[i - 1];
	        }
	        
	        mergesort(sum, 0, sum.length - 1, temp);
	        return count;
	    }
	    
	    private void mergesort(long[] sum, int start, int end, long[] temp) {
	        if (start >= end) {
	            return;
	        }
	        int mid = start + (end - start) / 2;
	        mergesort(sum, start, mid, temp);
	        mergesort(sum, mid + 1, end, temp);
	        merge(sum, start, mid, end, temp);
	    }
	    
	    private void merge(long[] sum, int start, int mid, int end, long[] temp) {
	        int right = mid + 1;
	        int index = start;
	        int low = mid + 1, high = mid + 1;
	        for (int left = start; left <= mid; left++) {
	            while (low <= end && sum[low] - sum[left] < lower) {
	                low++;
	            }
	            while (high <= end && sum[high] - sum[left] <= upper) {
	                high++;
	            }
	            while (right <= end && sum[right] < sum[left]) {
	                temp[index++] = sum[right++];
	            }
	            temp[index++] = sum[left];
	            count += high - low;
	        }
	        while (right <= end) {
	            temp[index++] = sum[right++];
	        }
	        
	        for (int i = start; i <= end; i++) {
	            sum[i] = temp[i];
	        }
	    }
	
}
