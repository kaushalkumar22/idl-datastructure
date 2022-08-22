package xyz_miscellaneous;

/**
 * Given two integers A and B, return any string S such that:
 * 
 * S has length A + B and contains exactly A 'a' letters, and exactly B 'b'
 * letters; The substring 'aaa' does not occur in S; The substring 'bbb' does
 * not occur in S.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = 1, B = 2 Output: "abb" Explanation: "abb", "bab" and "bba" are all
 * correct answers.
 * 
 * Example 2:
 * 
 * Input: A = 4, B = 1 Output: "aabaa"
 *
 */
public class StringWithoutAAAorBBB {
	public String strWithout3a3b(int A, int B) {
		  StringBuilder res = new StringBuilder(A + B);
		  char a = 'a', b = 'b';
		  int i = A, j = B;
		  if (B > A) { a = 'b'; b = 'a'; i = B; j = A; }
		  while (i-- > 0) {
		    res.append(a);
		    if (i > j) { res.append(a); --i; }
		    if (j-- > 0) res.append(b);
		  }
		  return res.toString();
		}
}
