package com.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairswithSmallestSums {

	public int maxEvents(int[][] A) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
		int i = 0, res = 0, d = 0, n = A.length;
		while (!pq.isEmpty() || i < n) {
			if (pq.isEmpty())
				d = A[i][0];
			while (i < n && A[i][0] <= d)
				pq.offer(A[i++][1]);
			pq.poll();
			++res; ++d;
			while (!pq.isEmpty() && pq.peek() < d)
				pq.poll();
		}
		return res;
	}


}


