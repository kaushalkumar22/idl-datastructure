package graph_shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some
 * intersections. The inputs are generated such that you can reach any intersection from any other intersection and that
 * there is at most one road between any two intersections.
 *
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road
 * between intersections ui and vi that takes time i minutes to travel. You want to know in how many ways you can travel
 * from intersection 0 to intersection n - 1 in the shortest amount of time.
 *
 * Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large,
 * return it modulo 109 + 7.
 *
 * Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * Output: 4
 * Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
 * The four ways to get there in 7 minutes are:
 * - 0 -> 6
 * - 0 -> 4 ->6
 * - 0 -> 1 ->2 -> 5 -> 6
 * - 0 -> 1 ->3 -> 5 ->6
 *
 * Example 2:
 *
 * Input: n = 2, roads = [[1,0,10]]
 * Output: 1
 * Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 */
public class NumberOfWaysToArriveAtDestination {
	public static void main(String[] args) {
		int  n = 7, roads[][] = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		System.out.println(countPaths( n, roads));
	}
	public static int countPaths(int n, int[][] roads) {
		List<int[]>[] graph = new List[n];
		for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
		for (int[] e : roads) {
			graph[e[0]].add(new int[]{e[1], e[2]});
			graph[e[1]].add(new int[]{e[0], e[2]});
		}
		return dijkstra(graph, n, 0);
	}
	static int dijkstra(List<int[]>[] graph, int n, int src){
		int  MOD = (int) 10e7;
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int[] ways = new int[n];
		ways[src] = 1;
		dist[src] = 0;
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->a[0] - b[0]);
		minHeap.offer(new int[]{0, src});  // dist, src
		while (!minHeap.isEmpty()) {
			int[] top = minHeap.poll();
			int d = top[0];
			int u = top[1];
			if (d > dist[u]) continue;  //Optimization
			for (int[] nei : graph[u]) {
				int v = nei[0];
				int time = nei[1];
				if (dist[v] > d + time) {
					dist[v] = d + time;
					ways[v] = ways[u];
					minHeap.add(new int[]{dist[v], v});
				} else if (dist[v] == d + time) {
					ways[v] = (ways[v] + ways[u]) % MOD;
				}
			}
		}
		return ways[n-1];
	}

}
