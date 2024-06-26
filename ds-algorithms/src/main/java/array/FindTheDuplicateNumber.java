package array;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Input: [1,3,4,2,2] Output: 2
 * <p>
 * Input: [3,1,3,4,2] Output: 3
 * <p>
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only). You must use
 * only constant, O(1) extra space. Your runtime complexity should be less than
 * O(n2). There is only one duplicate number in the array, but it could be
 * repeated more than once
 *
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(nums));
		System.out.println(findDuplicate2(nums));
	}

	public static int findDuplicate(int[] nums) {
		if (nums.length <= 1)
			return -1;
		int slow = nums[0];
		int fast = nums[0];
		while (slow != nums[fast]) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}
	public static int findDuplicate2(int[] nums) {//algo is slow
		int low = 1, high = nums.length - 1;
	    while (low <= high) {
	        int mid = low + (high - low)/2;
	        int cnt = 0;
	        for (int a : nums) {
	            if (a <= mid) ++cnt;
	        }
	        if (cnt <= mid) low = mid + 1;
	        else high = mid - 1;
	    }
	    return low;
	}
}
