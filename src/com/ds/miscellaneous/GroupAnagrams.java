package com.ds.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
    String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strs));
	}
	public static List<List<String>> groupAnagrams(String[] strs) { 
		   int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
		    
		            List<List<String>> res = new ArrayList<>();
		            HashMap<Integer, Integer> map = new HashMap<>();
		            for (String s : strs) {
		                int key = 1;
		                for (char c : s.toCharArray()) {
		                    key *= prime[c - 'a'];
		                }
		                List<String> t;
		                if (map.containsKey(key)) {
		                    t = res.get(map.get(key));
		                } else {
		                    t = new ArrayList<>();
		                    res.add(t);
		                    map.put(key, res.size() - 1);
		                }
		                t.add(s);
		            }
		            return res;
		    }
	public static List<List<String>> groupAnagrams2(String[] strs) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (map.containsKey(keyStr)) {
				List<String> list =map.get(keyStr);
				list.add(keyStr);

			}else {
				List<String> list =new ArrayList<String>();
				list.add(keyStr);
				map.put(keyStr, list);
			}
		}
		return new ArrayList<List<String>>(map.values());
	}
}
