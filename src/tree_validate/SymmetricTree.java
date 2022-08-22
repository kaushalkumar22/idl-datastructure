package tree_validate;

import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center). For example, this binary tree [1,2,2,3,4,4,3] is
 * symmetric:
 *
 *   1
   / \
  2   2
 / \ / \
3  4 4  3

 *But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 * 
 */
public class SymmetricTree {

	public static void main(String[] args) {

		SymmetricTree tree = new SymmetricTree();
		// List<Integer> nums = Arrays.asList(1,2,2,3,4,4,3);
		List<Integer> nums = Arrays.asList(1, 2, 2, null, 3, null, 3);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.isSymentric(root));

	}
	public boolean isSymentric(TreeNode root) {
		if(root==null)return true;
		return isSame( root.left, root.right);

	}
	private boolean isSame(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p == null || q == null)
			return false;

		if(p.val == q.val)
			return isSame(p.left, q.right) && isSame(p.right, q.left);
		
		return false;
	}

}
