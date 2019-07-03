package com.ds.advance;

public class JumpGame2 {

	public static void main(String[] args) {
		int arr[] ={2,3,4,2,1,1,4};
		System.out.println(jump(arr));
	}
	 public static int jump(int[] A) {
			int jumps = 0, curEnd = 0, curFarthest = 0;
			for (int i = 0; i < A.length - 1; i++) {
				curFarthest = Math.max(curFarthest, i + A[i]);
				if (i == curEnd) {
					jumps++;
					curEnd = curFarthest;

					/*if (curEnd >= A.length - 1) {
						break;
					}*/
				}
			}
			return jumps;
		}
	}
