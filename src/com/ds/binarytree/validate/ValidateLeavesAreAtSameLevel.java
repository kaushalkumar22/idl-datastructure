package com.ds.binarytree.validate;

import java.util.Arrays;
import java.util.List;

import com.ds.binarytree.common.TreeNode;
import com.ds.binarytree.common.TreeUtil;

class ValidateLeavesAreAtSameLevel {

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

	public static void main(String args[]) {

		ValidateLeavesAreAtSameLevel tree = new ValidateLeavesAreAtSameLevel();
		List<Integer> nums = Arrays.asList(12,5,null,3,9,1,null,1,null);
		TreeNode root =TreeUtil.createTree(nums);
		if (tree.checkLeafLevel(root,0,0)) {
			System.out.println("Leaves are at same level");
		} else {
			System.out.println("Leaves are not at same level");
		}
	}

}