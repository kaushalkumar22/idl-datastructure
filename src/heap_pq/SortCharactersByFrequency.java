package heap_pq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 * Return the sorted string. If there are multiple answers, return any of them.
 *  Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {

	public static void main(String[] args) {
		String s= "Aabb";
		System.out.println( frequencySortOpt( s));
		System.out.println( frequencySort( s));

	}
	public static String frequencySortOpt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) 
			map.put(c, map.getOrDefault(c, 0) + 1);

		List<Character> [] bucket = new List[s.length() + 1];
		for (char key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
			bucket[frequency].add(key);
		}

		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >= 0; pos--)
			if (bucket[pos] != null)
				for (char c : bucket[pos])
					for (int i = 0; i < pos; i++)
						sb.append(c);

		return sb.toString();
	}
	//Complexity Analysis
	//	� Time complexity: O(N) .
	//	� Space complexity: O(N). 

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(map.entrySet());

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry e = pq.poll();
			for (int i = 0; i < (int)e.getValue(); i++) 
				sb.append(e.getKey());
		}
		return sb.toString();
	}
	//Complexity Analysis
	//	� Time complexity : O(Nlogk) if k<N and O(N) in the particular case of N=k. That ensures time complexity to be better than O(NlogN).
	//	� Space complexity : O(N+k)to store the hash map with not more N elements and a heap with k elements. 

}
