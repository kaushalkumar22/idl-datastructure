package graph_unionfind;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find
 * the number of connected components in an undirected graph.
 *
 * Example 1:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * Output: 2
 *
 * Example 2:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * Output: 1
 *
 * Note: You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0]
 * and thus will not appear together in edges.
 */

public class NumberofConnectedComponentsinanUndirectedGraph {

	public static void main(String[] args) {
		NumberofConnectedComponentsinanUndirectedGraph s = new NumberofConnectedComponentsinanUndirectedGraph();
		System.out.println(s.countComponents(5, new int[][]{ {0, 1}, {1, 2},{2, 3}, {3, 4} }));
	}

	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		int count=n;
		for (int[] edge : edges) {
			if(uf.find(edge[0])!=uf.find(edge[1])) {
				uf.union(edge[0],edge[1]);
				count--;
			}
		}
		return count;
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

