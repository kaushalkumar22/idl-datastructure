package com.algo.universal;

/**
 * There are n flights, and they are labeled from 1 to n. We have a list of
 * flight bookings. The i-th booking bookings[i] = [i, j, k] means that we
 * booked k seats from flights labeled i to j inclusive. Return an array answer
 * of length n, representing the number of seats booked on each flight in order
 * of their label.
 * 
 * Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5 Output:[10,55,45,25,25]
 *
 */
public class CorporateFlightBookings {

	/*
	 * Since ranges are continuous, what if we add reservations to the first flight
	 * in the range, and remove them after the last flight in range? We can then use
	 * the running sum to update reservations for all flights.
	 * 
	 * This picture shows the logic for this test case:
	 * [[1,2,10],[2,3,20],[3,5,25]].
	 * flights       1     2        3      4       5
	 * res1          10    10 
	 * res2                20       20
	 * res3                25       25     25       25
	 *               10    55       45     25       25
	 * 
	 */
	public int[] corpFlightBookings(int[][] bookings, int n) {
		  int[] res = new int[n];
		  for (int[] v : bookings) {
		    res[v[0] - 1] += v[2];
		    if (v[1] < n) res[v[1]] -= v[2];
		  }
		  for (int i = 1; i < n; ++i) res[i] += res[i - 1];
		  return res;
		}
}