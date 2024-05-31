# Graph Algorithms

## Breadth-First Search (BFS)

- BFS explores all the nodes at the present depth level before moving on to the next depth level.
- BFS uses a queue to keep track of nodes that need to be explored.
- BFS starts at a given node (often called the root in a tree or the starting node in a graph).
- To avoid revisiting nodes, BFS uses a set or an array (depending on the implementation) to keep track of visited nodes.

### Applications:

- Finding the shortest path in an unweighted graph.
- Minimum cost from source to destination.
- Level-order traversal of a tree.
- BFS can be used to find all nodes in a connected component of an undirected graph.
- BFS can be used to detect cycles in an undirected graph.
- Solving puzzles with only a few possible moves.

### Algorithm:

1. Initialize the queue with the starting node and mark it as visited.
2. While the queue is not empty:
    - Dequeue a node from the queue.
    - For each adjacent (neighboring) node:
        - If the node has not been visited, mark it as visited and enqueue it.

```java
// BFS traversal from a given source node
public void BFS(int start) {
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
```

### Complexity:

- **Time Complexity**: \(O(V + E)\), where \(V\) is the number of vertices and \(E\) is the number of edges in the graph.
- **Space Complexity**: \(O(V)\) for the queue and the visited set or array.

### Problem List

- [752. Open the Lock](https://leetcode.com/problems/open-the-lock/)
- [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)
- [1162. As Far from Land as Possible](https://leetcode.com/problems/as-far-from-land-as-possible/)
- [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
- [1091. Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
- [909. Snakes and Ladders](https://leetcode.com/problems/snakes-and-ladders/)
- [127. Word Ladder](https://leetcode.com/problems/word-ladder/)

## Depth-First Search (DFS)

The DFS algorithm is a recursive algorithm that uses the idea of backtracking. It involves exhaustive searches of all the nodes by going ahead if possible, else by backtracking.

- DFS explores as far as possible along each branch before backtracking. It dives deep into the graph/tree structure, exploring each branch to its full depth before moving to another branch.
- DFS uses backtracking to explore different paths. This makes it suitable for problems where all possible solutions need to be explored.
- Recursive DFS: Uses the call stack of the system for backtracking.
- Iterative DFS: Uses an explicit stack to simulate the recursion process.
- Disconnected Graphs: In the case of disconnected graphs, DFS will only traverse the connected component of the starting vertex. To traverse the entire graph, DFS needs to be called for every unvisited vertex.

### Applications:

- Topological Sorting
- Cycle Detection
- Finding Strongly Connected Components (SCCs)
- Path Finding and Maze Solving
- Graph Coloring and Bipartite Checking

### Algorithm:

#### Recursive DFS:

1. Initialization:
    - Start from a given source node.
    - Create a boolean array `visited[]` to mark the visited nodes.
2. DFS Function:
    - Mark the current node as visited.
    - Process the current node (e.g., print it).
    - Recur for all adjacent vertices that have not been visited yet.
3. Helper Function:
    - A recursive function to perform the actual DFS.

```java
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
```

#### Iterative DFS:

1. Initialization:
    - Start from a given source node.
    - Create a stack and push the starting node onto it.
    - Create a boolean array `visited[]` to mark the visited nodes.
2. DFS Function:
    - While the stack is not empty:
        - Pop a node from the stack.
        - If the node has not been visited:
            - Mark it as visited.
            - Process the node (e.g., print it).
            - Push all its unvisited adjacent vertices onto the stack.

```java
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
```

### Complexity:

#### Time Complexity

- \(O(V + E)\), where \(V\) is the number of vertices and \(E\) is the number of edges. This is because each vertex and each edge is explored once in the worst case.

#### Space Complexity:

- Recursive DFS: \(O(V)\) due to the call stack.
- Iterative DFS: \(O(V)\) due to the explicit stack used.

### Problem List

- [1376. Time Needed to Inform All Employees](https://leetcode.com/problems/time-needed-to-inform-all-employees/)
- [1020. Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/)
- [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)
- [1254. Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/)
- [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)
- [841. Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)
- [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
- [733. Flood Fill](https://leetcode.com/problems/flood-fill/)
- [1034. Coloring A Border](https://leetcode.com/problems/coloring-a-border/)
- [690. Employee Importance](https://leetcode.com/problems/employee-importance/)
- [997. Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)
- [802. Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/)
- [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)

## Topological Sort: Kahn’s Algorithm

### Kahn’s Algorithm

- [Course Schedule](https://leetcode.com/problems/course-schedule/)
- [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
- [Sequence Reconstruction](https://leetcode.com/problems/sequence-reconstruction/)
- [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/solution/)

## Minimum Spanning Trees: Prim's, Kruskal's Algorithm

### 4.1 Prim's Algorithm

- Start with any vertex. Use Priority Queue to process the smallest edge.
- Use a visited array or distance array.
- Difference between Prim's and Dijkstra's is “Don’t add current vertex distance to calculate neighbor distance”.
- Example:
  - Dijkstra: `dis[v] = dis[u] + graph[u][v]`
  - Prim: `dis[v] = graph[u][v]`
- Time Complexity is \(O(E \log V)\)

[Implementation](https://leetcode.com/problems/min-cost-to-connect-all-points)

### 4.2 Kruskal's Algorithm

- Sort all the edges by their weights and use union-find to avoid cycle
- Time Complexity is \(O(E \log E)\)

[Implementation](https://leetcode.com/problems/min-cost-to-connect-all-points)

- [1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree](https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/)
- [Optimize Water Distribution in a Village](https://leetcode.com/problems/optimize-water-distribution-in-a-village/)

## Single Source Shortest Paths: Bellman-Ford's, Dijkstra's Algorithm

### 5.1 Bellman-Ford

- Used with negative weights also.
- Able to find whether graph has a negative cycle.
- Not preferred over Dijkstra as time complexity of Bellman-Ford is \(O

(VE)\).
- Run this algo one more time if a negative cycle check is required. If the shortest distance of a vertex is reduced, then the graph has a negative cycle.

[Implementation](https://leetcode.com/problems/network-delay-time)

### 5.2 Dijkstra

- Used only if weights are non-negative.
- Similar to BFS but has below differences:
  - Used Priority Queue with Integer Array instead of Queue with Integer.
  - Used Distance array instead of boolean visited array.
- Time Complexity is \(O(E \log E) \approx O(E \log V)\).

[Implementation](https://leetcode.com/problems/network-delay-time)
[Implementation](https://leetcode.com/problems/cheapest-flights-within-k-stops/)

## All-Pairs Shortest Paths: Floyd-Warshall, Johnson’s Algorithm

### 6.1 Floyd-Warshall

- It prefers adjacency matrix over adjacency list.
- Time Complexity is \(O(V^3)\).
- Run this algo one more time if a negative cycle check is required. If the shortest distance of a vertex is reduced, then the graph has a negative cycle.

[1334. Find the City with the Smallest Number of Neighbors at a Threshold Distance](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/)
[399. Evaluate Division](https://leetcode.com/problems/evaluate-division/)
[787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)
[1462. Course Schedule IV](https://leetcode.com/problems/course-schedule-iv/)
[1617. Count Subtrees with Max Distance Between Cities](https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/)

### 6.2 Johnson’s Algorithm

## Strongly Connected Components

Simple DFS and visited array is used to find SCC in an undirected graph. Tarjan's algorithm and Kosaraju's algorithm are used to find SCC in directed graphs.

### 7.1 Tarjan’s Algorithm

- Used to find SCC, articulation point, bridge in graph.
- Time complexity is \(O(V + E)\).

[SCC Video](https://www.youtube.com/watch?v=aZXi1unBdJA&ab_channel=WilliamFiset)
[Bridge and Articulation Point Video](https://www.youtube.com/watch?v=aZXi1unBdJA&ab_channel=WilliamFiset)
[Implementation](https://leetcode.com/problems/critical-connections-in-a-network)

### 7.2 Kosaraju’s Algorithm

- Time Complexity is \(O(V + E)\).

[Video](https://www.youtube.com/watch?v=RpgcYiky7uw&ab_channel=TusharRoy-CodingMadeSimple)
[Implementation](https://leetcode.com/problems/course-schedule/discuss/249688/Different-O(V%2BE)-solution-using-Kosaraju's-algorithm)

## Union-Find (Disjoint Set)

Identify if problems talk about finding groups or components.

- [Friend Circles](https://leetcode.com/problems/friend-circles/)
- [Redundant Connection](https://leetcode.com/problems/redundant-connection/)
- [Most Stones Removed with Same Row or Column](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/)
- [Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)
- [Satisfiability of Equality Equations](https://leetcode.com/problems/satisfiability-of-equality-equations/)
- [Accounts Merge](https://leetcode.com/problems/accounts-merge/)
- [Connecting Cities with Minimum Cost](https://leetcode.com/problems/connecting-cities-with-minimum-cost/)

## Travelling Salesman Problem (TSP): Euler's and Hamilton's Algorithm

- It is a Hamiltonian circuit. It is a Hamiltonian path if returning to the start vertex is not needed.
- Time Complexity is \(O(N^2 \cdot 2^N)\).
- Implemented using DP with bit masking as `dp[1 << N][N]` where N is the number of vertices.

[Implementation](https://www.hackerearth.com/practice/notes/codemonk-dynamic-programming-ii-1/)
[Find the Shortest Superstring](https://leetcode.com/problems/find-the-shortest-superstring/)

### 9.1 Hamiltonian Path or TSP

- Path which traverses each vertex exactly once.
- Simple way: DFS + backtracking.

[Implementation](https://www.hackerearth.com/practice/algorithms/graphs/hamiltonian-path/tutorial/)

### 9.2 Euler Path

- Path which traverses each edge exactly once.

[Video](https://www.youtube.com/watch?v=8MpoO2zA2l4&ab_channel=WilliamFiset)
[Implementation](https://leetcode.com/problems/reconstruct-itinerary/)

## Eulerian Circuits

### 10.1 Hierholzer's Algorithm

[Implementation](https://leetcode.com/problems/reconstruct-itinerary/)

## Max-Flow, Min-Cut

### 11.1 Ford-Fulkerson Algorithm

[Implementation](https://leetcode.com/problems/maximum-students-taking-exam)

## Graph Coloring

- [Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)
- [Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)

## Connected Components Problems

- [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
- [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
- [Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)
- [Accounts Merge](https://leetcode.com/problems/accounts-merge/)
- [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/)

## Flood Fill Algorithm

[Implementation](https://leetcode.com/problems/maximum-students-taking-exam/)
