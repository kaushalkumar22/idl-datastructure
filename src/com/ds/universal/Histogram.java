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
	/*
		Stack<Integer> s = new Stack<Integer>();

		int hMaxArea = 0;
		int top;  // To store top of stack
		int areaWithTop; // To store area with top bar as the smallest bar
		//Start from first bar, and do following for every bar ‘hArray[i]’ where ‘i’ varies from 0 to n-1.
		int i = 0;
		while (i < n){
			// If stack is empty or hArray[i] is higher than hArray[s.peek()], then push ‘i’ to stack.
			if (s.empty() ||hArray[s.peek()] <= hArray[i]){
				s.push(i);
				i++;

				//if hArray[i] is smaller than top of stack hArray[s.peek()], then keep removing the top of stack while top of the stack is greater
				// Let the removed bar be hist[tp]. Calculate area of rectangle with hArray[top] as smallest bar. For hArray[top], the ‘left index’ is previous 
				//(previous to top) item in stack and ‘right index’ is ‘i’ (current index). 
			}else{    	
				top = s.peek();  
				s.pop(); 
				// Calculate the area with hist[top] stack as smallest bar
				areaWithTop = hArray[top] * (s.empty() ? i : i - s.peek() - 1);

				if (hMaxArea < areaWithTop){
					hMaxArea = areaWithTop;
				}
			}
		}
		// Now pop the remaining bars from stack and calculate area with every
		while (s.empty() == false){
			top = s.peek();
			s.pop();
			areaWithTop = hArray[top] * (s.empty() ? i : i - s.peek() - 1);

			if (hMaxArea < areaWithTop){
				hMaxArea = areaWithTop;
			}
		}
		System.out.println(hMaxArea);
	}*/
}
