package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * 
 * Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation: The longest consecutive
 * elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 *
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(nums));
	}

	/**
	 * First turn the input into a set of numbers. That takes O(n) and then we can
	 * ask in O(1) whether we have a certain number. Then go through the numbers. If
	 * the number x is the start of a streak (i.e., x-1 is not in the set), then
	 * test y = x+1, x+2, x+3, ... and stop at the first number y not in the set.
	 * The length of the streak is then simply y-x and we update our global best
	 * with that. Since we check each streak only once, this is overall O(n). This
	 * ran in 44 ms on the OJ, one of the fastest Python submissions.
	 * 
	 * @param nums
	 * @return
	 */
	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			set.add(n);
		}
		int best = 0;
		for (int num : set) {
			int count = 0;
			if(set.contains(num-1)) continue;
			while (set.contains(num)) {
				count++;
				num++;
			}
			best = Math.max(best, count);
		}
		return best;
	}

	/**
	 * Whenever a new element n is inserted into the map, do two things:
	 * 
	 * See if n - 1 and n + 1 exist in the map, and if so, it means there is an
	 * existing sequence next to n. Variables left and right will be the length of
	 * those two sequences, while 0 means there is no sequence and n will be the
	 * boundary point later. Store (left + right + 1) as the associated value to key
	 * n into the map. Use left and right to locate the other end of the sequences
	 * to the left and right of n respectively, and replace the value with the new
	 * length.
	 * 
	 * Everything inside the for loop is O(1) so the total time is O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public int longestConsecutive2(int[] num) {
		 int res = 0;
		    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		    for (int n : num) {
		        if (!map.containsKey(n)) {
		            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
		            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
		            // sum: length of the sequence n is in
		            int sum = left + right + 1;
		            map.put(n, sum);
		            
		            // keep track of the max length 
		            res = Math.max(res, sum);
		            
		            // extend the length to the boundary(s)
		            // of the sequence
		            // will do nothing if n has no neighbors
		            map.put(n - left, sum);
		            map.put(n + right, sum);
		        }
		        else {
		            // duplicates
		            continue;
		        }
		    }
		    return res;
		}
	}

