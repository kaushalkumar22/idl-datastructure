package graph_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
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
		System.out.println(new OpenTheLock().openLock2(deadends,  target));
	}
	public  int openLock2(String[] deadends, String target) {

		Set<String> deads   = new HashSet<>(Arrays.asList(deadends));
		Set<String> visited  = new HashSet<>();

		Queue<String> que = new LinkedList<>();
		que.add("0000");
		int minCount =0;
		while(!que.isEmpty()){
			int qSize = que.size();
			for(int i=0;i<qSize;i++){
				String curr = que.poll();
				if(curr.equals(target)) return minCount;

				for(int j= 0;j<4;j++){
					char c = curr.charAt(j);
					String backward = curr.substring(0,j) + (c=='0' ?  '9' :( c-'0'-1)) + curr.substring(j+1,4);
					String forward = curr.substring(0,j) + (c=='9' ? '0' :( c-'0'+1)) + curr.substring(j+1,4);
					//String forward  =  curr.substring(0,j) + (c =='9' ? '0' :c -'0'+1) + curr.substring(j+1);
					//String backward =  curr.substring(0,j) + (c =='0' ? '9' :c -'0' -1) + curr.substring(j+1);
					if(!deads.contains(forward)&&!visited.contains(forward)){
						que.add(forward);
						visited.add(forward);
					}

					if(!deads.contains(backward)&&!visited.contains(backward)){
						que.add(backward);
						visited.add(backward);
					}
				}
			}
			minCount++;
		}
		return -1;
	}
}

