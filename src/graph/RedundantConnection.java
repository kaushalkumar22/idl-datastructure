package graph;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * The given input is a graph that started as a tree with N nodes (with distinct
 * values 1, 2, ..., N), with one additional edge added. The added edge has two
 * different vertices chosen from 1 to N, and was not an edge that already
 * existed.
 * 
 * The resulting graph is given as a 2D-array of edges. Each element of edges is
 * a pair [u, v] with u < v, that represents an undirected edge connecting nodes
 * u and v.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of N
 * nodes. If there are multiple answers, return the answer that occurs last in
 * the given 2D-array. The answer edge [u, v] should be in the same format, with
 * u < v.
 * 
 * Example 1:
 * 
 * Input: [[1,2], [1,3], [2,3]] Output: [2,3] Explanation: The given undirected
 * graph will be like this:
 *    1 
 *   / \ 
 *  2 - 3
 * 
 * Example 2:
 * 
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]] Output: [1,4] Explanation: The
 * given undirected graph will be like this: 
 * 5 - 1 - 2 
 *     |   | 
 *     4 - 3
 *
 * 
 */
public class RedundantConnection {

	public static void main(String[] args) {
		int[][] edges =  {{1,2},{2,3},{3,4},{1,4},{1,5}};
		System.out.println(Arrays.toString(new RedundantConnection()
				.findRedundantConnection(edges))); 

	}

	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length+1;
		UnionFind uf = new UnionFind(n);

		for (int[] edge : edges) {
			if(uf.find(edge[0])==uf.find(edge[1])) {
				return edge;
			}else {
				uf.union(edge[0],edge[1]);
			}
		}

		return edges[0];
	}
	class UnionFind{

		private int[] parent ;
		private int[] rank ;

		public UnionFind(int n) {
			parent = new int[n+1];
			rank =  new int[n+1];
			for(int i=0;i<=n;i++) {
				parent[i]=i;
				rank[i]=1;
			}
		}
		public int find(int x) {
			if(x != parent[x]) {
				parent[x] = find(parent[x]);    // path compression by halving
			}
			return parent[x];
		}

		public void union(int a, int b) {
			int par1 = find(a);
			int par2 = find(b);
			if (rank[par1] > rank[par2]) {
				parent[par2] = par1;
				rank[par1]+=rank[par2];
			}else {
				parent[par1] = par2;
				rank[par2]+=rank[par1];
			}
		}
	}
}

