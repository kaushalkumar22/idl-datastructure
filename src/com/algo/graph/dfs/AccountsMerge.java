package com.algo.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
	public static void main(String[] args) {

		//List<List<String>> accounts = Arrays.asList(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),Arrays.asList("Mary","mary@mail.com"),Arrays.asList("John","johnnybravo@mail.com"));
		List<List<String>> accounts = Arrays.asList(Arrays.asList("Lily","Lily3@m.co","Lily4@m.co","Lily17@m.co"),Arrays.asList("Lily","Lily5@m.co","Lily3@m.co","Lily23@m.co"),Arrays.asList("Lily","Lily0@m.co","Lily1@m.co","Lily8@m.co"),Arrays.asList("Lily","Lily14@m.co","Lily23@m.co"),Arrays.asList("Lily","Lily4@m.co","Lily5@m.co","Lily20@m.co"),Arrays.asList("Lily","Lily1@m.co","Lily2@m.co","Lily11@m.co"),Arrays.asList("Lily","Lily2@m.co","Lily0@m.co","Lily14@m.co"));

		System.out.println(new AccountsMerge().accountsMerge(accounts));
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		int n = accounts.size();
		UniunFind uf = new UniunFind(n);
		// Maps email to their component index
		Map<String, Integer> emailGroup = new HashMap<>();
		for (int i=0;i<n;i++) {
			for(int j=1;j<accounts.get(i).size();j++) {
				String email = accounts.get(i).get(j);
				if(emailGroup.containsKey(email)) {
					// If we have seen this email before then union this
					// group with the previous group of the email
					uf.union(emailGroup.get(email), i);
				}else {
					// If this is the first time seeing this email then
					// assign component group as the account index
					emailGroup.put(email, i);
				}
			}

		}

		//Store emails corresponding to the disjointSet parent
		Map<Integer, List<String>> disjointSet = new HashMap<>();
		for (String email : emailGroup.keySet()) {
			int groupIndex = emailGroup.get(email);
			int parent = uf.find(groupIndex);
			disjointSet.putIfAbsent(parent, new ArrayList<>());
			disjointSet.get(parent).add(email);
		}
		// Sort the components and add the account name
		List<List<String>> result = new ArrayList<>();
		for (int index : disjointSet.keySet()) {     
			Collections.sort(disjointSet.get(index));
			disjointSet.get(index).add(0, accounts.get(index).get(0));
			result.add(disjointSet.get(index));
		}
		return result;
	}

	class UniunFind{

		int[] parent;
		UniunFind(int size){
			parent = new int[size];
			for (int i =0;i<size;i++) {
				parent[i]=i;
			}
		}
		// Finds the parent of group x
		public int find(int x) {
			if (x == parent[x]) {
				return x;
			}
			// This is path compression
			return parent[x] = find(parent[x]);
		}
		// Unite the group that contains "a" with the group that contains "b"
		public void union(int a, int b) {
			int parentA = find(a);
			int parentB = find(b);

			// If nodes a and b already belong to the same group, do nothing.
			if (parentA == parentB) {
				return;
			}
			parent[parentB] = parentA;
		}
	}
}

