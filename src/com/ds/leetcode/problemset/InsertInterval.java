package com.ds.leetcode.problemset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
https://leetcode.com/problems/insert-intervals/
 * @author I339640
 *
 */
public class InsertInterval {

	public static void main(String[] args) {
		List<Interval> intervals = Arrays.asList(new Interval(1,2),new Interval(3,5),new Interval(6,7),
				new Interval(8,10),new Interval(12,16));
		Interval newInterval = new Interval(4,8);
		System.out.println(insert(intervals,  newInterval));
	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> list = new LinkedList<>();
	    for(Interval curr: intervals){
	        if(newInterval.end < curr.start) {
	            list.add(newInterval);
	            newInterval = curr;
	        } else if (curr.end < newInterval.start) {
	            list.add(curr);
	        } else {
	            newInterval.start = Math.min(newInterval.start, curr.start);
	            newInterval.end = Math.max(newInterval.end, curr.end);
	        }
	    }
	    list.add(newInterval);
	    return list;
	}
	private static class Interval{
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "[" +start  +","+  end +"]";
		}		
		
	}
}
