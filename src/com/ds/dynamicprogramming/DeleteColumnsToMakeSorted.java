package com.ds.dynamicprogramming;

import java.util.Arrays;

public class DeleteColumnsToMakeSorted {
	/**
We are given an array A of N lowercase letter strings, all of the same length.
Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef","vyz"].
Suppose we chose a set of deletion indices D such that after deletions, the final array has its elements in lexicographic order (A[0] <= A[1] <= A[2] ... <= A[A.length - 1]).
Return the minimum possible value of D.length.


Example 1:
Input: ["ca","bb","ac"]
Output: 1
Explanation: 
After deleting the first column, A = ["a", "b", "c"].

 Intuition

Solve it with a greed algorithme.

Initial N empty string.
For each column,
add the character to each row,
and check if all rows are still sorted.

If not, we have to delete this column.
Explanation
Initial a boolean array sorted,
sorted[i] = true if and only if A[i] < A[i + 1],
that is to say A[i] and A[i + 1] are sorted.

For each col, we check all unsorted rows.
If A[i][j] > A[i + 1][j], we need to deleted this col, res++.

Otherwise, we can keep this col, and update all sorted rows.

	 * @param A
	 * @return
	 */
	public int minDeletionSizeII(String[] A) {
		int res = 0, n = A.length, m = A[0].length(), i, j;
		boolean[] sorted = new boolean[n - 1];
		for (j = 0; j < m; ++j) {
			for (i = 0; i < n - 1; ++i) {
				if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
					res++;
					break;
				}
			}
			if (i < n - 1) continue;
			for (i = 0; i < n - 1; ++i)
				if (A[i].charAt(j) < A[i + 1].charAt(j))
					sorted[i] = true;
		}
		return res;
	}
	/**
 We are given an array A of N lowercase letter strings, all of the same length.
Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
For example, if we have an array A = ["babca","bbazb"] and deletion indices {0, 1, 4}, then the final array after deletions is ["bc","az"].
Suppose we chose a set of deletion indices D such that after deletions, the final array has every element (row) in lexicographic order.
For clarity, A[0] is in lexicographic order (ie. A[0][0] <= A[0][1] <= ... <= A[0][A[0].length - 1]), A[1] is in lexicographic order (ie. A[1][0] <= A[1][1] <= ... <= A[1][A[1].length - 1]), and so on.
Return the minimum possible value of D.length.

Example 1:
Input: ["babca","bbazb"]
Output: 3
Explanation: After deleting columns 0, 1, and 4, the final array is A = ["bc", "az"].
Both these rows are individually in lexicographic order (ie. A[0][0] <= A[0][1] and A[1][0] <= A[1][1]).

Intuition

Take n cols as n elements, so we have an array of n elements.
=> The final array has every row in lexicographic order.
=> The elements in final state is in increasing order.
=> The final elements is a sub sequence of initial array.
=> Transform the problem to find the maximum increasing sub sequence.

Explanation

Now let's talking about how to find maximum increasing subsequence.
Here we apply a O(N^2) dp solution.

dp[i] means the longest subsequence ends with i-th element.
For all j < i, if A[][j] < A[][i], then dp[j] = max(dp[j], dp[i] + 1)


Time Complexity:

O(N^2) to find increasing subsequence
O(M) for comparing elements.
So Overall O(MN^2) time.
Space O(N) for dp.
	 * @param A
	 * @return
	 */
	public int minDeletionSizeIII(String[] A) {
		int m = A.length, n = A[0].length(), res = n - 1, k;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int j = 0; j < n; ++j) {
			for (int i = 0; i < j; ++i) {
				for (k = 0; k < m; ++k) {
					if (A[k].charAt(i) > A[k].charAt(j)) break;
				}
				if (k == m && dp[i] + 1 > dp[j])
					dp[j] = dp[i] + 1;
			}
			res = Math.min(res, n - dp[j]);
		}
		return res;
	}
}
