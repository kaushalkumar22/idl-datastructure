package graph_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 *
 * Example 2:
 *
 * Input: n = 2, connections = [[0,1]]
 * Output: [[0,1]]
 */
public class CriticalConnectionsInANetwork {//Tarjan Algorithm
	public static void main(String[] args) {
		
	}
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(List<Integer> oneConnection :connections) {
			graph[oneConnection.get(0)].add(oneConnection.get(1));
			graph[oneConnection.get(1)].add(oneConnection.get(0));
		}
		HashSet<List<Integer>> connectionsSet = new HashSet<>(connections);
		int[] rank = new int[n];
		Arrays.fill(rank, -2);
		dfs(graph, 0, 0, rank, connectionsSet);
		return new ArrayList<>(connectionsSet);
	}

	int dfs(List<Integer>[] graph, int node, int depth, int[] rank, HashSet<List<Integer>> connectionsSet){
		if (rank[node]>=0){
			return rank[node]; // already visited node. return its rank
		}
		rank[node] = depth;
		int minDepthFound = depth; // can be Integer.MAX_VALUE also.
		for(Integer neighbor: graph[node]){
			if (rank[neighbor] == depth-1){ // ignore parent
				continue;
			}
			int minDepth = dfs(graph, neighbor, depth+1, rank, connectionsSet);
			minDepthFound = Math.min(minDepthFound, minDepth);
			if (minDepth <= depth){
				// to avoid the sorting just try to remove both combinations. of (x,y) and (y,x)
				connectionsSet.remove(Arrays.asList(node, neighbor));
				connectionsSet.remove(Arrays.asList(neighbor, node));
			}
		}
		return minDepthFound;
	}
}


