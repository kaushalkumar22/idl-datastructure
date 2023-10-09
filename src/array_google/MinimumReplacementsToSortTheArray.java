package array_google;

/**
 * You are given a 0-indexed integer array nums. In one operation you can replace any element of the array
 * with any two elements that sum to it.
 * For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].
 *
 * Return the minimum number of operations to make an array that is sorted in non-decreasing order.
 * Input: nums = [3,9,3]
 * Output: 2
 * Explanation: Here are the steps to sort the array in non-decreasing order:
 * - From [3,9,3], replace the 9 with 3 and 6 so the array becomes [3,3,6,3]
 * - From [3,3,6,3], replace the 6 with 3 and 3 so the array becomes [3,3,3,3,3]
 * There are 2 steps to sort the array in non-decreasing order. Therefore, we return 2.
 *
 * Input: nums = [1,2,3,4,5]
 * Output: 0
 * Explanation: The array is already in non-decreasing order. Therefore, we return 0.
 *
 *[12,9,7,6,17,19,21] O/P =6
 * Constraints:
 *     1 <= nums.length <= 105
 *     3,9,3
 *     3 3
 * --------------------------------------------------------------------------------------
 * Start traversing from the end of array
 *
 * if current no is divisible by the previous number and suppose
 * current no is a, and prev no is b,
 * then we must need to divide current number(a) to a/b-1 times
 *
 * suppose current number is 9 and previous number is 3,
 * then we can divide it into 9/3 times-1,
 * in this case prev remains same (No need to update)
 *
 * now suppose if prev number is not divisible by current number,
 * suppose current is 7 prev is 5,
 * so we can divide 7 into
 * 2 ,5
 * 3, 4
 * out of this 3,4 is the best choice ,
 *
 * and for every element we have to add noOfTime to our ans,
 * i.e, no of times we need to divide a current element,
 *
 * what is reason behind for finding prev by prev=nums[i]/noOfTime; how it find best fit
 * suppose a number is 10 and we have to divide it into 3 times,
 * then our aim is to make minimum no from these three as maximum as possible,
 * but why ??
 * suppose array is 3 10 4
 * then our ans is , 2
 * because we divide 10 into 3 pieces i.e, 3 3 4
 * but what if i divide it into 2 4 4, ?
 * still the answer is 2 ???
 * No answers is 3 now,
 *
 * to select the minimum no out of these 3 partition number,
 * we make prev=nums[i]/noOfTime;
 * means prev=10/3 , i.e, (3)
 */
public class MinimumReplacementsToSortTheArray {
    public static void main(String[] args) {
        int[] nums ={3,10,3};
        System.out.println(minimumReplacement( nums));
    }
    public static long minimumReplacement(int[] nums) {
        int n = nums.length , prev = nums[n-1];;
        long ans=0;
        for(int i=n-2;i>=0;i--){
            int noOfTime = nums[i]/prev;
            if((nums[i])%prev!=0){
                noOfTime++;
                prev=nums[i]/noOfTime;
            }
            ans+=noOfTime-1;
        }
        return ans;
    }
}

