package heap_pq;

import java.util.*;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *  Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *  Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */
public class TopKFrequentWords {
	
	public static void main(String[] args) {
		 String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
				 int k = 4;
           System.out.println(topKFrequent(words,k) );
	}

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String s : words){
            freq.put(s, freq.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)-> a.getValue()==b.getValue()?
                b.getKey().compareTo(a.getKey()):b.getValue()-a.getValue());
        for(Map.Entry<String, Integer> entry : freq.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>(k);
        while(!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
