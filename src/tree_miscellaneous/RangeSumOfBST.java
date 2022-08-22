package tree_miscellaneous;

import java.util.Stack;

/**
 * Given the root node of a binary search tree, return the sum of values of all
 * nodes with value between L and R (inclusive).
 * 
 * The binary search tree is guaranteed to have unique values.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 Output: 32
 * 
 * Example 2:
 * 
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10 Output: 23
 * 
 * 
 * Note:
 * 
 * The number of nodes in the tree is at most 10000. The final answer is
 * guaranteed to be less than 2^31.
 *
 * 
 * 
 */
public class RangeSumOfBST {

	public int rangeSumBSTRec(TreeNode root, int L, int R) {
		if (root == null)
			return 0; // base case.
		if (root.val < L)
			return rangeSumBSTRec(root.right, L, R); // left branch excluded.
		if (root.val > R)
			return rangeSumBSTRec(root.left, L, R); // right branch excluded.
		return root.val + rangeSumBSTRec(root.right, L, R) + rangeSumBSTRec(root.left, L, R); // count in both children.
	}
	public int rangeSumBST(TreeNode root, int L, int R) {
		Stack<TreeNode> stk = new Stack<>();
		stk.push(root);
		int sum = 0;
		while (!stk.isEmpty()) {
			TreeNode n = stk.pop();
			if (n == null) { 
				continue; 
			}
			if (n.val > L) {// left child is a possible candidate.
				stk.push(n.left);
			} 
			if (n.val < R) { // right child is a possible candidate.
				stk.push(n.right); 
			} 
			if (L <= n.val && n.val <= R) { 
				sum += n.val; 
			}
		}
		return sum;
	}
}
