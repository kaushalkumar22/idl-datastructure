package com.ds.common;

//this code will work for consecutive no only it sub array is not contiguous will return no such array
//need to write code for non contiguous
public class MinimumLengthSubArraySumK {

	public static void main(String[] args) {
        int[] array = {2,1,3,7,-1};
        int k = 9;
        printMinSubArrayWithSumK(array, k);
    }
     
    public static void printMinSubArrayWithSumK(int[] array, int k) {
          
        int start = -1;     // Start of min subarray
        int end = -1;       // End of min subarray
        int min = Integer.MAX_VALUE;    // size of the smallest subarray with sum = k
         
        for(int i = 0; i < array.length; i++) {
             
            int currentSum = 0;
            for(int j = i; j < array.length && (j-i+1) < min; j++) {        
                currentSum += array[j];
                if(currentSum == k) {
                    start = i;
                    end = j;
                    min = end - start + 1;
                    break;
                }            
            }    
        }
 
        if(start == -1 || end == -1)  {
            System.out.println("No subarray exists with sum = " + k);
            return ;
        }
 
        System.out.print("[ ");
        while(start <= end) {
            System.out.print(array[start] + " ");
            start++;;
        }       
        System.out.println("]");
    }
 
}
        