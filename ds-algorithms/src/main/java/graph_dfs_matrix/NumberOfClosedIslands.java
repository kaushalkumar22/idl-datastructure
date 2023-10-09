package graph_dfs_matrix;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of
 * 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 *
 * Input: grid = [
 * [0,0,1,0,0],
 * [0,1,0,1,0],
 * [0,1,1,1,0]]
 * Output: 1
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 * Output: 2

 * Constraints:
 *
 *     1 <= grid.length, grid[0].length <= 100
 *     0 <= grid[i][j] <=1
 */
public class NumberOfClosedIslands {
	public static void main(String[] args) {
		int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
		System.out.println(new NumberOfClosedIslands().closedIsland(grid));
	}
	public int closedIsland(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < row; ++i){
			for (int j = 0; j < col; ++j){
				if (i * j * (row-i-1) * (col -j - 1) == 0 && grid[i][j]==0){
					dfs(grid,i,j);
				}
			}
		}
		int res =0 ;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j]==0){
					dfs(grid,i,j);
					res++;
				}
			}
		}
		return res;
	}

	public  void dfs(int[][] grid,int row,int col){
		if(row<0||col<0||row>=grid.length||col>=grid[0].length|| grid[row][col]!=0) return;
		grid[row][col] = 2;
		dfs(grid, row, col+1);
		dfs(grid, row+1, col);
		dfs(grid, row-1, col);
		dfs(grid, row, col-1);

	}
}

