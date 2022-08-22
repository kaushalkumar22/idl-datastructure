package heap_pq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentElements {
	public static void main(String[] args) 
	{
		TopKFrequentElements solution = new TopKFrequentElements();

		int[] array = {1,2,2,2,2,3,3,3,4,4,4,5,6,6,6};

		int n = 3;
		System.out.println("Nth most frequent number is:\n" + solution.topKFrequent(array, n));
		System.out.println("Nth most frequent number is:\n" + solution.topKFrequent1(array, n));
		System.out.println("Nth most frequent number is:\n" + solution.topKFrequent2(array, n));

	}
	//Java O(n) Solution - Bucket Sort
	public List<Integer> topKFrequent(int[] nums, int k) {
		// freq map
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int n : nums) {
			freq.put(n, freq.getOrDefault(n, 0) + 1);
		}
		// bucket sort on freq
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int i = 0; i < bucket.length; i++) bucket[i] = new ArrayList();
		for (int key : freq.keySet()) {
			bucket[freq.get(key)].add(key);
		}
		// gather result
		List<Integer> res = new ArrayList();
		for (int i = bucket.length - 1; i >= 0; i--) {
			res.addAll(bucket[i]);
			if (res.size() >= k) break;
		}
		return res;
	}

	// use an array to save numbers into different bucket whose index is the frequency
	public List<Integer> topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int n: nums){
			map.put(n, map.getOrDefault(n,0)+1);
		}

		// corner case: if there is only one number in nums, we need the bucket has index 1.
		List<Integer>[] bucket = new List[nums.length+1];
		for(int n:map.keySet()){
			int freq = map.get(n);
			if(bucket[freq]==null)
				bucket[freq] = new LinkedList<>();
			bucket[freq].add(n);
		}

		List<Integer> res = new LinkedList<>();
		for(int i=bucket.length-1; i>0 && k>0; --i){
			if(bucket[i]!=null){
				List<Integer> list = bucket[i]; 
				res.addAll(list);
				k-= list.size();
			}
		}

		return res;
	}




	// use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
	public List<Integer> topKFrequent2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int n: nums){
			map.put(n, map.getOrDefault(n,0)+1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
				new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
		for(Map.Entry<Integer,Integer> entry: map.entrySet()){
			maxHeap.add(entry);
		}

		List<Integer> res = new ArrayList<>();
		while(res.size()<k){
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			res.add(entry.getKey());
		}
		return res;
	}




	// use treeMap. Use freqncy as the key so we can get all freqencies in order
	public List<Integer> topKFrequent3(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int n: nums){
			map.put(n, map.getOrDefault(n,0)+1);
		}

		TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
		for(int num : map.keySet()){
			int freq = map.get(num);
			if(!freqMap.containsKey(freq)){
				freqMap.put(freq, new LinkedList<>());
			}
			freqMap.get(freq).add(num);
		}

		List<Integer> res = new ArrayList<>();
		while(res.size()<k){
			Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
			res.addAll(entry.getValue());
		}
		return res;
	}
}


