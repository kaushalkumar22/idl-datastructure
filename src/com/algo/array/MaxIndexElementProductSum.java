package com.algo.array;

/*Given an array, find the maximum possible value of sum of index-element-products(i*array[i])
 *  with only rotations allowed on a given array. Sum of index-element-products for array of length 'n'
 * is computed as - 0*array[0] + 1*array[1] + 2*array[2] + ... + n-1*array[n-1].

 For example, for the array {3,4,5,6,1,2} without doing any rotations sum of index-element-products is 46.
 After doing one clockwise rotation of the array, it would be modified to {2,3,4,5,6,1} and sum of 
 index-element-products in this case is 55. 
 */
public class MaxIndexElementProductSum {

	public static void main(String[] args) {
		int[] array = {24, 26, 25, 22};

		MaxIndexElementProductSum solution = new MaxIndexElementProductSum();

		System.out.println(solution.findMaxIndexElementProductSum(array));
	}
	private int findIndexElementProductSum(int[] array){
		int currValue = 0;
		for (int i = 0; i < array.length; i++){
			currValue   += i*array[i];
		}

		return currValue;
	}

	private void rotateClockwise(int[] array){
		if (array == null || array.length < 2){
			return;
		}

		int n = array.length;
		int temp = array[n-1];

		for (int i = n-1; i >= 1; i--){
			array[i] = array[i-1];
		}
		array[0] = temp;
	}


	public int simpleFindMaxIndexElementProductSum(int[] array){
		// currValue indicates index-element-product sum when no rotation is performed
		int sumElements = 0, currValue = 0;
		for (int i = 0; i < array.length; i++){
			sumElements += array[i];
			currValue   += i*array[i];
		}


		int maxValue = currValue, n = array.length;

		for (int i = 1; i < n; i++){
			rotateClockwise(array);
			currValue = findIndexElementProductSum(array);
			if (currValue > maxValue){
				maxValue = currValue;
			}
		}
		return maxValue;
	}

	public int findMaxIndexElementProductSum(int[] array)
	{
		// currValue indicates index-element-product sum when no rotation is performed
		int sumElements = 0, currValue = 0;
		for (int i = 0; i < array.length; i++)
		{
			sumElements += array[i];
			currValue   += i*array[i];
		}

		/* 
		 * If 'n' indicates length of array then there could be maximum 'n-1' rotations. 
		 * n'th rotation restores the original array.
		 * 
		 * If 'currValue' is the index-element-product sum after 'i-1' rotations then 
		 * the index-element-product sum after 'i' rotations would be currValue + sumElements - n*array[n-i] 
		 */
		int maxValue = currValue, n = array.length;

		for (int i = 1; i < n; i++)
		{
			currValue += sumElements - n*array[n-i];
			if (currValue > maxValue)
			{
				maxValue = currValue;
			}
		}

		return maxValue;
	}


}
