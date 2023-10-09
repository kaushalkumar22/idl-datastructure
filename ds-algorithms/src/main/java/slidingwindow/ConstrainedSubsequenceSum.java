package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an integer array nums and an integer k, return the maximum sum of a
 * non-empty subsequence of that array such that for every two consecutive
 * integers in the subsequence, nums[i] and nums[j], where i < j, the condition
 * j - i <= k is satisfied.
 * 
 * A subsequence of an array is obtained by deleting some number of elements
 * (can be zero) from the array, leaving the remaining elements in their
 * original order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [10,2,-10,5,20], k = 2 Output: 37 Explanation: The subsequence
 * is [10, 2, 5, 20].
 * 
 * Example 2:
 * 
 * Input: nums = [-1,-2,-3], k = 1 Output: -1 Explanation: The subsequence must
 * be non-empty, so we choose the largest number.
 * 
 * Example 3:
 * 
 * Input: nums = [10,-2,-10,-5,20], k = 2 Output: 23 Explanation: The
 * subsequence is [10, -2, -5, 20].
 * 
 *
 */
public class ConstrainedSubsequenceSum {

	/*
	 * We need to know the maximum in the window of size k. Use heqp will be
	 * O(NlogN) Use TreeMap will be O(NlogK) Use deque will be O(N) Done. (If not
	 * done, continue read)
	 * 
	 * Prepare
	 * 
	 * How about google "sliding window maximum", and make sure you understand 239.
	 * Sliding Window Maximum Done. (If not done, continue read)
	 * 
	 * Explanation
	 * 
	 * Update res[i], where res[i] means the maximum result you can get if the last
	 * element is A[i].
	 * 
	 * I directly modify on the input A, if you don't like it, use a copy of A
	 * 
	 * Keep a decreasing deque q, deque[0] is the maximum result in the last element
	 * of result.
	 * 
	 * If deque[0] > 0. we add it to A[i]
	 * 
	 * In the end, we return the maximum res.
	 * 
	 * Complexity
	 * 
	 * Because all element are pushed and popped at most once. Time O(N)
	 * 
	 * Because at most O(K) elements in the deque. Space O(K)
	 */
	
	public int constrainedSubsetSum(int[] A, int k) {
        int res = A[0];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < A.length; ++i) {
            A[i] += !q.isEmpty() ? q.peek() : 0;
            res = Math.max(res, A[i]);
            while (!q.isEmpty() && A[i] > q.peekLast())
                q.pollLast();
            if (A[i] > 0)
                q.offer(A[i]);
            if (i >= k && !q.isEmpty() && q.peek() == A[i - k])
                q.poll();
        }
        return res;
    }
}
