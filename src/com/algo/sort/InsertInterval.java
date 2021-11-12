package com.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]] Explanation: Because the new interval [4,8]
 * overlaps with [3,5],[6,7],[8,10].
 *
 */
public class InsertInterval {

	public static void main(String[] args) {
		List<Interval> intervals = Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7),
				new Interval(8, 10), new Interval(12, 16));
		Interval newInterval = new Interval(4, 8);
		System.out.println(insert(intervals, newInterval));
	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    
		List<Interval> result = new ArrayList<>();
		int i = 0;
		int start = newInterval.start;
		int end = newInterval.end;
		    

		while (i < intervals.size() && intervals.get(i).end < start) {
		    result.add(intervals.get(i++));
		}

		while (i < intervals.size() && intervals.get(i).start <= end) {
		    start = Math.min(start, intervals.get(i).start);
		    end = Math.max(end, intervals.get(i).end);
		    i++;
		}
		result.add(new Interval(start,end)); 

		while (i < intervals.size()) result.add(intervals.get(i++)); 
		return result;
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
