package com.algo.ads.dp.matrix;

import java.util.Stack;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 * 
 * Input: matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * 
 * Input: matrix = [] Output: 0
 *  
 * Input: matrix = [["0"]] Output: 0
 *  
 * Input: matrix = [["1"]] Output: 1
 * 
 * Input: matrix = [["0","0"]] Output: 0
 */
public class MaximalRectangle {
	public static void main(String[] args) {
		char matrix[][] =  {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};
		System.out.println(maximalRectangle(matrix));
	}

	public static int maximalRectangle(char[][] matrix) {
		if( matrix.length==0) return 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int[] temp =new int[col];
		int maxRec=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(matrix[i][j]=='0'){
					temp[j]=0;
				}else{
					temp[j]+=1;
				}
			}  
			maxRec=Math.max(maxRec,largestRectangleArea(temp));
		}
		return maxRec;
	}
	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<Integer>();
		int n = heights.length;
		int maxArea = 0;
		int i=0;
		while(i < n){

			if(s.isEmpty() || heights[s.peek()] <= heights[i]){
				s.push(i++);
			}else{
				int top = s.pop();
				maxArea = Math.max(maxArea, heights[top]*(s.isEmpty()?i:i-s.peek()-1));
			}
		}
		while(!s.isEmpty()){
			int top = s.pop();
			maxArea = Math.max(maxArea, heights[top]*(s.isEmpty()?i:i-s.peek()-1));
		}
		return maxArea;
	}
}
