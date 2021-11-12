package com.algo.mustdo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Find top k (or most frequent) numbers in a stream Given an array of n
 * numbers. Your task is to read numbers from the array and keep at-most K
 * numbers at the top (According to their decreasing frequency) every time a new
 * number is read. We basically need to print top k numbers sorted by frequency
 * when input stream has included k distinct elements, else need to print all
 * distinct elements sorted by frequency.	
 * 
 *
 */
public class TopKFrequentElementsInStream {

	public static void main(String[] args) {
		int k = 4;
		int arr[] = { 5, 2, 1, 3, 2 };
		kmostFrequentNum(arr, k);
	}

	private static void kmostFrequentNum(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] top = new int[k + 1];
		int n = arr.length;
		map.put(0, 0);
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
			top[k] = num;
			int index = findIndex(top, num);
			for (int j = index; j > 0; j--) {
				if (map.get(top[j - 1]) < map.get(top[j])) {
					int temp = top[j];
					top[j] = top[j - 1];
					top[j - 1] = temp;
				} else if (map.get(top[j - 1]) == map.get(top[j]) && top[j - 1] > top[j]) {
					int temp = top[j];
					top[j] = top[j - 1];
					top[j - 1] = temp;
				} else {
					break;
				}
			}

			for (int j = 0; j < k; j++) {
				if (top[j] == 0) {
					break;
				} else {
					System.out.print(top[j] + " ");
				}

			}
		}
	}

	private static int findIndex(int[] top, int num) {
		for (int i = 0; i < top.length; i++) {
			if (top[i] == num) {
				return i;
			}
		}
		return -1;
	}
}