package com.algo.binary;

/**
 * A string of '0's and '1's is monotone increasing if it consists of some
 * number of '0's (possibly 0), followed by some number of '1's (also possibly
 * 0.)
 * 
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or
 * a '1' to a '0'.
 * 
 * Return the minimum number of flips to make S monotone increasing.
 * 
 * Input: "00110" Output: 1 Explanation: We flip the last digit to get 00111.
 * Input: "010110" Output: 2 Explanation: We flip to get 011111, or alternatively 000111. 
 * Input: "00011000" Output: 2 Explanation: We flip to get 00000000.
 * 
 *
 */
public class FlipStringToMonotoneIncreasing {
/*
	Skip 0's until we encounter the first 1.
	Keep track of number of 1's in onesCount (Prefix).
	Any 0 that comes after we encounter 1 can be a potential candidate for flip. Keep track of it in flipCount.
	If flipCount exceeds oneCount - (Prefix 1's flipped to 0's)
	a. Then we are trying to flip more 0's (suffix) than number of 1's (prefix) we have.
	b. Its better to flip the 1's instead.
*/	public int minFlipsMonoIncr(String S) {
		if(S == null || S.length() <= 0 )
			return 0;

		char[] sChars = S.toCharArray();
		int flipCount = 0;
		int onesCount = 0;

		for(int i=0; i<sChars.length; i++){
			if(sChars[i] == '0'){
				if(onesCount == 0) continue;
				else flipCount++;
			}else{
				onesCount++;
			}
			if(flipCount > onesCount){
				flipCount = onesCount;
			}
		}
		return flipCount;
	}
}
