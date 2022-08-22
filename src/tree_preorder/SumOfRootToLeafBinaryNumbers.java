package tree_preorder;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * You are given the root of a binary tree where each node has a value 0 or 1.
 * Each root-to-leaf path represents a binary number starting with the most
 * significant bit. For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this
 * could represent 01101 in binary, which is 13.
 * 
 * For all leaves in the tree, consider the numbers represented by the path from
 * the root to that leaf.
 * 
 * Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,0,1,0,1,0,1] Output: 22 Explanation: (100) + (101) + (110) +
 * (111) = 4 + 5 + 6 + 7 = 22
 * 
 * Example 2:
 * 
 * Input: root = [0] Output: 0
 * 
 * Example 3:
 * 
 * Input: root = [1] Output: 1
 * 
 * Example 4:
 * 
 * Input: root = [1,1] Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000]. Node.val is 0 or
 * 1.
 * 
 * 
 */
public class SumOfRootToLeafBinaryNumbers {

	public static void main(String[] args) {
		SumOfRootToLeafBinaryNumbers tree = new SumOfRootToLeafBinaryNumbers();
		List<Integer> nums = Arrays.asList(1, 0, 1, 0, 1, 0, 1);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.sumRootToLeaf(root));
	}

	public int sumRootToLeafRec(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode root, int val) {
		if (root == null) return 0;
		val = val * 2 + root.val;
		if( root.left == root.right) return val;
		
		return dfs(root.left, val) + dfs(root.right, val);
	}
	
	   public int sumRootToLeaf(TreeNode root) {
	        if(root == null)
	            return 0;
	        Stack<TreeNode> stack = new Stack();
	        stack.push(root);
	        int sum = 0;
	        while(!stack.isEmpty()) {
	            root = stack.pop();
	            if(root.left == null && root.right == null)
	                sum += root.val;
	            if(root.right != null) {
	                root.right.val = 2 * root.val + root.right.val;
	                stack.push(root.right);
	            }
	            if(root.left != null) {
	                root.left.val = 2 * root.val + root.left.val;
	                stack.push(root.left);
	            }
	        }
	        return sum;
	    }
}
