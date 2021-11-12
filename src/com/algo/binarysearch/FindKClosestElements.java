package com.algo.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array. The result should also be sorted in ascending order. If there
 * is a tie, the smaller elements are always preferred.
 * 
 * Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4] Input:[1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * 
 *
 */
public class FindKClosestElements {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println("Output: " + findClosestElements(nums, 4, 1));
	}
	/*
	 * The array is sorted.If we want find the one number closest to x, we don't
	 * have to check one by one.it's straightforward to use binary research.
	 * 
	 * Explanation: Assume we are taking A[i] ~ A[i + k]. 
	 * We can binary research i We compare the distance between x - A[mid] and A[mid + k] - x
	 * 
	 * Assume A[mid] ~ A[mid + k] is sliding window
	 * 
	 * case 1: x - A[mid] < A[mid + k] - x, need to move window go left
	 * -------x----A[mid]-----------------A[mid + k]----------
	 * 
	 * case 2: x - A[mid] < A[mid + k] - x, need to move window go left again
	 * -------A[mid]----x-----------------A[mid + k]----------
	 * 
	 * case 3: x - A[mid] > A[mid + k] - x, need to move window go right
	 * -------A[mid]------------------x---A[mid + k]----------
	 * 
	 * case 4: x - A[mid] > A[mid + k] - x, need to move window go right
	 * -------A[mid]---------------------A[mid + k]----x------
	 * 
	 *  If x - A[mid] > A[mid+ k] - x, it means A[mid + 1] ~ A[mid + k] is better 
	 *  than A[mid] ~ A[mid + k - 1], and we have mid smaller than the right i.
	 *   So assign left = mid + 1.
	 * 
	 * Note: SHOULD NOT compare the absolute value of abs(x - A[mid]) and abs(A[mid
	 * + k] - x). It fails at cases like A = [1,1,2,2,2,2,2,3,3], x = 3, k = 3
	 * 
	 * Time Complexity: O(log(N - K)) to binary research and find reseult O(K) to
	 * create the returned list.
	 */

	public static List<Integer> findClosestElements(int[] A, int k, int x) {
		int left = 0, right = A.length - k;
		while (left < right) {
			int mid = (left + right) / 2;
			if (x - A[mid] > A[mid + k] - x)
				left = mid + 1;
			else
				right = mid;
		}
		return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
	}

}
