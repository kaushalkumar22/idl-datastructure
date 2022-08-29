package graph_unionfind;

/**
 *There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b
 * is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 */
public class Numberofprovinces {

	public static void main(String[] args) {
		int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(new Numberofprovinces().findCircleNum(isConnected));
	}
	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		UnionFind uf = new UnionFind(n);

		int count=n;
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n; j++) {
				if (isConnected[i][j] == 1&&uf.find(i)!=uf.find(j)) {
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

