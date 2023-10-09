package array_google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return an integer array counts where counts[i] is the number
 * of smaller elements to the right of nums[i].
 *
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * Input: nums = [-1]
 * Output: [0]
 *
 * Input: nums = [-1,-1]
 * Output: [0,0]
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 */
public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(nums));
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums ==null || nums.length ==0 ) return res;
        int n = nums.length;
        int[] result = new int[n];
        int[][] numsWithIndex = new int[n][2];
        for(int i = 0;i<n;i++){
            numsWithIndex[i] = new int[]{nums[i],i};
        }
        sort(numsWithIndex,0,n-1,result);
        for(int i =0 ;i<n; i++){
            res.add(i,result[i]);
        }
        return res;
    }

    private void sort(int[][] numsWithIndex, int low, int high, int[]  res) {
        if(low>=high) return;
        int mid = low + (high-low)/2;
        sort(numsWithIndex,low,mid,res);
        sort(numsWithIndex,mid+1,high,res);
        merge(numsWithIndex,low,mid,high,res);
    }

    private void merge(int[][] nums, int low, int mid, int high, int[] res) {

        // Find sizes of two subarrays to be merged
        int n1 = mid - low + 1;
        int n2 = high- mid;

        /* Create temp arrays */
        int[][] left = new int[n1][2];
        int[][] right = new int[n2][2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            left[i] = nums[low + i];
        }
        for (int i = 0; i < n2; ++i) {
            right[i] = nums[mid + 1 + i];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = low;
        while (i < n1 && j < n2) {
            if (left[i][0] > right[j][0]) {
                nums[k] = left[i];
                res[left[i][1]] = res[left[i][1]]+1;
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            nums[k] = left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }
}

