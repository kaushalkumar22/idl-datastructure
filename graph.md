1. Breadth-First-Search  

   https://leetcode.com/problems/01-matrix/  
   https://leetcode.com/problems/as-far-from-land-as-possible/  
   https://leetcode.com/problems/rotting-oranges/  
   https://leetcode.com/problems/shortest-path-in-binary-matrix/  
  
2. Depth-First-Search

  DFS from boundary:  
https://leetcode.com/problems/surrounded-regions/  
https://leetcode.com/problems/number-of-enclaves/  

Shortest time:  
https://leetcode.com/problems/time-needed-to-inform-all-employees/  

Islands Variants  
https://leetcode.com/problems/number-of-closed-islands/  
https://leetcode.com/problems/number-of-islands/  
https://leetcode.com/problems/keys-and-rooms/  
https://leetcode.com/problems/max-area-of-island/  
https://leetcode.com/problems/flood-fill/  
https://leetcode.com/problems/coloring-a-border/  

Hash/DFS:  
https://leetcode.com/problems/employee-importance/  
https://leetcode.com/problems/find-the-town-judge/  

Cycle Find:  
https://leetcode.com/problems/find-eventual-safe-states/  

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




