package com.algo.dp.pattern.lcs;

/**
 * 
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character Delete a character Replace a character
 * 
 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse
 * (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 * 
 * Input: word1 = "intention", word2 = "execution" Output: 5 
 * Explanation:
 * intention -> inention (remove 't') 
 * inention -> enention (replace 'i' with 'e') 
 * enention -> exention (replace 'n' with 'x') 
 * exention -> exection (replace 'n' with 'c') 
 * exection -> execution (insert 'u')
 *
 */
public class EditDistance {
	
	public static void main(String args[]) {
		String str1 = "azced";
		String str2 = "abcdef";
		int result = dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
		System.out.println("Minimum Edit Distance: " + result);
		System.out.println(minDistance(str1, str2));
	}
	/**
	 * Uses bottom up DP to find the edit distance
	 */
	public static int dynamicEditDistance(char[] str1, char[] str2) {
		int temp[][] = new int[str1.length + 1][str2.length + 1];

		for (int i = 0; i < temp[0].length; i++) {
			temp[0][i] = i;
		}

		for (int i = 0; i < temp.length; i++) {
			temp[i][0] = i;
		}

		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					temp[i][j] = temp[i - 1][j - 1];
				} else {
					temp[i][j] = 1 + min(temp[i - 1][j - 1], temp[i - 1][j], temp[i][j - 1]);
				}
			}
		}
		// printActualEdits(temp, str1, str2);
		return temp[str1.length][str2.length];

	}

	static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length(), pre;
        int[] cur= new int[n+1];
        for (int j = 1; j <= n; j++) {
            cur[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            pre = cur[0];
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = cur[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = pre;
                } else {
                    cur[j] = Math.min(pre, Math.min(cur[j - 1], cur[j])) + 1;
                }
                pre = temp;
            }
        }
        return cur[n];
    }
	private static int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
	}

	

}
