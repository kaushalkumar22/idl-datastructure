package com.algo.tree.common;

import java.util.ArrayList;
import java.util.HashSet;

public class SumOfDistancesInTree {

	public static void main(String[] args) {
		SumOfDistancesInTree tree = new SumOfDistancesInTree();
		int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
		int[] iss = tree.sumOfDistancesInTree( 6,  edges);
		for (int is : iss) {
			System.out.println(is);
		}
	}
	 int[] res, count;
	    ArrayList<HashSet<Integer>> tree;
	    public int[] sumOfDistancesInTree(int N, int[][] edges) {
	        tree = new ArrayList<HashSet<Integer>>();
	        res = new int[N];
	        count = new int[N];
	        for (int i = 0; i < N ; ++i)
	            tree.add(new HashSet<Integer>());
	        for (int[] e : edges) {
	            tree.get(e[0]).add(e[1]);
	            tree.get(e[1]).add(e[0]);
	        }
	        dfs(0, -1);
	        dfs2(0, -1);
	        return res;
	    }

	    public void dfs(int root, int pre) {
	        for (int i : tree.get(root)) {
	            if (i == pre) continue;
	            dfs(i, root);
	            count[root] += count[i];
	            res[root] += res[i] + count[i];
	        }
	        count[root]++;
	    }


	    public void dfs2(int root, int pre) {
	        for (int i : tree.get(root)) {
	            if (i == pre) continue;
	            res[i] = res[root] - count[i] + count.length - count[i];
	            dfs2(i, root);
	        }
	    }
}
