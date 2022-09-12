package graph_unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
 * [0,1] is the same as [1,0] and thus will not appear together in edges.
 *
 * Company:
 * Adobe Amazon Facebook Google LinkedIn Pinterest Salesforce Zenefits
 */


public class GraphValidTree {

	public static void main(String[] args) {
		int n = 5,  edges[][] = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
		//int n = 5,  edges[][] = {{0,1}, {0,2}, {0,3}, {1,4}};
		//int[][] edges = {};
		System.out.println(new GraphValidTree().validTree(n,edges) );
	}
	public  boolean validTree(int n, int[][] edges) {
		if(n-1!=edges.length) return false;
		int count=n;
		UnionFind uf = new UnionFind(n);
		for (int[] edg : edges) {
			if(uf.find(edg[0])==uf.find(edg[1])) {
				return false;
			}
			uf.union(edg[0], edg[1]);
			count--;
		}

		return count==1 ;
	}
	static class UnionFind{
		int[] parent;
		int[] rank;
		UnionFind(int n){
			parent= new int[n];
			rank = new int[n];
			for (int i=0;i<n;i++){
				parent[i]=i;
				rank[i]=1;
			}
		}
		int find(int x){
			if(x!=parent[x]){
				parent[x]=find(parent[x]);
			}
			return parent[x];
		}
		void union(int a , int b){
			int p1 =find(a);
			int p2 =find(b);
			if(rank[p1]>rank[p2]){
				parent[p2]=p1;
				rank[p1]+=rank[p2];
			}else{
				parent[p1]=p2;
				rank[p2]+=rank[p1];
			}
		}
	}
}


