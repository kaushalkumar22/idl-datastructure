package array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 *
 * Input: 5 Output: [ 
 *     [1], 
 *    [1,1], 
 *   [1,2,1], 
 *  [1,3,3,1], 
 * [1,4,6,4,1] ]
 *
 *
 *
 */
public class PascalsTriangle {
	public static void main(String[] args) {
		int n= 5;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> sub = new ArrayList<>();
		for(int i=0;i<n;i++){
			sub.add(0,1);
			for(int j=1;j<sub.size()-1;j++) {
				sub.set(j,sub.get(j)+sub.get(j+1));
			}
			res.add(new ArrayList<>(sub));
		}

		System.out.println(res);
		System.out.println(generate(5));
	}
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allrows = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<>();
		for(int i=0;i<numRows;i++) {
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++) {
				row.set(j, row.get(j) + row.get(j + 1));
			}
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;

	}
}
