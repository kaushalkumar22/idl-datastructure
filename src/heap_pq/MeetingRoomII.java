package heap_pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *   Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *     Input: [[0, 30],[5, 10],[15, 20]]
 *     Output: 2
 *     Example 2:
 *     Input: [[7,10],[2,4]]
 *     Output: 1
 *
 *     Company:
 *     Amazon Apple Atlassian Baidu Bloomberg Booking.com Cisco Citrix Drawbridge eBay Expedia Facebook GoDaddy
 *     Goldman Sachs Google Lyft Microsoft Nutanix Oracle Paypal Postmates Quora Snapchat Uber Visa Walmart Labs Yelp
 *
 *     Same as minimum platform require
 */
public class MeetingRoomII {

    public static void main(String[] args) {
        //int[][] intervals ={{0, 30},{5, 10},{15, 20}};
        int[][] intervals ={{1,30},{2,30},{5,16},{17,18}};
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {

        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by start time
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        // to store end time of each meeting, smaller value will be at the peek()
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        // start with the first meeting, put it to a meeting room
        int count = 1;
        heap.offer(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){

            if(intervals[i][0] < heap.peek()) {
                count++; // conflict, need 1 more room
                heap.offer(intervals[i][1]); // poll then offer, conceptually merging 2 intervals
            } else {
                // if the current meeting starts right after there's no need for a new room,
                //merge the interval, poll then offer, conceptually merging 2 intervals
                heap.offer(Math.max(intervals[i][1], heap.poll()));             }
        }

        return count;
    }

}
