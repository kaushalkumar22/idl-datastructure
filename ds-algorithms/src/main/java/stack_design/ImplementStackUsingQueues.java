package stack_design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. empty() -- Return whether the stack
 * is empty.
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1); stack.push(2); stack.top(); // returns 2 stack.pop(); //
 * returns 2 stack.empty(); // returns false
 *
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid. Depending
 * on your language, queue may not be supported natively. You may simulate a
 * queue by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a queue. You may assume that all operations are valid
 * (for example, no pop or top operations will be called on an empty stack).
 *
 */
public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());// returns 2
		System.out.println(stack.pop());// return 2
		System.out.println(stack.empty());// returns false
	}
	Queue<Integer> que;
	public ImplementStackUsingQueues() {
		que= new LinkedList<>();
	}

	public void push(int x) {
		int size= que.size();
		que.add(x);
		for(int i=0;i<size;i++){
			que.add(que.poll());
		}
	}

	public int pop() {
		return que.poll();
	}

	public int top() {
		return que.peek();
	}

	public boolean empty() {
		return que.isEmpty();
	}
}
