package com.algo.lds.mustdo.binarysearch;

/**
 * A Conveyor belt has packages that must be shipped from one port to another
 * within D days.
 * 
 * The i-th package on the conveyor belt has a weight of weights[i]. Each day,
 * we load the ship with packages on the conveyor belt (in the order given by
 * weights). We may not load more weight than the maximum weight capacity of the
 * ship.
 * 
 * Return the least weight capacity of the ship that will result in all the
 * packages on the conveyor belt being shipped within D days.
 * 
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5 Output: 15 Explanation: A ship
 * capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5 2nd day: 6, 7 3rd day: 8 4th day: 9 5th day: 10
 * 
 * Note that the cargo must be shipped in the order given, so using a ship of
 * capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6,
 * 7), (8), (9), (10) is not allowed.
 * 
 * Input: weights = [3,2,2,4,1,4], D = 3 Output: 6 Explanation: A ship capacity
 * of 6 is the minimum to ship all the packages in 3 days like this: 1st day: 3,
 * 2 2nd day: 2, 4 3rd day: 1, 4
 * 
 * Input: weights = [1,2,3,1,1], D = 4 Output: 3 Explanation: 1st day: 1 2nd
 * day: 2 3rd day: 3 4th day: 1, 1
 * 
 * Constraints:
 * 
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * 
 */
public class CapacityToShipPackagesWithinDDays {
	public static void main(String[] args) {
		int weights[] = {1,2,3,4,5,6,7,8,9,10}, D = 5;
		System.out.println(shipWithinDays(weights, D));
	}

	/*
	 * [1,2,3,4,5,6,7,8,9,10], D = 5
	 * 
	 * [1, 2, 3], [4, 5], [6, 7], [8] ,[9,10]
	 * 
	 * capacity : 19 but its not maximum capacity: [1, 2, 3, 4, 5], [6, 7], [8] ,[9], [10] 
	 * Ans 14
	 * 
	 * min =10(max no) max=55(sum)
	 * 
	 * capacity =10 [1, 2, 3, 4], [5], [6], [7], [8] ,[9], [10] so D =7
	 * 
	 * capacity =11 [1, 2, 3, 4], [5,6], [7], [8] ,[9], [10] so D =6
	 * 
	 * ...............
	 * 
	 * capacity:14 [1, 2, 3, 4, 5], [6, 7], [8] ,[9], [10] =5
	 * 
	 * so time complexity is O(n)*O(max-min) i.e O(n2)
	 * so can we do better, yes if we do the binary search on min and max 
	 * 
	 * time complexity will be O(nlogn)
	 */
	public static int shipWithinDays(int[] weights, int D) {
		int min = 0, max = 0;
		for (int w: weights) {
			min = Math.max(min, w);
			max += w;
		}
		while (min < max) {
			int mid = min +(max-min) / 2;
			int	daysRequired = 1, curr = 0;
			for (int w: weights) {
				if (curr + w > mid) {
					daysRequired ++;
					curr = 0;
				}
				curr += w;
			}
			if (daysRequired > D) {
				min = mid + 1;
			}else {
				max = mid;
			}
		}
		return min;
	}
}
