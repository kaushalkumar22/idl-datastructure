package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note:
 * 
 * If there are multiple valid itineraries, you should return the itinerary that
 * has the smallest lexical order when read as a single string. For example, the
 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All
 * airports are represented by three capital letters (IATA code). You may assume
 * all tickets form at least one valid itinerary. One must use all the tickets
 * once and only once.
 * 
 * Example 1:
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * Example 2:
 * 
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible
 * reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in
 * lexical order.
 *
 * 
 * 
 */
public class ReconstructItinerary {

	public static void main(String[] args) {
		//String[][] tickets ={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};

		ReconstructItinerary ri = new ReconstructItinerary();
		System.out.println(ri.findItinerary(tickets));
	}
	public List<String> findItinerary1(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
		LinkedList<String> res = new LinkedList<String>();
		buildGraph(tickets,adjMap);
		dfs("JFK",adjMap,res);
		return res;		
	}
	private void buildGraph(List<List<String>> tickets, Map<String, PriorityQueue<String>> adjMap) {

		for (List<String> tc : tickets) {
			adjMap.putIfAbsent(tc.get(0), new PriorityQueue<>());
			adjMap.get(tc.get(0)).add(tc.get(1));	
		}
	}
	
	private void dfs(String departure, Map<String, PriorityQueue<String>> adjMap, LinkedList<String> res) {
		//res.add(departure);
		PriorityQueue<String> arrivals = adjMap.get(departure);
		while (arrivals != null && !arrivals.isEmpty())
			dfs(arrivals.poll(),adjMap,res);
		res.addFirst(departure);
	}

	public  List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
		LinkedList<String> res = new LinkedList<String>();
		buildGraph1(tickets,adjMap);
		dfs("JFK",adjMap,res);
		return res;			
	}
	private void buildGraph1(String[][] tickets, Map<String, PriorityQueue<String>> adjMap) {

		for (String[] tc : tickets) {
			adjMap.putIfAbsent(tc[0], new PriorityQueue<>());
			adjMap.get(tc[0]).add(tc[1]);	
		}
	}

}
