package graph_dfs_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches
 * the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c]
 * represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west
 * if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent
 * to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci)
 * to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *
 * Example 2:
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 */
public class PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		System.out.println( new PacificAtlanticWaterFlow().pacificAtlantic(heights));

	}
	public List<List<Integer>> pacificAtlantic(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		boolean[][] pac = new boolean[row][col];
		boolean[][] atl = new boolean[row][col];
		for(int i=0 ;i<row;i++){
			dfs(board,i,0,board[i][0],pac);
			dfs(board,i,col-1,board[i][col-1],atl);
		}

		for(int i=0 ;i<col;i++){
			dfs(board,0,i,board[0][i],pac);
			dfs(board,row-1,i,board[row-1][i],atl);
		}
		List<List<Integer>> res = new ArrayList<>();
		for(int i=0 ;i<row;i++){
			for(int j=0 ;j<col;j++){
				if(pac[i][j]==true&&atl[i][j]==true){
					res.add(Arrays.asList(i,j));
				}
			}
		}
		return res;
	}
	private void dfs(int[][] board, int row , int col,int prev,boolean[][] visited){
		if(row<0||col<0||row>=board.length || col>=board[0].length
				|| board[row][col]< prev || visited[row][col]==true) return ;
		visited[row][col] = true;
		dfs(board,  row +1 ,  col,board[row][col],visited);
		dfs(board,  row -1,  col,board[row][col],visited);
		dfs(board,  row ,  col +1,board[row][col],visited);
		dfs(board,  row ,  col -1,board[row][col],visited);
	}
}

