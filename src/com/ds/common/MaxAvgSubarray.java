package com.ds.common;

public class MaxAvgSubarray {
	 
    private static int getMaxAvgSubarrayStartIndex(int input[], int k)
    {
        int n = input.length;
        if (k > n)
            throw new IllegalArgumentException("k should be less than or equal to n");
      
        if(k == n) {
            return 0;   // whole array is the solution
        }
 
        // Sum of first k elements
        int sum = input[0];
        for (int i = 1; i < k; i++)
            sum += input[i];
      
        // Initialized to first k elements sum
        int maxSum = sum;
        int maxSumIndex = 0;
      
        // Sum of remaining sub arrays
        for (int i = k; i < n; i++)
        {
            // Remove first element of the current window and add next element to the window
            sum = sum - input[i-k] + input[i] ;
            if (sum > maxSum)
            {
                maxSum = sum;
                maxSumIndex = i-k;
            }
        }
      
        // Return starting index of max avg sub array
        return maxSumIndex + 1;
    }
     
    public static void printMaxAvgSubarray(int[] input, int k) {
        System.out.print("Maximum average subarray of length " + k + " is:  ");
        int index = getMaxAvgSubarrayStartIndex(input, k);
        for(int i =0 ; i < k; i++) {
            System.out.print(input[index++] + " ");
        }
    }
     
    public static void main(String[] args) {
        int[] input = {11, -8, 16, -7, 24, -2, 3};
        int k = 3;
        printMaxAvgSubarray(input, k);
    }
}