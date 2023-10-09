package graph_shortestpath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkstra {
	public static void main(String[] args) {

	//	int[][] paths = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int[][] paths = {{1,2,7},{1,3,9},{1,6,14},{2,3,10},{2,4,15},{3,4,11},{3,6,2},{6,5,9},{4,5,6}};

		int[] res =dijkstra(paths,1);
		System.out.println(Arrays.toString(res));
		
		//    Queue<Map<Integer,Integer>> pq = new PriorityQueue<Map<Integer,Integer>>
		// (Comparator.comparing(Map.Entry::getKey));
	}
	public static int[] dijkstra(int[][] paths,int source ) {

		Map<Integer, Map<Integer,Integer>> adj = buildAdjacencyList(paths);
		int[] relaxed = new int[6+ 1];
		Arrays.fill(relaxed, Integer.MAX_VALUE);
		relaxed[source]=0;
		//distance, node into pq
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
		pq.add(new int[]{0,source});
		Set<Integer> settled = new HashSet<>();

		while (!pq.isEmpty()) {
			// Removing the minimum distance node from the priority queue
			int[] topPair = pq.poll();
			
			int currCost = topPair[0];
			int currNode = topPair[1];
		
			if (currCost > relaxed[currNode]) {
				continue;
			}
			 if (!adj.containsKey(currNode)) {
	                continue;
	         }
			// Adding the node whose distance is finalized
			if (settled.contains(currNode)) {
				continue;
			}
			settled.add(currNode);

			// All the adjacent of currNode
			for(int next : adj.get(currNode).keySet()){

				// If current node hasn't already been processed
				if(!settled.contains(next)) {
					int cost = adj.get(currNode).get(next);
				
					// If new distance is cheaper in cost
					if(currCost+cost<relaxed[next]) {
						relaxed[next]=currCost+cost;
					}
					// Add the current node to the queue
					pq.add(new int[] {relaxed[next],next});

				}
			}

		}
		return relaxed;
	}

	// Build the adjacency list
	private static Map<Integer, Map<Integer,Integer>> buildAdjacencyList(int[][] paths) {
		Map<Integer, Map<Integer,Integer>> adj = new HashMap<>();
		for (int[] path : paths) {
			int source = path[0];
			int dest = path[1];
			int cost = path[2];
			adj.putIfAbsent(source, new HashMap<>());
			adj.get(source).put(dest,cost);
		}
		return adj;

	}
}
