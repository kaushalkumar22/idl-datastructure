package com.algo.array;

/**
 * Given a number, find the next greater number using same digits(or by rearranging the digits). 
 * For example, if the given number is 1234 then next greater number would be 1243. For the input 1243, 
 * next greater number would be 1324. If the input is 6938652 then the output should be the number 6952368.

  If there is no next greater number possible, then the program should return the same number. 
  For example, for number 4321, same number 4321 would be returned.
 * @author I339640
 *
 */
public class NextGreaterNumber {	
	
	public static void main(String[] args) {     
		int[] number = {6,9,3,8,6,5,2};

		findNextGreaterNumber(number);

		System.out.println("Next greater number is: ");
		for (int i = 0; i < number.length; i++){
			System.out.print(number[i]);
		}
	}
	public static  void findNextGreaterNumber(int[] num){
		int arrL = num.length-1;
		int lastNumIndex = arrL;

		int i = arrL-1;
		while(i>=0){
			if(num[i]<num[lastNumIndex]){
				swap(num,i, lastNumIndex);
				reverseArray(num,i+1,arrL);
				break;
			}else if(i==0){
				lastNumIndex =lastNumIndex-1;
				i =lastNumIndex-1;
			}else{
				i--;
			}	
		}
	}
	private static void swap(int[] number, int i, int j){
		int temp  = number[i];
		number[i] = number[j];
		number[j] = temp;
	}
	// Reverse an array between start (s) and end (e)
	private static void reverseArray(int[] array, int s, int e) {
		int mid = (e+s)/2;
		for(int i=s;i<=mid;i++){
			int tmp = array[i];
			array[i] = array[e-i+s];
			array[e-i+s] = tmp;
		}
	}

}
