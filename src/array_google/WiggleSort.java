package array_google;

import java.util.Arrays;

/**
 *Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 *  For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        new WiggleSort().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

    }
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(i%2==0&&nums[i-1]<nums[i] ||i%2==1&&nums[i-1]>nums[i]){
                swap(nums, i,i-1);
            }
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i]=nums[i-1];
        nums[i-1]=temp;
    }
}
