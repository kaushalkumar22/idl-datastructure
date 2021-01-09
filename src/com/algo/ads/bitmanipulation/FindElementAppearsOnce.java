package com.algo.ads.bitmanipulation;

public class FindElementAppearsOnce {

	private static int getOddOccurrence(int arr[], int n)
	{
		// Initialize result
	    int result = 0;
	 
	    int x, sum;
	 
	    // Iterate through every bit
	    for (int i = 0; i < n; i++)
	    {
	      // Find sum of set bits at ith position in all
	      // array elements
	      sum = 0;
	      x = (1 << i);
	      for (int j=0; j< n; j++ )
	      {
	          if ((arr[j] & x)!=0)
	            sum++;
	      }
	 
	      // The bits with sum not multiple of 3, are the
	      // bits of element with single occurrence.
	      if (sum % 3!=0)
	        result |= x;
	    }
	    return result;
	}

	/* Diver function to test above function */
	public static void main(String[] args) {

		int ar[] = { 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
		int n = ar.length;
		System.out.println(getOddOccurrence(ar, n));

	}
}
