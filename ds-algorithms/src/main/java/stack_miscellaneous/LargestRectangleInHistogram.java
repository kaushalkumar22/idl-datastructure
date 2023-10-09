package stack_miscellaneous;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * Input: [2,1,5,6,2,3] Output: 10
 *
 * 
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int input[] = { 2};
		System.out.println(getmaxArea(input));
	}

	public static int getmaxArea(int heights[]) {

		int maxArea=0;
		Stack<Integer> st= new Stack<>();
		int n= heights.length;
		int i=0;
		while (i<n){
			if(st.isEmpty()||heights[st.peek()]<heights[i]){
				st.push(i++);
			}else{
				int top = st.pop();
				maxArea=Math.max(maxArea,heights[top]*(i-(st.isEmpty()?0:st.peek()+1)));

			}
		}
		while (!st.isEmpty()){
			int top = st.pop();
			maxArea=Math.max(maxArea,heights[top]*(i-(st.isEmpty()?0:st.peek()+1)));
		}
		return maxArea;
	}
}
