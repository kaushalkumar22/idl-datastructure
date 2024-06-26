package graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right
 * cell (i.e., (n - 1, n - 1)) such that:
 *
 *     All the visited cells of the path are 0.
 *     All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an
 *     edge or a corner).
 *
 * The length of a clear path is the number of visited cells of this path.
 *
 * Input: grid = [
 * [0,1],
 * [1,0]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: grid = [
 * [0,0,0],
 * [1,1,0],
 * [1,1,0]]
 * Output: 4
 *
 * Example 3:
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 */
public class ShortestPathinBinaryMatrix {
	public static void main(String[] args) {
		int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
		System.out.println(new ShortestPathinBinaryMatrix().shortestPathBinaryMatrix(grid));
	}
	public int shortestPathBinaryMatrix(int[][] grid) {
		int row = grid.length-1;
		int col = grid[0].length-1;
		if(grid[0][0] == 1 || grid[row][col] == 1 ) return -1;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{0,0});
		int[][] dirs = {{1,1},{1,0},{-1,0},{-1,-1},{1,-1},{-1,1},{0,1},{0,-1}};
		int count = 0;
		while(!que.isEmpty()){
			int size = que.size();
			for(int i= 0 ;i< size;i++){
				int[] curr = que.poll();
				if(curr[0] ==row&&curr[1]==col) return count+1;
				for(int[] dir :dirs){
					int x = curr[0] + dir[0] ;
					int y = curr[1] + dir[1] ;

					if(!isValid(grid, x,y)) continue;
					que.add(new int[]{x,y});
					grid[x][y] =1;
				}
			}
			count++;
		}
		return -1;
	}

	private boolean isValid(int[][] grid, int row ,int col){
		if(row<0||col<0 || row >= grid.length || col >= grid[0].length || grid[row][col]==1){
			return false;
		}
		return true;
	}
	public int shortestPathBinaryMatrix1(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;
		if(grid[0][0]==1||grid[row-1][col-1]==1){//invalid cases return from here
			return -1;
		}
		int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{0,0});
		int count =0;
		while (!que.isEmpty()){
			count++;
			int n = que.size();
			for (int i=0;i<n;i++){
				int[] curr = que.poll();
				if(curr[0]==row-1&&curr[1]==col-1){
					return count;
				}
				for(int j=0;j<8;j++){
					int x =curr[0]+dir[j][0];
					int y =curr[1]+dir[j][1];
					if(!isValid(grid,x,y)){
						continue;
					}
					grid[x][y]=1;
					que.add(new int[]{x,y});
				}
			}
		}
		return -1;
	}
	private boolean isValid1(int[][] grid, int x, int y) {
		if(x<0||y<0|x>=grid.length||y>=grid[0].length||grid[x][y]==1){
			return false;
		}
		return true;
	}
}



