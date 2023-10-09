package array_google;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2007. Find Original Array From Doubled Array : Medium
 * An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.
 *
 * Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.
 *
 * Example 1:
 *
 * Input: changed = [1,3,4,2,6,8]
 * Output: [1,3,4]
 * Explanation: One possible original array could be [1,3,4]:
 * - Twice the value of 1 is 1 * 2 = 2.
 * - Twice the value of 3 is 3 * 2 = 6.
 * - Twice the value of 4 is 4 * 2 = 8.
 * Other original arrays could be [4,3,1] or [3,1,4].
 *
 * Example 2:
 *
 * Input: changed = [6,3,0,1] 0,1,3,6
 * Output: []
 * Explanation: changed is not a doubled array.
 *
 * Example 3:
 *
 * Input: changed = [1]
 * Output: []
 * Explanation: changed is not a doubled array.
 *
 * Constraints:
 *
 *     1 <= changed.length <= 105
 *     0 <= changed[i] <= 105
 */
public class FindOriginalArrayFromDoubledArray {
    public static void main(String[] args) {
        int[] nums ={6,3,0,1};
        System.out.println(Arrays.toString(findOriginalArray(nums)));
    }
    public static int[] findOriginalArray(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return new int[0];
        }

        Map<Integer, Integer> count = new TreeMap<>();
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        System.out.println(count);
        int[] res = new int[n / 2];
        int i=0;
        for (int key : count.keySet()) {
            if (count.get(key) > count.getOrDefault(2*key, 0))
                return new int[0];
            for (int j = 0; j < count.get(key); ++j) {
                res[i++] = key;
                count.put(2*key, count.get(2*key) - 1);
            }
        }
        return res;
    }
}
