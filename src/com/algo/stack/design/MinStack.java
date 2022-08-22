package com.algo.stack.design;

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
	//Approch 1: Using two stack
	Stack<Integer> st= new Stack<Integer>();
	Stack<Integer> minStack= new Stack<Integer>();

	/** Push element x onto stack. */
	public void push(int x) {
		st.push(x);
		if(minStack.empty()||minStack.peek()>=x) {
			minStack.push(x);
		}
	}
	/** Removes the element on top of the stack and returns that element. */
	public void pop() {
		int value =st.pop();
		if(!minStack.empty()&&minStack.peek()==value) {
			minStack.pop();
		}
	}

	/** Get the top element. */
	public int top() {
		return st.peek();

	}
	/** Get the min element. */
	public int getMin() {
		return minStack.peek();

	}

	//Approch 2:Using Linked list
	private Node head; 
	/** Push element x onto stack. */
	public void push1(int x) {
		if (head == null) 
			head = new Node(x, x, null);
		else 
			head = new Node(x, Math.min(x, head.min), head);
	}
	/** Removes the element on top of the stack and returns that element. */
	public void pop1() {
		head = head.next;
	}
	/** Get the top element. */
	public int top1() {
		return head.val;
	}

	/** Get the min element. */
	public int getMin1() {
		return head.min;
	}  
	private class Node {
		int val;
		int min;
		Node next;  
		private Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}

}
