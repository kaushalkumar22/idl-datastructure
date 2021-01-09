package com.algo.lds.slidingwindow;

/**
 * Today, the bookstore owner has a store open for customers.length minutes.
 * Every minute, some number of customers (customers[i]) enter the store, and
 * all those customers leave after the end of that minute.
 * 
 * On some minutes, the bookstore owner is grumpy. If the bookstore owner is
 * grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0. When the
 * bookstore owner is grumpy, the customers of that minute are not satisfied,
 * otherwise they are satisfied.
 * 
 * The bookstore owner knows a secret technique to keep themselves not grumpy
 * for X minutes straight, but can only use it once.
 * 
 * Return the maximum number of customers that can be satisfied throughout the
 * day.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * Output: 16 Explanation: The bookstore owner keeps themselves not grumpy for
 * the last 3 minutes. The maximum number of customers that can be satisfied = 1
 * + 1 + 1 + 1 + 7 + 5 = 16
 * 
 * @author I339640
 *
 */
public class GrumpyBookstoreOwner {

	/*
	 * Use a sliding window winOfMakeSatisfied to record the number of
	 * unsatisfied customers for X minutes. Deduct the unsatisfied customers
	 * from left end of the sliding window when it is wider than X:
	 * winOfMakeSatisfied -= grumpy[i - X] * customers[i - X];. Use satisfied to
	 * record the number of satistified customers without grumpy technique. by
	 * the end of iterations, satisfied + max(winOfMakeSatisfied) is the answer.
	 */
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int satisfied = 0, maxMakeSatisfied = 0;
		for (int i = 0, winOfMakeSatisfied = 0; i < grumpy.length; ++i) {
			if (grumpy[i] == 0) { satisfied += customers[i]; }
			else { winOfMakeSatisfied += customers[i]; }
			if (i >= X) {
				winOfMakeSatisfied -= grumpy[i - X] * customers[i - X];
			}
			maxMakeSatisfied = Math.max(winOfMakeSatisfied, maxMakeSatisfied);
		}
		return satisfied + maxMakeSatisfied;        
	}
}
