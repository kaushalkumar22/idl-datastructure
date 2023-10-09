package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Input: [4,3,2,7,8,2,3,1]
 * <p>
 * Output: [2,3]
 *
 */
public class FindAllDuplicatesInAnArray {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDuplicates(nums));

	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for(int i =0 ;i<nums.length ;i++){
			int index = Math.abs(nums[i]);
			if(nums[index-1]<0){
				res.add(index);
			}else{
				nums[index-1] =-nums[index-1];
			}
		}
		return res;
	}
}
