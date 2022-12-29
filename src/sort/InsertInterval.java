package sort;

import java.util.*;

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
		int intervals[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}}, newInterval[] = {4,8};
		intervals = insert(intervals, newInterval);
		for(int[] interval : intervals){
			System.out.println(interval[0]+","+interval[1]);
		}
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> res = new ArrayList<>();
		for(int i=0;i<intervals.length;i++){
			int[] interval =intervals[i];
			if(interval[1]<newInterval[0]){
				res.add(interval);
			}else if(interval[0]>newInterval[1]){
				res.add(newInterval);
				res.addAll(Arrays.asList(Arrays.copyOfRange(intervals,i,intervals.length)));
				return res.toArray(new int[res.size()][2]);
			}else {
				newInterval[0] = Math.min(interval[0],newInterval[0]);
				newInterval[1] = Math.max(interval[1],newInterval[1]);
			}
		}
		res.add(newInterval);
		return res.toArray(new int[res.size()][2]);
	}
}

