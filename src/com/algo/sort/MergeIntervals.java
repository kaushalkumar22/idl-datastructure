package com.algo.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5]
 * are considered overlapping. InsertInterval
 * 
 * @author I339640
 *
 */

public class MergeIntervals {

	public static void main(String[] args) {
		List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10),
				new Interval(15, 18));

		System.out.println(merge(intervals));
	}
	package com.algo.sort;

	import java.util.Arrays;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.LinkedList;
	import java.util.List;

	/**
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * Example 1:
	 * 
	 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
	 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	 * 
	 * Example 2:
	 * 
	 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5]
	 * are considered overlapping. InsertInterval
	 * 
	 * @author I339640
	 *
	 */

	public class MergeIntervals {

		public static void main(String[] args) {
			int[][] intervals ={{1,3},{2,6},{8,10},{15,18}};//Output: [[1,6],[8,10],[15,18]]
			//int[][] intervals= {{1,4},{4,5}};

			System.out.println(merge(intervals)[0][1]);
		}

		public static int[][]  merge(int[][] intervals) {

			Arrays.sort(intervals,(a,b)->a[0]-b[0]);

			List<int[]> list = new LinkedList<>();
			int[] pre = {intervals[0][0],intervals[0][1]};
			for (int[] curr : intervals) {
				if (pre[1] < curr[0]) {
					list.add(pre);
					pre = curr;
				} else {

					pre[1] = Math.max(pre[1], curr[1]);
				}
			}
			list.add(pre);
			int[][] res = new int[list.size()][2];
			int i=0;
			for (int[] is : list) {
				res[i]=is;
				i++;
			}
			return res;
		}
	}
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return Collections.emptyList();
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		List<Interval> list = new LinkedList<>();
		Interval pre = new Interval(intervals.get(0).start, intervals.get(0).end);
		for (Interval curr : intervals) {
			if (pre.end < curr.start) {
				list.add(pre);
				pre = curr;
			} else {
				pre.start = Math.min(pre.start, curr.start);
				pre.end = Math.max(pre.end, curr.end);
			}
		}
		list.add(pre);
		return list;
	}

	private static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}

	}
}