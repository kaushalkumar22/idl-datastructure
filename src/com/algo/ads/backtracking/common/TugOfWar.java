package com.algo.ads.backtracking.common;

public class TugOfWar {

	static int[] a = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
	static int n = a.length;
	static int minDiff = Integer.MAX_VALUE;
	static boolean[] solution = new boolean[n];
	static boolean[] selected = new boolean[n];

	public static void main(String[] args) {
		solve(0);
		print();
	}

	// the solution is simple,

	// 1. in each iteration, either add or remove the current element from the selected array
	// 2. check if we have already selected the requried number of elements, in that case update solution
	// 3. check if have already reached the end of the array, in that case, simply return
	protected static void solve(int currentIndex) {

		// get size of selected
		int selectedSize = 0;
		for (int i = 0; i < n; i++)
			if (selected[i])
				selectedSize++;

		if (selectedSize == n / 2) {
			// check if diff < minDiff, update solution
			int diff = getDiff();
			if (diff < minDiff) {
				minDiff = diff;
				updateSolution();
			}
		}

		// check if currentIndex == n and return
		if (currentIndex >= n)
			return;

		// add curindex to selected
		selected[currentIndex] = true;
		solve(currentIndex + 1);

		// remove curindex from selected
		selected[currentIndex] = false;
		solve(currentIndex + 1);
	}

	protected static void updateSolution() {
		for (int i = 0; i < n; i++) {
			solution[i] = selected[i];
		}
	}

	protected static void print() {
		for (int i = 0; i < n; i++) {
			if (solution[i]) {
				System.out.print(a[i]);
				System.out.print(",");
			}
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			if (!solution[i]) {
				System.out.print(a[i]);
				System.out.print(",");
			}
		}
		System.out.println();
	}

	protected static int getDiff() {

		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < n; i++) {
			if (selected[i])
				leftSum += a[i];
			else
				rightSum += a[i];
		}

		return Math.abs(rightSum - leftSum);
	}
}