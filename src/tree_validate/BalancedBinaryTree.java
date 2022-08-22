package tree_validate;

import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given a binary tree, determine if it is height-balanced. For this problem, a
 * height-balanced binary tree is defined as: a binary tree in which the depth
 * of the two subtrees of every node never differ by more than 1. 
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *  3
   / \
  9  20
    /  \
   15   7
Return true.

Given the following tree [1,2,2,3,3,null,null,4,4]:
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 * 
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		BalancedBinaryTree tree=new BalancedBinaryTree();
		List<Integer> nums = (List<Integer>) Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4);
		System.out.println(nums);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.isBalanced(root));
		System.out.println(tree.isBalancedOpt(root));
	}


	public boolean isBalanced (TreeNode root) {
		if (root == null) return true;

		int left = depth(root.left);
		int right= depth(root.right);

		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
	private int depth (TreeNode root) {
		if (root == null) return 0;

		return 1+Math.max (depth(root.left), depth (root.right));
	}

	boolean isBalancedOpt(TreeNode root) {
		return dfsHeight (root) != -1;
	}
	int dfsHeight (TreeNode root) {
		if (root == null) return 0;
		if(root.left==null&&root.right==null) return 1;
		int lHeight = dfsHeight (root.left);
		int rHeight = dfsHeight (root.right);

		if (lHeight == -1||rHeight == -1||Math.abs(lHeight - rHeight) > 1)  return -1;
		return Math.max (lHeight, rHeight) + 1;
	}

}