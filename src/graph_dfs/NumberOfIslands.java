package graph_dfs;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * Input: grid = [ ['1','1','1','1','0'], ['1','1','0','1','0'],
 * ['1','1','0','0','0'], ['0','0','0','0','0'] ] 
 * Output: 1
 *  
 * Input: grid = [ ['1','1','0','0','0'], ['1','1','0','0','0'],
 * ['0','0','1','0','0'], ['0','0','0','1','1'] ] 
 * Output: 3
 *  
 * Constraints:
 * m == grid.length 
 * n == grid[i].length 
 * 1 <= m, n <= 300 
 * grid[i][j] is '0' or'1'.
 * 
 */
public class NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','1','1','0'}, 
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};	
		System.out.println(numIslands(grid));
	}
	public static int numIslands(char[][] grid) {
		int row =grid.length;
		int col =grid[0].length;
		int count =0;		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(grid[i][j]=='1') {
					dfs(grid,i,j);
					count++;
				}
			}
		}
		return count;
	}
	private static void dfs(char[][] grid, int i, int j) {

		if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j] != '1') return;

		grid[i][j]='#';

		dfs(grid,i,j+1);
		dfs(grid,i,j-1);
		dfs(grid,i-1,j);
		dfs(grid,i+1,j);

	}
}
