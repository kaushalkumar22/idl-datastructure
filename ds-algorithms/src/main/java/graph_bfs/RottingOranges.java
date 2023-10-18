package graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * you are given an m x n grid where each cell can have one of three values:
 *
 *     0 representing an empty cell,
 *     1 representing a fresh orange, or
 *     2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 * Input: grid = [
 * [2,1,1],
 * [1,1,0],
 * [0,1,1]]
 * Output: 4
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because
 * rotting only happens 4-directionally.
 */
public class RottingOranges {
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(new RottingOranges().orangesRotting1(grid));

	}
	public int orangesRotting1(int[][] grid) {
		int freshOrange  = 0;
		int row = grid.length;
		int col = grid[0].length;
		Queue<int[]> que = new LinkedList<>();

		for(int i=0;i< row ;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j] == 2){
					que.add( new int[]{i,j});
				}
				if(grid[i][j] == 1){
					freshOrange ++;
				}
			}
		}
		int count = 0;
		int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
		while(!que.isEmpty()){
			int size = que.size();
			for(int i = 0;i< size ; i++){
				int[]  curr = que.poll();
				if(freshOrange==0) return count;
				for(int[] dir : dirs){
					int x = curr[0] + dir[0];
					int y = curr[1] + dir[1];
					if(!isValid(grid,x,y) )continue;
					que.add( new int[]{x,y});
					grid[x][y] = 2 ;
					freshOrange -- ;
				}
			}
			count++;
		}
		return freshOrange != 0 ? -1 : count;
	}
	public int orangesRotting(int[][] grid) {
		int row =grid.length;
		int col = grid[0].length;
		Queue<int[]> que = new LinkedList<>();
		int freshCount =0;
		for (int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j]==2) {
					que.add(new int[]{i, j});
				}else if(grid[i][j]==1) {
					freshCount++;
				}
			}
		}
		if (freshCount==0) return 0;
		if (que.isEmpty()) return -1;
		int[][] dirs ={{-1,0},{0,-1},{1,0},{0,1}};
		int count = 0;
		//Set rotten
		while(!que.isEmpty()){
			count++;
			int qSize = que.size();
			for(int i=0;i<qSize;i++){
				int[] curr = que.poll();
				for (int[] dir :dirs){
					int x =curr[0]+dir[0];// new x-co-ordinate but need to validate
					int y =curr[1]+dir[1];//new x-co-ordinate but need to validate
					if(!isValid( grid , x , y)){ //validating co-ordinate and cell value for next move
						continue;
					}
					grid[x][y]=2;
					freshCount--;
					que.add(new int[]{x, y});
				}
			}

		}
		return freshCount==0?count-1:-1;
	}
	boolean isValid(int[][] grid ,int x ,int y){
		if(x<0||y<0||x>grid.length-1||y>grid[0].length-1||grid[x][y]==0||grid[x][y]!=1){
			return false;
		}
		return true;
	}
}

