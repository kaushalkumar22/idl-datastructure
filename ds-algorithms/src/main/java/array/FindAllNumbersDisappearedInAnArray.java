package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * <p>
 * Input: [4,3,2,7,8,2,3,1]
 * <p>
 * Output: [5,6]
 *
 */
public class FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {

		System.out.println(findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1} ));
	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for(int i =0;i<nums.length;i++){
			int index = Math.abs(nums[i]);
			if(nums[index-1]<0){
				continue;
			}else{
				nums[index-1] = -nums[index-1];
			}
		}
		for(int i =0;i<nums.length;i++){
			if(nums[i]>0){
				res.add(i+1);
			}
		}
		return res;
	}
}
