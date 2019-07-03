package com.ds.matrix;

public class MaximumSizeSquareSubmatrixOf1s {

	public static void main(String[] args) {
		int M[][] =  {
				{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
                };
             
     printMaxSubSquare(M);
	}
private static void printMaxSubSquare(int M[][])
	{
	  int i,j;
	  int S[][] = new int[5][5];
	  int max_of_s, max_i, max_j; 
	  
	  /* Set first column of S[][]*/
	  for(i = 0; i < 5; i++)
	     S[i][0] = M[i][0];
	  
	  /* Set first row of S[][]*/    
	  for(j = 0; j < 5; j++)
	     S[0][j] = M[0][j];
	      
	  /* Construct other entries of S[][]*/
	  for(i = 1; i < 5; i++)
	  {
	    for(j = 1; j < 5; j++)
	    {
	      if(M[i][j] == 1) 
	        S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1;
	      else
	        S[i][j] = 0;
	    }    
	  } 
	   
	  /* Find the maximum entry, and indexes of maximum entry 
	     in S[][] */
	  max_of_s = S[0][0]; max_i = 0; max_j = 0;
	  for(i = 0; i < 5; i++)
	  {
	    for(j = 0; j < 5; j++)
	    {
	      if(max_of_s < S[i][j])
	      {
	         max_of_s = S[i][j];
	         max_i = i; 
	         max_j = j;
	      }        
	    }                 
	  }     
	   
	  System.out.println(" Maximum size sub-matrix is: ");
	  for(i = max_i; i > max_i - max_of_s; i--)
	  {
	    for(j = max_j; j > max_j - max_of_s; j--)
	    {
	      System.out.print( M[i][j]+" ");
	    }  
	    System.out.println();
	  }  
	}     
	 
	/* UTILITY FUNCTIONS */
	/* Function to get minimum of three values */
private static 	int min(int a, int b, int c)
	{
	  int m = a;
	  if (m > b) 
	    m = b;
	  if (m > c) 
	    m = c;
	  return m;
	}
/*
 * Let the given binary matrix be M[R][C]. The idea of the algorithm is to construct an auxiliary size matrix S[][] 
 * in which each entry S[i][j] represents size of the square sub-matrix with all 1s including M[i][j] where M[i][j] 
 * is the rightmost and bottom most entry in sub-matrix.

1) Construct a sum matrix S[R][C] for the given M[R][C].
     a)	Copy first row and first columns as it is from M[][] to S[][]
     b)	For other entries, use following expressions to construct S[][]
         If M[i][j] is 1 then
            S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
         Else //If M[i][j] is 0
            S[i][j] = 0
2) Find the maximum entry in S[R][C]
3) Using the value and coordinates of maximum entry in S[i], print 
   sub-matrix of M[][]

For the given M[R][C] in above example, constructed S[R][C] would be:

   0  1  1  0  1
   1  1  0  1  0
   0  1  1  1  0
   1  1  2  2  0
   1  2  2  3  1
   0  0  0  0  0

The value of maximum entry in above matrix is 3 and coordinates of the entry are (4, 3). Using the maximum value 
and its coordinates, we can find out the required sub-matrix.
*/
}
