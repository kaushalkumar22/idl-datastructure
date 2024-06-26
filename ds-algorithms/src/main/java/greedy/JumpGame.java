package greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0
 * to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,1,0,4] Output: false Explanation: You will always arrive
 * at index 3 no matter what. Its maximum jump length is 0, which makes it
 * impossible to reach the last index.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 10^4 0 <= nums[i][j] <= 10^5
 * 
 * 
 */
public class JumpGame {

	public static void main(String[] args) {
		//int arr[] = { 3,2,1,0,4 };
		int arr[] = { 2,3,1,1,4 };

		System.out.println(canJump(arr));
		System.out.println(canJump2(arr));
	}
	static boolean canJump2(int A[]) {
		int n = A.length;
		int reach=0;
		for(int i=0;i<n;i++) {
			reach = Math.max(i + A[i], reach);
			if(reach!=n-1&&reach==i) return false;
		}
		return true;
	}
	public static boolean canJump(int[] nums) {
		int n=nums.length-1;
		int destination =n;
		for(int i=n;i>=0;i--){
			if(i+nums[i]>=destination){
				destination=i;
			}
		}
		return destination==0;
	}
}

