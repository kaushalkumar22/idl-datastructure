package com.algo.backtracking.common;

//Given a string that may contain duplicates, write a function to print all permutations of given string 
//such that no permutation is repeated in output.
public class PermutationsOfAString {
	
	public void permutation(char[] arrA, int left, int size) {
		int x;
		if (left == size) {
			for (int i = 0; i < arrA.length; i++) {
				System.out.print(arrA[i]);
			}
			System.out.print(" ");
		} else {
			for (x = left; x < size; x++) {
				swap(arrA, left, x);
				permutation(arrA, left + 1, size);
				swap(arrA, left, x);
			}
		}
	}

	public void swap(char[] arrA, int i, int j) {
		char temp = arrA[i];
		arrA[i] = arrA[j];
		arrA[j] = temp;
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		String s = "abdd";
		char[] arrCh = s.toCharArray();
		PermutationsOfAString i = new PermutationsOfAString();
		i.permutation(arrCh, 0, arrCh.length);
	}
}