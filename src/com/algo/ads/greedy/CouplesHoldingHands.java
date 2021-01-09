package com.algo.ads.greedy;

/**
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want
 * to know the minimum number of swaps so that every couple is sitting side by
 * side. A swap consists of choosing any two people, then they stand up and
 * switch seats. The people and seats are represented by an integer from 0 to
 * 2N-1, the couples are numbered in order, the first couple being (0, 1), the
 * second couple being (2, 3), and so on with the last couple being (2N-2,
 * 2N-1). The couples' initial seating is given by row[i] being the value of the
 * person who is initially sitting in the i-th seat. Example 1: Input: row = [0,
 * 2, 1, 3] Output: 1 Explanation: We only need to swap the second (row[1]) and
 * third (row[2]) person.
 * 
 * Example 2: Input: row = [3, 2, 0, 1] Output: 0 Explanation: All couples are
 * already seated side by side.
 *
 * 
 */
public class CouplesHoldingHands {

	public static void main(String[] args) {
		int[] row ={3, 2, 0, 1};
		System.out.println(minSwapsCouples(row));

	}

	/*
	 * II -- N couples problem
	 * 
	 * The N couples problem can be solved using exactly the same idea as the N
	 * integers problem, except now we have different placement requirements:
	 * instead of i == row[i], we require i == ptn[pos[ptn[row[i]]]], where we have
	 * defined two additional arrays ptn and pos:
	 * 
	 * 
	 * ptn[i] denotes the partner of label i (i can be either a seat or a person) -
	 * - ptn[i] = i + 1 if i is even; ptn[i] = i - 1 if i is odd.
	 * 
	 * 
	 * pos[i] denotes the index of the person with label i in the row array - -
	 * row[pos[i]] == i.
	 * 
	 * 
	 * The meaning of i == ptn[pos[ptn[row[i]]]] is as follows:
	 * 
	 * 
	 * The person sitting at seat i has a label row[i], and we want to place him/her
	 * next to his/her partner.
	 * 
	 * 
	 * So we first find the label of his/her partner, which is given by ptn[row[i]].
	 * 
	 * 
	 * We then find the seat of his/her partner, which is given by pos[ptn[row[i]]].
	 * 
	 * 
	 * Lastly we find the seat next to his/her partner's seat, which is given by
	 * ptn[pos[ptn[row[i]]]].
	 * 
	 * 
	 * Therefore, for each pivot index i, its expected index j is given by
	 * ptn[pos[ptn[row[i]]]]. As long as i != j, we swap the two elements at index i
	 * and j, and continue until the placement requirement is satisfied. A minor
	 * complication here is that for each swapping operation, we need to swap both
	 * the row and pos arrays.
	 * 
	 * Here is a list of solutions for Java and C++. Both run at O(N) time with O(N)
	 * space. Note that there are several optimizations we can do, just to name a
	 * few:
	 * 
	 * 
	 * The ptn array can be replaced with a simple function that takes an index i
	 * and returns i + 1 or i - 1 depending on whether i is even or odd.
	 * 
	 * 
	 * We can check every other seat instead of all seats. This is because we are
	 * matching each person to his/her partners, so technically speaking there are
	 * always half of the people sitting at the right seats.
	 * 
	 * 
	 * There is an alternative way for building the index groups which goes in
	 * backward direction, that is instead of building the cycle like i0 --> i1 -->
	 * ... --> jk --> i0, we can also build it like i0 <-- i1 <-- ... <-- ik <-- i0,
	 * where i <-- j means the element at index j is expected to appear at index i.
	 * In this case, the pivot index will be changing along the cycle as the
	 * swapping operations are applied. The benefit is that we only need to do
	 * swapping on the row array.
	 */
	public static int minSwapsCouples(int[] row) {
		int res = 0, N = row.length;

		int[] ptn = new int[N];    
		int[] pos = new int[N];

		for (int i = 0; i < N; i++) {
			ptn[i] = (i % 2 == 0 ? i + 1 : i - 1);
			pos[row[i]] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]) {
				swap(row, i, j);
				swap(pos, row[i], row[j]);
				res++;
			}
		}

		return res;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
