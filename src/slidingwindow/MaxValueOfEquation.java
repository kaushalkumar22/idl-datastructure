package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 
 * Given an array points containing the coordinates of points on a 2D plane,
 * sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all
 * 1 <= i < j <= points.length. You are also given an integer k.
 * 
 * Find the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <=
 * k and 1 <= i < j <= points.length. It is guaranteed that there exists at
 * least one pair of points that satisfy the constraint |xi - xj| <= k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1 Output: 4 Explanation:
 * The first two points satisfy the condition |xi - xj| <= 1 and if we calculate
 * the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy
 * the condition and give a value of 10 + -10 + |5 - 6| = 1. No other pairs
 * satisfy the condition, so we return the max of 4 and 1.
 * 
 * Example 2:
 * 
 * Input: points = [[0,0],[3,0],[9,2]], k = 3 Output: 3 Explanation: Only the
 * first two points have an absolute difference of 3 or less in the x-values,
 * and give the value of 0 + 0 + |0 - 3| = 3.
 *
 * 
 */
public class MaxValueOfEquation {
	public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Pair<Integer, Integer>> ms = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        for (int[] point : points) {
            while (!ms.isEmpty() && point[0] - ms.peekFirst().getValue() > k) {
                ms.pollFirst();
            }
            if (!ms.isEmpty()) {
                res = Math.max(res, ms.peekFirst().getKey() + point[0] + point[1]);
            }
            while (!ms.isEmpty() && point[1] - point[0] > ms.peekLast().getKey()) {
                ms.pollLast();
            }
            ms.offerLast(new Pair<>(point[1] - point[0], point[0]));
        }
        return res;
    }
}
