package com.algo.stack.design;

/**
 * 
 * 1381. Design a Stack With Increment Operation Medium
 * 
 * Design a stack which supports the following operations.
 * 
 * Implement the CustomStack class:
 * 
 * CustomStack(int maxSize) Initializes the object with maxSize which is the
 * maximum number of elements in the stack or do nothing if the stack reached
 * the maxSize. void push(int x) Adds x to the top of the stack if the stack
 * hasn't reached the maxSize. int pop() Pops and returns the top of stack or -1
 * if the stack is empty. void inc(int k, int val) Increments the bottom k
 * elements of the stack by val. If there are less than k elements in the stack,
 * just increment all the elements in the stack.
 * 
 * 
 Input
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
Output
[null,null,null,2,null,null,null,null,null,103,202,201,-1]
Explanation
CustomStack customStack = new CustomStack(3); // Stack is Empty []
customStack.push(1);                          // stack becomes [1]
customStack.push(2);                          // stack becomes [1, 2]
customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
customStack.push(2);                          // stack becomes [1, 2]
customStack.push(3);                          // stack becomes [1, 2, 3]
customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
customStack.increment(5, 100);                // stack becomes [101, 102, 103]
customStack.increment(2, 100);                // stack becomes [201, 202, 103]
customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
customStack.pop();                            // return -1 --> Stack is empty return -1.
 * 
 */
public class StackWithIncrementOperation {

	public static void main(String[] args) {
		StackWithIncrementOperation st =new StackWithIncrementOperation(3);
		st.push(1);
		st.push(2);	
		System.out.println(st.pop());
		st.push(2);
		st.push(3);
		st.push(4);
		st.increment(5, 100);                // stack becomes [101, 102, 103]
		st.increment(2, 100);                // stack becomes [201, 202, 103]
		System.out.println(st.pop());       // return 103 --> Return top of the stack 103, stack becomes [201, 202]
		System.out.println(st.pop());      // return 202 --> Return top of the stack 102, stack becomes [201]
		System.out.println(st.pop());     // return 201 --> Return top of the stack 101, stack becomes []
		System.out.println(st.pop());    // return -1 --> Stack is empty return -1.

	}
	int[] stack;
	int count;
	public StackWithIncrementOperation(int maxSize) {
		stack = new int[maxSize];
		count=-1;
	}
	/** Push element x onto stack. */
	public void push(int x) {
		if(count+1<stack.length) {
			stack[++count]=x;
		}
	}
	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if(count==-1) return -1;
		int x = stack[count];
		stack[count]=0;
		count--;
		return x;
	}
	/** increment as of condition*/
	public void increment(int k, int val) {
		k=k<count+1?k:count+1;
		for(int i=0;i<k;i++) {
			stack[i]=stack[i]+val;
		}
	}
}
