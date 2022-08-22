package dynamicprogramming_minmaxcosttoreachtarget;

/**
 * 983. Minimum Cost For Tickets
 * 
 * In a country popular for train travel, you have planned some train traveling
 * one year in advance. The days of the year that you will travel is given as an
 * array days. Each day is an integer from 1 to 365.
 * 
 * Train tickets are sold in 3 different ways:
 * 
 * a 1-day pass is sold for costs[0] dollars; a 7-day pass is sold for costs[1]
 * dollars; a 30-day pass is sold for costs[2] dollars.
 * 
 * The passes allow that many days of consecutive travel. For example, if we get
 * a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7,
 * and 8.
 * 
 * Return the minimum number of dollars you need to travel every day in the
 * given list of days.
 * 
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15] Output: 11 Explanation: For
 * example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1. On
 * day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4,
 * ..., 9. On day 20, you bought a 1-day pass for costs[0] = $2, which covered
 * day 20. In total you spent $11 and covered all the days of your travel.
 * 
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15] Output: 17
 * Explanation: For example, here is one way to buy passes that lets you travel
 * your travel plan: On day 1, you bought a 30-day pass for costs[2] = $15 which
 * covered days 1, 2, ..., 30. On day 31, you bought a 1-day pass for costs[0] =
 * $2 which covered day 31. In total you spent $17 and covered all the days of
 * your travel.
 * 
 */
public class MinimumCostForTickets {

	public static void main(String[] args) {
		int[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, costs = { 2, 7, 15 };
		System.out.println(mincostTickets(days, costs));
	}

	/*
	 * For each travel day, we can buy a one-day ticket, or use 7-day or 30-day pass
	 * as if we would have purchased it 7 or 30 days ago. We need to track rolling
	 * costs for at least 30 days back, and use them to pick the cheapest option for
	 * the next travel day.
	 * 
	 * main approach take min of all 3 cost( single day ,7 days pass, 30 days)
	 * dp[Math.max(i - X, 0) % 30] it will check x days back what is value +current days
	 * Math.max(i - X, 0) is used ,if i-x is not exist return 0.
	 */
	public static int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[30];
		int d = 0; // d means the index of next travel day
		int lastday = days[days.length - 1];

		for (int i = days[0]; i <= lastday; i++) {
			if (i != days[d])
				dp[i % 30] = dp[(i - 1) % 30]; // we don't have this day for travel, price as yesterday
			else { // i == days[d]
				dp[i % 30] = Math.min(dp[(i - 1) % 30] + costs[0],
						Math.min(dp[Math.max(i - 7, 0) % 30] + costs[1], 
								dp[Math.max(i - 30, 0) % 30] + costs[2]));
				d++;
			}
		}

		return dp[lastday % 30];
	}
}
