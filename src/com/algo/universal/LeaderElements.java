package com.algo.universal;

/*Given an array of integers, print the leaders in the array. A leader is an element which is larger than all the
 * elements in the array to its right.
 * 
 *For example:
 *Input Array:
 *{ 98, 23, 54, 12, 20, 7, 27 }
 *Output:
 *Leaders- 27 54 98*/

public class LeaderElements {

	public static void printLeaders(int[] input) 
	{
		if(input == null || input.length == 0) {
			return;
		}
		int inputSize = input.length;
		int currentLeader = input[inputSize - 1];
		System.out.print("Leaders- ");
		for (int i = inputSize - 1; i >= 0; i--) {
			if(input[i] >= currentLeader) {
				currentLeader = input[i];
				System.out.print(currentLeader + " ");
			}
		}
	}
	public static void main(String[] args) {
		int[] input = { 98, 23, 54, 12, 20, 7, 27 };
		printLeaders(input);
	}
}
