package com.algo.array1;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * being repeated, count the frequency of all elements.
 * 
 * Input Array: {2, 3,3, 2, 5} Output: {{2,2},{3,2},{5,1}}
 * 
 * Could you do it without extra space and in O(n) runtime?
 */
public class CountFrequencies {

	public static void main(String[] args) {
		int[] input = { 2, 3, 3, 2, 5 };
		countFrequenciesOpt(input);
		countFrequencies(input);

	}

	// O(n) time and O(1) space
	public static void countFrequenciesOpt(int input[]) {

		int n = input.length;
		for (int i = 0; i < n; i++) {
			input[i]--;
		}

		for (int i = 0; i < n; i++) {
			input[input[i] % n] = input[input[i] % n] + n;
		}

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " " + input[i] / n);
			// Change the element back to original value
			input[i] = input[i] % n + 1;
		}
	}

	// O(n) time and O(n) space
	public static void countFrequencies(int[] input) {
		int n = input.length;
		int[] count = new int[n];

		for (int i = 0; i < n; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			count[input[i] - 1]++;
		}

		for (int i = 0; i < n; i++) {
			System.out.println(i + 1 + " " + count[i]);
		}
	}

}