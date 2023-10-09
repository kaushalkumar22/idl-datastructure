package graph_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *  
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 *
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *  
 *
 * Constraints:
 *
 *     n == grid.length == grid[i].length
 *     2 <= n <= 100
 *     grid[i][j] is either 0 or 1.
 *     There are exactly two islands in grid.
 */
public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        System.out.println(new ShortestBridge().shortestBridge(grid));
    }
    public int shortestBridge(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean isFound=false;
        for (int i = 0; i < row; i++) {
            if(isFound)
                break;
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 ) {
                    isFound=true;
                    dfs(grid, i, j);
                    break;
                }

            }
        }
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    que.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int minDist = Integer.MAX_VALUE;
        int count = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                int[] curr = que.poll();

                for (int[] dir : dirs) {
                    int x = curr[0];
                    int y = curr[1];

                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (!isValid(grid, nextX, nextY)) continue;
                    if (grid[nextX][nextY] == 2){
                        return count;
                    }
                    grid[nextX][nextY] = 1;
                    que.add(new int[]{nextX, nextY});
                }
            }
            count++;
        }
        return count;
    }
    private boolean isValid(int[][] grid , int row , int col ){
        if(row<0 || col<0 || row>=grid.length||col>=grid[0].length || grid [row][col]==1){
            return false;
        }
        return true ;
    }

    private void dfs(int[][] grid , int row , int col){
        if(row<0 || col<0 || row>=grid.length||col>=grid[0].length || grid [row][col]!=1){
            return ;
        }
        grid[row][col]=2;
        dfs(grid, row +1, col);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);

    }
}

