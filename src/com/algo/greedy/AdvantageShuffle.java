package com.algo.greedy;

import java.util.TreeMap;

/**
 * 
 * Given two arrays A and B of equal size, the advantage of A with respect to B
 * is the number of indices i for which A[i] > B[i].
 * 
 * Return any permutation of A that maximizes its advantage with respect to B.
 * 
 * 
 * Input: A = [2,7,11,15], B = [1,10,4,11] Output: [2,11,7,15]
 * 
 * Input: A = [12,24,8,32], B = [13,25,32,11] Output: [24,32,8,12]
 *
 * 
 */
public class AdvantageShuffle {

	public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i : A) m.put(i, m.getOrDefault(i, 0) + 1);
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            Integer x = m.higherKey(B[i]);
            if (x == null) x = m.firstKey();
            m.put(x, m.get(x) - 1);
            if (m.get(x) == 0) m.remove(x);
            res[i] = x;
        }
        return res;
    }
}
