package stack_pattern2;

import java.util.Stack;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three
 * integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] <
 * nums[k] < nums[j].
 * 
 * Return true if there is a 132 pattern in nums, otherwise return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: false Explanation: There is no 132 pattern in
 * the sequence.
 * 
 * Example 2:
 * 
 * Input: nums = [3,1,4,2] Output: true Explanation: There is a 132 pattern in
 * the sequence: [1, 4, 2].
 * 
 * Example 3:
 * 
 * Input: nums = [-1,3,2,0] Output: true Explanation: There are three 132
 * patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 * 
 */
public class Find132Pattern {
	public static void main(String[] args) {
		int[] nums= {3,1,4,2};
		System.out.println(find132pattern(nums));
	}
	 public static boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<Integer>();
        for( int i = nums.length-1; i >= 0; i -- ){//need to start from end because the the last value should greater the first 1<3
            if( nums[i] < s3 ) { 
            	return true;
            }else {
            	while( !st.empty() && nums[i] > st.peek() ){ 
                s3 = st.pop(); 
            	}
            }
            st.push(nums[i]);
        }
        return false;
    }
}
