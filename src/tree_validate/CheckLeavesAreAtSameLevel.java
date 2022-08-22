package tree_validate;

import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

public class CheckLeavesAreAtSameLevel {

	public static void main(String args[]) {

		CheckLeavesAreAtSameLevel tree = new CheckLeavesAreAtSameLevel();
		List<Integer> nums = Arrays.asList(12,5,null,3,9,1,null,1,null);
		TreeNode root =TreeUtil.createTree(nums);
		System.out.println(tree.checkLeafLevel(root,0,0));
	
	}
	boolean checkLeafLevel(TreeNode node, int level, int leafLevel) {

		if (node == null) {
			return true;
		}
		if (node.left == null && node.right == null) {
			if (leafLevel == 0) {
				leafLevel = level; // Set first found leaf's level
				return true;
			}
			// If this is not first leaf node, compare its level with first leaf's level
			return (level == leafLevel);
		}
		// If this node is not leaf, recursively check left and right subtrees
		return checkLeafLevel(node.left, level + 1, leafLevel)
				&& checkLeafLevel(node.right, level + 1, leafLevel);
	}

	

}