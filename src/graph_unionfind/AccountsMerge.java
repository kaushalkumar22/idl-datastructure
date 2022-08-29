package graph_unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to
 * both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the
 * same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the
 * rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],
 * ["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],
 * ["John","johnnybravo@mail.com"]]
 * Explanation:
 * The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 *
 * Example 2:
 *
 * Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
 * ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
 * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],
 * ["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],
 * ["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 */
public class AccountsMerge {
	public static void main(String[] args) {

		List<List<String>> accounts = Arrays.asList(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),Arrays.asList("Mary","mary@mail.com"),Arrays.asList("John","johnnybravo@mail.com"));
		//List<List<String>> accounts = Arrays.asList(Arrays.asList("Lily","Lily3@m.co","Lily4@m.co","Lily17@m.co"),Arrays.asList("Lily","Lily5@m.co","Lily3@m.co","Lily23@m.co"),Arrays.asList("Lily","Lily0@m.co","Lily1@m.co","Lily8@m.co"),Arrays.asList("Lily","Lily14@m.co","Lily23@m.co"),Arrays.asList("Lily","Lily4@m.co","Lily5@m.co","Lily20@m.co"),Arrays.asList("Lily","Lily1@m.co","Lily2@m.co","Lily11@m.co"),Arrays.asList("Lily","Lily2@m.co","Lily0@m.co","Lily14@m.co"));
		System.out.println(new AccountsMerge().accountsMerge(accounts));
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		int n = accounts.size();
		UnionFind uf = new UnionFind(n);
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

