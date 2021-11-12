package com.algo.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are n cities connected by m flights. Each flight starts from city u and
 * arrives at v with a price w.
 * 
 * Now given all the cities and flights, together with starting city src and the
 * destination dst, your task is to find the cheapest price from src to dst with
 * up to k stops. If there is no such route, output -1.
 * 
 * Example 1: Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]] src = 0, dst
 * = 2, k = 1 Output: 200 Explanation: The graph looks like this:
 * 
 * 
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as
 * marked red in the picture.
 * 
 * Example 2: Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]] src = 0, dst
 * = 2, k = 0 Output: 500 Explanation: The graph looks like this:
 * 
 * 
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as
 * marked blue in the picture.
 *
 * 
 */
public class CheapestFlightsWithinKStops {
	public static void main(String[] args) {
		int n = 3, flights[][] = {{0,1,100},{1,2,100},{0,2,500}},src = 0, dst= 2, k = 0 ;
		System.out.println(findCheapestPrice( n, flights,src,dst, k));
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
		for (int[] f : flights) {
			if (!prices.containsKey(f[0]))
				prices.put(f[0], new HashMap<>());
			prices.get(f[0]).put(f[1], f[2]);
		}
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
		pq.add(new int[] { 0, src, k + 1 });
		while (!pq.isEmpty()) {
			int[] top = pq.remove();
			int price = top[0];
			int city = top[1];
			int stops = top[2];
			if (city == dst)
				return price;
			if (stops > 0) {
				Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
				for (int a : adj.keySet()) {
					pq.add(new int[] { price + adj.get(a), a, stops - 1 });
				}
			}
		}
		return -1;
	}
}
