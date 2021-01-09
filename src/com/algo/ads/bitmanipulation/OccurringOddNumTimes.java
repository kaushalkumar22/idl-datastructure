package com.algo.ads.bitmanipulation;

public class OccurringOddNumTimes {
//Find the element that appears once
//Given an array where every element occurs three times, except one element which occurs only once. 
//	Find the element that occurs once. 
//	Expected time complexity is O(n) and O(1) extra space.Examples: 
private static int getOddOccurrence(int ar[], int ar_size)
{
	     int i;
	     int res = 0; 
	     for (i=0; i < ar_size; i++)     
	        res = res ^ ar[i];
	      
	     return res;
	}
	 
	/* Diver function to test above function */
	public static void main(String[] args) {
		
	     int ar[] = {2,2,3,3,4,5,5,5,5};
	     int n = ar.length;
	     System.out.println(getOddOccurrence(ar, n));
	     
	}
}
