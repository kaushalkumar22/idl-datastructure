package com.algo.slidingwindow;

import java.util.LinkedList;

public class MaximumfromEachSubarray {
	public static void main(String[] args)
    {
        MaximumfromEachSubarray solution = new MaximumfromEachSubarray();
 
        int[] array = {9,6,11,8,10,5,14,13,93,14};
        int k = 4;
         
        System.out.println("Maximum elements from each sub-array of specified size are - ");
        solution.printMaxfromEachSubarray(array, k);
    }
   
     
    private void printMax(int[] array, int low, int high) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++)
        {
            if (array[i] > maxValue)
            {
                maxValue = array[i];
            }
        }
         
        System.out.println(maxValue);
    }
     
    public void simplePrintMaxfromEachSubarray(int[] array, int k)
    {
        // {4,2,12,34,23,35,44,55};
        int low = 0, high = low + k - 1;
         
        while (high < array.length)
        {
            printMax(array, low, high);
            low  += 1;
            high += 1;
        }
    }
     
    public void printMaxfromEachSubarray(int[] array, int k)
    {
        LinkedList<Integer> list = new LinkedList();
         
        for (int i = 0; i < k; i++)
        {
            // remove all useless elements present at the front of the list
            while (!list.isEmpty() && array[list.getLast()] < array[i])
            {
                list.removeLast();
            }
             
            // add index of current element at the back
            list.addLast(i);
        }
         
        for (int i = k; i < array.length; i++)
        {
            // first element present in the list is the greatest element for the last 'k' sized sub-array
            System.out.println(array[list.getFirst()]);
             
            // now remove all indices of elements from the list which do not belong to current window
            while (!list.isEmpty() && (list.getFirst() < (i-k+1)))
            {
                list.removeFirst();
            }
             
            // now again remove all useless elements present at the front of the list
            // remove all useless elements present at the front of the list
            while (!list.isEmpty() && array[list.getLast()] < array[i])
            {
                list.removeLast();
            }
             
            // and finally insert this new element at the back of the list
            list.add(i);
        }
         
        // now print the largest element from the last sub-array(window)
        System.out.println(array[list.getFirst()]);
    }
 
    
}
  