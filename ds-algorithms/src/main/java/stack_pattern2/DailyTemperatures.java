package stack_pattern2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Daily Temperatures
 * 
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature. If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each
 * temperature will be an integer in the range [30, 100].
 *
 */
public class DailyTemperatures {

	public static void main(String[] args) {
		int[] T= {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toString(dailyTemperatures(T)));
	}

	public static int[] dailyTemperatures(int[] T) {
		int[] warmer = new int[T.length];
		Stack<Integer> st =new Stack<Integer>();
		for(int i=0;i<T.length;i++) {
			while(!st.isEmpty()&&T[i]>T[st.peek()]) {
				warmer[st.peek()]=i-st.pop();
			}
			st.push(i);
		}
		return warmer;

	}
	public int[] dailyTemperatures1(int[] temperatures) {
		int n = temperatures.length;
		int hottest = 0;
		int answer[] = new int[n];

		for (int currDay = n - 1; currDay >= 0; currDay--) {
			int currentTemp = temperatures[currDay];
			if (currentTemp >= hottest) {
				hottest = currentTemp;
				continue;
			}

			int days = 1;
			while (temperatures[currDay + days] <= currentTemp) {
				// Use information from answer to search for the next warmer day
				days += answer[currDay + days];
			}
			answer[currDay] = days;
		}

		return answer;
	}
}
