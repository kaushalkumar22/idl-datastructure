package com.algo.twopointers;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order.
 * 
 * Return the intersection of these two interval lists.
 * 
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 * numbers x with a <= x <= b. The intersection of two closed intervals is a set
 * of real numbers that is either empty, or can be represented as a closed
 * interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 * 
 * 
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 * 
 */
public class IntervalListIntersections {
	public static void main(String[] args) {

	}
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		int m = A.length;
		int n = B.length;
		int t = Math.max(m, n)+1;
		int[][] res = new int[m+n][2];
		    for (int i = 0, j = 0; i < A.size() && j < B.size();i++,j++) {
		    	if (A[i][1] < B[j][1]) {
		    		++i;
		    	}else if(A[i][1] > B[j][1]) {
		    		++j;
		    	}else {
		    		 int start = Math.max(A[i][0], B[j][0]);
				     int end = Math.min(A[i][1], B[j][1]);
		    	}
		       		        if (start <= end) 
		            res.push_back({start, end});
		    }
		    return res;   
		return res;
	}
}
