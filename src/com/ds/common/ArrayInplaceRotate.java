package com.ds.common;

class ArrayInplaceRotate 
{
	//all right last step to test our code
	public static void main(String[] args)
	{
		int[] nums = {1,2,3,4,5,6};
		int k = 3;//so after rotation, we expect {4,5,6,1,2,3}
		System.out.println("Original: "+java.util.Arrays.toString(nums));
		rotate(nums, k);
		System.out.println("After rotation: "+java.util.Arrays.toString(nums));
	}

	//now we start define our key method
	static void rotate(int[] nums, int k)
	{
		//as we discussed, we firstly reverse 0-k-1 index sub-array and k-length-1 sub-array
		//and finally reverse whole array
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
		reverse(nums, 0, nums.length-1);
	}

	//we firstly define a swap method as this is the basic idea of not requiring extra memory
	static void swap(int[] nums, int a, int b)
	{
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	//next, as we discussed, the key is to reverse the sub-arraies and reverse whole array
	//in order to rotate with minimal time complexity, we define the reverse method to support
	static void reverse(int[] nums, int start, int end)
	{
		//the reverse is simple, reverse head and tail and get closer until meeting
		for(int i=start; i<=(start+end)/2; i++)//notice we stop at mid! otherwise it reverse and reverse
		{
			swap(nums, i, (start+end)-i);//the to be swapped index is "start+end-i"
		}
	}
}


/**
* Please watch at http://www.youtube.com/user/ProgrammingInterview
* Contact: haimenboy@gmail.com
*
* Step by step to crack programming interview questions.
* 1. All questions were searched publicly from Google, Glassdoor, Careercup and StackOverflow.
* 2. All codes were written from scratch and links to download the source files are provided in each video's description. All examples were written in java, and tools I have used include Editplus, Eclipse and IntelliJ.
* 3. All videos were made without using any non-authorized material. All videos are silent sorry. Text comment is provided during coding as additional explanations.
* Thank you very much. 
*/
