package com.ds.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class BuildingBridges {

	public static void main(String[] args) {
		RSide[] side= new RSide[6];
		side[0] = new RSide(1, 3);
		side[1] = new RSide(2, 4);
		side[2] = new RSide(3, 5);
		side[3] = new RSide(4, 6);
		side[4] = new RSide(5, 1);
		side[5] = new RSide(6, 2);
		System.out.println(buildingBridges(side));
	}
	private static int buildingBridges(RSide[] side) {
		
		Arrays.sort(side,sideComprator);
		int len =side.length;
		int[] T = new int[len];	
		for(int i=0;i<len;i++){
			T[i]=1;
		}
		for(int i=1;i<len;i++){
			for(int j=0;j<i;j++){
				
				if(side[j].north<side[i].north&&T[i]<T[j]+1){
					T[i]=T[j]+1;
				}
			}
		}
		return T[len-1];
	}
	private static Comparator<RSide> sideComprator = new Comparator<RSide>() {
		@Override
		public int compare(RSide o1, RSide o2) {			
			return o1.souht-o2.souht;
		}
	}; 
	private static class RSide{
		int north;
		int souht;
		public RSide(int north, int souht) {
			this.north = north;
			this.souht = souht;
		}
	}
}
