package heap_pq;

import java.util.Arrays;

public class KClosestPointsToOrigin {
	public static void main(String[] args) {
		int points[][] = {{1,3},{-2,2},{2,-2}}, k = 2;
		int kpoints[][] = new KClosestPointsToOrigin().kClosest(points, k);
		for (int[] is : kpoints) {
			System.out.println(is[0]+","+is[1]);

		}

	}
	public int[][] kClosest(int[][] points, int k) {
		return quickSelect(points,k);
	}
	private int[][] quickSelect(int[][] points, int k) {
		//if(points.length<=k) return points;
		int low =0,high = points.length-1;
		while(low<=high) {
			int pivot = partition(points,low,high);
			if(pivot>k) {
				high=pivot-1;
			}else if(pivot<k) {
				low =pivot+1;
			}else {
				break;
			}		
		}
		return Arrays.copyOfRange(points,0, k);
	}
	private int partition(int[][] points, int low, int high) {

		int pIndex =low;
		int pivot = distance(points[high]);
		for(int i=low;i<high;i++) {
			if(distance(points[i])<=pivot) {
				swap(points,i,pIndex);
				pIndex++;
			}		
		}
		swap(points,pIndex,high);
		return pIndex;
	}
	private void swap(int[][] points, int i, int j) {
		int[] temp =points[i];
		points[i]=points[j];
		points[j]=temp;
	}
	private int distance(int[] points) {

		return points[0]*points[0]+points[1]*points[1];
	}
}