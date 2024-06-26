package greedy;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value. You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 * Input: [1,0,2] Output: 5 Explanation: You can allocate to the first, second
 * and third child with 2, 1, 2 candies respectively.
 *
 */
public class Candy {

	public static void main(String[] args) {
		int[] ratings = { 1,0,5,4,3 };
		System.out.println(candy(ratings));
	}

	public static int candy(int[] ratings) {
		int candies[] = new int[ratings.length];
		Arrays.fill(candies, 1);// Give each child 1 candy
		// Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
		for (int i = 1; i < candies.length; i++) {			
			if (ratings[i] > ratings[i - 1])
				candies[i] = (candies[i - 1] + 1);
		}
		// Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
		for (int i = candies.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])//1,0,5,4,3
				candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
		}
		return Arrays.stream(candies).sum();
	}
}
