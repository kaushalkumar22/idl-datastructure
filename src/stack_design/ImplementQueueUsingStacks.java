package stack_design;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty.
 * 
 * Example:
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1); 
 * queue.push(2); 
 * queue.peek(); // returns 1 
 * queue.pop(); //returns 1 
 * queue.empty(); // returns false
 *
 */
public class ImplementQueueUsingStacks {

	public static void main(String[] args) {

	}
	Stack<Integer> st1 ;
	Stack<Integer> st2 ;
	/** Initialize your data structure here. */
	public ImplementQueueUsingStacks() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		st1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		peek();
		return st2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (st2.empty())
			while (!st1.empty())
				st2.push(st1.pop());
		return st2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return st1.empty() && st2.empty();
	}
}
