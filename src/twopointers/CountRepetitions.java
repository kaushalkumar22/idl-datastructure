package twopointers;

/**
 * Define S = [s,n] as the string S which consists of n connected strings s. For
 * example, ["abc", 3] ="abcabcabc".
 * 
 * On the other hand, we define that string s1 can be obtained from string s2 if
 * we can remove some characters from s2 such that it becomes s1. For example,
 * “abc” can be obtained from “abdbec” based on our definition, but it can not
 * be obtained from “acbbe”.
 * 
 * You are given two non-empty strings s1 and s2 (each at most 100 characters
 * long) and two integers 0 <= n1 <= 106 and 1 <= n2 <= 106. Now consider the
 * strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer
 * M such that [S2,M] can be obtained from S1.
 * 
 * Example:
 * 
 * Input: s1="acb", n1=4 s2="ab", n2=2
 * 
 * Return: 2
 *
 * 
 */
public class CountRepetitions {
	public static void main(String[] args) {
		System.out.println(getMaxRepetitionsOpt("acb", 4, "ab", 2));
	}
	/*
	 * How do we know "string s2 can be obtained from string s1"? Easy, use two
	 * pointers iterate through s2 and s1. If chars are equal, move both.
	 * Otherwise only move pointer1. We repeat step 1 and go through s1 for n1
	 * times and count how many times can we go through s2. Answer to this
	 * problem is times go through s2 divide by n2.
	 */
	public static int getMaxRepetitionsOpt(String s1, int n1, String s2, int n2) {
        int count1 = 0, count2 = 0, i = 0, j = 0;
        while (count1 < n1) {
        	if(s1.charAt(i) == s2.charAt(j)) {
                j++;
                if (j == s2.length()) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == s1.length()) {
                i = 0;
                count1++;
            }
        }
        
        return count2 / n2;
    }
	
	public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {

		int k = 0;
		int count = 0;
		for(int i = 0; i < n1; i++) {
			for(int j = 0; j < s1.length();) {
				if(s1.charAt(j) == s2.charAt(k)) {
					j++;
					k++;
					if(k == s2.length()) {
						k = 0;
						count += 1;
					}
				}else {
					j++;
				}

				if(j==s1.length() && k == 0) {
					return (int) (n1 * 1.0 / (i+1) * count / n2);
				}
			}
		}
		return count / n2 ;
	}
}
