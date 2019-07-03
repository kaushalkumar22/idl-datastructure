package com.ds.common;

/*Given a string of size 'n' where each character can be either 'd' or 'i' and nothing else.
 * If character 'd' denotes decrease in value and character 'i' denotes increase in value 
 * then how can we build an integer array of size 'n+1' created by using numbers from 1 to 'n+1'
 * such that this array holds one to one correspondence with the input string.
 *   
For example, if the given string is "di" then because string size is 2, we need to use numbers 1,2,3 
and build integer array [3,1,2] where first pair formed by first two elements 3,1 corresponds to 
character 'd' since there is decrease in value from 3 to 1 and then second pair 1,2 corresponds to 
character 'i' - increase in value from 1 to 2. Another way to build this could have been [2,1,3]. 
Now pair (2,1) corresponds to 'd' and second pair (1,3) corresponds to character 'i'.

When we consider 'n' such pairs formed out of adjacent elements from 'n+1' elements, 'n' pairs 
should correspond to 'n' characters of input string in the same sequence.
Another example could be for input string 'ddddi', one of the outputs could be [6,4,3,2,1,5].
Write a program to create any one of the correct output integer array given an input string having 
characters 'd' and 'i'.

Now the algorithm is very simple. Whenever we see a 'd' at string[i],
 we just put decreaseValue at output[i+1] and decrement decreaseValue by 1. 
 And whenever we see a 'i' at string[i], we just put increaseValue at output[i+1] 
 and increment increaseValue by 1. Output[0] is already initilaized to the number 
 next to numbers reserved for 'i' and 'd' transitions.

 */
public class IsDsSequence {

	public void createSequence(String input, int[] output){
		if (input.length() == 0){
			return;
		}

		int iCount = 0;
		// count the number of increases required
		for (int i = 0;  i < input.length(); i++){
			if (input.charAt(i) == 'i'){
				iCount += 1;
			}
		}

		// now in numbers 1 to n+1 reserve 'iCount' higher numbers to be used for 'i'
		// for example if there are 3 'i's in 6 character string, 
		// then reserve numbers 7,6 and 5 for 'i'

		int n = input.length();

		// if we see a 'i', put 'increaseValue' in the output array and increment 'increaseValue' by 1
		int increaseValue = n + 2 - iCount;

		// keep startValue fixed
		int startValue = increaseValue - 1;

		// if we see a 'd', put 'decreaseValue' in  the output array and decrement 'decreaseValue' by 1 
		int decreaseValue = startValue - 1;

		output[0] = startValue;
		for (int i = 0;  i < input.length(); i++){
			if (input.charAt(i) == 'i'){
				output[i+1] = increaseValue;
				increaseValue += 1;
			}

			if (input.charAt(i) == 'd'){
				output[i+1] = decreaseValue;
				decreaseValue -= 1;
			}
		}
	}


	public static void main(String[] args) {
		IsDsSequence solution = new IsDsSequence();

		String input = "ddiddiid";
		int[] output = new int[input.length() + 1];

		solution.createSequence(input, output);

		System.out.print("Output sequence corresponding to input string: ");
		for (int i = 0; i < output.length; i++)
		{
			System.out.print(output[i] + " ");
		}
	}
}