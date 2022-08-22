package com.algo.dp.matrix;

import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 */
public class Triangle {

	public static void main(String[] args) {

		List<List<Integer>> triangle =Arrays.asList( Arrays.asList(2),
				Arrays.asList(3,4),
				Arrays.asList(6,5,7),
				Arrays.asList(4,1,8,3));

		System.out.println(minimumTotal(triangle));	
	}

	static int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] minlen =new int[n];
		for (int i = 0; i < triangle.get(n - 1).size(); i++) {
			minlen[i] = triangle.get(n - 1).get(i);
		}
		for (int layer = n-2; layer >= 0; layer--) // For each layer
		{
			for (int i = 0; i <= layer; i++) // Check its every 'node'
			{
				// Find the lesser of its two children, and sum the current value in the triangle with it.
				minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(layer).get(i); 
			}
		}
		return minlen[0];
	}
}
