package com.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Given the locations and
 * heights of all the buildings, return the skyline formed by these buildings
 * collectively.
 * 
 * The geometric information of each building is given in the array buildings
 * where buildings[i] = [lefti, righti, heighti]:
 * 
 * lefti is the x coordinate of the left edge of the ith building. righti is the
 * x coordinate of the right edge of the ith building. heighti is the height of
 * the ith building.
 * 
 * You may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 * 
 * The skyline should be represented as a list of "key points" sorted by their
 * x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left
 * endpoint of some horizontal segment in the skyline except the last point in
 * the list, which always has a y-coordinate 0 and is used to mark the skyline's
 * termination where the rightmost building ends. Any ground between the
 * leftmost and rightmost buildings should be part of the skyline's contour.
 * 
 * Note: There must be no consecutive horizontal lines of equal height in the
 * output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is
 * not acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...,[2 3],[4 5],[12 7],...]
 *
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]] 
 * Output:[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]] 
 * Explanation: Figure A shows the buildings of the input. Figure B shows the skyline formed by those
 * buildings. The red points in figure B represent the key points in the output
 * list.
 * 
 * Input: buildings = [[0,2,3],[2,5,3]] Output: [[0,3],[5,0]]
 * 
 * Constraints:
 * 
 * 1 <= buildings.length <= 104
 *  0 <= lefti < righti <= 231 - 1 
 *  1 <= heighti <= 231 - 1 
 *  buildings is sorted by lefti in non-decreasing order.
 *
 * 
 * 
 */
public class TheSkylineProblem {

	public static void main(String[] args) {
		int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		System.out.println(getSkyline(buildings));
	}
	public static List<List<Integer>> getSkyline(int[][] buildings) {
		// getSkyline(0, buildings.length-1, buildings);

		List<int[]> skyLine =  getSkyline(0, buildings.length-1, buildings);
		List<List<Integer>> li = new ArrayList<List<Integer>>();
		for (int[] is : skyLine) {
			li.add(Arrays.asList(is[0],is[1]));
		}
		return li;
	}

	// given two skylines, merge them
	private static List<List<Integer>> mergeSkylines(List<int[]> skylineListLower, List<int[]> skylineListHigher)
	{
		int h1 = 0, h2 = 0;
		List<List<Integer>> skylineMerged = new ArrayList<>();;

		while (true)
		{
			if (skylineListLower.isEmpty() || skylineListHigher.isEmpty())
			{
				break;
			}

			// first key points from both the skylines
			int [] stripe1 = skylineListLower.get(0);
			int [] stripe2 = skylineListHigher.get(0);

			// 0: 'x' co-ordinate, 1: height
			int [] mergedStripe = new int[2];

			// comparing 'x' co-ordinates of current key points of skyline-1 and skyline-2 
			if (stripe1[0] < stripe2[0]) // key point from skyline-1 is chosen 
			{
				mergedStripe[0] = stripe1[0];
				mergedStripe[1] = stripe1[1];

				// if 'y' co-ordinate for key point from skyline-1 is less than last seen height of skyline-2
				// then we need to update merged key point's 'y' co-ordinate to last seen height of skyline-2
				if (stripe1[1] < h2)
				{
					mergedStripe[1] = h2;
				}

				// update the last seen height for skyline-1
				// note that last seen height for skyline-2 is not updated 
				h1 = stripe1[1];

				// move to next key point for this skyline
				skylineListLower.remove(0);
			}
			else if (stripe2[0] < stripe1[0])
			{
				mergedStripe[0] = stripe2[0];
				mergedStripe[1] = stripe2[1];

				if (stripe2[1] < h1)
				{
					mergedStripe[1] = h1;
				}

				// update the last seen height of skyline-2
				// note that last seen height of skyline-
				h2 = stripe2[1];

				skylineListHigher.remove(0);
			}

			// if 'x' co-ordinates of key points for both skylines are same
			// then choose the key point with greater 'y' value
			// advance key points for both and hence update last seen height for both
			else
			{
				mergedStripe[0] = stripe2[0];
				mergedStripe[1] = Math.max(stripe1[1], stripe2[1]);

				h1 = stripe1[1];
				h2 = stripe2[1];

				skylineListLower.remove(0);
				skylineListHigher.remove(0);
			}

			skylineMerged.add(mergedStripe);
		}

		if (skylineListLower.isEmpty())
		{
			while (!skylineListHigher.isEmpty())
			{
				skylineMerged.add(skylineListHigher.remove(0));
			}
		}
		else
		{
			while (!skylineListLower.isEmpty())
			{
				skylineMerged.add(skylineListLower.remove(0));
			}
		}

		// remove redundant key points from merged skyline 
		int current = 0;
		while (current < skylineMerged.size())
		{
			boolean dupeFound = true;
			int i = current + 1;
			while ((i < skylineMerged.size()) &&  dupeFound)
			{
				if (skylineMerged.get(current)[1] == skylineMerged.get(i)[1])
				{
					dupeFound = true;
					skylineMerged.remove(i);
				}
				else
				{
					dupeFound = false;
				}
			}
			current += 1;
		}

		return skylineMerged;
	}

	private static List<List<Integer>> getSkyline(int low, int high, int[][]buildings){
		List<List<Integer>> skyLines = new ArrayList<>();

		// invalid case
		if (low > high){
			return skyLines;
		}
		// base case: if there is only one building, only two key points define the skyline for it
		else if (low == high){
			skyLines.add(Arrays.asList(buildings[low][0],buildings[low][2]));// first key point
			skyLines.add(Arrays.asList(buildings[low][1],0));// second key point

			return skyLines;
		}else{
			int mid = (low + high) / 2;

			// get the skyline for lower half
			List<List<Integer>> skylineLow = getSkyline(low, mid, buildings);

			// get the skyline for upper half
			List<List<Integer>> skylineHigh = getSkyline(mid+1, high, buildings); 

			// merge skylines for these two halves
			return mergeSkylines(skylineLow, skylineHigh);  
		}

	}

}