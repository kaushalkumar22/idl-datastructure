package dynamicprogramming_lcs;

/**
 * You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.
 * We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
 * 	• nums1[i] == nums2[j], and
 * 	• the line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).
 * Return the maximum number of connecting lines we can draw in this way.
 *
 *
 * Input: nums1 = [1,4,2], nums2 = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
 * Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * Output: 3
 * Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * Output: 2
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length, dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j <n; ++j)
                if (A[i] == B[j])
                    dp[i+1][j+1] = 1 + dp[i][j];
                else
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
        return dp[m][n];
    }

    public int maxUncrossedLines2(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m < n) {
            return maxUncrossedLines(B, A);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <m; ++i) {
            for (int j = 0, prevRow = 0, prevRowPrevCol = 0; j <n; ++j) {
                prevRowPrevCol = prevRow;
                prevRow = dp[j + 1];
                if(A[i] == B[j]) {
                    dp[j + 1] = 1+prevRowPrevCol ;
                }else
                    dp[j + 1] =  Math.max(dp[j], prevRow);
            }
        }
        return dp[n];
    }

}
