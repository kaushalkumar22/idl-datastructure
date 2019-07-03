package com.ds.dynamicprogramming;

public class BinaryStringsWithNoConsecutiveOnes {

	public static void main(String[] args) {
		int bStringLength =8;
		int totalStrings = getBinaryString(bStringLength);
		System.out.println(totalStrings);
	}

	private static int getBinaryString(int bStringLength) {
		if(bStringLength<=0) return 0;
		
		int c0=1;
		int c1=1;
		for(int i=0;i<bStringLength;i++){
			 int temp=c0;
			  c0=c0+c1;
			  c1=temp;
		}
		return c0+c1;
	}
}
