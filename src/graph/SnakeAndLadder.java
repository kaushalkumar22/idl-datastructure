package graph;

import java.util.LinkedList;
import java.util.Queue;
/*
 Given a snake and ladder board, find the minimum number of dice throws required to reach the destination 
 or last cell from source or 1st cell. Basically, the player has total control over outcome of dice throw 
 and wants to find out minimum number of throws required to reach last cell.

 The idea is to consider the given snake and ladder board as a directed graph with number of vertices 
  equal to the number of cells in the board. The problem reduces to finding the shortest path in a graph.
  Every vertex of the graph has an edge to next six vertices if next 6 vertices do not have a snake or ladder. 
  If any of the next six vertices has a snake or ladder, then the edge from current vertex goes to the 
  top of the ladder or tail of the snake. Since all edges are of equal weight, we can efficiently find 
  shortest path using Breadth First Search of the graph. 
  
  http://www.geeksforgeeks.org/snake-ladder-problem-2/
  
  Time complexity of the above solution is O(N) as every cell is added and removed only once from queue. 
  And a typical enqueue or dequeue operation takes O(1) time.
 */
public class SnakeAndLadder {


	/* 
	 * This function returns minimum number of dice throws required to Reach last cell from 0'th cell in a snake and ladder game.
	 * move[] is an array of size N where N is no. of cells on board If there is no snake or ladder from cell i, then move[i] is -1
	 * Otherwise move[i] contains cell to which snake or ladder at i takes to.
	 */
	private	static int  getMinDiceThrows(int move[], int N)
	{
		// The graph has N vertices. Mark all the vertices as not visited
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++)
			visited[i] = false;

		// Create a queue for BFS and Mark the node 0 as visited and enqueue it.
		Queue<QEntry> entryQueue = new LinkedList<QEntry>();

		visited[0] = true; 

		QEntry start = new QEntry();  // distance of 0'th vertex is also 0
		start.distance=0;
		start.vertex=0;
		entryQueue.add(start) ; // Enqueue 0'th vertex

		// Do a BFS starting from vertex at index 0
		QEntry qEntry =null; 

		while (!entryQueue.isEmpty())
		{
			qEntry = entryQueue.peek();
			int vertex = qEntry.vertex; // vertex no. of queue entry

			// If front vertex is the destination vertex, we are done
			if (vertex == N-1)
				break;

			// Otherwise dequeue the front vertex and enqueue its adjacent vertices (or cell numbers reachable through a dice throw)
			entryQueue.remove();

			for (int i=vertex+1; i<=(vertex+6) && i<N; i++)
			{
				// If this cell is already visited, then ignore
				if (!visited[i])
				{
					// Otherwise calculate its distance and mark it as visited
					QEntry a = new QEntry();
					a.distance = (qEntry.distance + 1);
					visited[i] = true;

					// Check if there a snake or ladder at 'j' then tail of snake or top of ladder become the adjacent of 'i'
					if (move[i] != -1){
						a.vertex = move[i];
					}else{
						a.vertex = i;
					}
					entryQueue.add(a);
				}
			}
		}

		// We reach here when 'qEntry' has last vertex return the distance of vertex in 'qEntry'
		return qEntry.distance;
	}

	public static void main(String[] args) {

		// Let us construct the board given in above diagram
		int N = 30;
		int board[] = new int[N];

		for (int i = 0; i<N; i++)
			board[i] = -1;

		// Ladders
		board[2] = 21;
		board[4] = 7;
		board[10] = 25;
		board[19] = 28;

		// Snakes
		board[26] = 0;
		board[20] = 8;
		board[16] = 3;
		board[18] = 6;

		System.out.println("Min Dice throws required is : "+getMinDiceThrows(board, N));
	}
	//An entry in queue used in BFS
	static class QEntry
	{
		int vertex;     // Vertex number
		int distance;  // Distance of this vertex from source
	}
}
