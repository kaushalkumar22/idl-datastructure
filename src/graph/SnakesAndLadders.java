package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
	public static void main(String[] args) {

	}

	public int snakesAndLadders(int[][] board) {
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

