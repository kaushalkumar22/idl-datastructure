package graph_dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1. 
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i] is 
 * an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
 *
 * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path 
 * starting from that node leads to a terminal node (or another safe node).
 *
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 * Illustration of graph
 *
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
 * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 *
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * Explanation:
 * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 * Constraints:
 *
 *     n == graph.length
 *     1 <= n <= 104
 *     0 <= graph[i].length <= n
 *     0 <= graph[i][j] <= n - 1
 *     graph[i] is sorted in a strictly increasing order.
 *     The graph may contain self-loops.
 *     The number of edges in the graph will be in the range [1, 4 * 104].
 *     value of color represents three states:
 *
 * 0:have not been visited
 * 1:safe
 * 2:unsafe
 * For DFS,we need to do some optimization.When we travel a path,we mark the node with 2 which represents having been visited,and
 * when we encounter a node which results in a cycle,we return false,all node in the path stays 2 and it represents unsafe.
 * And in the following traveling,whenever we encounter a node which points to a node marked with 2,we know it will results
 * in a cycle,so we can stop traveling.On the contrary,when a node is safe,we can mark it with 1 and whenever we encounter a
 * safe node,we know it will not results in a cycle.
 */
public class FindEventualSafeStates {
	public static void main(String[] args) {
		int[][] graph= {{1,2,3,4},{1,2},{3,4},{0,4},{}};
		System.out.println(new FindEventualSafeStates().eventualSafeNodes(graph));
	}
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> res = new ArrayList<>();
		if(graph == null || graph.length == 0)  return res;

		int nodeCount = graph.length;
		int[] color = new int[nodeCount];

		for(int i = 0;i < nodeCount;i++){
			if(dfs(graph, i, color))  {
				res.add(i);
			}
		}
		return res;
	}
	public boolean dfs(int[][] graph, int start, int[] color){
		if(color[start] != 0) {
			return color[start] == 1;
		}

		color[start] = 2;
		for(int newNode : graph[start]){
			if(!dfs(graph, newNode, color))    return false;
		}
		color[start] = 1;

		return true;
	}
}

