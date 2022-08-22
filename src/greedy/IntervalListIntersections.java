package greedy;

import java.util.ArrayList;
import java.util.List;

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
		int[][] A = {{0,2},{5,10},{13,23},{24,25}}, B = {{1,5},{8,12},{15,24},{25,26}};
		int[][] res = intervalIntersection(A, B);
		for (int[] is : res) {
			System.out.print("["+is[0]+","+is[1]+"]");
		}
	}
	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> ans = new ArrayList<int[]>();
		int i = 0, j = 0;

		while (i < A.length && j < B.length) {
			// Let's check if A[i] intersects B[j].
			// the startpoint of the intersection
			// the endpoint of the intersection
			int startPoint  = Math.max(A[i][0], B[j][0]);
			int endPoint = Math.min(A[i][1], B[j][1]);
			if (startPoint  <= endPoint)
				ans.add(new int[]{startPoint , endPoint});

			// Remove the interval with the smallest endpoint
			if (A[i][1] < B[j][1])
				i++;
			else
				j++;
		}

		return ans.toArray(new int[ans.size()][]);
	}
}

