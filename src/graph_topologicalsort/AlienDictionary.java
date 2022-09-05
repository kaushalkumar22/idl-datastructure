package graph_topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of
 * this new language. Derive the order of letters in this language.
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 *
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 *
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 *
 * Note:
 *
 *     You may assume all letters are in lowercase.
 *     You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 *     If the order is invalid, return an empty string.
 *     There may be multiple valid order of letters, return any one of them is fine.
 */
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


