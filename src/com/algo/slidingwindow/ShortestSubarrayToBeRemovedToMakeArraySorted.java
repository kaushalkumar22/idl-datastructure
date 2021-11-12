package com.algo.slidingwindow;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
	public static void main(String[] args) {
	}
	int findLengthOfShortestSubarray(int[] A) {
		int N = A.length, ans = N - 1, i;
		for (i = 1; i < N; ++i) {
			if (A[i] >= A[i - 1]) continue;
			int j = N - 1;
			while (j > i && A[j] >= A[i - 1] && (j == N - 1 || A[j] <= A[j + 1])) --j;
			ans = Math.min(ans, j - i + 1);
			break;
		}
		if (i == N) return 0;
		for (i = N - 2; i >= 0; --i) {
			if (A[i] <= A[i + 1]) continue;
			int j = 0;
			while (j < i && A[j] <= A[i + 1] && (j == 0 || A[j] >= A[j - 1])) ++j;
			ans = Math.min(ans, i - j + 1);
			break;
		}
		return ans;
	}
}

