package com.algo.dp.pattern.minmaxcosttoreachtarget;

/**
 * A car travels from a starting position to a destination which is target miles
 * east of the starting position.
 * 
 * Along the way, there are gas stations. Each station[i] represents a gas
 * station that is station[i][0] miles east of the starting position, and has
 * station[i][1] liters of gas.
 * 
 * The car starts with an infinite tank of gas, which initially has startFuel
 * liters of fuel in it. It uses 1 liter of gas per 1 mile that it drives.
 * 
 * When the car reaches a gas station, it may stop and refuel, transferring all
 * the gas from the station into the car.
 * 
 * What is the least number of refueling stops the car must make in order to
 * reach its destination? If it cannot reach the destination, return -1.
 * 
 * Note that if the car reaches a gas station with 0 fuel left, the car can
 * still refuel there. If the car reaches the destination with 0 fuel left, it
 * is still considered to have arrived.
 * 
 * Input: target = 1, startFuel = 1, stations = [] Output: 0 Explanation: We can
 * reach the target without refueling.
 * 
 * Input: target = 100, startFuel = 1, stations = [[10,100]] Output: -1
 * Explanation: We can't reach the target (or even the first gas station).
 * 
 * 
 * Input: target = 100, startFuel = 10, stations =
 * [[10,60],[20,30],[30,30],[60,40]] Output: 2 Explanation: We start with 10
 * liters of fuel. We drive to position 10, expending 10 liters of fuel. We
 * refuel from 0 liters to 60 liters of gas. Then, we drive from position 10 to
 * position 60 (expending 50 liters of fuel), and refuel from 10 liters to 50
 * liters of gas. We then drive to and reach the target. We made 2 refueling
 * stops along the way, so we return 2.
 *
 */
public class MinimumNumberOfRefuelingStops {
	public static void main(String[] args) {
		int target = 100;
		int startFuel = 10;
		int[][] stations = { { 10, 60 }, { 30, 30 }, { 20, 30 }, { 60, 40 } };
		System.out.println(minRefuelStops(target, startFuel, stations));
	}

	/*
	 * dp[t] means the farthest distance that we can travel.
	 * 
	 * So for every station s[i], if the current distance dp[t] >= s[i][0] it means we have enough fuel to travel 
	 * to next gas station, we can refuel: dp[t + 1] = max(dp[t + 1], dp[t] + s[i][1]) 
	 * 
	 * In the end, we'll return the first t with dp[i] >= target, otherwise we'll return -1.
	 */
	public static int minRefuelStops(int target, int startFuel, int[][] s) {
		long[] dp = new long[s.length + 1];
		dp[0] = startFuel;
		for (int i = 0; i < s.length; ++i)
			for (int t = i; t >= 0; --t)
				if (dp[t] >= s[i][0]) {
					dp[t + 1] = Math.max(dp[t + 1], dp[t] + s[i][1]);
				}
		for (int t = 0; t <= s.length; ++t)
			if (dp[t] >= target)
				return t;
		return -1;
	}
}
