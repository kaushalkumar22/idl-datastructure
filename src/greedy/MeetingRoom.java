package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *  252.Meeting Rooms
 *
 *  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 *  determine if a person could attend all meetings.
 *
 *  For example,
 *  Given [[0, 30],[5, 10],[15, 20]],
 *  return false.
 *  Input: [[7,10],[2,4]]
 *  Output: true
 */
public class MeetingRoom {

	public static void main(String[] args) {
		int[][] intervals = {{0, 30},{15, 20},{5, 10}};
		System.out.println(canAttendMeetings(intervals));
	}
	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
		int[] prev =intervals[0];
		for(int i=1;i<intervals.length;i++){
			if(prev[i]>intervals[i][0]){
				return false;
			}else{
				prev = intervals[i];
			}
		}
		return true;
	}
}
