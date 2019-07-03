package com.ds.stack;

import java.util.Stack;
//5 6 3 8 2 5 2 9 3 62
//Find the minimum element in a stack in O(1) time complexity and O(n) space complexity ?
//Find the Max element in a stack in O(1) time complexity and O(n) space complexity ?
//Find the Range in a stack in O(1) time complexity and O(n) space complexity ?
public class MaxMinStack {

	Stack<Integer> st = new Stack<Integer>();
	Stack<Integer> maxSt = new Stack<Integer>();
	Stack<Integer> minSt = new Stack<Integer>();
	private int max = 0;
	private int min =999999;
	
	public int getMax() {
		return max;
	}
	public int getMin() {
		return min;
	}
	public static void main(String[] args){
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
		System.out.println("Max: "+stack.getMax() + " Min: "+stack.getMin() +" Range :" +(stack.max-stack.min));
		stack.popOut();
		System.out.println("Max: "+stack.getMax() + " Min: "+stack.getMin() +" Range :" +(stack.max-stack.min));
		stack.popOut();
		System.out.println("Max: "+stack.getMax() + " Min: "+stack.getMin() +" Range :" +(stack.max-stack.min));
		stack.popOut();
		System.out.println("Max: "+stack.getMax() + " Min: "+stack.getMin() +" Range :" +(stack.max-stack.min));
		stack.popOut();
		System.out.println("Max: "+stack.getMax() + " Min: "+stack.getMin() +" Range :" +(stack.max-stack.min));
		stack.popOut();
		System.out.println("Max: "+stack.getMax() + " Min: "+stack.getMin() +" Range :" +(stack.max-stack.min));
		stack.popOut();
		System.out.println("Max: "+stack.getMax() + " Min: "+stack.getMin() +" Range :" +(stack.max-stack.min));
		
	}
	private void pushIn(int n){
		st.push(n);
		if(n>max){
			max =n;
			maxSt.push(n);
		}
		if(n<min){
			min = n;
			minSt.push(n);
		}
	}
	private void popOut(){
		
		int popedInt = st.pop();		
		if(popedInt == max){
			maxSt.pop();
			max = maxSt.peek();
		}
		if(popedInt == min){
			minSt.pop();
			min = minSt.peek();
		}
	}
}
