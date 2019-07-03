package com.ds.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsGroup {

	public static void main(String[] args) {

		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

		List<List<String>> list =groupAnagrams(strs);
        System.out.println(list);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {

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