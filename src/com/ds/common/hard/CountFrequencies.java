package com.ds.common.hard;

/*Given an array of length n having integers 1 to n with some elements being repeated. 
 * Count frequencies of all elements from 1 to n.
Example:
Input Array: {2, 3, 3, 2, 5}
Output:
1 0
2 2
3 2
4 0
5 1*/
public class CountFrequencies {
	 
    // O(n^2) time and O(1) space
    public static void countFrequenciesNaive(int[] input) {
        int n = input.length;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (input[j] == i) {
                    count++;
                }
            }
            System.out.println(i + " " + count);
        }
    }
 
    // O(n) time and O(n) space
    public static void countFrequencies(int[] input) {
        int n = input.length;
        int[] count = new int[n];
 
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
 
        for (int i = 0; i < n; i++) {
            count[input[i] - 1]++;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " " + count[i]);
        }
    }
 
    // O(n) time and O(1) space
    public static void countfrequenciesEfficient(int input[]) {
 
        int n = input.length;
        for (int i = 0; i < n; i++) {
            input[i]--;
        }
 
        for (int i = 0; i < n; i++) {
            input[input[i] % n] = input[input[i] % n] +n;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + input[i] / n);
            // Change the element back to original value
            input[i] = input[i] % n + 1;
        }
    }
 
    public static void main(String[] args) {
        int[] input = { 2, 3, 3, 2, 5 };
        countfrequenciesEfficient(input);
    }
}