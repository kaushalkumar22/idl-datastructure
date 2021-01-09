package com.algo.lds.nicetodo.binarysearch;

/**
 * 
 * Given an array A of 0s and 1s, divide the array into 3 non-empty parts such
 * that all of these parts represent the same binary value. If it is possible,
 * return any [i, j] with i+1 < j, such that: 
 * A[0], A[1], ..., A[i] is the first
 * part; A[i+1], A[i+2], ..., A[j-1] is the second part, 
 * and A[j], A[j+1], ...,A[A.length - 1] is the third part. 
 * 
 * All three parts have equal binary value.
 * If it is not possible, return [-1, -1]. Note that the entire part is used
 * when considering what binary value it represents. 
 * For example, [1,1,0]
 * represents 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1]
 * and [1,1] represent the same value.
 * 
 * Example 1: Input: [1,0,1,0,1] Output: [0,3] 
 * Example 2: Input: [1,1,0,1,1] Output: [-1,-1] *
 */
public class ThreeEqualParts {
	/*
	 * count how many ones (if num%3!=0 return [-1,-1]) search from right side to
	 * left, until we found num/3 1s. This index is not final answer, but it defines
	 * patten of 1s from feft, ignore leading 0s, and then match the pattern found
	 * in step 2, to get the first EndIndex do another matching to found second
	 * EndIndex
	 */
	 public int[] threeEqualParts(int[] A) {
		    int numOne = 0;
		    for (int i: A) if (i == 1) numOne++;

		    int[] res = {-1, -1};
		    if (numOne == 0) return new int[]{0,2}; // special case
		    if (numOne % 3 != 0) return res;

		    int thirdPartStartingIndex = 0;
		    int count = 0;
		    for (int i = A.length - 1; i >= 0; --i){
		        if (A[i] == 1){
		            if (++count == numOne / 3){
		                thirdPartStartingIndex = i;
		                break;
		            }
		        }
		    }

		    int firstPartEndIndex = findNextEndIndexAndCompare(A, 0, thirdPartStartingIndex);
		    if (firstPartEndIndex < 0) return res;

		    int secondPartEndIndex = findNextEndIndexAndCompare(A, firstPartEndIndex + 1, thirdPartStartingIndex);
		    if (secondPartEndIndex < 0) return res;

		    return new int[]{firstPartEndIndex, secondPartEndIndex+1};
		}


		/** the implementation idea is similar to find last k node in a list
		 *  in the sense that pacer is a pacer
		 *  when the pacer reaches the end, the end for the current part has been anchored
		 *  Note: we also do the comparing for the two parts of interest
		 *
		 * @param A
		 * @param start
		 * @param pacer
		 * @return
		 */
		private int findNextEndIndexAndCompare(int[] A, int start, int pacer){
		    while (A[start] == 0) start++;
		    while (pacer < A.length){
		        if (A[start] != A[pacer]) return -1;
		        start++;
		        pacer++;
		    }
		    return start - 1;
		}
}
