package com.ds.common;
import java.util.HashMap;
import java.util.Map;
 
public class NthMostFrequentNumber 
{
    private class NumberFrequencyTuple
    {
        int number;
        int frequency;
         
        public NumberFrequencyTuple(int number, int frequency)
        {
            this.number = number;
            this.frequency = frequency;
        }
    }
     
    private void swap(NumberFrequencyTuple[] array, int i, int j) 
    {
        NumberFrequencyTuple tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;     
    }
     
    private void maxHeapify(NumberFrequencyTuple[] array, int curIndex, int heapSize)
    {
        // left child in heap
        int leftChild = 2*curIndex+1;
         
        // right child in heap
        int rightChild = 2*curIndex+2;
         
        // index pointing to the largest element(out of node and its two children)
        int largestIndex = curIndex;
       
        if(leftChild < heapSize && (array[leftChild].frequency > array[curIndex].frequency))
        {
            largestIndex = leftChild;
        }
       
        if(rightChild < heapSize && (array[rightChild].frequency > array[largestIndex].frequency))
        {
            largestIndex = rightChild;
        }
       
        // make the largest element as node and maxHeapify the corresponding sub-tree 
        // since the swap operation could result in violation of max-heap property for corresponding sub-tree
        if(largestIndex != curIndex)
        {
            swap(array, curIndex, largestIndex);
            maxHeapify(array, largestIndex, heapSize);
        }
    }
      
    private void buildMaxHeap(NumberFrequencyTuple[] array, int heapSize)
    {
        // find index of the last internal node
        int lastElementIndex = array.length - 1;
        int lastInternalNodeIndex = (lastElementIndex - 1)/2;
         
        // call maxHeapify for all internal nodes
        for(int i = lastInternalNodeIndex; i >= 0; i--)
        {
            maxHeapify(array, i, heapSize);
        }
    }
     
    private int extractMax(NumberFrequencyTuple[] array, int heapSize)
    {
        int maxElement = array[0].number;
        swap(array, 0, heapSize-1);
        maxHeapify(array,0, heapSize-1);
         
        return maxElement;
    }
     
     
    public int findNthMostFrequentNumber(int[] array, int n)
    {
        if (array == null || array.length < 1 || array.length < n)
        {
            System.out.println("Invalid input case");
            return -1;
        }
         
        // build hashTable containing frequency of each element in the array
        HashMap<Integer, Integer> frequencyTable = new HashMap<Integer, Integer>();
         
        for (int i = 0; i < array.length; i++)
        {
            if (frequencyTable.get(array[i]) == null)
            {
                frequencyTable.put(array[i], 1);
            }
            else
            {
                int prevFrequency = frequencyTable.get(array[i]);
                frequencyTable.put(array[i], prevFrequency + 1);
            }
        }
 
        // check if the number of frequencies we have got is at least equal to 'n' 
        if (frequencyTable.size() < n)
        {
            System.out.println("nth most frequent number cannot be found for this input array");
            return -1;
        }
         
        // then create the array of tuples(number, frequency) out of hashTable of frequencies
        NumberFrequencyTuple[] list = new NumberFrequencyTuple[frequencyTable.size()]; 
        int i = 0;
         
        for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) 
        {
            list[i] = new NumberFrequencyTuple(entry.getKey(), entry.getValue());
            i += 1;
        }
 
        // build max-heap using this array of tuples
        int heapSize = list.length;
        buildMaxHeap(list, heapSize);
         
        // do extractMax operation 'n' times on this max-heap. 
        // return the result of last extractMax operation
        int result = -1;
        for (i = 0; i < n; i++)
        {
            if (i == n-1)
            {
                result = extractMax(list, heapSize);
            }
            else
            {
                extractMax(list, heapSize);
            }
            heapSize -= 1;
        }
         
        return result;
    }
     
     
    public static void main(String[] args) 
    {
        NthMostFrequentNumber solution = new NthMostFrequentNumber();
 
        int[] array = {1,2,2,2,2,3,3,4,4,4,5,6,6,6};
         
        int n = 3;
        System.out.println("Nth most frequent number is:\n" + solution.findNthMostFrequentNumber(array, 4));
    }
}