package com.algo.stack.common;

import java.util.Stack;

//Reverse a stack without using extra stack (i.e. doing in place reversal).
//(hinted about using double recursion)
public class ReverseStack {

	public static void main(String[] args){
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(10);
		s1.push(20);
		s1.push(30);
		/*s1.push(40);
		s1.push(50);
		s1.push(60);*/
		System.out.println("Before reverce :");
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());


		s1.push(10);
		s1.push(20);
		s1.push(30);

		revertStack(s1);
		System.out.println("After reverce :");
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());

	}
	public static void revertStack(Stack<Integer> s) {
		if (s.isEmpty()) {
			return;
		} else {
			Integer a = s.pop();
			revertStack(s);
			appendStack(s, a);
		}
	}
	public static void appendStack(Stack<Integer> s, Integer a) {
		if (s.isEmpty()) {
			s.push(a);
			return;
		} else {
			Integer o = s.pop();
			appendStack(s, a);
			s.push(o);
		}
	}
}
