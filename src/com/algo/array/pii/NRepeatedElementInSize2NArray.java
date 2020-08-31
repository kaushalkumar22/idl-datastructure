package com.algo.array.pii;

/**
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of
 * these elements is repeated N times.
 * 
 * Return the element repeated N times.
 * 
 * 
 * Input: [1,2,3,3] Output: 3
 * 
 * Input: [2,1,2,5,3,2] Output: 2
 * 
 * Input: [5,1,5,2,5,3,5,4] Output: 5
 * 
 *
 */
public class NRepeatedElementInSize2NArray {

	 public int repeatedNTimes(int[] A) {
	        int[] count = new int[10000];
	        for (int a : A)
	            if (count[a]++ == 1)
	                return a;
	        return -1;
	    }
	 
	 public int repeatedNTimesOpt(int[] A) {
	        for (int i = 2; i < A.length; ++i)
	            if (A[i] == A[i - 1] || A[i] == A[i - 2])
	                return A[i];
	        return A[0];
	    }
}
