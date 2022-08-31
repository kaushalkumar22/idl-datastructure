package heap_pq;

import java.util.PriorityQueue;

/**
 * You have some sticks with positive integer lengths.
 * You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 *  Input: sticks = [2,4,3]
 * Output: 14
 * Input: sticks = [1,8,3,5]
 * Output: 30
 */
public class MinimumCostToConnectSticks {

	public static void main(String[] args) {
		int[] sticks = {2,4,3};
		System.out.println(connectSticks(sticks));
	}
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int stick : sticks)
            priorityQueue.offer(stick);
        int cost = 0;
        while (priorityQueue.size() > 1) {
            int stick1 = priorityQueue.poll();
            int stick2 = priorityQueue.poll();
            int sum = stick1 + stick2;
            cost += sum;
            priorityQueue.offer(sum);
        }
        return cost;
    }

}
