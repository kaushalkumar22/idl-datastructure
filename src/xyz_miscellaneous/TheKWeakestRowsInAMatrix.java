package xyz_miscellaneous;

import java.util.PriorityQueue;

/**
 * Given a m * n matrix mat of ones (representing soldiers) and zeros
 * (representing civilians), return the indexes of the k weakest rows in the
 * matrix ordered from the weakest to the strongest.
 * 
 * A row i is weaker than row j, if the number of soldiers in row i is less than
 * the number of soldiers in row j, or they have the same number of soldiers but
 * i is less than j. Soldiers are always stand in the frontier of a row, that
 * is, always ones may appear first and then zeros.
 * 
Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 2 
row 1 -> 4 
row 2 -> 1 
row 3 -> 2 
row 4 -> 5 
Rows ordered from the weakest to the strongest are [2,0,3,1,4]

Example 2:

Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 1 
row 1 -> 4 
row 2 -> 1 
row 3 -> 1 
Rows ordered from the weakest to the strongest are [0,2,3,1] 
 */
public class TheKWeakestRowsInAMatrix {
	public static void main(String[] args) {
	}

	public int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
		int[] ans = new int[k];

		for (int i = 0; i < mat.length; i++) {
			pq.offer(new int[] { numOnes(mat[i]), i });
			if (pq.size() > k)
				pq.poll();
		}

		while (k > 0)
			ans[--k] = pq.poll()[1];

		return ans;
	}

	private int numOnes(int[] row) {
		int lo = 0;
		int hi = row.length;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (row[mid] == 1)
				lo = mid + 1;
			else
				hi = mid;
		}

		return lo;
	}
}
