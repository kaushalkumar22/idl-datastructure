package dynamicprogramming_miscellaneous;

/**
 * 
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example:
 * 
 * Input: n = 10 Output: 12 Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the
 * sequence of the first 10 ugly numbers. *
 */
public class UglyNumberII {

	public static void main(String[] args) {

	}

	public int nthUglyNumber(int n) {
		if (n <= 0)
			return 0; // get rid of corner cases
		if (n == 1)
			return 1; // base case
		int t2 = 0, t3 = 0, t5 = 0; // pointers for 2, 3, 5
		int[] k = new int[n];
		k[0] = 1;
		for (int i = 1; i < n; i++) {
			k[i] = Math.min(k[t2] * 2, Math.min(k[t3] * 3, k[t5] * 5));
			if (k[i] == k[t2] * 2)
				t2++;
			if (k[i] == k[t3] * 3)
				t3++;
			if (k[i] == k[t5] * 5)
				t5++;
		}
		return k[n - 1];
	}
}
