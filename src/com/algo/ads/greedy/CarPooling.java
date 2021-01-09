package com.algo.ads.greedy;
/**
You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east 
(ie. it cannot turn around and drive west.)
Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: 
the number of passengers that must be picked up, and the locations to pick them up and drop them off.  
The locations are given as the number of kilometers due east from your vehicle's initial location.
Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 * @author I339640
 *
 */
public class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {    
		  int stops[] = new int[1001]; 
		  for (int t[] : trips) {
		      stops[t[1]] += t[0];
		      stops[t[2]] -= t[0];
		  }
		  for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
		  return capacity >= 0;
		}
}
