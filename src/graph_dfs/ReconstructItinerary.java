package graph_dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
<<<<<<< Updated upstream
 * belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * 
=======
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * <p>
>>>>>>> Stashed changes
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that
 * has the smallest lexical order when read as a single string. For example, the
 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All
 * airports are represented by three capital letters (IATA code). You may assume
 * all tickets form at least one valid itinerary. One must use all the tickets
 * once and only once.
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * <p>
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]  <p>
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]  <p> Explanation: Another possible
 * reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in
 * lexical order.
 * <p>
 * JFK ={ATL,SFO}, ATL={JFK,SFO},SFO={ATL}
 * <p>
 *  CALL STACK: JFK,ATL,JFK,SFO,ATL,SFO
 * <p>
 *  EX :{NRT=[JFK], JFK=[KUL, NRT]}

call stack : JFK,KUL,NRT,JFK
 */
public class ReconstructItinerary {

	public static void main(String[] args) {
		//String[][] tickets ={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		//String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<List<String>> tickets =Arrays.asList(Arrays.asList("JFK","KUL"),
				Arrays.asList("JFK","NRT"),Arrays.asList("NRT","JFK"));
		ReconstructItinerary ri = new ReconstructItinerary();
		System.out.println(ri.findItinerary(tickets));
	}
	public List<String> findItinerary(List<List<String>> tickets) {
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
		PriorityQueue<String> arrivals = adjMap.get(departure);
		//we need to load the all in call stack once it empty that means we are at 
		//destination that will be the last node
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll(),adjMap,res);
		}
		res.addFirst(departure);

        
	}

}
