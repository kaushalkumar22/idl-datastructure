package com.ds.stack;

import java.util.Stack;

//http://www.informatik.uni-ulm.de/acm/Locals/2003/html/histogram.html
//Time and space Complexity O(n)
public class HistogramUsingStack {

	public static void main(String[] args) {

		int hArray[] = {6, 2, 5, 4, 5,5, 2, 6,4};
		int n = hArray.length;

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
	}
}
