package com.algo.dp.pattern.lcs;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubstring {

	public static void main(String args[]) {
		String s1="CLCL";
		String s2="LCLC";
		List<String> result = commonSubstring(s1, s2);
		for (String str : result) {
			System.out.println(str);
		}
		System.out.println(LCS( s1,  s2));
	}
public static int LCS(String s1, String s2) {
		
	int m= s1.length();
	int n =s2.length();
	int[][] T = new int[m+1][n+1];
	int max = Integer.MIN_VALUE;
	for(int i=1;i<m+1;i++) {
		for(int j=1;j<n+1;j++) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				T[i][j] = 1+T[i-1][j-1];
				max= Math.max(max, T[i][j]);
			}else {
				T[i][j] =0;//in java this else part not require its already 0
				max= Math.max(max, T[i][j]);
			}
		}
	}
		return max;
	}
	public static List<String> commonSubstring(String S1, String S2) {
		
		Integer match[][] = new Integer[S1.length()][S2.length()];

		int len1 = S1.length();
		int len2 = S2.length();
		int max = Integer.MIN_VALUE; // Maximum length of the string
		ArrayList<String> result = null; // Result list

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (S1.charAt(i) == S2.charAt(j)) {
					if (i == 0 || j == 0)
						match[i][j] = 1;

					else
						match[i][j] = match[i - 1][j - 1] + 1;

					if (match[i][j] > max) // If you find a longer common substring re-initialize the max count and
											// update the result list.
					{
						max = match[i][j];
						result = new ArrayList<String>();
						result.add(S1.substring(i - max + 1, i + 1)); // substring starts at i-max+1 and ends at i
					} else if (match[i][j] == max) // else if you find a common substring with the max length, store it
													// in the list.
					{
						result.add(S1.substring(i - max + 1, i + 1));
					}
				} else
					match[i][j] = 0;

			}
		}
		return result;
	}

}
