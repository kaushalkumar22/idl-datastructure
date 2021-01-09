package com.algo.ads.dp.minmaxcosttoreachtarget;

import java.util.Arrays;

/**
 * 
 * Given a square array of integers A, we want the minimum sum of a falling path
 * through A.
 * 
 * A falling path starts at any element in the first row, and chooses one
 * element from each row. The next row's choice must be in a column that is
 * different from the previous row's column by at most one.
 * 
 * Input: 
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ] Output: 12 Explanation: The possible falling
 * paths are:
 * 
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9] 
 * 
 * [2,4,7], [2,4,8], [2,5,7],[2,5,8], [2,5,9], [2,6,8], [2,6,9] 
 * 
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8],[3,6,9]
 * 
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 */
public class MinimumFallingPathSum {
	public static void main(String[] args) {
		int[][] A= {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(minFallingPathSum(A));

	}
	public static int minFallingPathSum(int[][] A) {
		  for (int i = 1; i < A.length; ++i)
		    for (int j = 0; j < A.length; ++j)
		      A[i][j] += Math.min(A[i - 1][j],
		    		  Math.min(A[i - 1][Math.max(0, j - 1)], 
		    				  A[i - 1][Math.min(A.length - 1, j + 1)]));
		  return Arrays.stream(A[A.length - 1]).min().getAsInt();
		}        
}
