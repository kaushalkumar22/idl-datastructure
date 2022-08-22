package com.algo.graph;

import com.algo.graph.RedundantConnection.UnionFind;

public class Numberofprovinces {


	public int findCircleNum(int[][] M) {
		int n = M.length;
		UnionFind uf = new UnionFind(n);

		int count=n;
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n; j++) {
				if (M[i][j] == 1&&uf.find(i)!=uf.find(j)) {
					uf.union(i, j);
					count--;
				}
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

