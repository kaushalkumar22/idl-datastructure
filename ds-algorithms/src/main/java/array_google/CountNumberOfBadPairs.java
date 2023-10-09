package array_google;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
 *
 * Return the total number of bad pairs in nums.
 *
 * Input: nums = [4,1,3,3]
 * Output: 5
 * Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
 * The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
 * The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
 * The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
 * The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
 * There are a total of 5 bad pairs, so we return 5.
 *
 * Input: nums = [1,2,3,4,5]
 * Output: 0
 * Explanation: There are no bad pairs.
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     1 <= nums[i] <= 109
 *
 *     j-nums[j]=  i- nums[i].
 *
 *  if size of array in n then there are total pairs n*(n-1)/2
 *  so total pair = good pair + bad pair
 *  bad  = total -good;
 *  condition for bad  j - i != nums[j] - nums[i]
 *  then condition for good is i-nums[i] = j- nums[j]
 *  now this prob is similar to find the two sum from unsorted array.
 */
public class CountNumberOfBadPairs{
    public static void main(String[] args) {
        int[] nums ={4,1,3,3};
        System.out.println(countBadPairs( nums));
    }
    public static long countBadPairs(int[] nums) {
        long count = 0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int prev = map.getOrDefault(i-nums[i],0);
            count += prev ;
            map.put(i-nums[i], prev+1);
        }
        return 1l*n*(n-1)/2 -count;
    }
}

