package com.algo.array.kth;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Your KthLargest class will have a constructor which accepts an integer k and
 * an integer array nums, which contains initial elements from the stream. For
 * each call to the method KthLargest.add, return the element representing the
 * kth largest element in the stream.
 * 
 * 
 * int k = 3; int[] arr = [4,5,8,2]; 
 * KthLargest kthLargest = new KthLargest(3,arr); 
 * kthLargest.add(3); // returns 4 
 * kthLargest.add(5); // returns 5
 * kthLargest.add(10); // returns 5 
 * kthLargest.add(9); // returns 8
 * kthLargest.add(4); // returns 8
 * 
 */
public class kthLargestElementInStream {

	public static void main(String[] args) {
		int stream[] = { 23, 10, 15, 70, 5, 80, 100 };
		int k = 3;
		kthLargest(stream, k);
		
	}

	private static void kthLargest(int[] stream, int k) {
		int count = 0;
		int[] arr = new int[k];

		for (int i = 0; i < stream.length; i++) {
			int x = stream[i];
			// Nothing much to do for first k-1 elements
			if (count < k - 1) {
				arr[count] = x;

			} else {
				// If this is k'th element, then store it and build the heap
				// created above
				if (count == k - 1) {
					arr[count] = x;
					minHeap(arr);
				} else if (x > arr[0]) { // If next element is greater than k'th
											// largest, then replace the root
					arr[0] = x;
					minHeap(arr);
				}
				System.out.println(k + "th largest element is " + arr[0]);
			}
			count++;
		}
	}

	private static void minHeap(int arr[]) {

		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			minHeapify(arr, n, i);
		}
	}

	private static void minHeapify(int[] arr, int n, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int min = i;
		if (l < n && arr[l] < arr[min])
			min = l;
		if (r < n && arr[r] < arr[min])
			min = r;
		if (min != i) {
			swap(arr, i, min);
			minHeapify(arr, n, min);
		}
	}

	private static void swap(int arr[], int min, int i) {

		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
	  class KthLargest {
	        final PriorityQueue<Integer> q;
	        final int k;

	        public KthLargest(int k, int[] a) {
	            this.k = k;
	            q = new PriorityQueue<>(k);
	            for (int n : a)
	                add(n);
	        }

	        public int add(int n) {
	            if (q.size() < k)
	                q.offer(n);
	            else if (q.peek() < n) {
	                q.poll();
	                q.offer(n);
	            }
	            return q.peek();
	        }
	    }
}