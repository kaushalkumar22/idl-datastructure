package com.algo.array;

/**
 * An array[a0,a1,a2---an] of n size where n is an even number. An array is
 * balanced if the sum of the left half of the array elements is equal to the
 * sum of right half.
 * Input0: 1, 2, 1, 2, 1, 3 
 * Output0: -1
 * Input1 : 1, 2, 5 ,2 ,4, 2 
 * Output1: 2
 * 
 */
public class BalancePointInArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 1, 2, 1, 3 };// expected 6th position
		System.out.println("Balance point for a is index " + balancePointOpt(a));
		System.out.println("min for balance array " + balanceArray(a));
	}

	public static int balancePointOpt(int[] a) {
		int leftSum = a[0];
		int rightSum = 0;
		for (int i = 1; i < a.length; i++)// notice we start from 2nd as 1st
											// value is set
			rightSum += a[i];// each sum is sum of previous sum plus current
								// value

		for (int i = 0; i < a.length - 1; i++) {
			if (leftSum == rightSum)
				return i;
			leftSum += a[i + 1];
			rightSum -= a[i + 1];
		}
		return -1;// otherwise we return -1 as not found
	}
	/** An array[a0,a1,a2---an] of n size where n is an even number. An array is
	 * balanced if the sum of the left half of the array elements is equal to the
	 * sum of right half.
	 * To balance an array, you can add a non-negative integer ( ) to any array
	 * element . Your task is to find the smallest value of that makes the array
	 * balanced.
	 * 
	 * 
	 * Input0: 1 2 1 2 1 3 
	 * Output 0: 2 
	 * The sum of first elements is and the sum of
	 * last elements is . To make the array balanced you can add to index and make
	 * sum of both side equal to
	 * 
	 * Input1 : 1 2 5 2 4 2 
	 * Output1 0
	 */
	static int balanceArray(int[] a){
        int leftSum=0;
        int rightSum=0;
        for (int i=0; i<a.length/2;i++) {
            leftSum+=a[i];
            rightSum+=a[a.length-i-1];            
        }
        return Math.abs(leftSum-rightSum);
    }
}
