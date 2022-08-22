package stack_miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * We are given hours, a list of the number of hours worked per day for a given
 * employee.
 * 
 * A day is considered to be a tiring day if and only if the number of hours
 * worked is (strictly) greater than 8.
 * 
 * A well-performing interval is an interval of days for which the number of
 * tiring days is strictly larger than the number of non-tiring days.
 * 
 * Return the length of the longest well-performing interval.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: hours = [9,9,6,0,6,6,9] Output: 3 Explanation: The longest
 * well-performing interval is [9,9,6].
 * 
 *
 */
public class LongestWellPerformingInterval {
	public int longestWPI(int[] hours) {
		int res = 0, score = 0, n = hours.length;
		Map<Integer, Integer> seen = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			score += hours[i] > 8 ? 1 : -1;
			if (score > 0) {
				res = i + 1;
			} else {
				seen.putIfAbsent(score, i);
				if (seen.containsKey(score - 1))
					res = Math.max(res, i - seen.get(score - 1));
			}
		}
		return res;
	}
}
