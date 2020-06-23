package com.algo.array;

/**
 * 
 * You may recall that an array A is a mountain array if and only if:
 * 
 * A.length >= 3 There exists some i with 0 < i < A.length - 1 such that: A[0] <
 * A[1] < ... A[i-1] < A[i] A[i] > A[i+1] > ... > A[A.length - 1] Given a
 * mountain array mountainArr, return the minimum index such that
 * mountainArr.get(index) == target. If such an index doesn't exist, return -1.
 * 
 * You can't access the mountain array directly. You may only access the array
 * using a MountainArray interface:
 * 
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array. Submissions making
 * more than 100 calls to MountainArray.get will be judged Wrong Answer. Also,
 * any solutions that attempt to circumvent the judge will result in
 * disqualification.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: array = [1,2,3,4,5,3,1], target = 3 Output: 2 Explanation: 3 exists in
 * the array, at index=2 and index=5. Return the minimum index, which is 2.
 * Example 2:
 * 
 * Input: array = [0,1,2,4,2,1], target = 3 Output: -1 Explanation: 3 does not
 * exist in the array, so we return -1.
 * 
 *
 */
public class MountainArray {

	/*
	 * Triple Binary Search, Triple Happiness.
	 * 
	 * Intuition Binary find peak in the mountain. 852. Peak Index in a Mountain
	 * Array Binary find the target in strict increasing array Binary find the
	 * target in strict decreasing array
	 * 
	 * 
	 * Personally, (just a tip) If I want find the index, I always use while
	 * (left < right) If I may return the index during the search, I'll use
	 * while (left <= right)
	 * 
	 * Complexity Time O(logN) Space O(1)
	 * 
	 * 
	 * Some Improvement Cache the result of get, in case we make the same calls.
	 * In sacrifice of O(logN) space for the benefit of less calls. Binary
	 * search of peak is unnecessary, just easy to write.
	 */

	int findInMountainArray(int target, IMountainArray A) {
		int n = A.length(), l, r, m, peak = 0;
		// find index of peak
		l  = 0;
		r = n - 1;
		while (l < r) {
			m = (l + r) / 2;
			if (A.get(m) < A.get(m + 1))
				l = peak = m + 1;
			else
				r = m;
		}
		// find target in the left of peak
		l = 0;
		r = peak;
		while (l <= r) {
			m = (l + r) / 2;
			if (A.get(m) < target)
				l = m + 1;
			else if (A.get(m) > target)
				r = m - 1;
			else
				return m;
		}
		l = peak;
		r = n - 1;
		while (l <= r) {
			m = (l + r) / 2;
			if (A.get(m) > target)
				l = m + 1;
			else if (A.get(m) < target)
				r = m - 1;
			else
				return m;
		}
		return -1;
	}
}

interface IMountainArray {
	public int get(int index);
	public int length();
}