package com.algo.array;

import java.util.Arrays;

/**
 * Given an array A of integers, return true if and only if we can partition the
 * array into three non-empty parts with equal sums.
 * 
 * Formally, we can partition the array if we can find indexes i+1 < j with
 * (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1]
 * + ... + A[A.length - 1])
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [0,2,1,-6,6,-7,9,1,2,0,1] Output: true Explanation: 0 + 2 + 1 = -6
 * + 6 - 7 + 9 + 1 = 2 + 0 + 1 Example 2:
 * 
 * Input: A = [0,2,1,-6,6,7,9,-1,2,0,1] Output: false Example 3:
 * 
 * Input: A = [3,3,6,5,-2,2,5,1,-9,4] Output: true Explanation: 3 + 3 = 6 = 5 -
 * 2 + 2 + 5 + 1 - 9 + 4
 * 
 * @author I339640
 *
 */
public class PartitionArrayIntoThreePartsWithEqualSum {

	/*
	 * Method 1: Count valid parts
	 * 
	 * Loop through the array A, and compute part of sum; if the average value
	 * is found, reset the part to 0, and increase the counter; By the end if
	 * the average can be seen for at least 3 times and if the total sum is
	 * divisible by 3;, return true; otherwise return false. note: if the
	 * average (sum / 3) found 2 times before the end of the array, then the
	 * remaining part is also equals to the average. Therefore, no need to
	 * continue after the counter reaches 3.
	 */
	public boolean canThreePartsEqualSum(int[] A) {
		int sum = Arrays.stream(A).sum(), part = 0, average = sum / 3, cnt = 0;
		for (int a : A) {
			part += a;
			if (part == average) { // find the average: sum / 3
				++cnt; // find an average, increase the counter.
				part = 0; // reset part.
			}
		}
		return cnt >= 3 && sum % 3 == 0;
	}

	/*
	 * Method 2: 2 pointers greedy, credit to @D9night
	 * 
	 * Staring from the two ends of the input array, accumulate left and right
	 * parts till getting the average values; If having found average values on
	 * both parts before the two pointers meet, return true; otherwise, return
	 * false.
	 * 
	 * Time: O(n), space: O(1), where n = A.length.
	 * 
	 * 
	 */
	public boolean canThreePartsEqualSum1(int[] A) {
		int sum = Arrays.stream(A).sum(), average = sum / 3;
		int l = 0, r = A.length - 1;
		int leftSum = A[l++], rightSum = A[r--];
		do {
			if (leftSum != average)
				leftSum += A[l++];
			if (l < r && rightSum != average)
				rightSum += A[r--];
			if (l <= r && sum % 3 == 0 && leftSum == average && rightSum == average)
				return true;
		} while (l < r);
		return false;
	}
}
