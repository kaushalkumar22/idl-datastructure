package dynamicprogramming_lis;

/**
 * Given an array arr of N positive integers, the task is to find the maximum sum increasing subsequence of the given array.
 *
 * Input: N = 5, arr[] = {1, 101, 2, 3, 100}  Output: 106
 * Explanation:The maximum sum of an increasing sequence is obtained from {1, 2, 3, 100}
 * Input: N = 3, arr[] = {1, 2, 3}  Output: 6
 * Explanation:The maximum sum of an increasing sequence is obtained from {1, 2, 3}
 */
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int N = 5, arr[] = {1, 101, 2, 3, 100};
        System.out.println(maximumSumIncreasingSubsequence(arr,N));
    }
    public static int maximumSumIncreasingSubsequence(int arr[], int n){
        int i, j, max = 0;
        int dp[] = new int[n];
        //Initialize msis values for all indexes
        for (i = 0; i < n; i++)
            dp[i] = arr[i];
        // Compute maximum sum values in bottom up manner
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] &&dp[i] < dp[j] + arr[i])
                    dp[i] = dp[j] + arr[i];
        // Pick maximum of all msis values
        for (i = 0; i < n; i++)
            if (max < dp[i])
                max = dp[i];
        return max;
    }

}
