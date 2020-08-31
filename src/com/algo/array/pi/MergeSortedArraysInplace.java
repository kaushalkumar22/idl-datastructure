package com.algo.array.pi;
/*Given two sorted arrayA and arrayB such that arrayA has enough void spaces in it to be able to accommodate arrayB in it. 
 * Void spaces in an array are denoted using INVALID_NUM. Write a program to merge arrayB into arrayA such that resulting 
 * array is a sorted array. The expected space complexity is O(1).  

For example, if arrayA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM} and arrayB = {-1, 2, 6, 12}
then arrayS should be modified to array - {-3, -1, 2, 5, 6, 7, 10, 11, 12}
 */
public class MergeSortedArraysInplace 
{
	final static int INVALID_NUM = 0;

	public static void mergeSortedArrays(int[] arrA, int[] arrB)
	{
		//-3, 5, 0, 7, 0, 10, 0, 11, 0, 
		int lenA = arrA.length;
		int lenB = arrB.length;
		int vIndex = lenA-1;
		for(int i= lenA-1;i>=0;i--){
			
			if(arrA[i]!=INVALID_NUM){
				arrA[vIndex] = arrA[i];
				arrA[i] = INVALID_NUM;
				vIndex -= 1;
			}
		}
		int j=0,k=0;
		int i = vIndex+1;

		while(i<lenA&&j<lenB){
			if(arrA[i]<arrB[j]){
				arrA[k]=arrA[i];
				k++;
				i++;
			}else{
				arrA[k]=arrB[j];
				j++;
				k++;
			}
		}
		while(j<lenB){
			arrA[k++] = arrB[j++];
		}
	}

	public static void main(String[] args) 
	{


		int[] arrA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM};
		int[] arrB = {-1, 2, 6, 12};

		mergeSortedArrays(arrA, arrB);
		for (int i = 0;  i < arrA.length; i++)
		{
			System.out.print(arrA[i] + ", ");
		}
	}
}
