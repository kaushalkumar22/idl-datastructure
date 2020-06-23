package com.algo.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

class Bridge{
	int x, y;
	Bridge(int x,int y){
		this.x=x;
		this.y=y;
	}
};
public class BuildingBridges  {

	static Comparator<Bridge> SORT_NORTH = new Comparator<Bridge>() {
		public int compare(Bridge a, Bridge b) {
			return a.x < b.x ?b.x:a.x;
		}

	};

	static int bulidingBridges(Bridge a[], int n){

		Arrays.sort(a,SORT_NORTH); 

		int ans[] = new int[n];
		int result = 1;
		for (int i = 0; i < n; i++)
			ans[i] = 1;

		for (int i = 1; i < n; i++) {       // apply LIS on right bridges
			for (int j = 0; j < i; j++) {
				if(a[i].y > a[j].y && ans[i] < ans[j] + 1)
					ans[i] = ans[j] + 1;
			}
		}

		for (int i = 0; i < n; i++)
			result = Math.max(result, ans[i]);

		return result;
	}

	public static void main(String[] args) {

		/*1 2 3 4 5 6
	      3 4 5 6 1 2 */
		Bridge a[] = {new Bridge(1, 3), new Bridge(2, 4),new Bridge(3, 5),new Bridge(4, 6),new Bridge(5, 1),new Bridge(6, 2)};
		int n = a.length;

		System.out.println( "Maximum number of bridges " + bulidingBridges(a, n));
	}



}
