package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * Return a list of integers representing the size of these parts.
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * Constraints:
 *     1 <= s.length <= 500
 *     s consists of lowercase English letters.
 */
public class PartitionLabels {

	public List<Integer> partitionLabels(String S) {
		List<Integer> res = new ArrayList<Integer>();

		int[] lastIndexMap = new int[26];
		//record the last index of each char in lastIndexMap
		for(int i=0;i<S.length();i++) {
			lastIndexMap[S.charAt(i)-'a']=i;
		}
		 // record the end index of the current sub stringintlast = 0;
		int start =0;
		int last=0;
		for(int i=0;i<S.length();i++) {
			last=Math.max(last, lastIndexMap[S.charAt(i)-'a']);
			if(last==i) {
				res.add(last-start+1);
				start =last+1;
			}
		}
		return res;
	}
}
