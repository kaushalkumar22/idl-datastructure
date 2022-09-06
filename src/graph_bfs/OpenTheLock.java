package graph_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
 * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn
 * '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will
 * stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns
 * required to open the lock, or -1 if it is impossible.
 *
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 *
 * Example 2:
 *
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
 *
 * Example 3:
 *
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation: We cannot reach the target without getting stuck.
 */
public class OpenTheLock {//BFS
	public static void main(String[] args) {
		String deadends[]= {"0201","0101","0102","1212","2002"}, target = "0202";
		System.out.println(new OpenTheLock().openLock(deadends,  target));
	}
	public  int openLock(String[] deadends, String target) {
		Set<String> deeds = new HashSet<>(Arrays.asList(deadends));
		Set<String> visited = new HashSet<>();
		Queue<String> que = new LinkedList<>();
		que.add("0000");
		visited.add("0000");
		int count =0;
		while(!que.isEmpty()){
			int qsize = que.size();
			for(int j=0;j<qsize;j++) {
				String curr = que.poll();
				if (curr.equals(target)) return count;
				char[] ch = curr.toCharArray();
				for (int i = 0; i < 4; i++) {
					char c = ch[i];
					String nextMove1 = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1);
					String nextMove2 = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i + 1);
					if (!deeds.contains(nextMove1) && !visited.contains(nextMove1)) {
						que.add(nextMove1);
						visited.add(nextMove1);
					}
					if (!deeds.contains(nextMove2) && !visited.contains(nextMove2)) {
						que.add(nextMove2);
						visited.add(nextMove2);
					}
				}
			}
			count++;
		}
		return -1;
	}
}

