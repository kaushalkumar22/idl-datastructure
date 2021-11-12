package com.algo.heap;
/**
 * 
 *Connect n ropes with minimum cost

 *There are given n ropes of different lengths, we need to connect these ropes into one rope. 
 *The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.

 *For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
 *1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
 *2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 *3) Finally connect the two ropes and all ropes have connected.
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes.
 * Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first
 * (we get three strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and 2). 
 * Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
 * 
 * Time Complexity: Time complexity of the algorithm is O(nLogn) assuming that we use a O(nLogn) sorting algorithm. 
 * Note that heap operations like insert and extract take O(Logn) time.
 * @author kaushal
 *
 */
public class ConnectNRopesWithMinCost {

	//private static int heap_size=0;
	public static void main(String[] args) {

		int ropes[] = {4, 3, 2, 6};
		printArray(ropes);
		minHeap(ropes);
		System.out.println("Connect n ropes with minimum cost of : "+getMinCost(ropes));
	}

	private static int getMinCost(int arr[]){
		int totalMinCost =0;
		int heapSize = arr.length;
		//it will iterate until last element left in heap
		while(heapSize-1>0){
			
			int tempMinCost = arr[0];
			swap(arr, heapSize-1,0);
			
			for(int i=heapSize-1/2-1;i>=0;i--){
				heapify(arr,heapSize-1,i);
			}		
			
			arr[0]=tempMinCost+arr[0];
			totalMinCost = totalMinCost+arr[0];
			//n/2-1 its last non child node
			for(int i=heapSize-1/2-1;i>=0;i--){
				heapify(arr,heapSize-1,i);
			}	
			heapSize--;
		}
		return totalMinCost;
	}
  //build min heap
	private static void minHeap(int arr[]){

		int n= arr.length;
		//n/2-1 its last non child node
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
	}
	//heapify min heap 
	private static void heapify(int arr[], int n, int i){

		int left = 2*i+1;
		int right = 2*i+2;
		int smalest =i;

		if(left<n&&arr[left]<arr[smalest]){
			smalest = left;
		}
		if(right<n&&arr[right]<arr[smalest]){
			smalest=right;
		}
		if(smalest!=i){
			swap(arr, smalest, i);
			heapify(arr, n, smalest);
		}
	}

	private static void swap(int arr[], int largest, int i){

		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
	}

	private static void printArray(int arr[]){

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
