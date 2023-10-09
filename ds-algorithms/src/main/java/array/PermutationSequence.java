package array;

import java.util.ArrayList;

/**
 * 
 * Permutation Sequence Hard
 * 
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note:
 * 
 * Given n will be between 1 and 9 inclusive. Given k will be between 1 and n!
 * inclusive.
 *
 * Input: n = 3, k = 3 Output: "213"
 *
 * Input: n = 4, k = 9 Output: "2314"
 *
 * 
 */
public class PermutationSequence {
	public static void main(String[] args) {

        System.out.println(getPermutation(3,6));
	}
	public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        k=k-1;
        for(int i =0;i<n;i++){
            fact =fact/(n-i); //
            int index = k/fact;
            sb.append(num.remove(index));
            k = k- index * fact;
        }
        return sb.toString();
    }
}
