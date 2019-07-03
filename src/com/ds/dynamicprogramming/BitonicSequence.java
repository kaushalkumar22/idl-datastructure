package com.ds.dynamicprogramming;


public class BitonicSequence {

	public static void main(String args[]){
        BitonicSequence bs = new BitonicSequence();
        int[] arr = {1,4,3,7,2,1,8,11,13,6,2};
        int r = bs.longestSequence(arr);
        System.out.print(r);
    
    }

	private int longestSequence(int[] arr) {
		
		int[] lts =new int[arr.length];
		int[] rts =new int[arr.length];
		
		for(int i=0;i<arr.length;i++){
			lts[i]=1;
			rts[i]=1;
		}
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j]){
					lts[i] = Math.max(lts[i], lts[j]+1);
				}	
			}
		}
		for(int i=arr.length-2;i>0;i--){
			for(int j=arr.length-1;j>i;j--){
				if(arr[i]>arr[j]){
				rts[i] =Math.max(rts[i], rts[j]+1);
				}
			}
		}
		int max=0;
		for(int i=0;i<arr.length-1;i++){
		if(max<lts[i]+rts[i]-1){
			max=lts[i]+rts[i]-1;
		}
		
	}
		return max;
	}
}
