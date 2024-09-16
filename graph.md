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

## Topological Sort:

Topological sort is a linear ordering of vertices in a directed acyclic graph (DAG) such that for every directed edge u→v, vertex u comes before v in the ordering. This is only possible if the graph has no directed cycles, i.e., it is a DAG. 

### Applications
- Task Scheduling
- Software Dependency Resolution
- Compiler Optimizations
- Course Scheduling

### Topological Sort Algorithms

#### 1. Kahn’s Algorithm (BFS-based)

Kahn's Algorithm uses the concept of in-degrees:

- Calculate in-degrees (number of incoming edges) for all vertices.
- Initialize a queue with all vertices having in-degree 0.
- While the queue is not empty:
  - Dequeue a vertex from the queue, add it to the topological order.
  - Reduce the in-degree of all adjacent vertices by 1.
  - If the in-degree of an adjacent vertex becomes 0, enqueue it.
- If all vertices are processed, the graph is a DAG and the topological order is valid. If not, the graph has at least one cycle, and topological sorting is not possible.

```java
public List<Integer> topologicalSort(int vertices, List<List<Integer>> adj) {
    int[] inDegree = new int[vertices];
    for (int i = 0; i < vertices; i++) {
        for (int neighbor : adj.get(i)) {
            inDegree[neighbor]++;
        }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < vertices; i++) {
        if (inDegree[i] == 0) {
            queue.add(i);
        }
    }

    List<Integer> topoOrder = new ArrayList<>();
    while (!queue.isEmpty()) {
        int node = queue.poll();
        topoOrder.add(node);

        for (int neighbor : adj.get(node)) {
            inDegree[neighbor]--;
            if (inDegree[neighbor] == 0) {
                queue.add(neighbor);
            }
        }
    }

    if (topoOrder.size() != vertices) {
        throw new RuntimeException("Graph has at least one cycle, topological sort not possible.");
    }

    return topoOrder;
}
```
#### Complexity

- Time Complexity: O(V+E):
    The outer for loop will be executed V number of times and the inner for loop will be executed E number of times.
- Auxiliary Space: O(V):  
    The queue needs to store all the vertices of the graph. So the space required is O(V)

### 2. DFS-based Algorithm

The DFS-based algorithm uses the concept of backtracking and post-order:

- Perform a DFS traversal of the graph.
- Use a boolean array to mark all the vertices as not visited.
- Use a stack to store the vertices in the order of their finishing times (i.e., when a vertex has no more unvisited adjacent vertices).
- For every unvisited vertex, call the recursive helper function.
- In the helper function, mark the current vertex as visited.
  - Recur for all its adjacent vertices.
  - Push the current vertex onto the stack.
- Pop all vertices from the stack to get the topological order.

```java
public List<Integer> topologicalSortDFS(int vertices, List<List<Integer>> adj) {
    boolean[] visited = new boolean[vertices];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < vertices; i++) {
        if (!visited[i]) {
            dfs(i, visited, stack, adj);
        }
    }

    List<Integer> topoOrder = new ArrayList<>();
    while (!stack.isEmpty()) {
        topoOrder.add(stack.pop());
    }

    return topoOrder;
}

private void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
    visited[node] = true;

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, visited, stack, adj);
        }
    }

    stack.push(node);
}
```

