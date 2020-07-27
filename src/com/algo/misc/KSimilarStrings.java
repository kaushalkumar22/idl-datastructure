package com.algo.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Strings A and B are K-similar (for some non-negative integer K) if we can
 * swap the positions of two letters in A exactly K times so that the resulting
 * string equals B.
 * 
 * Given two anagrams A and B, return the smallest K for which A and B are
 * K-similar.
 * 
 * 
 * Input: A = "ab", B = "ba" Output: 1 
 * 
 * Input: A = "abc", B = "bca" Output: 2 
 * 
 * Input: A = "abac", B = "baca" Output: 2 
 * 
 * Input: A = "aabc", B = "abca" Output: 2
 *
 */
public class KSimilarStrings {

	//Classic BFS: swap only pair at every step and use bfs to guaranteee shortest path

	public static void main(String[] args) {
		System.out.println(kSimilarity("abac","baca"));
		
	}
	    public static int kSimilarity(String A, String B) {
	        Queue<String> queue = new LinkedList<>();
	        Set<String> seen = new HashSet<>();
	        queue.offer(A);
	        seen.add(A);
	        int res = 0;
	        while (!queue.isEmpty()){
	            int size = queue.size();
	            for (int i = 0; i < size; i++){
	                String curr = queue.poll();
	                if (curr.equals(B)){
	                    return res;
	                }
	                int j = 0;
	                while (j < curr.length() && curr.charAt(j) == B.charAt(j)){
	                    j++;
	                }
	                for (int k = j + 1; k < curr.length(); k++){
	                    if (curr.charAt(k) == B.charAt(j) && curr.charAt(k) != B.charAt(k)){
	                        String next = swap(curr, j, k);//return string to ensure that curr won't change
	                        if (!seen.contains(next)){
	                            queue.offer(next);
	                            seen.add(next);
	                        }
	                    }
	                }
	            }
	            res++;
	        }
	        return res;
	    }
	    private static String swap(String curr, int j, int k){
	        char[] arr = curr.toCharArray();
	        char temp = arr[j];
	        arr[j] = arr[k];
	        arr[k] = temp;
	        return new String(arr);
	    }
	}
