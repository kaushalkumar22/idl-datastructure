package com.algo.ads.bitmanipulation;

public class ReverseNumBit {

	public static void main(String[] args) {
		
		int num = 987654;
		int rev = 0;
		while(num>0){
			 int rem =num%10;
			 num =num/10;
			 rev = rev*10 +rem*10;
		}
		rev =rev/10;
		System.out.println(rev);
	}
}
