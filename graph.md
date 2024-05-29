1. Breadth-First-Search

	Ø BFS explores all the nodes at the present depth level before moving on to next depth level   
	Ø BFS uses a queue to keep track of nodes that need to be explored.  
	Ø BFS starts at a given node (often called the root in a tree or the starting node in a graph)  
	Ø To avoid revisiting nodes, BFS uses a set or an array (depending on the implementation) to keep track of visited nodes.  

	• Applications:
		○ Finding the shortest path in an unweighted graph.
		○ Minimum cost from source to destination.
		○ Level-order traversal of a tree.
		○ BFS can be used to find all nodes in a connected component of an undirected graph 
		○ BFS can be used to detect cycles in an undirected graph 
		○ Solving puzzles with only a few possible moves.
		
	• Algorithm:
	
		a. Initialize the queue with the starting node and mark it as visited.
		b. While the queue is not empty:
			§ Dequeue a node from the queue.
			§ For each adjacent (neighboring) node:
					If the node has not been visited, mark it as visited else enqueue it.
				
	
	
	  // BFS traversal from a given source node
  public  void BFS(int start) {
        // Mark all vertices as not visited (false)
        boolean visited[] = new boolean[vertices];
	// Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
	// Mark the starting node as visited and enqueue it
        visited[start] = true;
        queue.add(start);
	while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            start = queue.poll();
            System.out.print(start + " ");
	// Get all adjacent vertices of the dequeued vertex
            // If an adjacent has not been visited, mark it visited and enqueue it
            Iterator<Integer> i = adj[start].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    } 

	• Complexity:  
	
		○ Time Complexity: O(V+E)O(V+E), where VV is the number of vertices and EE is the number of edges in the graph.  
		○ Space Complexity: O(V)O(V) for the queue and the visited set or array.  
        
	•  Problem List  
        
	752. Open the Lock
	542. 01 Matrix
	1162. As Far from Land as Possible
	994. Rotting Oranges
	1091. Shortest Path in Binary Matrix
	909. Snakes and Ladders
	127. Word Ladder

2. Depth-First-Search

The DFS algorithm is a recursive algorithm that uses the idea of backtracking. It involves exhaustive searches of all the nodes by going ahead, if possible, else by backtracking

	Ø DFS explores as far as possible along each branch before backtracking. It dives deep into the graph/tree structure, exploring each branch to its full depth before moving to another branch.  
	Ø DFS uses backtracking to explore different paths. This makes it suitable for problems where all possible solutions need to be explored.
	Ø Recursive DFS: Uses the call stack of the system for backtracking.
	Ø Iterative DFS: Uses an explicit stack to simulate the recursion process.

	Ø Disconnected Graphs: In the case of disconnected graphs, DFS will only traverse the connected component of the starting vertex. To traverse the entire graph, DFS needs to be called for every unvisited vertex.

	· Applications: 

		· Topological Sorting
		· Cycle Detection
		· Finding Strongly Connected Components (SCCs)
		· Path Finding and Maze Solving
		· Graph Coloring and Bipartite Checking
		
	· Algorithm:

	Recursive DFS:
	
		a. Initialization:
			§ Start from a given source node.
			§ Create a boolean array visited[] to mark the visited nodes.
		b. DFS Function:
			§ Mark the current node as visited.
			§ Process the current node (e.g., print it).
			§ Recur for all adjacent vertices that have not been visited yet.
		c. Helper Function:
			§ A recursive function to perform the actual DFS.

		void DFS(int v) {
    boolean[] visited = new boolean[vertices];
    DFSUtil(v, visited);
}
		void DFSUtil(int v, boolean[] visited) {
    // Mark the current node as visited and print it
    visited[v] = true;
    System.out.print(v + " ");
    
    // Recur for all vertices adjacent to this vertex
    for (int n : adj[v]) {
        if (!visited[n]) {
            DFSUtil(n, visited);
        }
    }
}
	Iterative DFS:  

		a. Initialization:
			§ Start from a given source node.
			§ Create a stack and push the starting node onto it.
			§ Create a boolean array visited[] to mark the visited nodes.
		b. DFS Function:
			§ While the stack is not empty:
				□ Pop a node from the stack.
				□ If the node has not been visited:
					® Mark it as visited.
					® Process the node (e.g., print it).
					® Push all its unvisited adjacent vertices onto the stack.
	
	void DFSIterative(int v) {
    boolean[] visited = new boolean[vertices];
    Stack<Integer> stack = new Stack<>();
    
    stack.push(v);
    
    while (!stack.isEmpty()) {
        int node = stack.pop();
        
        if (!visited[node]) {
            visited[node] = true;
            System.out.print(node + " ");
            
            for (int n : adj[node]) {
                if (!visited[n]) {
                    stack.push(n);
                }
            }
        }
    }
}

	• Time Complexity:
		• O(V + E), where VV is the number of vertices and EE is the number of edges. This is because each vertex and each edge is explored once in the worst case.
	• Space Complexity:
		• Recursive DFS: O(V) due to the call stack.
		• Iterative DFS: O(V) due to the explicit stack used.
		
	•  Problem List  

	1376. Time Needed to Inform All Employees
	1020. Number of Enclaves
	130. Surrounded Regions
	1254. Number of Closed Islands
	200. Number of Islands
	841. Keys and Rooms
	695. Max Area of Island
	200. Number of Islands
	733. Flood Fill
	1034. Coloring A Border
	690. Employee Importance
	997. Find the Town Judge
	802. Find Eventual Safe States
	417. Pacific Atlantic Water Flow
