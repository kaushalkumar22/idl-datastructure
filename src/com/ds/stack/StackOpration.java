package com.ds.stack;
import java.util.EmptyStackException;
public class StackOpration {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack();
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println("stack.peek(): " + stack.peek());
		System.out.println("stack.pop(): " + stack.pop());
		System.out.println("stack.pop(): " + stack.pop());
		stack.display();
	}
}
class ArrayStack implements Stack {

	private static final int INITIAL_CAPACITY = 10;
	private int[] arrStack;
	private int top;
	public ArrayStack() {
		arrStack =  new int[INITIAL_CAPACITY];

	}
	
	public void push(int element) {
		if (top == arrStack.length-1){
			throw new StackOverflowError("Stack Overflow");
		}
		arrStack[++top] = element;
	}		
	
	public int peek() {
		// TODO Auto-generated method stub
		return arrStack[top];
	}
	
	public int pop() {
		if (top == 0) {
			throw new EmptyStackException();
		}
		int element = arrStack[top];
		--top;
		return element;
	}
	
	public int top() {
		return top;
	}
	
	public boolean isEmpty() {
		return (top==0);
	}
	public void display() {
		while(!isEmpty()){
			System.out.println("display : "+pop());
		}
	}
}
interface Stack{
	public void push(int element);
	public boolean isEmpty();
	public int peek();
	public int pop();	
	public int top();
}
