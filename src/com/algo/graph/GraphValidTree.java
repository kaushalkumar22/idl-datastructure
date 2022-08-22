package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.

Company:
Adobe Amazon Facebook Google LinkedIn Pinterest Salesforce Zenefits
 */

public class GraphValidTree {

	public static void main(String[] args) {
		//int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
		int[][] edges = {};
		System.out.println(new GraphValidTree().validTree(2,edges) );
	}
	public  boolean validTree(int n, int[][] edges) {

		if(n==0||n==1) return true;
		
		Map<Integer, List<Integer>> adjMap = adjList(n, edges);
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0 ; i < n; i++) {
			if (dfs(i, adjMap,-1,visited)&&n==visited.size()) {
				return true;
			}
		}
		return false;
	}

	private  boolean dfs(int node, Map<Integer, List<Integer>> adjMap,int parent,Set<Integer> visited) {

		if(visited.contains(node)) return false;

		visited.add(node);
		for (Integer j : adjMap.get(node)) {	
			if(j==parent) continue;
			if (!dfs(j, adjMap,node,visited)) return false;
		}
		return true;
	}
	private  Map<Integer, List<Integer>> adjList(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		//its a undirected hence both will be neighbor of each other so in adj list will be vice versa. 
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0]; 
			int v = edges[i][1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		return graph;
	}
}


