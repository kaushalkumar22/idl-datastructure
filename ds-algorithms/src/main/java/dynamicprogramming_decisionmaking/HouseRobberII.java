package dynamicprogramming_decisionmaking;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * Input: [2,3,2] Output: 3 Explanation: You cannot rob house 1 (money = 2) and
 * then rob house 3 (money = 2), because they are adjacent houses.
 * 
 * Example 2:
 * 
 * Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then rob
 * house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * 
 * 
 * @author IBM
 *
 */
public class HouseRobberII {
	public static void main(String[] args) {

	}
	private int rob(int[] num, int lo, int hi) {
	    int include = 0, exclude = 0;
	    for (int j = lo; j <= hi; j++) {
	        int i = include, e = exclude;
	        include = e + num[j];
	        exclude = Math.max(e, i);
	    }
	    return Math.max(include, exclude);
	}
}
