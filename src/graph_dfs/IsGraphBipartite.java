package graph_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. 
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. 
 * More formally, for each v in graph[u], there is an undirected edge between node u and node v. 
 * The graph has the following properties:
 *
 *     There are no self-edges (graph[u] does not contain u).
 *     There are no parallel edges (graph[u] does not contain duplicate values).
 *     If v is in graph[u], then u is in graph[v] (the graph is undirected).
 *     The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 *
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the
 * graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 *
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node
 * in one and a node in the other.
 *
 * Example 2:
 *
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 */
public class IsGraphBipartite {
	public static void main(String[] args) {
		//int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
		int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
		//int[][] graph ={{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
		System.out.println(isBipartite_dfs(graph));
		System.out.println(isBipartite_bfs(graph));
		System.out.println(isBipartite_uf(graph));
	}

	public static boolean isBipartite_uf(int[][] graph) {

		int n = graph.length;
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (uf.find(i) == uf.find(graph[i][j])) {
					return false;
				}
				uf.union(graph[i][0], graph[i][j]);
			}
		}
		return true;
	}

	public static boolean isBipartite_bfs(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];
		int color = 1;
		int j;
		for (j = 0; j < graph.length; j++) {
			if (colors[j] != 0) continue;

			Queue<Integer> que = new LinkedList<>();
			que.offer(j);
			colors[j] = color;
			while (!que.isEmpty()) {
				int size = que.size();
				for (int i = 0; i < size; i++) {
					int curr = que.poll();
					for (int next : graph[curr]) {
						if (colors[curr] == colors[next]) return false;
						if (colors[next] == 0) {
							colors[next] = -colors[curr];
							que.offer(next);
						}
					}
				}
			}
		}
		return j == graph.length ? true : false;
	}

	public static boolean isBipartite_dfs(int[][] graph) {
		int[] colors = new int[graph.length];
		for (int i = 0; i < graph.length; i++)
			if (colors[i] == 0 && !dfs(graph, colors, i, 1))
				return false;
		return true;
	}

	private static boolean dfs(int[][] graph, int[] colors, int start, int color) {
		if (colors[start] != 0) {
			return colors[start] == color;
		}
		colors[start] = color;
		for (int next : graph[start]) {
			if (colors[start] == colors[next]) return false;

			if (colors[next] == 0 && !dfs(graph, colors, next, -color)) {
				return false;
			}
		}
		return true;
	}
}
	class UnionFind {
	int n ;
	int[] parent;
	int[] rank;
	public UnionFind(int n){
		this.n =n;
		this.parent = new int[n];
		this.rank = new int[n];
		for(int i =0;i<n;i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	public int find(int x){
		if(x!=parent[x]){
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public void union(int x ,int y){
		int p1 = find( x);
		int p2 = find( y);
		//parent[p2] = p1;
		if(rank[p1]>rank[p2]){
			parent[p2] = p1;
			rank[p1]+=rank[p2];
		}else{
			parent[p1] = p2;
			rank[p2]+=rank[p1];
		}
	}
}
