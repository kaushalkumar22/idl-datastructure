package com.ds.matrix;

public class MaxSizeSquareSubMatrixWith1s {

	private static int getMaxSizeSquareSubmatrixWithAllOnes(int matrix[][]){

		int r = matrix.length;
		int c = matrix[0].length;
		int maxSize =0;
		int[][] table =new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){

				if(i==0 || j==0){
					table[i][j]=matrix[i][j];
					maxSize = (matrix[i][j]>maxSize ? matrix[i][j] : maxSize);
				}else if(matrix[i][j]==0){
					table[i][j]=0;
				}else{
					table[i][j]= Math.min(table[i-1][j-1],Math.min(table[i-1][j],table[i][j-1]))+1;
					if(table[i][j]>maxSize){
						maxSize = table[i][j];
					}
				}
			}
		}
		
		return maxSize;
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
		System.out.println(getMaxSizeSquareSubmatrixWithAllOnes(matrix));
	}

}
