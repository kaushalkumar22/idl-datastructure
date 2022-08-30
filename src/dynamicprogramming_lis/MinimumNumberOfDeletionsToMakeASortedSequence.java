package dynamicprogramming_lis;

/**
 * Given an array arr of size N, the task is to remove or delete the minimum number of elements from the array so that when the remaining elements are placed in the same sequence order form an increasing sorted sequence.
 * Input: N = 5, arr[] = {5, 6, 1, 7, 4}
 * Output: 2
 * Explanation: Removing 1 and 4 leaves the remaining sequence order as 5 6 7 which is a sorted sequence.
 *
 * Input: N = 3, arr[] = {1, 1, 1}
 * Output: 2
 */
public class MinimumNumberOfDeletionsToMakeASortedSequence {
    public static void main(String[] args) {
        int arr[] = { 5, 6, 1, 7, 4 };
        int n = arr.length;
        System.out.println("Length of LCS is:" + lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        int n =nums.length;
        if(n<2) return n;
        int[] dp = new int[n];
        int count=1;
        dp[0]=nums[0];
        for(int i=1;i<n;i++) {
            if(dp[count-1]<nums[i]) {
                dp[count++]=nums[i];
            }else {
                int index = binarySearch(dp,0, count, nums[i]);
                dp[index] = nums[i];
            }
        }
        return n-count;
    }
    static int binarySearch(int[] A,int low, int high,int target) {
        while (low <high) {
            int mid = (low+high) / 2;
            if (A[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }


}
