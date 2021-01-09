package com.algo.nlds.stack.design;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation MinStack minStack = new MinStack(); 
 * minStack.push(-2);
 * minStack.push(0);
 *  minStack.push(-3); 
 *  minStack.getMin(); // return -3
 * minStack.pop(); 
 * minStack.top(); // return 0 
 * minStack.getMin(); // return -2
 *
 * 
 */
public class MinStack {
	public static void main(String[] args) {

	}
	Stack<Integer> st= new Stack<Integer>();
	Stack<Integer> minStack= new Stack<Integer>();

	public void push(int x) {
		st.push(x);
		if(minStack.empty()||minStack.peek()>=x) {
			minStack.push(x);
		}
	}

	public void pop() {
		int value =st.pop();
		if(!minStack.empty()&&minStack.peek()==value) {
			minStack.pop();
		}
	}

	public int top() {
		return st.peek();

	}

	public int getMin() {
		return minStack.peek();

	}
}
