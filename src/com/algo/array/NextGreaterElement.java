package com.algo.array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	/**Given an array of integers(positive or negative), print the next greater element of all elements in the array.
	 *  If there is no greater element then print null.
	 Next greater element of an array element array[i], is an integer array[j], such that
	1. array[i] < array[j]
	2. i < j
	3. j - i is minimum
	i.e. array[j] is the first element on the right of array[i] which is greater than array[i].
	For example:
	Input array:  98, 23, 54, 12, 20, 7, 27
	Output:
	Next greater element for 23     = 54
	Next greater element for 12     = 20
	Next greater element for 7     = 27
	Next greater element for 20     = 27
	Next greater element for 27     = null
	Next greater element for 54     = null
	Next greater element for 98     = null
	 */
	public static void printNextGreaterElement(int[] input) {
		Stack<Integer> stack = new Stack<Integer>();
		int inputSize = input.length;
		stack.push(input[0]);
		for (int i = 1; i < inputSize; i++) {
			while (!stack.isEmpty() && stack.peek() < input[i]) {
				System.out.println("Next greater element for "
						+ stack.pop() + "\t = " + input[i]);
			}
			stack.push(input[i]);
		}
		while (!stack.isEmpty()) {
			int top = (int) stack.pop();
			System.out.println("Next greater element for " + top + "\t = " + null);
		}
	}

	/**
	 * Given a circular array (the next element of the last element is the first
	 * element of the array), print the Next Greater Number for every element.
	 * The Next Greater Number of a number x is the first greater number to its
	 * traversing-order next in the array, which means you could search
	 * circularly to find its next greater number. If it doesn't exist, output
	 * -1 for this number.
	 * 
	 * Example 1: Input: [1,2,1] Output: [2,-1,2] Explanation: The first 1's
	 * next greater number is 2; The number 2 can't find next greater number;
	 * The second 1's next greater number needs to search circularly, which is
	 * also 2.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }
	public static void main(String[] args) {
		int[] input = { 98, 23, 54, 12, 20, 7, 27 };
		printNextGreaterElement(input);
	}
}
