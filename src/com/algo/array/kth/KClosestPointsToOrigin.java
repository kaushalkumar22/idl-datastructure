package com.algo.array.kth;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane. Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * 
 * 
 * Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]] 
 * 
 * Explanation: 
 * The distance between (1, 3) and the origin is sqrt(10). The distance between (-2,2) 
 * and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin. 
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2 Output: [[3,3],[-2,4]] (The
 * answer [[-2,4],[3,3]] would also be accepted.)
 * 
 *
 */
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] points ={{3,3},{5,-1},{-2,4}};
		System.out.println(Arrays.toString(kClosest(points,2)[0]));
		System.out.println(Arrays.toString(kClosest1(points,2)[1]));
		System.out.println(Arrays.toString(kClosest2(points,2)[1]));

	}
	/*
	 * I. The very naive and simple solution is sorting the all points by their
	 * distance to the origin point directly, then get the top k closest points.
	 * We can use the sort function and the code is very short.
	 * 
	 * Theoretically, the time complexity is O(NlogN), pratically, the real time
	 * it takes on leetcode is 104ms.
	 * 
	 * The advantages of this solution are short, intuitive and easy to
	 * implement. The disadvatages of this solution are not very efficient and
	 * have to know all of the points previously, and it is unable to deal with
	 * real-time(online) case, it is an off-line solution.
	 * 
	 * The short code shows as follows:
	 */
	public static int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
		return Arrays.copyOfRange(points, 0, K);
	}

	/*
	 * II. The second solution is based on the first one. We don't have to sort
	 * all points. Instead, we can maintain a max-heap with size K. Then for
	 * each point, we add it to the heap. Once the size of the heap is greater
	 * than K, we are supposed to extract one from the max heap to ensure the
	 * size of the heap is always K. Thus, the max heap is always maintain top K
	 * smallest elements from the first one to crruent one. Once the size of the
	 * heap is over its maximum capacity, it will exclude the maximum element in
	 * it, since it can not be the proper candidate anymore.
	 * 
	 * Theoretically, the time complexity is O(NlogK), but pratically, the real
	 * time it takes on leetcode is 134ms.
	 * 
	 * The advantage of this solution is it can deal with real-time(online)
	 * stream data. It does not have to know the size of the data previously.
	 * The disadvatage of this solution is it is not the most efficient
	 * solution.
	 * 
	 * The short code shows as follows:
	 */
	public static int[][] kClosest1(int[][] points, int K) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
		for (int[] p : points) {
			pq.offer(p);
			if (pq.size() > K) {
				pq.poll();
			}
		}
		int[][] res = new int[K][2];
		while (K > 0) {
			res[--K] = pq.poll();
		}
		return res;
	}

	/*
	 * III. The last solution is based on quick sort, we can also call it quick
	 * select. In the quick sort, we will always choose a pivot to compare with
	 * other elements. After one iteration, we will get an array that all
	 * elements smaller than the pivot are on the left side of the pivot and all
	 * elements greater than the pivot are on the right side of the pviot
	 * (assuming we sort the array in ascending order). So, inspired from this,
	 * each iteration, we choose a pivot and then find the position p the pivot
	 * should be. Then we compare p with the K, if the p is smaller than the K,
	 * meaning the all element on the left of the pivot are all proper
	 * candidates but it is not adequate, we have to do the same thing on right
	 * side, and vice versa. If the p is exactly equal to the K, meaning that
	 * we've found the K-th position. Therefore, we just return the first K
	 * elements, since they are not greater than the pivot.
	 * 
	 * Theoretically, the average time complexity is O(N) , but just like quick
	 * sort, in the worst case, this solution would be degenerated to O(N^2),
	 * and pratically, the real time it takes on leetcode is 15ms.
	 * 
	 * The advantage of this solution is it is very efficient. The disadvatage
	 * of this solution are it is neither an online solution nor a stable one.
	 * And the K elements closest are not sorted in ascending order.
	 * 
	 * The short code shows as follows:
	 */
	public static int[][] kClosest2(int[][] points, int K) {
		int len = points.length, l = 0, r = len - 1;
		while (l <= r) {
			int mid = helper(points, l, r);
			if (mid == K)
				break;
			if (mid < K) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return Arrays.copyOfRange(points, 0, K);
	}

	private static int helper(int[][] A, int l, int r) {
		int[] pivot = A[l];
		while (l < r) {
			while (l < r && compare(A[r], pivot) >= 0)
				r--;
			A[l] = A[r];
			while (l < r && compare(A[l], pivot) <= 0)
				l++;
			A[r] = A[l];
		}
		A[l] = pivot;
		return l;
	}

	private static int compare(int[] p1, int[] p2) {
		return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
	}
}
