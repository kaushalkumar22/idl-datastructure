package com.algo.dynamicprogramming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping way: 
 * 'A' -> 1 
 * 'B' -> 2 ... 
 * 'Z' -> 26 Beyond that, now the
 * encoded string can also contain the character '*', which can be treated as
 * one of the numbers from 1 to 9. Given the encoded message containing digits
 * and the character '*', return the total number of ways to decode it. Also,
 * since the answer may be very large, you should return the output mod 109 + 7.
 * Example 1: Input: "*" Output: 9 Explanation: The encoded message can be
 * decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * 
 * Example 2: Input: "1*" Output: 9 + 9 = 18
 * 
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
        /* initial conditions */
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;

        /* bottom up method */
        for(int i = 2; i <= s.length(); i++){
            char first = s.charAt(i-2);
            char second = s.charAt(i-1);

            // For dp[i-1]
            if(second == '*'){
                dp[i] += 9*dp[i-1];
            }else if(second > '0'){
                dp[i] += dp[i-1];
            }
            
            // For dp[i-2]
            if(first == '*'){
                if(second == '*'){
                    dp[i] += 15*dp[i-2];
                }else if(second <= '6'){
                    dp[i] += 2*dp[i-2];
                }else{
                    dp[i] += dp[i-2];
                }
            }else if(first == '1' || first == '2'){
                if(second == '*'){
                    if(first == '1'){
                       dp[i] += 9*dp[i-2]; 
                    }else{ // first == '2'
                       dp[i] += 6*dp[i-2]; 
                    }
                }else if( ((first-'0')*10 + (second-'0')) <= 26 ){
                    dp[i] += dp[i-2];    
                }
            }

            dp[i] %= 1000000007;
        }
        /* Return */
        return (int)dp[s.length()];
    }
	 public int numDecodings2(String s) {
	        if (s.length() == 0 || s.charAt(0) == '0') return 0;
	        long prev1 = s.charAt(0) == '*' ? 9 : 1;
	        long prev2 = 1;
	        for (int i = 1;i < s.length(); i++){
	            long count = 0;
	            char first = s.charAt(i - 1);
	            char second = s.charAt(i);
	            if (second == '*'){
	                count = 9 * prev1;
	            } else if (second > '0'){
	                count = prev1;
	            }
	            if (first == '*'){
	                if (second == '*'){
	                    count += 15 * prev2;
	                } else if (second <= '6'){
	                    count += 2 * prev2;
	                } else {
	                    count += prev2;
	                }
	            } else if (first == '1' || first == '2'){
	                if (second == '*'){
	                    count += first == '1' ? 9 * prev2 : 6 * prev2;
	                } else if (second <= '6'){
	                    count += prev2;
	                } else {
	                    if (first == '1') count += prev2;
	                }
	            }
	            count %= 1000000007;
	            prev2 = prev1;
	            prev1 = count;
	        }
	        return (int)prev1;
	    }
	}

