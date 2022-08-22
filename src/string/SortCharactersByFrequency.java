package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * 
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together.
 * 
 * @author I339640
 *
 */
public class SortCharactersByFrequency {

	public static void main(String[] args) {
		System.out.println(frequencySort3("tree"));
	}

	public static String frequencySort3(String s) {

		Map<Character,Integer> freq = new HashMap<>();
		for(Character c:s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0)+1);
		}
		List<Character>[] bucket = new List[s.length()+1];

		for(char ch:freq.keySet()) {
			int count = freq.get(ch);

			if(bucket[count]==null) {
				bucket[count]= new ArrayList<Character>();
			}
			bucket[count].add(ch);
		}
		StringBuilder res = new StringBuilder();
		for(int i = bucket.length-1;i>=0;i--) {
			if(bucket[i]==null)continue;

			List<Character> chList = bucket[i];
			for (Character ch : chList) {
				for(int j = 0;j<i;j++) {	
					res.append(ch);
				}
			}


		}
		return res.toString();

	}
	//The logic is very similar to NO.347 and here we just use a map a count and according to the frequency to put it into the right bucket. Then we go through the bucket to get the most frequently character and append that to the final stringbuilder.

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) 
			map.put(c, map.getOrDefault(c, 0) + 1);

		List<Character> [] bucket = new List[s.length() + 1];
		for (char key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) 
				bucket[frequency] = new ArrayList<>();
			bucket[frequency].add(key);
		}

		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >= 0; pos--)
			if (bucket[pos] != null)
				for (char c : bucket[pos])
					for (int i = 0; i < map.get(c); i++)
						sb.append(c);

		return sb.toString();
	}

	public static String frequencySort2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(map.entrySet());

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry e = pq.poll();
			char c = (char) e.getKey();
			for (int i = 0; i < (int)e.getValue(); i++) 
				sb.append(c);
		}
		return sb.toString();
	}
}


