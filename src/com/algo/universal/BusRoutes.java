package com.algo.universal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], 
this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.
We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number 
of buses we must take to reach our destination? Return -1 if it is not possible.

Example:
Input: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6. 

For each of the bus stop, we maintain all the buses (bus routes) that go through it. To do that, we use a HashMap, where bus stop number 
is the key and all the buses (bus routes) that go through it are added to an ArrayList.
We use BFS, where we process elements in a level-wise manner. We add the Start bus stop in the queue. Next, when we enter the while loop, 
we add all the bus stops that are reachable by all the bus routes that go via the Start. Thus, if we have the input as [[1, 2, 7], [3, 6, 7]] 
and Start as 6, then upon processing bus stop 6, we would add bus stops 3 and 7.
With this approach, all the bus stops at a given level, are "equal distance" from the start node, in terms of number of 
buses that need to be changed.
To avoid loops, we also maintain a HashSet that stores the buses that we have already visited.
Note that while in this approach, we use each stop for doing BFS, one could also consider each bus (route) also for BFS.
 * @author I339640
 *
 */
public class BusRoutes {

	public int numBusesToDestination(int[][] routes, int S, int T) {
		if (S == T) return 0;
		HashSet<Integer> used = new HashSet<>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < routes.length; i++)
			for (int j = 0; j < routes[i].length; j++) {
				graph.putIfAbsent(routes[i][j], new LinkedList<>());
				graph.get(routes[i][j]).add(i);
			}
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		int r = 1;
		while (!q.isEmpty()) {
			for (int size = q.size(); size > 0; size--)
				for (int bus : graph.get(q.poll()))
					if (used.add(bus))
						for (int j = 0; j < routes[bus].length; j++)
							if (routes[bus][j] == T)
								return r;
							else q.offer(routes[bus][j]);
			r++;
		}
		return -1;
	}
}
