package heap_pq;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation: The distance between (1, 3) and the origin is sqrt(10).The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
public class KClosestPointsToOrigin {
	public static void main(String[] args) {
		int points[][] = {{1,3},{-2,2},{2,-2}}, k = 1;
		int kpoints[][] = new KClosestPointsToOrigin().kClosest(points, k);
		for (int[] is : kpoints) {
			System.out.println(is[0]+","+is[1]);

		}

	}
	public int[][] kClosestPQ(int[][] points, int k) {
        // Use a lambda comparator to sort the PQ by farthest distance
        Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int[] entry = {squaredDistance(points[i]), i};
            if (maxPQ.size() < k) {
                // Fill the max PQ up to k points
                maxPQ.add(entry);
            } else if (entry[0] < maxPQ.peek()[0]) {
                // If the max PQ is full and a closer point is found,
                // discard the farthest point and add this one
                maxPQ.poll();
                maxPQ.add(entry);
            }
        }
 
        // Return all points stored in the max PQ
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            int entryIndex = maxPQ.poll()[1];
            answer[i] = points[entryIndex];
        }    
        return answer;
    }
 
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
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