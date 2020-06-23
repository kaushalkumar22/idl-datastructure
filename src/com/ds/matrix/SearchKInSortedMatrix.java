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
		int[][] mat = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		search(mat, 4, 27);
		searchRecursive(mat, 0, 3, 27);
	}

	private static boolean searchRecursive(int mat[][], int i, int j, int ele) {
		if (i < 4 && j > -1) {
			if (mat[i][j] == ele) {
				System.out.println("\n Found at" + " " + i + " " + j);
				return true;
			} else if (mat[i][j] < ele) {
				return searchRecursive(mat, i + 1, j, ele);
			} else {
				return searchRecursive(mat, i, j - 1, ele);
			}
		}
		return false;
	}

	private static void search(int mat[][], int n, int x) {
		int i = 0, j = n - 1; // set indexes for top right element
		boolean found = false;
		while (i < n && j >= 0) {
			if (mat[i][j] == x) {
				found = true;
				System.out.println("\n Found at" + " " + i + " " + j);
				break;
			}
			if (mat[i][j] > x)
				j--;
			else
				i++;
		}
		if (!found)
			System.out.println("\n Element not found");
		// if ( i==n || j== -1 )
	}

	/**
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. Example 1:
	 * 
	 * Input: matrix = [ 
	 * [1, 3, 5, 7], 
	 * [10, 11, 16, 20], 
	 * [23, 30, 34, 50] 
	 * ]
	 * target = 3 Output: true
	 *
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int l = 0, r = m * n - 1;
		while (l != r) {
			int mid = (l + r - 1) >> 1;
			if (matrix[mid / m][mid % m] < target)
				l = mid + 1;
			else
				r = mid;
		}
		return matrix[r / m][r % m] == target;
	}

	/*
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right. Integers
	 * in each column are sorted in ascending from top to bottom. Example:
	 * 
	 * Consider the following matrix:
	 * 
	 * [[1, 4, 7, 11, 15], 
	 *  [2, 5, 8, 12, 19],
	 *  [3, 6, 9, 16, 22], 
	 *  [10, 13, 14,17, 24], 
	 *  [18, 21, 23, 26, 30] ] Given target = 5, return true.
	 * 
	 * Given target = 20, return false.
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
			return false;
		}
		int col = matrix[0].length-1;
		int row = 0;
		while(col >= 0 && row <= matrix.length-1) {
			if(target == matrix[row][col]) {
				return true;
			} else if(target < matrix[row][col]) {
				col--;
			} else if(target > matrix[row][col]) {
				row++;
			}
		}
		return false;
	}
}