### Problems
- [Course Schedule](https://leetcode.com/problems/course-schedule/)
- [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
- [Sequence Reconstruction](https://leetcode.com/problems/sequence-reconstruction/)
- [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/solution/)
- [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/description/)
- [Parallel Courses](https://leetcode.com/problems/parallel-courses/description/)

## Minimum Spanning Trees: Prim's, Kruskal's Algorithm

A Minimum Spanning Tree (MST) is a subset of the edges of a connected, undirected graph that connects all the vertices together, without any cycles, and with the minimum possible total edge weight. In other words, an MST is a tree that spans all the vertices in the graph and has the least total edge weight among all possible spanning trees.

## Properties of Minimum Spanning Trees

- **Uniqueness**: An MST of a graph is unique if all the edge weights are distinct.
- **Total Weight**: The total weight of an MST is always less than or equal to the total weight of any other spanning tree.
- **Equal Edge Weights**: If all edges have the same weight, every spanning tree is an MST.

## Applications

- **Network Design**: Constructing economical networks such as electrical grids, computer networks, road networks, and telecommunication networks.
- **Approximation Algorithms**: Used in algorithms for solving NP-hard problems like the Traveling Salesman Problem (TSP).
- **Cluster Analysis**: MST can be used in hierarchical clustering, where clusters are formed based on minimum distance.

## Example Graph

Given a graph with vertices {A, B, C, D, E} and edges with weights:

- (A, B, 1)
- (A, C, 3)
- (B, C, 3)
- (B, D, 6)
- (C, D, 4)
- (C, E, 2)
- (D, E, 5)

## Kruskal's Algorithm

Kruskal's algorithm builds the MST by sorting all edges and adding the smallest edge to the MST if it doesn't form a cycle with the edges already included. This uses the Union-Find data structure to detect cycles.

### Algorithm

1. Sort all edges in non-decreasing order of their weights.
2. Initialize a Union-Find data structure to manage the components.
3. Iterate through the sorted edges and add each edge to the MST if it doesn't form a cycle.
4. Continue until the MST includes \(V-1\) edges, where \(V\) is the number of vertices.

### Time Complexity

The time complexity of Kruskal's algorithm is \(O(E \log E)\), which simplifies to \(O(E \log V)\) because the number of edges \(E\) is at most \(V^2\).

### Implementation

```java
class Kruskal {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int u) {
            if (u != parent[u]) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }

    public int kruskalMST(int vertices, List<Edge> edges) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(vertices);
        int mstWeight = 0;

        for (Edge edge : edges) {
            int srcRoot = uf.find(edge.src);
            int destRoot = uf.find(edge.dest);
            if (srcRoot != destRoot) {
                mstWeight += edge.weight;
                uf.union(srcRoot, destRoot);
            }
        }

        return mstWeight;
    }
}
```

### Steps with the Example Graph

1. Sort edges by weight: (A, B, 1), (C, E, 2), (A, C, 3), (B, C, 3), (C, D, 4), (D, E, 5), (B, D, 6).
2. Start with (A, B).
3. Add (C, E) (no cycle).
4. Add (A, C) (no cycle).
5. Add (C, D) (no cycle).
6. Stop since we have \(V-1\) edges.

## Prim's Algorithm

Prim's algorithm grows the MST by starting from an arbitrary vertex and repeatedly adding the minimum weight edge that connects a vertex in the growing MST to a vertex outside it.

### Algorithm

1. Start with any vertex. Initialize a priority queue to process the smallest edge.
2. Use a visited array or distance array to track the inclusion of vertices in the MST.
3. While there are vertices not yet included in the MST:
    - Extract the minimum weight edge from the priority queue.
    - Include the corresponding vertex in the MST.
    - Update the priority queue with edges connected to the newly included vertex.
    - Ensure that edges connecting two included vertices are ignored.

### Time Complexity

The time complexity of Prim's algorithm is \(O(E \log V)\), where \(E\) is the number of edges and \(V\) is the number of vertices.

### Implementation

```java
class Prim {
    class Edge {
        int vertex, weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public int primMST(int vertices, List<List<Edge>> adj) {
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        int mstWeight = 0;

        pq.add(new Edge(0, 0)); // Start with vertex 0

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int vertex = edge.vertex;

            if (visited[vertex]) continue;

            visited[vertex] = true;
            mstWeight += edge.weight;

            for (Edge neighbor : adj.get(vertex)) {
                if (!visited[neighbor.vertex]) {
                    pq.add(new Edge(neighbor.vertex, neighbor.weight));
                }
            }
        }

        return mstWeight;
    }
}
```

### Steps with the Example Graph

1. Start with vertex A. Current MST: A.
2. Add edge (A, B) (minimum edge). Current MST: A-B.
3. Add edge (A, C) (minimum edge). Current MST: A-B-A-C.
4. Add edge (C, E) (minimum edge). Current MST: A-B-A-C-E.
5. Add edge (C, D) (minimum edge). Current MST: A-B-A-C-E-D.

## Problems
- [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points)
- [Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree](https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/)
- [Optimize Water Distribution in a Village](https://leetcode.com/problems/optimize-water-distribution-in-a-village/)

        
## Single Source Shortest Paths: Bellman-Ford's, Dijkstra's Algorithm

Single Source Shortest Paths (SSSP) is a classic problem in graph theory. The goal is to find the shortest path from a given source vertex to all other vertices in a weighted graph. There are two widely used algorithms to solve this problem: Dijkstra's algorithm and the Bellman-Ford algorithm.

### Dijkstra's Algorithm

Dijkstra's algorithm is used to find the shortest paths from a single source vertex to all other vertices in a graph with non-negative edge weights.

#### Steps of Dijkstra's Algorithm

1. Initialize distances from the source to all vertices as infinite, except for the source itself, which is set to 0.
2. Create a priority queue (min-heap) and insert the source vertex with distance 0.
3. While the priority queue is not empty:
    - Extract the vertex with the minimum distance (let's call it u).
    - For each neighbor v of u:
        - If the distance to v through u is less than the current distance to v:
            - Update the distance to v.
            - Insert v into the priority queue with the updated distance.

#### Time Complexity

- Time Complexity: \(O((V+E) \log V)\), where \(V\) is the number of vertices and \(E\) is the number of edges, assuming the use of a priority queue.

#### Java Implementation

```java
class Dijkstra {
    class Edge {
        int vertex, weight;
        
        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int vertices, List<List<Edge>> adj, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        pq.add(new Edge(source, 0));
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.vertex;
            
            for (Edge neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }
        
        return dist;
    }
}
```

#### Example

Consider a graph with vertices \(\{A,B,C,D,E\}\) and edges with weights:

- \((A,B,4)\)
- \((A,C,1)\)
- \((C,B,2)\)
- \((B,D,5)\)
- \((C,D,8)\)
- \((D,E,3)\)
- \((C,E,10)\)

To find the shortest paths from \(A\):

1. Initialize distances: \(\{A:0,B:∞,C:∞,D:∞,E:∞\}\).
2. Start with \(A\) and update distances of its neighbors: \(\{A:0,B:4,C:1,D:∞,E:∞\}\).
3. Extract \(C\) and update distances: \(\{A:0,B:3,C:1,D:9,E:11\}\).
4. Extract \(B\) and update distances: \(\{A:0,B:3,C:1,D:8,E:11\}\).
5. Continue until all vertices are processed.

#### Example Problems

- Leetcode: Network Delay Time
- Leetcode: Cheapest Flights Within K Stops

### Bellman-Ford Algorithm

The Bellman-Ford algorithm is used to find the shortest paths from a source vertex to all other vertices in a graph that may have negative edge weights. It can also detect negative weight cycles.

#### Steps of Bellman-Ford Algorithm

1. Initialize distances from the source to all vertices as infinite, except for the source itself, which is set to 0.
2. For each vertex, repeat the following steps \(V-1\) times (where \(V\) is the number of vertices):
    - For each edge \((u,v)\) with weight \(w\):
        - If the distance to \(v\) through \(u\) is less than the current distance to \(v\):
            - Update the distance to \(v\).
3. Check for negative-weight cycles by repeating the edge relaxation step one more time. If any distance is updated, a negative weight cycle exists.

#### Time Complexity

- Time Complexity: \(O(VE)\), where \(E\) is the number of edges and \(V\) is the number of vertices.

#### Example

Consider the same graph with vertices \(\{A,B,C,D,E\}\) and edges with weights as before:

- \((A,B,4)\)
- \((A,C,1)\)
- \((C,B,2)\)
- \((B,D,5)\)
- \((C,D,8)\)
- \((D,E,3)\)
- \((C,E,10)\)

To find the shortest paths from \(A\):

1. Initialize distances: \(\{A:0,B:∞,C:∞,D:∞,E:∞\}\).
2. Relax edges repeatedly:
    - After first pass: \(\{A:0,B:4,C:1,D:∞,E:∞\}\).
    - After second pass: \(\{A:0,B:3,C:1,D:8,E:∞\}\).
    - After third pass: \(\{A:0,B:3,C:1,D:8,E:11\}\).
3. Continue until no further updates.

#### Java Implementation

```java
class BellmanFord {
    class Edge {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int[] bellmanFord(int vertices, List<Edge> edges, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;
                
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        
        // Check for negative weight cycles
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
            }
        }
        
        return dist;
    }
}
```

#### Example Problems

- [743. Network Delay Time]( https://leetcode.com/problems/network-delay-time)   
- [787. Cheapest Flights Within K Stops]( https://leetcode.com/problems/cheapest-flights-within-k-stops/)

### Differences

- **Dijkstra's Algorithm:** Efficient for graphs with non-negative weights, faster with priority queue implementation.
- **Bellman-Ford Algorithm:** Handles negative weights and detects negative weight cycles, but less efficient for large graphs with many edges.

## All-Pairs Shortest Paths: Floyd-Warshall, Johnson’s Algorithm

The All-Pairs Shortest Paths (APSP) problem involves finding the shortest paths between every pair of vertices in a given weighted graph.

### Floyd-Warshall Algorithm

The Floyd-Warshall algorithm is a dynamic programming approach that can handle graphs with negative weights (but no negative weight cycles).

#### Algorithm

1. Create a 2D array dist where dist[i][j] represents the shortest distance from vertex i to vertex j.
2. Initialize dist[i][i] = 0 for all vertices i.
3. Initialize dist[i][j] = weight(i, j) if there is an edge from i to j, otherwise set it to infinity.

#### Dynamic Programming

1. For each vertex k:
    - Update dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]) for all pairs of vertices i and j.

#### Time Complexity

- Time Complexity: \(O(V^3)\), where \(V\) is the number of vertices.

#### Java Implementation

```java
class FloydWarshall {
    final static int INF = 99999;

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print

(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

#### Example

Consider a graph with vertices \(\{A,B,C,D\}\) and the following edge weights:

- \((A,B,3)\)
- \((A,C,8)\)
- \((A,D,∞)\)
- \((B,C,2)\)
- \((B,D,5)\)
- \((C,D,1)\)
- \((D,A,7)\)

Initial distance matrix \(D\):

\[ \begin{matrix}
   & A & B & C & D \\
A & 0 & 3 & 8 & ∞ \\
B & ∞ & 0 & 2 & 5 \\
C & ∞ & ∞ & 0 & 1 \\
D & 7 & ∞ & ∞ & 0 \\
\end{matrix} \]

After running the algorithm, the final distance matrix \(D\) would reflect the shortest paths between all pairs of vertices.

#### Example Problems

- [1334. Find the City with the Smallest Number of Neighbors at a Threshold Distance](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/)
- [399. Evaluate Division](https://leetcode.com/problems/evaluate-division/)
- [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)
- [1462. Course Schedule IV](https://leetcode.com/problems/course-schedule-iv/)
- [1617. Count Subtrees with Max Distance Between Cities](https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/)

### Johnson's Algorithm

Johnson's algorithm is more efficient for sparse graphs and uses a combination of Bellman-Ford and Dijkstra's algorithms.

#### Algorithm

1. Add a new vertex \(s\) to the graph, connecting \(s\) to every other vertex with edge weight 0.
2. Use the Bellman-Ford algorithm to find the shortest path distances from \(s\) to every other vertex. If a negative weight cycle is detected, terminate as the APSP problem cannot be solved.
3. Reweight the edges of the original graph to ensure all edge weights are non-negative.
4. Use Dijkstra's algorithm to find the shortest paths from each vertex to every other vertex in the reweighted graph.
5. Adjust the distances obtained in step 4 to get the actual shortest path distances in the original graph.

#### Time Complexity

- Time Complexity: \(O(V^2 \log V + VE)\), where \(V\) is the number of vertices and \(E\) is the number of edges.

#### Example

Consider a graph with vertices \(\{A,B,C,D\}\) and the following edge weights:

- \((A,B,1)\)
- \((B,C,-2)\)
- \((C,D,2)\)
- \((D,A,-1)\)

1. Add a new vertex \(s\) and connect it to all vertices with edge weight 0.
2. Run Bellman-Ford from \(s\). If no negative cycle, proceed to reweighting.
3. Reweight edges using the distances obtained.
4. Run Dijkstra's algorithm from each vertex in the reweighted graph.
5. Adjust the distances to get the actual shortest path distances.

#### Implementation

```java
class Johnson {
    class Edge {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    int INF = Integer.MAX_VALUE;

    public int[][] johnson(int vertices, List<Edge> edges) {
        int[] h = new int[vertices + 1];
        Arrays.fill(h, INF);
        h[vertices] = 0;

        // Add new vertex and run Bellman-Ford
        for (int i = 0; i < vertices; i++) {
            for (Edge edge : edges) {
                if (h[edge.src] != INF && h[edge.src] + edge.weight < h[edge.dest]) {
                    h[edge.dest] = h[edge.src] + edge.weight;
                }
            }
        }

        // Reweight the edges
        int[][] dist = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (Edge edge : edges) {
            int weight = edge.weight + h[edge.src] - h[edge.dest];
            dist[edge.src][edge.dest] = weight;
        }

        // Run Dijkstra for each vertex
        for (int i = 0; i < vertices; i++) {
            dijkstra(dist, vertices, i);
        }

        return dist;
    }

    void dijkstra(int[][] graph, int vertices, int src) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        pq.add(new Edge(src, src, 0));
        int[] dist = new int[vertices];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Edge(u, v, dist[v]));
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            graph[src][i] = dist[i];
        }
    }
}
```

#### Example Problems

- Leetcode: Cheapest Flights Within K Stops
- Leetcode: Course Schedule IV

### Key Differences and Use Cases

- **Floyd-Warshall Algorithm:** Simple and easy to implement, suitable for dense graphs, but not efficient for large graphs due to its \(O(V^3)\) complexity.
- **Johnson's Algorithm:** More efficient for sparse graphs, uses both Bellman-Ford and Dijkstra's algorithms, and handles negative weights, but not suitable if the graph contains negative weight cycles.
    
## Strongly Connected Components

Simple DFS and visited array are used to find SCC in an undirected graph. Tarjan's algorithm and Kosaraju's algorithm are used to find SCC in directed graphs.

### Tarjan’s Algorithm

Tarjan's algorithm uses depth-first search (DFS) to find all SCCs in a graph. It maintains a stack to keep track of the visited vertices and ensures that the vertices are considered in the order of their DFS completion times.

#### Steps:

1. **Start DFS from each unvisited vertex.**
2. **During DFS, maintain three attributes for each vertex:**
    - Discovery time (when the vertex is first visited)
    - Low link value (the lowest discovery time of any vertex reachable from the current vertex)
    - A boolean flag indicating whether the vertex is on the stack.
3. **While traversing edges, push vertices onto the stack and update their low link values.**
4. **When a vertex with a low link value equal to its discovery time is found, it indicates the start of an SCC.**
5. **Pop vertices from the stack until the current vertex is reached.**

#### Algorithm

```plaintext
Initialization:
    Create an array disc[] to store the discovery times of visited vertices.
    Create an array low[] to store the lowest vertex reachable from the subtree rooted with the vertex.
    Create a stack st to store all visited vertices.
    Maintain a boolean array stackMember[] to check if a vertex is in the stack.

DFS Traversal:
    For every unvisited vertex, perform DFS.
    During DFS, update disc[] and low[].
    If the vertex v is not visited and is reachable from the subtree rooted with u, update low[u].
    If u is the root of an SCC, pop the stack until u is found.
```

#### Time Complexity

Time Complexity: \(O(V + E)\), where \(V\) is the number of vertices and \(E\) is the number of edges.

#### Example Implementation

```java
class TarjanSCC {
    private int time = 0;
    private static final int NIL = -1;

    void SCCUtil(int u, int disc[], int low[], Stack<Integer> st, boolean stackMember[], List<Integer>[] adj) {
        disc[u] = low[u] = ++time;
        st.push(u);
        stackMember[u] = true;

        for (int v : adj[u]) {
            if (disc[v] == -1) {
                SCCUtil(v, disc, low, st, stackMember, adj);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        int w = -1;
        if (low[u] == disc[u]) {
            while (w != u) {
                w = st.pop();
                System.out.print(w + " ");
                stackMember[w] = false;
            }
            System.out.println();
        }
    }

    void SCC(List<Integer>[] adj, int V) {
        int disc[] = new int[V];
        int low[] = new int[V];
        boolean stackMember[] = new boolean[V];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(disc, NIL);
        Arrays.fill(low, NIL);

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                SCCUtil(i, disc, low, st, stackMember, adj);
        }
    }
}
```

### Example Problems

- [SCC Video](https://www.youtube.com/watch?v=aZXi1unBdJA&ab_channel=WilliamFiset)
- [Bridge and Articulation Point Video](https://www.youtube.com/watch?v=aZXi1unBdJA&ab_channel=WilliamFiset)
- [Implementation](https://leetcode.com/problems/critical-connections-in-a-network)
- [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)

### Kosaraju’s Algorithm

Kosaraju's Algorithm is a widely used algorithm to find Strongly Connected Components in a directed graph.

#### Steps:

1. **Phase 1: DFS to find finishing times**
    - Perform a Depth-First Search (DFS) on the graph, recording the finishing time of each vertex when it completes exploration (i.e., when all vertices reachable from it have been explored).
    - Create a stack and push vertices onto it in the order of their finishing times.
2. **Phase 2: DFS to find SCCs**
    - Reverse the direction of all edges in the graph.
    - Pop vertices from the stack one by one.
    - Perform DFS on each popped vertex. Each DFS traversal starting from a vertex will find one SCC.

#### Algorithm

```plaintext
First Pass (Order of Finish Time):
    Perform a DFS on the graph and push each vertex onto a stack when its DFS is complete.

Transpose Graph:
    Reverse all the edges of the graph to obtain the transpose graph.

Second Pass (On Transposed Graph):
    Pop vertices from the stack and perform DFS on the transposed graph.
    Each DFS call in this step gives a strongly connected component.
```

#### Time Complexity

Time Complexity: \(O(V + E)\), where \(V\) is the number of vertices and \(E\) is the number of edges.

#### Example Implementation

```java
class KosarajuSCC {
    private int V;
    private List<Integer>[] adj;

    KosarajuSCC(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n]) {
                fillOrder(n, visited, stack);
            }
        }
        stack.push(v);
    }

    KosarajuSCC getTranspose() {
        KosarajuSCC g = new KosarajuSCC(V);
        for (int v = 0; v < V; v++) {
            for (int i : adj[v]) {
                g.adj[i].add(v);
            }
        }
        return g;
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        KosarajuSCC transposedGraph = getTranspose();
        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                transposedGraph.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }
}
```

### Example Problems

- [Video](https://www.youtube.com/watch?v=RpgcYiky7uw&ab_channel=TusharRoy-CodingMadeSimple)
- [Implementation](https://leetcode.com/problems/course-schedule/discuss/249688/Different-O(V%2BE)-solution-using-Kosaraju's-algorithm)
- [Course Schedule](https://leetcode.com/problems/course-schedule/)
- [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)
- [A Walk to Remember](https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/practice-problems/algorithm/a-walk-to-remember-qualifier2/submissions/)
- [YouTube Video](https://www.youtube.com/watch?v=aZXi1unBdJA)

## Union-Find (Disjoint Set)

Union-Find, also known as Disjoint Set, is a data structure that keeps track of a set of elements partitioned into disjoint subsets. It supports two main operations: union, which merges two sets, and find, which determines which set a particular element belongs to. Union-Find is commonly used for solving problems related to connectivity in graphs.

### Basics of Union-Find

- **Initialization**: Initially, each element is in its own set, representing a singleton set.
- **Union Operation**: Merge two sets into one by connecting their representatives.
- **Find Operation**: Determine which set a particular element belongs to. It returns the representative of the set to which the element belongs.

### Path Compression and Union by Rank

Two optimization techniques commonly used with Union-Find are Path Compression and Union by Rank.

- **Path Compression**: During the find operation, each visited node on the path to the root is connected directly to the root. This flattens the structure of the tree, reducing the time complexity of future find operations.
- **Union by Rank**: During the union operation, the tree with the smaller rank (depth) is attached to the root of the tree with the larger rank. This helps keep the tree balanced, ensuring better overall performance.

### Applications:

- Kruskal's algorithm for finding Minimum Spanning Trees
- Cycle detection in graphs
- Connected components in an undirected graph
- Dynamic connectivity in social networks and computer networks

### Time Complexity:

With Path Compression and Union by Rank optimizations, both Find and Union operations have nearly

 constant time complexity, \(O(\alpha(n))\), where \(\alpha\) is the inverse Ackermann function.

### Implementation

```java
class UnionFind {
    private int[] parent, rank;

    UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }
}
```

### Example Problems

- [Number of Islands](https://leetcode.com/problems/number-of-islands/)
- [Redundant Connection](https://leetcode.com/problems/redundant-connection/)
- [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)
- [The Earliest Moment When Everyone Become Friends](https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/)
- [Optimize Water Distribution in a Village](https://leetcode.com/problems/optimize-water-distribution-in-a-village/)
- [Connecting Cities With Minimum Cost](https://leetcode.com/problems/connecting-cities-with-minimum-cost/)
- [Bridges in a Graph](https://www.geeksforgeeks.org/bridge-in-a-graph/)

By using Union-Find and Strongly Connected Components algorithms, many complex graph problems can be solved efficiently, ensuring optimal performance even for large datasets.


Here's the revised version of the `git.md` file with a more structured and organized approach:

---

## Travelling Salesman Problem (TSP)

The Traveling Salesman Problem (TSP) is a classic optimization problem where the goal is to find the shortest possible route that visits each city exactly once and returns to the original city. TSP is a well-known NP-hard problem, meaning that there is no known polynomial-time algorithm that can solve all instances optimally.

### Brute Force Approach

The most straightforward way to solve the TSP is to try all possible permutations of the cities and calculate the total distance for each permutation. The shortest route found among all permutations would be the optimal solution. However, this approach becomes impractical as the number of cities increases due to its exponential time complexity.

### Dynamic Programming Approach

Dynamic Programming (DP) can be used to solve TSP efficiently for smaller instances. The idea is to store the subproblem solutions in a table and reuse them to compute larger subproblems. The DP approach is based on the principle of overlapping subproblems and optimal substructure.

#### Example Implementation

```java
class TSP {
    private static final int INF = Integer.MAX_VALUE;

    // Function to calculate the shortest tour that visits all cities
    // and returns to the starting city
    public int tsp(int[][] graph, int N) {
        // Initialize dp table with all entries set to infinity
        int[][] dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        // Base case: Starting from city 0 and ending at city 0
        dp[0][1] = 0;
        
        // Iterate over all possible subsets of cities
        for (int mask = 1; mask < (1 << N); mask++) {
            for (int u = 0; u < N; u++) {
                // If city u is not in the current subset, skip
                if ((mask & (1 << u)) == 0) continue;
                for (int v = 0; v < N; v++) {
                    // If city v is already visited or same as u, skip
                    if (u == v || (mask & (1 << v)) != 0) continue;
                    // Update the minimum distance
                    dp[v][mask | (1 << v)] = Math.min(dp[v][mask | (1 << v)], dp[u][mask] + graph[u][v]);
                }
            }
        }
        
        // Minimum tour distance will be the minimum value in the last row of the dp table
        int minDist = INF;
        for (int v = 0; v < N; v++) {
            minDist = Math.min(minDist, dp[v][(1 << N) - 1]);
        }
        return minDist;
    }
}
```

#### Example Problem

- [Find the Shortest Superstring](https://leetcode.com/problems/find-the-shortest-superstring/)

### Approximation Algorithms

For larger instances of TSP, approximation algorithms like the Nearest Neighbor Algorithm, the Christofides Algorithm, and the Lin-Kernighan Heuristic are commonly used to find suboptimal solutions with reasonable time complexity.

### Key Points

- TSP is a Hamiltonian circuit. It is a Hamiltonian path if returning to the start vertex is not needed.
- Time Complexity is \(O(N^2 \cdot 2^N)\).
- Implemented using DP with bit masking as `dp[1 << N][N]` where N is the number of vertices.

#### Additional Resources

- [Implementation](https://www.hackerearth.com/practice/notes/codemonk-dynamic-programming-ii-1/)
- [Find the Shortest Superstring](https://leetcode.com/problems/find-the-shortest-superstring/)

---

## Eulerian Path/Cycle & Hamiltonian Path/Cycle

Euler's and Hamilton's algorithms are both related to finding paths in graphs, but they address different types of paths: Eulerian and Hamiltonian paths/cycles, respectively.

### Eulerian Path/Cycle

An Eulerian path in a graph is a path that traverses each edge of the graph exactly once. If the path ends at the same vertex where it started, it is called an Eulerian cycle. A graph can have an Eulerian path or cycle if and only if all vertices have even degrees (or exactly two vertices have odd degrees in the case of a path).

#### Euler's Algorithm

Euler's algorithm is used to find Eulerian paths or cycles in a graph. The algorithm starts at a specified vertex and traverses edges until it returns to the starting vertex while covering every edge exactly once.

#### Example Problem

- [Video](https://www.youtube.com/watch?v=8MpoO2zA2l4&ab_channel=WilliamFiset)
- [Implementation](https://leetcode.com/problems/reconstruct-itinerary/)

### Hamiltonian Path/Cycle

A Hamiltonian path in a graph is a path that visits each vertex exactly once. If the path ends at the same vertex where it started, it is called a Hamiltonian cycle.

#### Example Problem

- [Find the Shortest Superstring](https://leetcode.com/problems/find-the-shortest-superstring/)
- [Implementation](https://www.hackerearth.com/practice/algorithms/graphs/hamiltonian-path/tutorial/)

### Differences

- **Eulerian paths/cycles** involve traversing each edge exactly once, while **Hamiltonian paths/cycles** involve visiting each vertex exactly once.
- Eulerian paths/cycles can be found efficiently using Euler's algorithm if certain conditions are met, whereas finding Hamiltonian paths/cycles is generally more difficult and often requires exponential time algorithms for general graphs.

### Hierholzer's Algorithm

Hierholzer's algorithm is a method for finding Eulerian cycles and paths in a graph. It efficiently computes a cycle that traverses each edge of a graph exactly once, given that the graph has an Eulerian cycle or path.

#### Algorithm Steps

1. **Choose a Starting Vertex**: Start at any vertex of the graph. If the graph has an Eulerian cycle, this vertex will be the starting and ending point of the cycle. If the graph has an Eulerian path, this vertex will be the starting point.
2. **Follow Edges**: From the chosen starting vertex, follow any available edge to an adjacent vertex. If there are multiple choices, select an arbitrary edge.
3. **Repeat Until Exhausted**: Continue following edges, visiting each edge exactly once, until returning to the starting vertex. If a vertex has multiple edges, select edges in any order.
4. **Backtrack as Necessary**: If a vertex has no more unvisited edges, backtrack to the previous vertex that still has unvisited edges. Continue the process from there.
5. **Combine Paths**: If the graph has multiple disconnected components, repeat steps 1-4 for each component. Finally, combine the Eulerian cycles or paths of each component into a single Eulerian cycle or path for the entire graph.

#### Time Complexity

- The overall time complexity of Hierholzer's algorithm is \(O(E)\).

#### Example Implementation

```java
class Graph {
    private int V;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public List<Integer> eulerianCycle() {
        List<Integer> cycle = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] inDegree = new int[V];

        // Calculate in-degree for each vertex
        for (int i = 0; i < V; ++i) {
            inDegree[i] = adj[i].size();
        }

        // Start DFS from any vertex
        stack.push(0);

        while (!stack.isEmpty()) {
            int u = stack.peek();
            if (inDegree[u] == 0) {
                cycle.add(u);
                stack.pop();
            } else {
                int v = adj[u].remove(0);
                adj[v].remove(Integer.valueOf(u)); // Remove back edge
                inDegree[u]--;
                inDegree[v]--;
                stack.push(v);
            }
        }

        return cycle;
    }
}
```

#### Example Problem

- [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/)

---

## Max-Flow, Min-Cut

Max-Flow, Min-Cut is a classic problem in graph theory and network flows. It involves finding the maximum flow that can be sent from a source node to a sink node in a flow network, while minimizing the capacity of the cut that separates the source from the sink.

### Max-Flow Problem

Given a flow network with capacities on edges and a source vertex \(s\) and a sink vertex \(t\), the goal is to find the maximum flow from \(s\) to \(t\) while satisfying capacity constraints on edges and flow conservation at vertices.

#### Ford-Fulkerson Algorithm

Ford-Fulkerson is a well-known algorithm for solving the max-flow problem. It iteratively augments the flow along augmenting paths from \(s\) to \(t\) until no augmenting path exists. The algorithm can be implemented using various methods to find augmenting paths, such as DFS or BFS.

### Min-Cut Problem

A cut in a flow network is a partition of the vertices into two disjoint sets \(S\) and \(T\

), such that the source \(s\) is in \(S\) and the sink \(t\) is in \(T\). The capacity of a cut is the sum of capacities of edges from \(S\) to \(T\).

### Min-Cut Theorem

The value of the maximum flow in a flow network equals the capacity of the minimum cut.

### Applications

- Network flow problems: transportation networks, communication networks, etc.
- Assignment and scheduling problems.
- Bipartite matching problems.
- Network reliability analysis.

### Example Problem

- **Maximum Flow Problem**: Given a network of pipes with various capacities, find the maximum amount of water that can flow from a source pipe to a destination pipe.
- **Minimum Cut Problem**: Given a communication network with various connections between nodes, identify the minimum number of connections that, if removed, would disconnect the network.

### Ford-Fulkerson Algorithm Steps

1. **Initialization**: Start with a flow of zero on all edges.
2. **Find Augmenting Paths**: Repeat until no augmenting path exists from the source \(s\) to the sink \(t\):
    - Use a path-finding algorithm (such as BFS or DFS) to find an augmenting path from \(s\) to \(t\).
    - An augmenting path is a simple path from \(s\) to \(t\) along which additional flow can be sent.
3. **Augment the Flow**: Along the augmenting path found in step 2, determine the maximum amount of flow that can be sent (limited by the capacity of the bottleneck edge). Increase the flow along this path by this maximum amount.
4. **Repeat**: Go back to step 2 and repeat until no augmenting path exists.

```python
def ford_fulkerson(graph, source, sink):
    parent = [-1] * len(graph)
    max_flow = 0
    
    def bfs(source, sink):
        visited = [False] * len(graph)
        queue = []
        queue.append(source)
        visited[source] = True
        
        while queue:
            u = queue.pop(0)
            for ind, val in enumerate(graph[u]):
                if visited[ind] == False and val > 0:
                    queue.append(ind)
                    visited[ind] = True
                    parent[ind] = u
                    if ind == sink:
                        return True
        return False

    while bfs(source, sink):
        path_flow = float("Inf")
        s = sink
        
        while s != source:
            path_flow = min(path_flow, graph[parent[s]][s])
            s = parent[s]
        
        v = sink
        while v != source:
            u = parent[v]
            graph[u][v] -= path_flow
            graph[v][u] += path_flow
            v = parent[v]
        
        max_flow += path_flow
    
    return max_flow
