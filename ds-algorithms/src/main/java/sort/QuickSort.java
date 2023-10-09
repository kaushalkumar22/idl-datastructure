package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int nums[] = {5,3,8,2,9,12,76,13,1,7,23};
		System.out.println(Arrays.toString(nums));
		int k=5;
		k=nums.length-k;
		
		System.out.println(quickSort(nums, 0,nums.length-1,k));
		System.out.println(Arrays.toString(nums));	
	}
	//[1, 2, 3, 5, 7, 8, 9, 12, 13, 23, 76]
	private static int quickSort(int[] nums, int low, int high,int k) {
		if(low<=high) {
			int pivot = partition(nums, low ,high);
			if(k==pivot) return nums[pivot];
			else if(k<pivot)
				return quickSort(nums, low,  pivot-1,k);
			else
				return quickSort(nums, pivot+1,  high,k);
		}
		return nums[k];
	}

	private static int partition(int[] nums, int low, int high) {

		int pIndex = low;
		int pivot = nums[high];
		for(int i=low;i<=high;i++) {
			if(nums[i]<pivot) {
				swap(nums,i,pIndex);
				pIndex++;
			}
		}
		swap(nums,pIndex,high);
		return pIndex;
	}

	private static void swap(int[] nums, int i, int pIndex) {
		int temp =nums[i];
		nums[i]=nums[pIndex];
		nums[pIndex]=temp;

	}


}



