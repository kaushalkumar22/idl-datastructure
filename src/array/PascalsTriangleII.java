package array;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's
 * triangle.
 * 
 * Notice that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: rowIndex = 3 Output: [1,3,3,1]
 * 
 * Example 2:
 * 
 * Input: rowIndex = 0 Output: [1]
 * 
 * Example 3:
 * 
 * Input: rowIndex = 1 Output: [1,1]
 *
 */
public class PascalsTriangleII {
	public static void main(String[] args) {

	}
	 public List<Integer> getRow(int rowIndex) {
	        Integer[] integers = new Integer[rowIndex + 1];
	        Arrays.fill(integers, 1);
	        for (int row = 0; row < rowIndex; row++) {
	            for (int col = row; col > 0; col--) {
	                integers[col] += integers[col - 1];
	            }
	        }
	        return Arrays.asList(integers);
	    }
}
