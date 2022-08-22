package slidingwindow;

/**
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * 
 * Input: A = [1,0,1,0,1], S = 2 Output: 4 
 * Explanation: The 4 subarrays are bolded below: 
 * [1,0,1,x,x] 
 * [1,0,1,0,x] 
 * [x,0,1,0,1] 
 * [x,X,1,0,1]
 *
 * 
 */
public class BinarySubarraysWithSum {

	public static void main(String[] args) {
		int[] A = {0,0,0,0,0};
		//numSubarraysWithSum1(A, 2);
		System.out.println(numSubarraysWithSum1(A, 0));
		System.out.println(numSubarraysWithSum(A, 0));
	}

	/*
	 * Solution 2: Sliding Window
	 * 
	 * We have done this hundreds time. Space O(1) Time O(N)
	 */
	public static int numSubarraysWithSum1(int[] A, int S) {
		return atMost(A, S) - atMost(A, S - 1);
	}
	//1,0,1,0,1
	public static int atMost(int[] A, int S) {
		if (S < 0) return 0;
		int res = 0, i = 0, n = A.length;
		for (int j = 0; j < n; j++) {
			S -= A[j];
			while (S < 0)
				S += A[i++];
			res += j - i + 1;
		}
		return res;
	}

	
	//[0,0,0,0,0,0] all special cases for this example
	//		0

	public static int numSubarraysWithSum(int[] A, int S) {
		int left = 0;
		int count = 0; 
		int sum = 0;
		for (int right = 0; right <A.length; right++) {
			sum += A[right];
			while (left < right && sum > S) {
				sum -= A[left++];
			}
			if (sum == S) count++;
			for (int i = left; sum == S && i < right && A[i] == 0; i++)
				count++;
		}

		return count;
	}
}



