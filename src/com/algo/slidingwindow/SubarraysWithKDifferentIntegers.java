package com.algo.slidingwindow;

/**
 * Given an array A of positive integers, call a (contiguous, not necessarily
 * distinct) subarray of A good if the number of different integers in that
 * subarray is exactly K.
 * 
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * 
 * Return the number of good subarrays of A.
 * 
 * Input: A = [1,2,1,2,3], K = 2 Output: 7 Explanation: Subarrays formed with
 * exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2],
 * [1,2,1,2].
 * 
 * 
 * Input: A = [1,2,1,3,4], K = 3 Output: 3 Explanation: Subarrays formed with
 * exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 *
 */
public class SubarraysWithKDifferentIntegers {

	public static void main(String[] args) {
		int[] A = { 1, 2, 1, 2, 3 };
		int K = 2;
		System.out.println(subarraysWithKDistinct(A, K));
	}

	/*
	 * Intuition
	 * 
	 * If the subarray [left, right] contains K unique numbers, and first prefix numbers
	 * also appear in [left + prefix, right] subarray, we have total 1 + prefix good
	 * subarrays. For example, there are 3 unique numers in [1, 2, 1, 2, 3]. First
	 * two numbers also appear in the remaining subarray [1, 2, 3], so we have 1 + 2
	 * good subarrays: [1, 2, 1, 2, 3], [2, 1, 2, 3] and [1, 2, 3].
	 * 
	 * left: left boundary of window
	 * right: right boundary of window
	 * count: 'count' to track subarray has how many unique ints
	 * prefix: to track the prefix
	 * intsCount[]: to keep track how many times each ints appears in our window
	 * 
	 * 1. first move the right until 'count>=k' and increment the count if new char,
	 *    and also increment the respective char count in 'intsCount'.
	 * 
	 * 2.if 'count>k', then decrement the 'count' and '--intsCount[c]' and reset the
	 *   prefix as zero because its a new window.we are trying to shrink our sliding
	 *   window while maintaining the same number of unique elements.
	 * 
	 * 3. if intsCount[left]= 1 then decrement the 'count' and 'intsCount[left]--', and
	 *    increment the 'left++'(we try to remove as many as possible numbers from the
	 *    front, until the number in the front appears only once. While removing
	 *    numbers, we are increasing prefix.)
	 * 
	 * 4. if 'count=k' update the maxlen.
	 * 
	 * 5. Repeat the step 1,2,3
	 * 
	 * Complexity Analysis
	 * 
	 * 
	 * Time Complexity: O(n), where n is the length of A. Space Complexity: O(n).
	 * 
	 */
	public static int subarraysWithKDistinct(int[] A, int K) {

		int[] intsCount = new int[A.length + 1];
		int left = 0;
		int right = 0;
		int count = 0;
		int subarraysCount = 0;
		int prefix = 0;

		for (right = 0; right < A.length; right++) {

			// increment the count if new char, and also increment the respective char count in 'cCount
			if (intsCount[A[right]]++ == 0) {
				count++;
			}

			if (count > K) {// it will reset the new window for new integers
				--intsCount[A[left++]];
				--count;
				prefix = 0;
			}

			while (intsCount[A[left]] > 1) {// window
				prefix++;
				--intsCount[A[left++]];
			}

			if (count == K) {
				subarraysCount += prefix + 1;
			}
		}
		return subarraysCount;
	}
}
