package com.ds.universal;

import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {

		int input[] = {6, 2, 5, 4, 5,5, 2, 6,4};

		System.out.println(getmaxArea(input)); 
	}
	public static int getmaxArea(int input[]){
		Stack<Integer> stack = new Stack<Integer>();
		int n = input.length;
		int maxArea = 0;
		int area = 0;
		int i=0;

		while(i < n){

			if(stack.isEmpty() || input[stack.peek()] <= input[i]){
				stack.push(i++);
				//i++;
			}else{
				int top = stack.pop();
				//stack.pop();
				//if stack is empty means everything till i has to be
				//greater or equal to input[top] so get area by
				//input[top] * i;
				if(stack.isEmpty()){
					area = input[top] * i;
				}
				//if stack is not empty then everythin from i-1 to input.peek() + 1
				//has to be greater or equal to input[top]
				//so area = input[top]*(i - stack.peek() - 1);
				else{
					area = input[top] * (i - stack.peek() - 1);
				}
				if(area > maxArea){
					maxArea = area;
				}
			}
		}
		while(!stack.isEmpty()){
			int top = stack.pop();

			//if stack is empty means everything till i has to be
			//greater or equal to input[top] so get area by
			//input[top] * i;
			if(stack.isEmpty()){
				area = input[top] * i;
			}
			//if stack is not empty then everything from i-1 to input.peek() + 1
			//has to be greater or equal to input[top]
			//so area = input[top]*(i - stack.peek() - 1);
			else{
				area = input[top] * (i - stack.peek() - 1);
			}
			if(area > maxArea){
				maxArea = area;
			}
		}
		return maxArea;

	}
}
