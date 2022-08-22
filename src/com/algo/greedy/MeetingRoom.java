package com.algo.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoom {

	public static void main(String[] args) {
		//int[][] intervals = {{0, 30},{15, 20},{5, 10}};
		//int[][] intervals ={{1,3},{2,6},{8,10},{15,18}};//Output: [[1,6],[8,10],[15,18]]
		int[][] intervals ={{7,10},{2,4}};//Output: [[1,6],[8,10],[15,18]]

		Arrays.sort(intervals,(a,b)->a[0]-b[0]);
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		int count =1;
		pq.offer(intervals[0][1]);
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i][0]<pq.peek()) {
				count++;
				pq.offer(intervals[i][1]);
			}else {
				pq.offer(Math.max(intervals[i][1], pq.poll()));
			}

		}
		System.out.println(count);
		System.out.println(merge(intervals));
	}

	public static int merge(int[][] intervals) {

		Arrays.sort(intervals,(a,b)->a[0]-b[0]);

		int[] pre = {intervals[0][0],intervals[0][1]};
		int count=1;
		for(int i=1;i<intervals.length;i++) {
			if (pre[1] > intervals[i][0]) {
				pre = intervals[i];
				count++;
			}
			pre[1] = Math.max(pre[1], intervals[i][1]);

		}
		return count;
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
