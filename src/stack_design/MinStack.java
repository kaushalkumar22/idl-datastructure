package stack_design;

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
//["MinStack","push","push","push","getMin","pop","getMin"]
	//	[[],[0],[1],[0],[],[],[]]

public class MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		System.out.println(minStack.top());// return 0
		System.out.println(minStack.getMin());// return -2
	}
	Stack<Integer> st;
	Stack<Integer> min;
	public MinStack() {
		st= new Stack<>();
		min= new Stack<>();
	}
	public void push(int val) {
		st.push(val);
		if(min.isEmpty()||min.peek()>=val){
			min.push(val);
		}
	}
	public void pop() {
		int val = st.pop();
		if(val==min.peek()){
			min.pop();
		}
	}
	public int top() {
		return st.peek();
	}
	public int getMin() {
		return min.peek();
	}
}
