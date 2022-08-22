package dynamicprogramming_numbers;

/*Given an array of size n, find the longest bitonic subsequence in the array.
A bitonic sequence a sequence which is first increasing and then decreasing.
i.e. it is of the form:
x1, x2, x3, ... xn
where:
    x1 < x2 < x3 < ... < xm
    xm > xm+1 > xm+2 > ... > xn
For example: 10, 25, 36, 40, 59, 48, 34, 20, 5
Here the sequence first increases from 10 to 59 then descreases to 5.

http://www.ideserve.co.in/learn/length-of-longest-bitonic-subsequence-in-an-array
*/
public class LongestBitonicSubsequence {
	 
    public static int longestBitonicSubsequence(int[] input) {
         
        if(input == null || input.length == 0) {
            return 0;
        }
         
        int n = input.length;
        // lisLength[i] = Length of Longest Increasing Subsequence in input[0..i]
        int[] lisLength = new int[n];
        // ldsLength[i] = Length of Longest Increasing Subsequence in input[i..n-1]
        int[] ldsLength = new int[n];
        int maxLength = 1;
 
        // Find lengths of longest increasing subsequence for all sub arrays [0..i]
        lisLength[0] = 1;
        for (int i = 1; i < n; i++) {
            lisLength[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && lisLength[i] < lisLength[j] + 1) {
                    lisLength[i] = lisLength[j] + 1;
                }
            }
        }
 
        // Find lengths of longest decreasing subsequence for all sub arrays [i..n-1]
        ldsLength[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            ldsLength[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (input[i] > input[j] && ldsLength[i] < ldsLength[j] + 1) {
                    ldsLength[i] = ldsLength[j] + 1;
                }
            }
        }
 
        for (int i = 1; i < n; i++) {
            if (maxLength < lisLength[i] + ldsLength[i] - 1)
                maxLength = lisLength[i] + ldsLength[i] - 1;
        }
 
        return maxLength;
    }
 
    public static void main(String[] args) {
        int[] array = { 12, 18, 7, 34, 30, 28, 90, 88 };
        System.out.println("Length of Longest Bitonic Subsequence: " + longestBitonicSubsequence(array));
    }
}
