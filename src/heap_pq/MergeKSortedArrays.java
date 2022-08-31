package heap_pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given an array of k lists, each list is sorted in ascending order. Merge all the
 *  lists into one sorted list and return it.
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 */
public class MergeKSortedArrays {
	public static void main(String[] args) {
		int[][] arr= {{2, 6, 8, 12, 34},
				{1, 9, 20, 25, 100, 1000},
				{23, 34, 90, 2000}};

		System.out.println(Arrays.toString(mergeKSortedArray(arr)));
	}
	public static int[] mergeKSortedArray(int[][] arr) {
		//PriorityQueue is heap in Java 
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int total=0;

		//add arrays to heap
		for (int i = 0; i < arr.length; i++) {
			queue.add(new ArrayContainer(arr[i], 0));
			total = total + arr[i].length;
		}

		int m=0;
		int result[] = new int[total];

		//while heap is not empty
		while(!queue.isEmpty()){
			ArrayContainer ac = queue.poll();
			result[m++]=ac.arr[ac.index];

			if(ac.index < ac.arr.length-1){
				queue.add(new ArrayContainer(ac.arr, ac.index+1));
			}
		}

		return result;
	}
	static class ArrayContainer implements Comparable<ArrayContainer> {
		int[] arr;
		int index;

		public ArrayContainer(int[] arr, int index) {
			this.arr = arr;
			this.index = index;
		}

		@Override
		public int compareTo(ArrayContainer o) {
			return this.arr[this.index] - o.arr[o.index];
		}
	}

}