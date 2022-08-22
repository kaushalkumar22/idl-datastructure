package tree_preorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given a binary tree, return all root-to-leaf paths. Note: A leaf is a node
 * with no children. Input:
 * 
 * 1
 /   \
2     3
 \
  5
 * Output: ["1->2->5", "1->3"] Explanation: All root-to-leaf paths are: 1->2->5,
 * 1->3
 *
 */
public class BinaryTreePaths {

	public static void main(String[] args) {
		BinaryTreePaths tree = new BinaryTreePaths();
		List<Integer> nums = Arrays.asList(1, 2, 3, null, 5);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.binaryTreePaths(root));
	}

	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }
    
    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
}
