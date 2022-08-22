package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

	public static void main(String[] args) {
		AlienDictionary ad= new AlienDictionary();
		//String[] words ={"wrt","wrf","er","ett","rftt"};
		String[] words ={"z","x"};
		System.out.println(ad.alienOrderDFS(words));
	}
	public String alienOrderDFS(String[] words) {

		Map<Character,List<Character>> adjMap = new HashMap<>();
		buildGraph(words,adjMap);
		StringBuilder sb = new StringBuilder();
		Set<Character> visited = new HashSet<>();
		Set<Character> cycle = new HashSet<>();
		
		for (Character c :adjMap.keySet()) {
			if(!dfs(c,adjMap,sb, visited,cycle)) {
				return "";
			}
		}
		return sb.reverse().toString();
	}

	private boolean dfs(Character c, Map<Character, List<Character>> adjMap, StringBuilder sb, Set<Character> visited,
			Set<Character> cycle) {
		
		if(cycle.contains(c)) return false;
		if(visited.contains(c)) return true;
		cycle.add(c);
		for (Character ch : adjMap.get(c)) {
			if(!dfs(ch,adjMap,sb, visited,cycle)) {
				return false;
			}
		}
		cycle.remove(c);
		visited.add(c);
		sb.append(c);
		
		return true;
	}
	private void buildGraph(String[] words, Map<Character, List<Character>> adjMap) {
		for (String word : words) {
			for (char c :word.toCharArray()) {	
				adjMap.put(c, new ArrayList<Character>());
			}
		}
		for (int i=1;i<words.length;i++) {
			String prev = words[i-1];
			String curr = words[i];
			for(int j=0;j<prev.length()&&j<curr.length();j++) {
				if(prev.charAt(j)!=curr.charAt(j)) {
					adjMap.get(prev.charAt(j)).add(curr.charAt(j));
					break;
				}
			}
		}
	}


}