```

#### Complexity

The time complexity of the Ford-Fulkerson algorithm depends on the choice of path-finding algorithm used to find augmenting paths. Using breadth-first search (BFS) to find augmenting paths yields a time complexity of \(O(E \cdot |f|)\), where \(|f|\) is the maximum flow value and \(E\) is the number of edges. In the worst case, the algorithm may require \(O(|f|)\) iterations, resulting in a total time complexity of \(O(E \cdot |f|^2)\).

#### Example Problem

- [Maximum Students Taking Exam](https://leetcode.com/problems/maximum-students-taking-exam)

---

## Graph Coloring

Graph coloring is a fundamental problem in graph theory that involves assigning colors to the vertices of a graph such that no two adjacent vertices share the same color. The minimum number of colors required to color a graph without any adjacent vertices sharing the same color is called the chromatic number of the graph.

### Example Problems

- [Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)
- [Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)

---

## Connected Components Problems

A connected component of an undirected graph is a maximal subset of vertices such that there is a path between every pair of vertices in the subset. In other words, within each connected component, every vertex is reachable from every other vertex by traversing edges of the graph.

### Example Problems

- [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
- [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
- [Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)
- [Accounts Merge](https://leetcode.com/problems/accounts-merge/)
- [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/)

---

## Flood Fill Algorithm

The Flood Fill Algorithm is a technique used to determine a connected area within a grid or bitmap and replace or manipulate its color. It is commonly used in image processing, computer graphics, and various other applications involving grid-based data structures.

### Example Problem

- [Flood Fill](https://leetcode.com/problems/flood-fill/)

---

This structured approach helps in understanding each problem and algorithm clearly and provides relevant examples and implementations for better comprehension.
