package heap_pq;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Input: [3,2,1,5,6,4] and k = 2 Output: 5
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
 *
 */
public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		System.out.println(Arrays.toString(nums));
		System.out.println(findKthLargestElement(nums,2));
		System.out.println(findKthLargestElementOpt(nums,2));
	}
	 public int findKthLargest(int[] nums, int k) {
		 
	        final PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int val : nums) {
	            pq.offer(val);
	 
	            if(pq.size() > k) {
	                pq.poll();
	            }
	        }
	        return pq.peek();
	    }

	/*
	 * O(N) best case / O(N^2) worst case running time + O(1) memory The smart
	 * approach for this problem is to use the selection algorithm (based on the
	 * partion method - the same one as used in quicksort).
	 */
	private static int findKthLargestElement(int[] nums, int k) {

		//k = nums.length - k;
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			final int pivot = partition(nums, start, end);
			if (pivot < k) {
				start = pivot + 1;
			} else if (pivot > k) {
				end = pivot - 1;
			} else {
				break;
			}
		}
		return nums[k];
		
	}

	private static int partition(int[] nums, int lo, int hi) {
		int pivot = nums[hi];
		
		int i = lo;
		for (int j = lo; j < hi; j++) {
			if (nums[j] <= pivot) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, hi);
		return i;
	}

	private static void swap(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	/*
	 * O(N) guaranteed running time + O(1) space
	 * 
	 * So how can we improve the above solution and make it O(N) guaranteed? The
	 * answer is quite simple, we can randomize the input, so that even when the
	 * worst case input would be provided the algorithm wouldn't be affected. So all
	 * what it is needed to be done is to shuffle the input.
	 */
	private static int findKthLargestElementOpt(int[] nums, int k) {

		shuffle(nums);
		k = nums.length - k;
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			final int pivot = partition(nums, start, end);
			if (pivot < k) {
				start = pivot + 1;
			} else if (pivot > k) {
				end = pivot - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}

	private static void shuffle(int a[]) {

		final Random random = new Random();
		for (int ind = 1; ind < a.length; ind++) {
			final int r = random.nextInt(ind + 1);
			swap(a, ind, r);
		}
	}
}
