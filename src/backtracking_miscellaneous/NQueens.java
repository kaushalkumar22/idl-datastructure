package backtracking_miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an nxn chessboard
 * such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 *
 * Input: 4
 * Output: [ [".Q..","...Q", "Q...", "..Q."] & ["..Q.","Q...", "...Q", ".Q.."] ]
 * Explanation: There exist two
 * distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens( 4));
	}
	public  List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i=0;i<n;i++){
			Arrays.fill(board[i],'.');
			//System.out.println(Arrays.toString(board[i]));
		}
		List<List<String>> res = new ArrayList<>();
		solve(board,res,0,n);
		return res;
	}
	private void solve(char[][] board, List<List<String>> res, int row, int n) {
		if(row==n){
			res.add(formatReslt(board));
			return;
		}
		for(int col =0;col<n;col++){
			if(!isValidLocation(board,row,col)) {
				continue;
			}
			board[row][col]='Q';
			solve(board,res,  row+1,  n);
			board[row][col]='.';
		}
	}
	private boolean isValidLocation(char[][] board, int row, int col) {

		if(board[row][col]=='Q') return false;

		for(int i=row;i>=0;i--){
			if(board[i][col]=='Q') return false;
		}
		for(int i=col;i>=0;i--){
			if(board[row][i]=='Q') return false;
		}
		//verify diagonal
		for(int  i=row-1 , j=col-1;i>=0&&j>=0;i--,j--){
			if(board[i][j]=='Q') return false;
		}
		//verify anti-diagonal
		for(int  i=row-1 , j=col+1;i>=0&&j<board.length;i--,j++){
			if(board[i][j]=='Q') return false;
		}
		return true;
	}

	private List<String> formatReslt(char[][] board) {
		List<String> res = new ArrayList<>();
		for(char[] row :board){
			res.add(new String(row));
		}
		return res;
	}

}
