package graph_dfs;

import java.util.*;

/**
<<<<<<< Updated upstream
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people,
 * and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person
 * labeled bi, return true if it is possible to split everyone into two groups in this way.
=======
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. 
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person 
 * labeled ai does not like the person labeled bi, return true if it is possible to split everyone into 
 * two groups in this way.
>>>>>>> Stashed changes
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 *
 * Example 2:
 *
 * Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 *
 * Example 3:
 *
 * Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 2000
 *     0 <= dislikes.length <= 104
 *     dislikes[i].length == 2
 *     1 <= dislikes[i][j] <= n
 *     ai < bi
 *     All the pairs of dislikes are unique.
 */
//graph coloring prob or detect cycle in directed graph
public class PossibleBipartition {
	public static void main(String[] args) {
		int n = 4, dislikes[][] = {{1, 2}, {1, 3}, {2, 4}};
		//int n = 3, dislikes[][] = {{1,2},{1,3},{2,3}};
		System.out.println(new PossibleBipartition().possibleBipartition(n, dislikes));
	}

	public boolean possibleBipartition(int n, int[][] dislikes) {
		int[] colors = new int[n + 1];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : dislikes) {
			graph.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
			graph.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
		}
		for (int i = 1; i <= n; i++) {
			if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(Map<Integer, List<Integer>> graph, int[] colorTable, int cur, int color) {
		colorTable[cur] = color;

		for (int next : graph.getOrDefault(cur, Collections.emptyList())) {
			if (colorTable[next] == color) {
				return false;
			}
			if (colorTable[next] == 0 && !dfs(graph, colorTable, next, -color)) {
				return false;
			}
		}
		return true;
	}
}

