package com.algo.dp.matrix;
/*Given a matrix with 0 and 1’s, find the largest rectangle of all 1’s in the matrix. 
 * The rectangle can be formed by swapping any pair of columns of given matrix.
 Input: bool mat[][] = { {0, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1},
                        {1, 1, 0, 1, 0}
                      };
Output: 6
The largest rectangle's area is 6. The rectangle 
can be formed by swapping column 2 with 3
The matrix after swapping will be
     0 0 1 1 0
     0 0 1 1 1
     1 0 1 1 0


Input: bool mat[R][C] = { {0, 1, 0, 1, 0},
                         {0, 1, 1, 1, 1},
                         {1, 1, 1, 0, 1},
                         {1, 1, 1, 1, 1}
                      };
Output: 9*/

public class LargestRectangleOf1sWithColumnsSwapping {
	
	private static int maxArea(int matrix[][])
	{
		int r = matrix.length;
		int c = matrix[0].length;
	    // An auxiliary array to store count of consecutive 1's in every column.
		int[][] hist = new  int [r+1][c+1];
	 
	    // Step 1: Fill the auxiliary array hist[][]
	    for (int i=0; i<c; i++)
	    {
	        // First row in hist[][] is copy of first row in mat[][]
	        hist[0][i] = matrix[0][i];
	 
	        // Fill remaining rows of hist[][]
	        for (int j=1; j<r; j++)
	            hist[j][i] = (matrix[j][i]==0)? 0: hist[j-1][i]+1;
	    }
	 
	 
	    // Step 2: Sort rows of hist[][] in non-increasing order
	    for (int i=0; i<r; i++)
	    {
	        int count[] = new int[r+1];
	 
	        // counting occurrence
	        for (int j=0; j<c; j++)
	            count[hist[i][j]]++;
	 
	        //  Traverse the count array from right side
	        int col_no = 0;
	        for (int j=r; j>=0; j--)
	        {
	            if (count[j] > 0)
	            {
	                for (int k=0; k<count[j]; k++)
	                {
	                    hist[i][col_no] = j;
	                    col_no++;
	                }
	            }
	        }
	    }
	 
	    // Step 3: Traverse the sorted hist[][] to find maximum area
	    int curr_area, max_area = 0;
	    for (int i=0; i<r; i++)
	    {
	        for (int j=0; j<c; j++)
	        {
	            // Since values are in decreasing order,
	            // The area ending with cell (i, j) can
	            // be obtained by multiplying column number
	            // with value of hist[i][j]
	            curr_area = (j+1)*hist[i][j];
	            if (curr_area > max_area)
	                max_area = curr_area;
	        }
	    }
	    return max_area;
	}
	public static void main(String[] args) {
		int matrix[][] = {
				{ 0, 1, 1, 0, 1, 1 },
				{ 1, 1, 0, 0, 1, 1 },
				{ 0, 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 1, 1 }
		};
		System.out.println(maxArea(matrix));
	}
}
