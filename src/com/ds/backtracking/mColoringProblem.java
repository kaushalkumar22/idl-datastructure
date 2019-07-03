package com.ds.backtracking;
/* Create following graph and test whether it is 3 colorable
(3)---(2)
 |   / |
 |  /  |
 | /   |
(0)---(1)

	 */

public class mColoringProblem {

	private static final int V = 4;
	
	public static void main(String args[]){
		int color[] = new int[V]; // Initialize all color values as 0
		int m = 3; // Number of colors
		int graph[][] = {
				{0, 1, 1, 1},
				{1, 0, 1, 0},
				{1, 1, 0, 1},
				{1, 0, 1, 0},
		};
		if (!graphColoringUtil(graph, m, color, 0)){
			System.out.println("Solution does not exist");
		}else{
			printSolution(color);
		}
	}
	
	/* This function solves the m Coloring problem using Backtracking. It mainly uses graphColoringUtil()
       to solve the problem. It returns false if the m colors cannot be assigned, otherwise return true
       and  prints assignments of colors to all vertices. Please note that there  may be more than one
       solutions, this function prints one of the feasible solutions.
	 */
	private static boolean graphColoringUtil(int graph[][], int m,int color[], int v){

		if (v == V)   // base case: If all vertices are assigned a color then return true
			return true;

		for (int c = 1; c <= m; c++){         // Consider this vertex v and try different colors

			if (isValidColor(v, graph, color, c)){  // Check if assignment of color c to v is fine
				color[v] = c;
				if (graphColoringUtil(graph, m,color, v + 1))  // recur to assign colors to rest of the vertices 
					return true;		
				color[v] = 0;               // If assigning color c doesn't lead to a solution then remove it 
			}
		}
		return false;
	}
	private static void printSolution(int color[]){
		System.out.println("Solution Exists: Following are the assigned colors");
		for (int i = 0; i < V; i++)
			System.out.print(" " + color[i] + " ");
		System.out.println();
	}
	private static boolean isValidColor(int v, int graph[][], int color[],int c){
		for (int i = 0; i < V; i++)
			if (graph[v][i] == 1 && c == color[i])
				return false;
		return true;
	}
	
}
