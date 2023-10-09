package stack_pattern2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * Given an array of integers(positive or negative), print the next greater
 * element of all elements in the array. If there is no greater element then
 * print null. Next greater element of an array element array[i], is an integer
 * array[j], such that 1. array[i] < array[j] 2. i < j 3. j - i is minimum i.e.
 * array[j] is the first element on the right of array[i] which is greater than
 * array[i]. For example: 
 * Input array: 98, 23, 54, 12, 20, 7, 27 
 * Output: 
 * Next greater element for 23 = 54 
 * Next greater element for 12 = 20 
 * Next greater element for 7 = 27 
 * Next greater element for 20 = 27 
 * Next greater element for 27 = null 
 * Next greater element for 54 = null 
 * Next greater element for 98 =null
 */
public class NextGreaterElement {

	public static void main(String[] args) {
		int[] input = { 98, 23, 54, 12, 20, 7, 27 };
		//nextGreaterElement(input);
	}
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
		Stack<Integer> stack = new Stack<>();
		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num)
				map.put(stack.pop(), num);
			stack.push(num);
		}   
		for (int i = 0; i < findNums.length; i++)
			findNums[i] = map.getOrDefault(findNums[i], -1);
		return findNums;
	}
}
