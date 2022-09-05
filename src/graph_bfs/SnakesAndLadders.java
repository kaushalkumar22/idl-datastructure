package graph_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
 *
 * You start on square 1 of the board. In each move, starting from square curr, do the following:
 *
 *     Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
 *         This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
 *     If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
 *     The game ends when you reach the square n2.
 *
 * A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.
 *
 * Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder
 * is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
 *
 *     For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2.
 *     You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
 *
 * Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
 * Output: 4
 * Explanation:
 * In the beginning, you start at square 1 (at row 5, column 0).
 * You decide to move to square 2 and must take the ladder to square 15.
 * You then decide to move to square 17 and must take the snake to square 13.
 * You then decide to move to square 14 and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * This is the lowest possible number of moves to reach the last square, so return 4.
 *
 * Example 2:
 *
 * Input: board = [[-1,-1],[-1,3]]
 * Output: 1
 */
public class SnakesAndLadders {
	public static void main(String[] args) {
		int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
		int a = 5;
		System.out.println(~a);
		System.out.println(snakesAndLadders(board));
		System.out.println(snakesAndLadders2(board));
	}
	/*	def snakesAndLadders(self, board):
        n = len(board)
        need = {1: 0}
        bfs = [1]
                for x in bfs:
                for i in range(x + 1, x + 7):
        a, b = (i - 1) / n, (i - 1) % n
                nxt = board[~a][b if a % 2 == 0 else ~b]
                if nxt > 0: i = nxt
                    if i == n * n: return need[x] + 1
                if i not in need:
                 need[i] = need[x] + 1
                bfs.append(i)
                return -1*/
	public static int snakesAndLadders2(int[][] board) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);//put the start value to queue
		int n = board.length;
		int goal = n*n;
		int ans = 0;
		Set<Integer> visited = new HashSet<>();
		while(!q.isEmpty()) {
			int qsize = q.size();
			++ans;
			for(int i = 0; i < qsize; ++i) {
				int currValue = q.poll();
				for(int j = 1; j <=6; ++j) {
					int nextValue = currValue+j;
					if (nextValue > goal) continue;
					int r = (nextValue-1)/n;
					int c = (nextValue-1)%n;
					int nxt =board[n-1-r][(r%2==0)?c:(n-1-c)];
					if(nxt > 0) {//if value is positive
						nextValue = nxt;
					}
					if( nextValue == goal) return ans;
					if(visited.contains(nextValue)){
						continue;
					}
					visited.add(nextValue);
					q.offer(nextValue);
				}

			}
		}
		return -1;
	}
	public static int snakesAndLadders(int[][] board) {
		int n = board.length;
		int[] arr = new int[n * n];
		boolean flag = n%2==0?true:false;
		int index = (n*n)-1;
		for(int i=0; i<n;i++){
			for(int j=0;j<n;j++){
				arr[index--] = flag? board[i][j]: board[i][n-j-1];
			}
			flag = !flag;
		}

		boolean[] visited = new boolean[n * n];
		Queue<Integer> q = new LinkedList<>();
		int start = arr[0] > -1 ? arr[0] - 1 : 0;
		q.offer(start);
		visited[start] = true;
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				if (cur == n * n - 1) {
					return step;
				}
				for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
					int dest = arr[next] > -1 ? arr[next] - 1 : next;
					if (!visited[dest]) {
						visited[dest] = true;
						q.offer(dest);
					}
				}
			}
			step++;
		}
		return -1;
	}

}

