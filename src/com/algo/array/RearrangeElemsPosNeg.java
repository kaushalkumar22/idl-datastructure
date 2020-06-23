package com.algo.array;

public class RearrangeElemsPosNeg {
	
	private static void leftShift(int[] array, int low, int high){
        int lastElement = array[high];
         
        for (int i = high; i > low; i--){
            array[i] = array[i-1];
        }
         
        array[low] = lastElement;
    }
     
    private static boolean notAtRightPosition(int[] array, int index)
    {
        // even indices should have positive elements in them
        if ((index % 2) == 0){
            if ((array[index]) < 0) // if negative element 
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else // odd indices should have negative elements in them
        {
            if ((array[index]) < 0)
            {
                return false;
            }
            else
            {
                return true;
            }
 
        }
    }
     
    private static int getNextOpposite(int[] array, int index){
        for (int i = index+1; i < array.length; i++)
        {
            if ((array[i]*array[index]) < 0)
            {
                return i;
            }
        }
        
        return -1;
    }
     
    public static void reArrangePositivesNegatives(int[] array){
    	
        for (int i = 0; i < array.length; i++)
        {
            if (notAtRightPosition(array, i))
            {
                int nextOppositeIndex = getNextOpposite(array, i);
                if (nextOppositeIndex != -1)
                {
                    leftShift(array, i, nextOppositeIndex);
                }
                else // no more opposite signed elements
                {
                    break;
                }
            }
        }
    }
     
     
    public static void main(String[] args)
    {
       
         
        int[] testArray = {-1,3,2,4,5,-6,7,-9};
        for(int i = 0;  i < testArray.length; i++)
        {
            System.out.print(testArray[i]+" ");
        }
        System.out.println();
        reArrangePositivesNegatives(testArray);
         
        for(int i = 0;  i < testArray.length; i++)
        {
            System.out.print(testArray[i]+" ");
        }
    }
}