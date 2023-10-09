package graph_shortestpath;

import java.util.PriorityQueue;

/**
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
 *
 * The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another
 * 4-directionally adjacent square if and only if the elevation of both squares individually are at most t.
 * You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 *
 * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
 *
 * Input: grid = [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 *
 * Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation: The final route is shown.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 */
public class SwiminRisingWater {
	public static void main(String[] args) {
		int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
	}
	public int swimInWater(int[][] grid) {
		int n = grid.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		boolean[][] visited = new boolean[n][n];
		int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

		visited[0][0] = true;
		pq.offer(new int[]{0, 0, grid[0][0]});
		while(!pq.isEmpty()){
			int[] info = pq.poll();
			int i = info[0], j = info[1], max = info[2];
			for(int[] dir : dirs){
				int newI = dir[0] + i, newJ = dir[1] + j;
				if(newI < 0 || newI >= n || newJ < 0 || newJ >= n)  continue;
				if(!visited[newI][newJ]){
					visited[newI][newJ] = true;
					int newmax = Math.max(max, grid[newI][newJ]);
					if(newI == n - 1 && newJ == n - 1)  return newmax;
					pq.offer(new int[]{newI, newJ, newmax});
				}
			}
		}

		return 0;
	}
}

