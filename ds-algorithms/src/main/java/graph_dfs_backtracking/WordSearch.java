package graph_dfs_backtracking;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * <p>
 * board = [
 * ['A','B','C','E'], <p>
 * ['S','F','C','S'], <p>
 * ['A','D','E','E'] <p>
 * ]
 * <p>
 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
 * word = "ABCB", return false.
 * <p>
 * Constraints:
 * <p>
 * board and word consists only of lowercase and uppercase English letters.
 * <p>
 * 1 <=board.length <= 200
 * <p>
 * 1 <= board[i].length <= 200
 * <p>
 * 1 <= word.length <= 10^3
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(new WordSearch().exist(board, word));
	}
	public boolean exist(char[][] board, String word){
		int length = word.length();
		int row = board.length;
		int col = board[0].length;
		for(int i =0 ;i<row ;i++){
			for(int j=0 ;j<col;j++){
				if(board[i][j]!=word.charAt(0))continue;
				if(dfs(board,i,j,word,0)){
					return true;
				}

			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int row , int col, String word ,int index){
		if(index ==word.length()) return true;
		if(row<0||col<0||row>=board.length || col>=board[0].length || board[row][col] != word.charAt(index)) return false;
		board[row][col] = '#';
		boolean isExist = dfs(board,  row +1 ,  col,word,index+1)
				|| dfs(board,  row -1,  col,word,index+1)
				|| dfs(board,  row ,  col +1,word,index+1)
				|| dfs(board,  row ,  col -1,word,index+1);

		board[row][col] = word.charAt(index);

		return 	isExist;
	}
}