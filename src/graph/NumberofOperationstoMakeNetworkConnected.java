package graph;

public class NumberofOperationstoMakeNetworkConnected {

	public static void main(String[] args) {
		//int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
		int[][] connections = {{0,1},{0,2},{0,3},{1,2}};
		//int[][] connections = { {0, 1}, {0, 2},{1,2}};
		NumberofOperationstoMakeNetworkConnected s = new NumberofOperationstoMakeNetworkConnected();
		System.out.println(s.makeConnected(6,connections));
	}

	public int makeConnected(int n, int[][] connections) {
		if(connections.length < n - 1)return  -1;
		UnionFind uf = new UnionFind(n);
		int count=n;
		for (int[] connect : connections) {
			if(uf.find(connect[0])!=uf.find(connect[1])) {
				uf.union(connect[0],connect[1]);
				count--;
			}
		}
		return count-1;
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

