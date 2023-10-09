package tree_depth;

import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * Given a binary tree
 *        1
         / \
        2   3
       / \     
      4   5    
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 */
public class DiameterOfBinaryTree {
	public static void main(String args[]) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.diameterOfBinaryTree(root));
		System.out.println(tree.diameterOfBinaryTree1(root));
	}
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) return 0;
		int[] max = {0};
		maxDepth2(root,max);
		return max[0];
	}

	private int maxDepth2(TreeNode root,int[] max) {
		if (root == null) return 0;
        
		int left = maxDepth2(root.left,max);
		int right = maxDepth2(root.right,max);

		max[0] = Math.max(max[0], left + right);

		return Math.max(left, right) + 1;
	}
	int max = 0;
	public int diameterOfBinaryTree1(TreeNode root) {
		maxDepth(root);
		return max;
	}

	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;
	}
}