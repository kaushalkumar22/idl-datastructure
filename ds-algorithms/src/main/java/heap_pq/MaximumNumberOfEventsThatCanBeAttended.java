package heap_pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 * You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
 * Return the maximum number of events you can attend.
 *
 *
 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.Attend the first event on day 1.Attend the second event on day 2.
 * Attend the third event on day 3.
 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
 * Output: 4
 */
public class MaximumNumberOfEventsThatCanBeAttended {
	
	public static void main(String[] args) {
		int[][] events= {{1,2},{2,3},{3,4},{1,2}};
		System.out.println(maxEvents(events) );

	}
	public static int maxEvents(int[][] A) {
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
