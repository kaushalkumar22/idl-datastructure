package com.ds.problemset;

import java.util.Arrays;
/**
 * calculate the number of platform is done by determining the maximum number of train at railway station any time.
 * @author Kaushal
 *
 */
public class MinPlatformsReq {

	public static void main(String[] args) {
		int arv[] = {900,915, 1030,  1045};
		int dep[] = {930,1100,1145, 1300 };
		//910, 1100,1120 ,1130,1130 1200 1900 2000
		//910 ,930, 1000 ,930 ,1100, 950,1500 1800
		int platfornNums = getMinPlatformsReq(arv,dep);
		System.out.println(platfornNums);
	}
	private static int getMinPlatformsReq(int[] arv,int[] dep){
		arv = sort(arv);
		dep = sort(dep);
		// plat_needed indicates number of platforms needed at a time
		int plat_needed = 0, result = 0;
		int n= arv.length;
		int i = 0, j = 0;

		// Similar to merge in merge sort to process all events in sorted order
		while (i < n && j < n){
			// If next event in sorted order is arrival, increment count of platforms needed
			if (arv[i] <= dep[j]){
				plat_needed++;
				i++;
				if (plat_needed > result)  // Update result if needed
					result = plat_needed;
			}else // Else decrement count of platforms needed
			{
				plat_needed--;
				j++;
			}
		}

		return result;
	}
	private static int[] sort(int[] arr){
		//need to write sorting code here
		Arrays.sort(arr);
		return arr;
	}
}
