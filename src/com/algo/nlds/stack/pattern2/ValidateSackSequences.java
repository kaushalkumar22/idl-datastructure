package com.algo.nlds.stack.pattern2;

import java.util.Stack;

/**
 * Given two sequences pushed and popped with distinct values, return true if
 * and only if this could have been the result of a sequence of push and pop
 * operations on an initially empty stack.
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1] Output: true Explanation:
 * We might do the following sequence: push(1), push(2), push(3), push(4), pop()
 * -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 
 * Example 2:
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2] Output: false Explanation:
 * 1 cannot be popped before 2.
 * 
 * 
 * @author IBM
 *
 */
public class ValidateSackSequences {
	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
		System.out.println(validateStackSequences(pushed,popped));
	}
	public static boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> stack = new Stack<>();
		int i = 0;
		for (int x : pushed) {
			stack.push(x);
			while (!stack.empty() && stack.peek() == popped[i]) {
				stack.pop();
				i++;
			}
		}
		return stack.empty();
	}

}

