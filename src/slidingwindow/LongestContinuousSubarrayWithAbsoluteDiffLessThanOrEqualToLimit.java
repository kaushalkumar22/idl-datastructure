package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * Given an array of integers nums and an integer limit, return the size of the
 * longest non-empty subarray such that the absolute difference between any two
 * elements of this subarray is less than or equal to limit.
 * 
 * Input: nums = [8,2,4,7], limit = 4 Output: 2 Explanation: All subarrays are:
 * 
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * 
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * 
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * 
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * 
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * 
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * 
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * 
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * 
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * 
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * 
 * Therefore, the size of the longest subarray is 2.
 * 
 * Input: nums = [10,1,2,4,7,2], limit = 5 Output: 4 Explanation: The subarray
 * [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * 
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0 Output: 3
 *
 * 
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("hi");
	}
	/*
	 * Intuition
	 * 
	 * Constrained Subsequence Sum how to get minimum in a subarray when sliding.
	 * 
	 * This week, we need to get both the maximum and the minimum, at the same time.
	 * 
	 * So I opened my post last week, and copy some my own codes.
	 * 
	 * Solution 0: Binary insert and remove
	 * 
	 * Keep an increasing list L. Binary insert the current element. If the
	 * L[L.size() - 1] - L[0] > limit, binary search the position of A[i] and remove
	 * it from the list.
	 * 
	 * Time O(N^2) Space O(N)
	 


	
	Solution 2: Use TreeMap

	Use one tree map can easily get the maximum and the minimum at the same time.
	In java, we can use TreeMap to count elements.
	In cpp, it suports multi treeset, that's even better.

	Time O(NogN)
	Space O(N)

	
*/
	public int longestSubarray1(int[] A, int limit) {
	    int i = 0, j;
	    TreeMap<Integer, Integer> m = new TreeMap<>();
	    for (j = 0; j < A.length; j++) {
	        m.put(A[j], 1 + m.getOrDefault(A[j], 0));
	        if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
	            m.put(A[i], m.get(A[i]) - 1);
	            if (m.get(A[i]) == 0)
	                m.remove(A[i]);
	            i++;
	        }
	    }
	    return j - i;
	}


	/*
	 * Solution 3: Use two deques
	 * 
	 * Time O(N) Space O(N)
	 * 
	 */
	    public int longestSubarray(int[] A, int limit) {
	        Deque<Integer> maxd = new ArrayDeque<>();
	        Deque<Integer> mind = new ArrayDeque<>();
	        int i = 0, j;
	        for (j = 0; j < A.length; ++j) {
	            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
	            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
	            maxd.add(A[j]);
	            mind.add(A[j]);
	            if (maxd.peek() - mind.peek() > limit) {
	                if (maxd.peek() == A[i]) maxd.poll();
	                if (mind.peek() == A[i]) mind.poll();
	                ++i;
	            }
	        }
	        return j - i;
	    }


}
