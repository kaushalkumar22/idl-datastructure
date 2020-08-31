package com.algo.slidingwindow;

/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * 
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 * 
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2 Output: 6 
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1. The longest
 * subarray is underlined.
 *
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int[] A = {1,1,1,0,0,0,1,1,1,1,0};
		int K = 2;
		System.out.println(longestOnes(A,K));
		System.out.println(longestOnes1(A,K));

	}
	/*
	 * Intuition
	 * 
	 * Translation: Find the longest subarray with at most K zeros.
	 * 
	 * Explanation
	 * 
	 * For each A[j], try to find the longest subarray. If A[i] ~ A[j] has zeros <=
	 * K, we continue to increment j. If A[i] ~ A[j] has zeros > K, we increment i
	 * (as well as j).
	 */

	public static int longestOnes(int[] A, int K) {
		int i = 0, j = 0;
		for (i = 0; i < A.length; ++i) {
			K -= 1 - A[i];
			if (K < 0) K += 1 - A[j++];
		}
		return i - j;
	}
	// Longest Repeating Character Replacement
	public static int longestOnes1(int[] A, int K) {
		int zeroCount=0,start=0,res=0;
		for(int end=0;end<A.length;end++){
			if(A[end] == 0) zeroCount++;
			while(zeroCount > K){
				if(A[start] == 0) zeroCount--;
				start++;
			}
			res=Math.max(res,end-start+1);
		}
		return res;
	}
}
