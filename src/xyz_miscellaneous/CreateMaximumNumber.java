package xyz_miscellaneous;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two. The
 * relative order of the digits from the same array must be preserved. Return an
 * array of the k digits. 
 * 
 * Note: You should try to optimize your time and space complexity. 
 * Example 1: Input: nums1 = [3, 4, 6, 5] nums2 = [9, 1, 2, 5, 8, 3] k = 5 Output: [9, 8, 6, 5, 3] 
 * Example 2: Input: nums1 = [6, 7] nums2 = [6, 0, 4] k = 5 Output: [6, 7, 6, 0, 4] 
 * Example 3: Input: nums1 = [3, 9] nums2 = [8, 9] k = 3 Output: [9, 8, 9]
 * 
 *
 */
public class CreateMaximumNumber {

	/*
	 * Create the maximum number of one array Create the maximum number of two array
	 * using all of their digits.
	 * 
	 * For an long and detailed explanation see my blog here.
	 * 
	 * The algorithm is O((m+n)^3) in the worst case. It runs in 22 ms.
	 */
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[k];
        for(int i = Math.max(0, k - len2); i <= k && i <= len1; i++){
            int[] can = merge(maxArray(nums1, i), maxArray(nums2, k - i));
            if(larger(can, 0, res, 0)){
                res = can;
            }
        }
        return res;
    }
    private int[] maxArray(int[] a, int k){
        int len = a.length;
        int valid = 0;
        int[] res = new int[k];
        for(int i = 0; i < len; i++){
            //len - 1 is the right index of 'a', while i is the left index we have visited
            //len - 1 - i means the length we have not visited yet
            // k - 1 is the right index of 'res', while valid is next index of res we need to give value
            //k - 1 - valid is the length we need to give value on 'res'
            //if len - 1 - i > k - 1 - valid, means we still have more options left on 'a' than we need to fill 'res'
            //so we are still free to search  for a larger number to put on lower index of 'res'.
            //so this is 'greedy' actually.
            while(len - i  - 1> k - 1 - valid && valid > 0 && res[valid - 1] < a[i]){
                valid--;
            }
            if(valid < k){
                res[valid++] = a[i];
            }
        }
        return res;
    }
    private int[] merge(int[] a, int[] b){
        int[] res = new int[a.length + b.length];
        int valid = 0, i = 0, j = 0;
        while(i < a.length && j < b.length){
            res[valid++] = larger(a, i, b, j) ? a[i++] : b[j++];
        }
        while(i < a.length){
            res[valid++]= a[i++];
        }
        while(j < b.length){
            res[valid++] = b[j++];
        }
        return res;
    } 
    private boolean larger(int[] a, int x, int[] b, int y){
        while(x < a.length && y < b.length && a[x] == b[y]){
            x++; y++;
        }
        return y == b.length || (x < a.length && a[x] > b[y]);
    }
}
