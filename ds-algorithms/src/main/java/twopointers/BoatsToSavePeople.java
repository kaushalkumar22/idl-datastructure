package twopointers;

import java.util.Arrays;

/**
 * 
 * The i-th person has weight people[i], and each boat can carry a maximum
 * weight of limit.
 *<p>
 * Each boat carries at most 2 people at the same time, provided the sum of the
 * weight of those people is at most limit.
 *<p>
 * Return the minimum number of boats to carry every given person. (It is
 * guaranteed each person can be carried by a boat.)
 *<p>
 * Input: people = [1,2], limit = 3 Output: 1 Explanation: 1 boat (1, 2)
 *<p>
 * Input: people = [3,2,2,1], limit = 3 Output: 3 Explanation: 3 boats (1, 2),
 * (2) and (3)
 *<p>
 * Input: people = [3,5,3,4], limit = 5 Output: 4 Explanation: 4 boats (3), (3),
 * (4), (5)
 *
 */
public class BoatsToSavePeople {

	public static void main(String[] args) {
		int people[] = {3,5,3,4}, limit = 5;
		System.out.println(numRescueBoats(people,limit));
	}
	public static int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);
		int low=0;
		int high =people.length-1;
		int count =0;
		while(low<=high) {
			int canCarry = people[low] + people[high];
			if (canCarry<=limit) {
				low++;
			}			
			high--;
			count++;

		}      
		return count;
	}
}
