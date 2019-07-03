package com.ds.common;

import java.util.LinkedList;

public class MaxElementFromEachGroupOfK {
	public static void main(String[] args)
	{

		int[] array = {9,6,5,3,2,5,14,13,93,14};
		int k = 4;

		System.out.println("Maximum elements from each sub-array of specified size are - ");
		getMaxElementFromEachGroupOfK(array, k);
	}
	private static void	getMaxElementFromEachGroupOfK(int[] arr,int k)
	{
		  LinkedList<Integer> list = new LinkedList<Integer>();
	   
          for(int i=0;i<k;i++){  	  
        	  if(list.isEmpty()){
        		  list.add(arr[i]);
        	  }else{       		  
        		  if(list.getLast()>arr[i]){
        			  int temp = list.getLast();
        			  list.removeLast();
        			  list.addLast(arr[i]);
        			  list.addLast(temp);
        		  }else{
        			  list.addLast(arr[i]);
        		  }
        	  }
          }
          System.out.println(list.getLast());
          for(int i=4;i<arr.length;i++)
          { 
        	  if(list.getLast()==arr[i-k]){
        		  list.removeLast();
        	  }else{
        		  //need to do traverse
        		  list.removeFirst();
        	  }
        	  
        	  if(list.getLast()>arr[i])
        	  {
    			  int temp = list.getLast();
    			  list.removeLast();
    			  list.addLast(arr[i]);
    			  list.addLast(temp);
    		  }else{
    			  list.addLast(arr[i]);
    		  }
        	  System.out.println(list.getLast());
          }   
	}
}
