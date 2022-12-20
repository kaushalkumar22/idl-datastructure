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
		ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.empty());

	}
	Stack<Integer> st1;
	Stack<Integer> st2;
	public ImplementQueueUsingStacks() {
          st1= new Stack<>();
		  st2= new Stack<>();
	}
	public void push(int x) {
           st1.push(x);
	}

	public int pop() {
		if(st2.isEmpty()){
			while (!st1.isEmpty()){
				st2.push(st1.pop());
			}
		}
		return st2.pop();
	}
	public int peek() {
		if(st2.isEmpty()){
			while (!st1.isEmpty()){
				st2.push(st1.pop());
			}
		}
		return st2.peek();
	}
	public boolean empty() {
       return st2.isEmpty()&&st1.isEmpty()?true:false;
	}
}
