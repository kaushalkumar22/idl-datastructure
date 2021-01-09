package com.algo.lds.heap;

import java.util.PriorityQueue;

/**
 * 
 * K’th largest element in a stream
 * 
 * Given an infinite stream of integers, find the k’th largest element at any
 * point of time.
 * 
 * Input: stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...} k = 3
 * 
 * Output: {_, _, 10, 11, 20, 40, 50, 50, ...}
 * 
 * Extra space allowed is O(k).
 * 
 */
public class KthLargestElementInAStream {

	public static void main(String[] args) {
		int stream[] = { 23, 10, 15, 70, 5, 80, 100 };
		int k = 3;
		kthLargest(stream, k);

	}

	/*
	 * An Efficient Solution is to use Min Heap of size k to store k largest
	 * elements of stream. The k’th largest element is always at root and can be
	 * found in O(1) time. How to process a new element of stream? Compare the new
	 * element with root of heap. If new element is smaller, then ignore it.
	 * Otherwise replace root with new element and call heapify for the root of
	 * modified heap. Time complexity of finding the k’th largest element is
	 * O(Logk).
	 */
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