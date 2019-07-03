package com.ds.common;

import java.util.Deque;
import java.util.LinkedList;

public class MaxFromGroupOfK {


	private static void printKMax(int arr[], int n, int k)
	{
		Deque<Integer> deque = new LinkedList<Integer>();

		// Create a Double Ended Queue, deque that will store indexes of array elements
		// The queue will store indexes of useful elements in every window and it will
		// maintain decreasing order of values from front to rear in Qi, i.e., 
		// arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
		// std::deque<int>  Qi(k);
		/* Process first k (or first window) elements of array */
		int i;
		for ( i= 0; i < k; ++i){
			// For very element, the previous smaller elements are useless so
			// remove them from Qi

			while ( (!deque.isEmpty()) && arr[i] >= arr[deque.getLast()]){
				deque.removeLast();  // Remove from rear
			}
			// Add new element at rear of queue
			deque.addLast(i);
		}

		// Process rest of the elements, i.e., from arr[k] to arr[n-1]
		for ( i=k-1; i < n; i++)
		{
			// The element at the front of the queue is the largest element of
			// previous window, so print it
			//cout << arr[Qi.front()] << " ";
			System.out.println(arr[deque.getFirst()]);
			// Remove the elements which are out of this window
			while ( !deque.isEmpty() && deque.getFirst()<= i - k-1){
				deque.removeFirst();//pop_front();  // Remove from front of queue
			}
			// Remove all elements smaller than the currently
			// being added element (remove useless elements)
			while ( (!deque.isEmpty()) && arr[i] >= arr[deque.getLast()]){
				deque.removeLast();
			}
			// Add current element at the rear of Qi
			//Qi.push_back(i);
			deque.addLast(i);
		}

		// Print the maximum element of last window
		//cout << arr[Qi.front()];
		//System.out.println(deque.getLast());
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		int arr[] = {12, 1, 78, 90, 57, 89, 56};
		int n = arr.length;
		int k = 3;
		printKMax(arr, n, k);
	}
}