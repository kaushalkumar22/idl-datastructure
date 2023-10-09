package graph_dfs_matrix;

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
 * Surrounded regions shouldn't be on the border, which means that any 'O' on
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 <p>
 X X X X<p>
 X O O X<p>
 X X O X<p>
 X O X X<p>
 <p>
 After running your function, the board should be:
 <p>
 X X X X<p>
 X X X X<p>
 X X X X<p>
 X O X X<p>
 *
 * Surrounded regions shouldn't be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border, and it is not connected to an 'O' on the border will be flipped to
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

		//char[][] board = {{'O','O'},{'O','O'}};
		new SurroundedRegions().solve(board);
		for (char[] cs : board) {
			System.out.println(Arrays.toString(cs));
		}

	}
	public  void solve(char[][] board) {
		int row = board.length;
		int col = board[0].length;
		for (int i = 0;i<row;i++) {
			for (int j = 0; j < col; j++) {
				if(i*j*(row-i-1)*(col-j-1)==0){
					dfs(board,i,j);
				}
			}
		}

		for (int i = 0;i<row;i++){
			for (int j=0;j<col;j++){
				if (board[i][j]=='O') {
					board[i][j]='X';
				}
				if (board[i][j]=='#') {
					board[i][j]='O';
				}
			}
		}
	}


	public  void dfs(char[][] board,int row,int col){
		if(row<0||col<0||row>=board.length||col>=board[0].length|| board[row][col]!='O') return;
		board[row][col]='#';
		dfs(board, row, col+1);
		dfs(board, row+1, col);
		dfs(board, row-1, col);
		dfs(board, row, col-1);
	}
}
