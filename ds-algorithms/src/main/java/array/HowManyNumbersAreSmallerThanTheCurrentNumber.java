package array;

import java.util.Arrays;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array
 * are smaller than it. That is, for each nums[i] you have to count the number
 * of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 * Input: nums = [8,1,2,2,3] Output: [4,0,1,1,3] Explanation: For nums[0]=8
 * there exist four smaller numbers than it (1, 2, 2 and 3). For nums[1]=1 does
 * not exist any smaller number than it. For nums[2]=2 there exist one smaller
 * number than it (1). For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 *
 *
 2 <= nums.length <= 500
 0 <= nums[i] <= 100
 *
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
	public static void main(String[] args) {
		int[] A= {8,1,2,2,3};
		System.out.println(Arrays.toString(smallerNumbersThanCurrent( A)));

	}

	public static int[] smallerNumbersThanCurrent(int[] A) {
		int[] count= new int[101];
		int[] res= new int[A.length];
		for(int i=0;i<A.length;i++) {
			count[A[i]]++;
		}
		int prev=count[0];
		for(int i=1;i<101;i++){
			int curr=count[i];
			count[i]=prev;
			prev= prev+curr;
		}
		for(int i=0;i<A.length;i++){
			res[i]= count[A[i]];
		}
		return res;
	}
}
