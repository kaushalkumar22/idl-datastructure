package xyz_miscellaneous;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * Given an array of events where events[i] = [startDayi, endDayi]. Every event
 * i starts at startDayi and ends at endDayi.
 * 
 * You can attend an event i at any day d where startTimei <= d <= endTimei.
 * Notice that you can only attend one event at any time d.
 * 
 * Return the maximum number of events you can attend.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: events = [[1,2],[2,3],[3,4]] Output: 3 Explanation: You can attend all
 * the three events. One way to attend them all is as shown. Attend the first
 * event on day 1. Attend the second event on day 2. Attend the third event on
 * day 3.
 * 
 * Example 2:
 * 
 * Input: events= [[1,2],[2,3],[3,4],[1,2]] Output: 4
 * 
 * Example 3:
 * 
 * Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]] Output: 4
 * 
 * Example 4:
 * 
 * Input: events = [[1,100000]] Output: 1
 * 
 * Example 5:
 * 
 * Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]] Output: 7
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= events.length <= 10^5 events[i].length == 2 1 <= events[i][0] <=
 * events[i][1] <= 10^5
 *
 * 
 */
public class MaximumNumberOfEventsThatCanBeAttended {
	/*
	 * Sort events increased by start time. Priority queue pq keeps the current open
	 * events.
	 * 
	 * Iterate from the day 1 to day 100000, Each day, we add new events starting on
	 * day d to the queue pq. Also we remove the events that are already closed.
	 * 
	 * Then we greedily attend the event that ends soonest. If we can attend a
	 * meeting, we increment the result res.
	 * 
	 * We can easily improve it to strict O(nlogn)
	 */
	public int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, d = 0, n = A.length;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty())
                d = A[i][0];
            while (i < n && A[i][0] <= d)
                pq.offer(A[i++][1]);
            pq.poll();
            ++res; ++d;
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
        }
        return res;
    }
}
