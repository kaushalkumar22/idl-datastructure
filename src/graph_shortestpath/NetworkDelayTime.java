package graph_shortestpath;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges
 times[i] = (ui, vi, wi),
where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. 
If it is impossible for all the n nodes to receive the signal, return -1.


Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

 */
public class NetworkDelayTime {
	public static void main(String[] args) {
		// 
		//  String s ="[[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2";
		//int times[][] = {{2,1,1},{2,3,1},{3,4,1}}, n = 4, k = 2;
		int times[][] = {{1,2,1}}, n = 2, k = 2;
		System.out.println( networkDelayTime(times,n,k));
	}
	public static int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer,Map<Integer,Integer>> adjMap = new HashMap<>();
		for (int[] t : times) {
			adjMap.putIfAbsent(t[0], new HashMap<>());
			adjMap.get(t[0]).put(t[1], t[2]);		
		}
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
		//0 is time taken to reach at source
		boolean[] visited = new boolean[n+1];
		minHeap.add(new int[]{0,k}); 
		int res=0;
		while(!minHeap.isEmpty()) {
			int[] top = minHeap.poll();
			int travelTime = top[0];
			int src = top[1];

			if(visited[src]) continue;
			visited[src] = true;
			res = Math.max(travelTime, res);
			n--;
			if(adjMap.containsKey(src)) {
				for (Integer neighbour : adjMap.get(src).keySet()) {
					minHeap.offer(new int[] {travelTime+adjMap.get(src).get(neighbour ),neighbour});
				}
			}
		}
		return n==0?res:-1;
	}
}