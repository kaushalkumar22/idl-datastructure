package com.algo.graph.dfs;

import java.util.Arrays;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X 
 * 
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 * Accepted
 * 
 * @author I339640
 *
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}
				};
		solve(board);
		for (char[] cs : board) {
			System.out.println(Arrays.toString(cs));
		}

	}
	public static void solve(char[][] board) {
		if (board.length==0) return;
		int row =board.length;
		int col = board[0].length;
		for (int i=0;i<col;i++){    // Check first row
			if (board[0][i]=='O') {
				dfs(board,0,i);
			}
		}
		for (int i=0;i<col;i++){    // Check last row
			if (board[row-1][i]=='O') {
				dfs(board,row-1,i);
			}
		}
		for (int i=0;i<row;i++){       // Check first column
			if (board[i][0]=='O') {
				dfs(board,i,0);
			}
		}
		for (int i=0;i<row;i++){       // Check last column
			if (board[i][col-1]=='O') {
				dfs(board,i,col-1);
			}
		}

		for (int i = 0;i<row;i++){
			for (int j=0;j<col;j++){
				if (board[i][j]=='O') board[i][j]='X';
			}
		}
		for (int i = 0;i<row;i++){
			for (int j=0;j<col;j++){
				if (board[i][j]=='-') board[i][j]='O';
			}
		}
	}

	public static void dfs(char[][] board,int i,int j){
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O') return;
		board[i][j]='-';
		dfs(board,i+1,j);
		dfs(board,i-1,j);
		dfs(board,i,j+1);
		dfs(board,i,j-1);
	}
}
