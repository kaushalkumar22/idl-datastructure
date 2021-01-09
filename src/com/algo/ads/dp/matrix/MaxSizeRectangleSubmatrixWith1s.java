package com.algo.ads.dp.matrix;

import com.algo.nlds.stack.common.LargestRectangleInHistogram;

public class MaxSizeRectangleSubmatrixWith1s {

	private static int largestRectangle(int matrix[][]){

		int r = matrix.length;
		int c = matrix[0].length;

		int temp[] = new int[c];
		int maxArea = 0;
		int area = 0;
		for(int i=0; i < r; i++){
			for(int j=0; j < c; j++){
				if(matrix[i][j] == 0){
					temp[j] = 0;
				}else{
					temp[j] += matrix[i][j];
				}
			}
			area = LargestRectangleInHistogram.getmaxArea(temp);

			if(area > maxArea){
				maxArea = area;
			}
		}
		return maxArea;
	}
	public static void main(String[] args) {
		int matrix[][] = {
				{ 0, 1, 1, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 0, 1 }
		};
		System.out.println(largestRectangle(matrix));
	}

}
