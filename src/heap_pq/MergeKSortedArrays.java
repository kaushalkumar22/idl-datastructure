package heap_pq;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given an array of k lists, each list is sorted in ascending order. Merge all the
 *  lists into one sorted list and return it.
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 */
public class MergeKSortedArrays {
	public static void main(String[] args) {
		int[][] arr= {
				{2, 6, 8, 12, 34},
				{1, 9, 20, 25, 100, 1000},
				{23, 34, 90, 2000}
		};

		System.out.println(mergeKSortedArray(arr));
	}
	public static List<Integer> mergeKSortedArray(int[][] nums) {
		//PriorityQueue is heap in Java 
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->Integer.compare(a[0], b[0]));

		//add each array to heap with their index
		for (int i = 0; i < nums.length; i++) {
			pq.add(new int[] {nums[i][0],i,0});
		}

        List<Integer> res = new ArrayList<Integer>();
		//while heap is not empty
		while(!pq.isEmpty()){
			int[] arr = pq.poll();
			int num = arr[0];
			int currArrIndex =arr[1];
			int currNumIndex =arr[2];
            res.add(num);
            
			if(nums[currArrIndex].length>currNumIndex+1){
				pq.add(new int[] {nums[currArrIndex][currNumIndex+1],currArrIndex,currNumIndex+1});
			}
		}

		return res;
	}
}