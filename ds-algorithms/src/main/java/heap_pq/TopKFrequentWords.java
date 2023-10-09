package heap_pq;

import java.util.*;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same
 * frequency by their lexicographical order.
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number
 * of occurrence being 4, 3, 2 and 1 respectively.
 *
 * Constraints:
 *
 *     1 <= words.length <= 500
 *     1 <= words[i].length <= 10
 *     words[i] consists of lowercase English letters.
 *     k is in the range [1, The number of unique words[i]]
 *
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */
public class TopKFrequentWords {
	
	public static void main(String[] args) {
		 String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
				 int k = 4;
           System.out.println(topKFrequent(words,k) );
	}
    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap();

        for(String word :words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> que = new PriorityQueue<>(
                (a,b)-> a.getValue()==b.getValue() ? a.getKey().compareTo(a.getKey()):a.getValue() - b.getValue());
        for(Map.Entry<String,Integer> entry :freq.entrySet()){
            que.add(entry);
            if(que.size()>k){
                que.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!que.isEmpty()){
            res.add(0,que.poll().getKey());
        }
        return res;
    }

}
