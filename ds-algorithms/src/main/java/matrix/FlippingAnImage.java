package matrix;

/**
 * 
 * iven a binary matrix A, we want to flip the image horizontally, then invert
 * it, and return the resulting image.
 * 
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * 
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced
 * by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * 
 * Example 1:
 * 
 * Input: [[1,1,0],[1,0,1],[0,0,0]] Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]]. Then, invert
 * the image: [[1,0,0],[0,1,0],[1,1,1]]
 * 
 * Example 2:
 * 
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]] Output:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] Explanation: First reverse each
 * row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]. Then invert the image:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * 
 */
public class FlippingAnImage {
	public static void main(String[] args) {

	}
	public int[][] flipAndInvertImage(int[][] A) {
		if(A==null || A.length ==0)
			return A;

		for(int[] row : A){
			for(int  i=0, j=row.length-1; i<=j; i++,j--){
				int temp = row[i];
				row[i]=1-row[j];
				row[j]=1-temp;
			}
		}
		return A;
	}
}
