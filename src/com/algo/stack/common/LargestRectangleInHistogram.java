package com.algo.stack.common;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * Input: [2,1,5,6,2,3] Output: 10
 *
 * 
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {

		int input[] = { 6, 2, 5, 4, 5, 5, 2, 6, 4 };

		System.out.println(getmaxArea(input));

	}

	public static int getmaxArea(int heights[]) {
		Stack<Integer> s = new Stack<Integer>();
		int n = heights.length;
		int maxArea = 0;
		int i = 0;
		while (i < n) {

			if (s.isEmpty() || heights[s.peek()] <= heights[i]) {
				s.push(i++);
			} else {
				int top = s.pop();
				maxArea = Math.max(maxArea, heights[top] * (s.isEmpty() ? i : i - s.peek() - 1));
			}
		}
		while (!s.isEmpty()) {
			int tp = s.pop();
			maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - s.peek() - 1));
		}
		return maxArea;

	}

}
