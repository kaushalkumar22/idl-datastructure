package xyz_miscellaneous;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 
 * Given two arrays A and B of equal size, the advantage of A with respect to B
 * is the number of indices i for which A[i] > B[i].
 * 
 * Return any permutation of A that maximizes its advantage with respect to B.
 * 
 * 
 * Input: A = [2,7,11,15], B = [1,10,4,11] Output: [2,11,7,15]
 * 
 * Input: A = [12,24,8,32], B = [13,25,32,11] Output: [24,32,8,12]
 *
 * 
 */
public class AdvantageShuffle {

	 public int[] advantageCount(int[] A, int[] B) {
	        Arrays.sort(A);
	        int n=A.length;
	        int[] res= new int[n];
	        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[0]-a[0]);
	        for (int i=0; i<n; i++) pq.add(new int[]{B[i], i});
	        int lo=0, hi=n-1;
	        while(!pq.isEmpty()){
	            int[] cur= pq.poll();
	            int idx=cur[1], val=cur[0];
	            if (A[hi]>val) res[idx]=A[hi--];
	            else res[idx]=A[lo++];
	        }
	        return res;
	    }  
}
