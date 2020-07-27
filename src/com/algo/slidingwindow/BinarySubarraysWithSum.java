package com.algo.slidingwindow;

/**
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * 
 * Input: A = [1,0,1,0,1], S = 2 Output: 4 
 * Explanation: The 4 subarrays are bolded below: 
 * [1,0,1,x,x] 
 * [1,0,1,0,x] 
 * [x,0,1,0,1] 
 * [x,X,1,0,1]
 *
 * 
 */
public class BinarySubarraysWithSum {

	public static void main(String[] args) {
		int[] A = {1,0,1,0,1};
		//numSubarraysWithSum1(A, 2);
		System.out.println(numSubarraysWithSum1(A, 2));
		System.out.println(numSubarraysWithSum(A, 2));
	}
	
	/*
	 * Solution 2: Sliding Window
	 * 
	 * We have done this hundreds time. Space O(1) Time O(N)
	 */
	 public static int numSubarraysWithSum1(int[] A, int S) {
        return atMost(A, S) - atMost(A, S - 1);
    }
//1,0,1,0,1
    public static int atMost(int[] A, int S) {
        if (S < 0) return 0;
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            S -= A[j];
            while (S < 0)
                S += A[i++];
            res += j - i + 1;
        }
        return res;
    }
    
  /*  Logic: In this problem we are required to find some interval [i:j] ,i < j where sum[i:j] = target. We know that sum[i:j] = A[i] + A[i+1] +... + A[j].
    		Then we also know that
    		Let's define prefixSum[j] = A[0] + A[1] + ... + A[j] 0 <= j <= n-1 (n = A.length)
    		It is easy to see that,
    		sum[i:j] = A[i] + A[i+1] ... + A[j] =
    		(A[0] + A[1] + ... A[i] ... + A[j]) - (A[0] + A[1] + ... A[i-1]) =
    		prefix[j] - prefix[i-1].

    		Now we the problem reduces to finding # of pairs (i, j) (i < j) such that
    		prefix[j] - prefix[i-1] = target
    		This becomes prefix[i-1] = prefix[j] - target with some algebra.
    		So we use the hashmap to find all pairs that satisfy the above equations.

    		We only need to track the prefix sum up to this point however, since we already saved all the previous results in the map.

    		if (sum == target) total++ Here I am checking for the case where the current element is equal to the sum (it needs no interval to produce the sum).
*/
    		
    		    public static int numSubarraysWithSum(int[] A, int target) {
    		        //The largest sum we can have is len(A) = n Why? What if array A[] has all 1's.
    		        int n = A.length;
    		        //Everything is initialized to zero
    		        int[] presum = new int[n+1];
    		        int sum = 0;
    		        //Case where it's just it's own 
    		        int total = 0;
    		        
    		        for (int i = 0; i < A.length; i++){
    		            sum += A[i];
    		            int compliment = sum - target;
    		            
    		            if (compliment >= 0)
    		            total += presum[compliment];
    		            
    		            if (sum == target) total++;
    		            //Also put this sum into the map as well
    		            presum[sum]+=1;
    		        }
    		        
    		        return total;
    		        
    		    }
    		}



