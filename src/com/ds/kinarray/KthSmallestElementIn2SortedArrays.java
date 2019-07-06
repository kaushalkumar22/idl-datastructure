package com.ds.kinarray;

public class KthSmallestElementIn2SortedArrays {
	
	public static void main(String[] args) {
		int[] arr1= {3,5,7,9};
		int[] arr2= {2,4,6,8,10,12,14};

		int x=arr1.length;
		int y=arr2.length;
		int k=9;
		System.out.println(kthSmallest(arr1,0,x,arr2,0,y,k));
		
	}

	private static int kthSmallest(int[] arr1, int startX, int endX, int[] arr2, int startY, int endY, int k) {

		if(k==1) return Math.min(arr1[startX], arr2[startY]);
		
		  int m = endX-startX;
		  int n = endY-startY;
		// let m <= n 
		  if (m > n) return kthSmallest(arr2,  startY,  endY, arr1,  startX,  endX, k); 
		    
		  // if arr1 is empty returning k-th element of arr2 
		  if (m == 0) return arr2[startY+k - 1]; 
		 // now the divide and conquer part 
		
		  if (k > (m+n) || k < 1) return -1; 
		  int i = Math.min(m, k / 2); 
		  int j = Math.min(n, k / 2); 
		    
		  if (arr1[startX+i - 1] > arr2[startY+j - 1] ) { 
		    // Now we need to find only k-j th element since we have found out the lowest j 
		    return kthSmallest(arr1, startX, startX+i,arr2, startY+j,endY, k - j); 
		  } else {
		    // Now we need to find only k-i th element since we have found out the lowest i 
			  return kthSmallest(arr1, startX+i, endX,arr2, startY,startY, k - i); 
		  }
	}
	
	
	
	
}
