package string;

import java.util.Arrays;

/**
 * We are given two strings, A and B.
 * 
 * A shift on A consists of taking string A and moving the leftmost character to
 * the rightmost position. For example, if A = 'abcde', then it will be 'bcdea'
 * after one shift on A. Return True if and only if A can become B after some
 * number of shifts on A.
 * 
 * Example 1: Input: A = 'abcde', B = 'cdeab' Output: true
 * 
 * Example 2: Input: A = 'abcde', B = 'abced' Output: false
 * 
 * @author I339640
 *
 */
public class RotateString {

	/*We can easily see whether it is rotated if B can be found in (A + A).
	For example, with A = "abcde", B = "cdeab", we have

	�abcdeabcde� (A + A)
	  �cdeab� (B)
	 */
	public boolean rotateString(String A, String B) {
		return A.length() == B.length() && (A + A).contains(B);
	}

	// KMP (Knuth-Morris-Pratt) 
	public boolean rotateString1(String A, String B) {
		int N = A.length();
		if (N != B.length()) return false;
		if (N == 0) return true;

		//Compute shift table
		int[] shifts = new int[N+1];
		Arrays.fill(shifts, 1);
		int left = -1;
		for (int right = 0; right < N; ++right) {
			while (left >= 0 && (B.charAt(left) != B.charAt(right)))
				left -= shifts[left];
			shifts[right + 1] = right - left++;
		}

		//Find match of B in A+A
		int matchLen = 0;
		for (char c: (A+A).toCharArray()) {
			while (matchLen >= 0 && B.charAt(matchLen) != c)
				matchLen -= shifts[matchLen];
			if (++matchLen == N) return true;
		}

		return false;
	}
}

