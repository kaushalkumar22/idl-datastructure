package array;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
 * and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 *     1 <= nums.length <= 2 * 104
 *     -10 <= nums[i] <= 10
 *     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,2,3,0,-2,4,-5};
        int best=nums[0];
        int prod =1;
        for(int num:nums){
            prod=prod*num==0?num:prod*num;
            best= Math.max(best,Math.max(prod,num));
        }
        System.out.println(best);
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int maxSum = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0){
                int tmp = currentMax;
                currentMax = currentMin;
                currentMin = tmp;
            }

            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }
}
