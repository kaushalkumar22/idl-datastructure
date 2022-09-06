package graph_dfs;

import java.util.*;

/**
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming
 * a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach
 * other servers directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 *
 * Input: n = 2, connections = [[0,1]]
 * Output: [[0,1]]
 */
public class CriticalConnectionsInANetwork {//Tarjan Algorithm

	public static void main(String[] args) {
		int n = 6;
		//[[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]
		List<List<Integer>> connections = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2),
				Arrays.asList(2, 0), Arrays.asList(1, 3), Arrays.asList(3,4),Arrays.asList(4,5),Arrays.asList(4,5),Arrays.asList(5,3)

		);
		System.out.println(new CriticalConnectionsInANetwork().criticalConnections(n, connections));
	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		Map<Integer, List<Integer>> adjMap = new HashMap<>();
		for (List<Integer> con : connections) {
			adjMap.putIfAbsent(con.get(0), new ArrayList<>());
			adjMap.putIfAbsent(con.get(1), new ArrayList<>());
			adjMap.get(con.get(0)).add(con.get(1));
			adjMap.get(con.get(1)).add(con.get(0));
		}
		Set<Integer> visited = new HashSet<>();
		List<List<Integer>> res = new ArrayList<>();
		for (Integer key : adjMap.keySet()) {
			List<Integer> values = adjMap.get(key);
			if (values.size() == 1 && !visited.contains(key)) {
				res.add(Arrays.asList(key, values.get(0)));
				visited.add(key);
				if (adjMap.get(values.get(0)).get(0)==key) {
					visited.add(values.get(0));
				}
			}
		}
		return res;
	}
}

