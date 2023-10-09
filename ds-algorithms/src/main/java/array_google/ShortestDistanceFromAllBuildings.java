package array_google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 *
 *     Each 0 marks an empty land which you can pass by freely.
 *     Each 1 marks a building which you cannot pass through.
 *     Each 2 marks an obstacle which you cannot pass through.
 *
 * There will be at least one building. If it is not possible to build such
 * house according to the above rules, return -1
 * Example
 *
 * Example 1
 *
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * Output: 7
 * Explanation:
 * In this example, there are three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
 * So return 7.
 *
 * Example 2
 *
 * Input: [[1,0],[0,0]]
 * Output: 1
 * In this example, there is one buildings at (0,0).
 * 1 - 0
 * |   |
 * 0 - 0
 * The point (1,0) or (0,1) is an ideal empty land to build a house, as the total travel
 * distance of 1 is minimal. So return 1
 */
public class ShortestDistanceFromAllBuildings {
    public static void main(String[] args) {
      //  int[][] grid   = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        int[][] grid   = {{1,0},{0,0}};
        System.out.println(new ShortestDistanceFromAllBuildings().shortestDistance(grid));
    }
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dis = new int[m][n];
        int[][]  buildings = new int[m][n];
        int count =0;
        for(int i =0 ;i< m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                    bfs(grid,i,j,dis,buildings);
                }
            }
        }
        int shortestDistance = Integer.MAX_VALUE;
        for(int i =0 ;i< m;i++) {
            for (int j = 0; j < n; j++) {
                if(buildings[i][j] == count){
                    shortestDistance = Math.min(shortestDistance, dis[i][j]);
                }
            }
        }
        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

    private void bfs(int[][] grid, int row, int col, int[][] dis, int[][] buildings) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int dist = 0;
        while (!que.isEmpty()){
            int n = que.size();
            dist++;
            for(int i =0 ;i< n;i++){
                int[] curr = que.poll();
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(!isValid(grid,x,y)) continue;
                    if(visited[x][y]) continue;
                    dis[x][y] += dist;
                    visited[x][y] = true;
                    buildings[x][y]++;
                    que.add(new int[]{x,y});
                }
            }
        }
    }
    private boolean isValid(int[][] grid, int i ,int j){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]!=0){
            return false;
        }
        return true;
    }
}
