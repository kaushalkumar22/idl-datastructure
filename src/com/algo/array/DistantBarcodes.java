package com.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a warehouse, there is a row of barcodes, where the i-th barcode is
 * barcodes[i]. Rearrange the barcodes so that no two adjacent barcodes are
 * equal. You may return any answer, and it is guaranteed an answer exists.
 * 
 * Input: [1,1,1,2,2,2] Output: [2,1,2,1,2,1] 
 * Input:[1,1,1,1,2,2,3,3] Output: [1,3,1,3,2,1,2,1]
 *
 * 
 */
public class DistantBarcodes {

	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 1, 2, 2, 3, 3 };
		System.out.println(rearrangeBarcodes(nums));
		System.out.println(rearrangeBarcodesOpt(nums));
	}

	/*
	 * Like Jianwen observed below, we do not need to sort elements by the number of
	 * occurrences, we just need to determine the most frequent one and fill it
	 * first. The rest of barcodes can be filled irrespective of their occurrences.
	 * Note that you still fill all occurrences of the same barcode skipping a
	 * position before moving to the next barcode.
	 * 
	 * Since barcodes are limited to [1...10000], we can use an array instead of
	 * hash map to make it even faster.
	 */
	private static int[] rearrangeBarcodesOpt(int[] b) {
		int m[] = new int[10001];
		int max_cnt = 0, max_n = 0, pos = 0;
		for (int n : b) {
			max_cnt = Math.max(max_cnt, ++m[n]);
			max_n = max_cnt == m[n] ? n : max_n;
		}
		for (int i = 0; i <= 10000; ++i) {
			int n = i == 0 ? max_n : i;
			while (m[n]-- > 0) {
				b[pos] = n;
				pos = pos + 2 < b.length ? pos + 2 : 1;
			}
		}
		return b;
	}

	/*
	 * Complexity Analysis Runtime: O(N), where N is the total number of elements.
	 * Memory: O(n), where n is the number of unique elements we track the count
	 * for.
	 */
	public static int[] rearrangeBarcodes(int[] barcodes) {
		Map<Integer, Integer> cnt = new HashMap();
		for (int i : barcodes)
			cnt.put(i, cnt.getOrDefault(i, 0) + 1);

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(cnt.entrySet());
		Collections.sort(list, Map.Entry.<Integer, Integer>comparingByValue().reversed());
		int l = barcodes.length, i = 0;
		int[] res = new int[l];
		for (Map.Entry<Integer, Integer> e : list) {
			int time = e.getValue();
			while (time-- > 0) {
				res[i] = e.getKey();
				i += 2;
				if (i >= barcodes.length)
					i = 1;
			}
		}
		return res;
	}
}