![image](https://github.com/kaushalkumar22/idl-datastructure/assets/10301674/ab65c4a1-6a05-4e59-82f8-48bd7d558004)


3. Topological Sort  
   3.1 Kahn’s algorithm

   Course Schedule : https://leetcode.com/problems/course-schedule/  
   Course Schedule II: https://leetcode.com/problems/course-schedule-ii/  
   Sequence Reconstruction: https://leetcode.com/problems/sequence-reconstruction/  
   Alien Dictionary: https://leetcode.com/problems/alien-dictionary/solution/

4. Minimum Spanning Trees:Prim's ,Kruskal's-algorithm

4.1 Prims Algo

    Start with any vertex. Use Priority Queue to process the smallest edge.
    Use visited array or distance array.
    Difference between Prims and Dijkstra is “Don’t add current vertex distance to calculate neighbour distance”.
    Example : u, v
    Dijkstra - dis[v] = dis[u] + graph[u][v];
    Prims - dis[v] = graph[u][v]
    Time Complexity is O(ElogV)
    https://www.youtube.com/watch?v=oP2-8ysT3QQ&t=430s&ab_channel=TusharRoy-CodingMadeSimple
    Implementation: https://leetcode.com/problems/min-cost-to-connect-all-points

4.2 Kruskal Algo

    Sort all the edges by their weights and use union find to avoid cycle
    Time Complexity is O(ElogE)
    https://www.youtube.com/watch?v=fAuF0EuZVCk&t=261s&ab_channel=TusharRoy-CodingMadeSimple
    Implementation: https://leetcode.com/problems/min-cost-to-connect-all-points

1489 https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/  
https://leetcode.com/problems/optimize-water-distribution-in-a-village/

5. Single Source Shortest Paths:Bellman-Ford's,Dijkstra's algorithm

5.1 Bellman-Ford

    Used with negative weights also.
    Able to find whether graph has negative cycle
    Not preferred over Dijkstra as time complexity of bellman ford is O(VE)
    Implemented Bellman ford for this problem to see its working code.
	https://leetcode.com/problems/network-delay-time
    Run this algo one more time if a negative cycle check is required. 
	If the shortest distance of a vertex is reduced, then the graph has a negative cycle.

5.2 Dijkstra

    Used only if weights are non-negative
    Similar to BFS but has below difference
    Used Priority Queue with Integer Array instead of Queue with Integer
    Used Distance array instead of boolean visited array.
    Time Complexity is O(Elog E) -> O(Elog V^2) -> O(E*2 log v) -> O(ElogV)
    https://leetcode.com/problems/network-delay-time
    https://leetcode.com/problems/cheapest-flights-within-k-stops/


6. All-Pairs Shortest Paths: Floyd-Warshall,Johnson’s algorithm

6.1 Floyd-Warshall  
1334 https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/  
399 https://leetcode.com/problems/evaluate-division/  
787 https://leetcode.com/problems/cheapest-flights-within-k-stops/  
1462 https://leetcode.com/problems/course-schedule-iv/  
1617 https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/

    It prefers adjacency matrix over adjacency list
    Time Complexity is O(V^3)
    Run this algo one more time if a negative cycle check is required. If the shortest distance of a vertex is reduced, then the graph has a negative cycle.
    https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/


6.2 Johnson’s algorithm

7. Strongly Connected Components

Simple DFS and visited array is used to find scc in an undirected graph.  
Tarjan algo and kosaraju algo are used to find scc in directed graphs.  
7.1 Tarjan’s Algorithm

    Used to find scc, articulation point, bridge in graph.
    Time complexity is O(V+E)
    https://www.youtube.com/watch?v=aZXi1unBdJA&ab_channel=WilliamFiset - scc
    Implemented both bridge and articulation points in this leetcode problem
    https://leetcode.com/problems/critical-connections-in-a-network
    https://www.youtube.com/watch?v=aZXi1unBdJA&ab_channel=WilliamFiset - Bridge and Articulation Point

7.2 Kosaraju’s Algorithm

    Time Complexity is O(V+E)
    https://www.youtube.com/watch?v=RpgcYiky7uw&ab_channel=TusharRoy-CodingMadeSimple
    Implemented on HackerEarth by me
    https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/practice-problems/algorithm/a-walk-to-remember-qualifier2/submissions/
    Implementation: https://leetcode.com/problems/course-schedule/discuss/249688/Different-O(V%2BE)-solution-using-Kosaraju's-algorithm

8. Union-Find (Disjoint set)  
   Identify if problems talks about finding groups or components.

https://leetcode.com/problems/friend-circles/  
https://leetcode.com/problems/redundant-connection/  
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/  
https://leetcode.com/problems/number-of-operations-to-make-network-connected/  
https://leetcode.com/problems/satisfiability-of-equality-equations/  
https://leetcode.com/problems/accounts-merge/  
https://leetcode.com/problems/connecting-cities-with-minimum-cost/


9. Travelling Salesman Problem (TSP):Euler's and Hamilton's algo

   It is a hamiltonian circuit. It is a hamiltonian path if returning to the start vertex is not needed.
   Time Complexity is O(N^2 * 2 ^N)
   Implemented using dp with bit masking as dp[1<<N][N] where N is number of vertices.
   Easiest Implementation: https://www.hackerearth.com/practice/notes/codemonk-dynamic-programming-ii-1/
   https://leetcode.com/problems/find-the-shortest-superstring

9.1 Hamiltonian Path or TSP

    Path which traverses each vertex exactly once.
    Simple way: DFS + backtracking
    https://www.hackerearth.com/practice/algorithms/graphs/hamiltonian-path/tutorial/  

9.2 Euler Path

    Path which traverses each edge exactly once.
    https://www.youtube.com/watch?v=8MpoO2zA2l4&ab_channel=WilliamFiset
    Implementation: https://leetcode.com/problems/reconstruct-itinerary/

10 Eulerian circuits

10.1 Hierholzer's algorithm  
https://leetcode.com/problems/reconstruct-itinerary/


11. Max-Flow, Min-Cut  
    11.1 Ford-Fulkerson Algorithm  
    https://leetcode.com/problems/maximum-students-taking-exam

12. Graph coloring:

    https://leetcode.com/problems/possible-bipartition/  
    https://leetcode.com/problems/is-graph-bipartite/

13. Connected components problems

    Number of Provinces: https://leetcode.com/problems/number-of-provinces/  
    Number of Connected Components in an Undirected Graph: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/  
    Number of Operations to Make Network Connected: https://leetcode.com/problems/number-of-operations-to-make-network-connected/  
    Accounts Merge: https://leetcode.com/problems/accounts-merge/  
    Critical Connections in a Network: https://leetcode.com/problems/critical-connections-in-a-network/

14. Flood Fill algo  
    https://leetcode.com/problems/maximum-students-taking-exam/  




