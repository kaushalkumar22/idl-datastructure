package com.ds.design;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * Input ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation MinStack minStack = new MinStack(); 
 * minStack.push(-2);
 * minStack.push(0); 
 * minStack.push(-3); 
 * minStack.getMin(); // return -3
 * minStack.pop(); 
 * minStack.top(); // return 0 
 * minStack.getMin(); // return -2
 * 
 *
 */
public class MaxMinStack {

	Stack<Integer> st = new Stack<Integer>();
	Stack<Integer> maxSt = new Stack<Integer>();
	Stack<Integer> minSt = new Stack<Integer>();
	private int max = 0;
	private int min = 999999;

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MaxMinStack stack = new MaxMinStack();
		stack.pushIn(35);
		stack.pushIn(7);
		stack.pushIn(45);
		stack.pushIn(5);
		stack.pushIn(10);
		stack.pushIn(75);
		stack.pushIn(2);
		stack.pushIn(100);
		stack.pushIn(1);
		System.out.println("Max: " + stack.getMax() + " Min: " + stack.getMin() + " Range :" + (stack.max - stack.min));
		stack.popOut();
		System.out.println("Max: " + stack.getMax() + " Min: " + stack.getMin() + " Range :" + (stack.max - stack.min));
		stack.popOut();
		System.out.println("Max: " + stack.getMax() + " Min: " + stack.getMin() + " Range :" + (stack.max - stack.min));
		stack.popOut();
		System.out.println("Max: " + stack.getMax() + " Min: " + stack.getMin() + " Range :" + (stack.max - stack.min));
		stack.popOut();
		System.out.println("Max: " + stack.getMax() + " Min: " + stack.getMin() + " Range :" + (stack.max - stack.min));
		stack.popOut();
		System.out.println("Max: " + stack.getMax() + " Min: " + stack.getMin() + " Range :" + (stack.max - stack.min));
		stack.popOut();
		System.out.println("Max: " + stack.getMax() + " Min: " + stack.getMin() + " Range :" + (stack.max - stack.min));

	}

	private void pushIn(int n) {
		st.push(n);
		if (n > max) {
			max = n;
			maxSt.push(n);
		}
		if (n < min) {
			min = n;
			minSt.push(n);
		}
	}

	private void popOut() {

		int popedInt = st.pop();
		if (popedInt == max) {
			maxSt.pop();
			max = maxSt.peek();
		}
		if (popedInt == min) {
			minSt.pop();
			min = minSt.peek();
		}
	}
}
