package com.ds.matrix;


/* given an n x n matrix, where every row and column is sorted in increasing order. 
  Given a number x, how to decide whether this x is in the matrix. The designed algorithm should have linear time complexity.

1) Start with top right element
2) Loop: compare this element e with x
 i) if they are equal then return its position
 ii) e < x then move it to down (if out of bound of matrix then break return false) 
 iii) e > x then move it to left (if out of bound of matrix then break return false)
3) repeat the i), ii) and iii) till you find element or returned false*/
public class SearchKInSortedMatrix {

	public static void main(String[] args) {
		int[][] mat = { 
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50},
		};
		search(mat, 4, 27);
		searchRecursive( mat, 0, 3, 27);
	}
	private static	boolean searchRecursive(int mat[][],int i,int j,int ele){
		if(i<4 && j>-1){
			if(mat[i][j]==ele){
				System.out.println("\n Found at"+" " +i+" "+ j);
				return true;
			}else if(mat[i][j]<ele){
				return searchRecursive(mat,i+1,j,ele);
			}else {
				return searchRecursive(mat,i,j-1,ele);
			}
		}
		return false;
	}
	private static void search(int mat[][], int n, int x)
	{
		int i = 0, j = n-1;  //set indexes for top right element
		boolean found =false;
				while ( i < n && j >= 0 )
				{
					if ( mat[i][j] == x )
					{
						found =true;
						System.out.println("\n Found at"+" " +i+" "+ j);
						break;
					}
					if ( mat[i][j] > x )
						j--;
					else 
						i++;
				}
				if(!found)
					System.out.println("\n Element not found");
				// if ( i==n || j== -1 )
	}
}
