package graph_shortestpath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * There are n cities connected by m flights. Each flight starts from city u and
 * arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the
 * destination dst, your task is to find the cheapest price from src to dst with
 * up to k stops. If there is no such route, output -1.
 *
 * Example 1: Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]] src = 0, dst
 * = 2, k = 1 Output: 200
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

		int n =13,
				flights[][]={{11,12,74},{1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},{4,0,91},
						{11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},{6,2,8},{4,3,54},{3,11,76},
						{3,12,23}, {11,6,79},{6,12,36},{2,11,100},{2,5,49},{7,0,17},{5,8,95},{3,9,98},{8,10,61},
						{2,12,38},{5,7,58},{9,4,37}, {8,6,79},{9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},
						{6,9,53},{7,4,90},{0,5,43},{11,2,52}, {11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},
						{12,0,26},{10,5,38}, {12,8,50},{0,2,77},{11,0,13}, {9,10,76},{2,6,67},{5,6,34},{9,7,62},{5,3,67}}
				,src = 10, dst= 1, k = 10 ;


		//int n = 3, flights[][] = {{0,1,100},{1,2,100},{0,2,500}},src = 0, dst= 2, k = 0 ;
		//int n = 4, flights[][] = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}},src = 0, dst= 3, k = 1 ;
		//int n = 5, flights[][] = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}},src = 0, dst= 2, k = 2 ;
		//convertInput("[[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]");
		System.out.println(findCheapestPrice1( n, flights,src,dst, k));
		System.out.println(findCheapestPrice( n, flights,src,dst, k));
	}

	//Bellman Ford
	//Much like BFS, run the algorithm K times, if the answer exists, it should be stored in the helper matrix

	public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K){
		int[] cost=new int[n];
		Arrays.fill(cost,Integer.MAX_VALUE);
		cost[src]=0;
		for(int i=0;i<=K;i++)
		{
			int[] temp= Arrays.copyOf(cost,n);
			for(int[] f: flights)
			{
				int curr=f[0],next=f[1],price=f[2];
				if(cost[curr]==Integer.MAX_VALUE)
					continue;
				temp[next]=Math.min(temp[next],cost[curr]+price);
			}
			cost=temp;
		}
		return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
	}

	////Dijkstra's
	//Much like BFS, but use a PriorityQueue based on the cheapest cost. Incorporate the stop limit to individual
	// paths to traverse upto k stops.

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)  {
		// Build the adjacency list
		Map<Integer,Map<Integer,Integer>> adjMap=new HashMap<>();
		for(int[] flight:flights){
			adjMap.putIfAbsent(flight[0],new HashMap<>());
			adjMap.get(flight[0]).put(flight[1],flight[2]);
		}

		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(Integer.compare(a[0],b[0])));
		pq.offer(new int[]{0,src,k+1});
		while(!pq.isEmpty()){

			int[] top=pq.remove();
			int cost=top[0];
			int city=top[1];
			int stops=top[2];

			if(city==dst) {
				return cost;
			}

			if(adjMap.containsKey(city)) {
				for (Integer neighbour : adjMap.get(city).keySet()) {
					if(!(stops-1<=0&&neighbour!=dst))
						pq.offer(new int[] {cost+adjMap.get(city).get(neighbour ),neighbour,stops-1});
				}
			}
		}

		return -1;
	}

}
