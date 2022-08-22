package com.algo.graph;

/*	
    One solution is to use DFS. The idea is to give each node a flag to mark whether it has been visited. For an unvisited node, we will increment the result by 1, because this must be a new connected region. , And then we traverse the neighboring nodes through the adjacency list and mark them as visited.

	After traversing all connected nodes, we continue to look for the next unvisited node, and so on until all nodes have been visited, then the number of connected regions is also calculated at this time
	Union Find

	Create a root array with the same subscript and node value. At this time, root[i] indicates that node i belongs to group i. We initialized n parts (res = n), assuming that each node belongs to a separate interval at the beginning .

	Then we start to traverse all the edges. For two points of an edge, their values in the root at the beginning are not the same. At this time, we reduce the result by 1, which means one interval is missing. Then update the root of one of the nodes Value to make the root value of the two nodes the same.

	Then we can mark the root values of all nodes in the connected interval as the same value, and the root values of different connected intervals are different, so that we can also find the number of connected intervals.
	Code
 */

import java.util.ArrayList;
import java.util.List;

import com.algo.graph.Numberofprovinces.UnionFind;

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

