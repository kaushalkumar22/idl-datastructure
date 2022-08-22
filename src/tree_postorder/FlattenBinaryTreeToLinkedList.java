package tree_postorder;

import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


 * @author I339640
 *
 */
public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,5,3,4,null,6);
		TreeNode root = TreeUtil.createTree(nums);
		flatten( root);
		TreeUtil.inorder(root);
	}
	public static void flatten(TreeNode root){
		flatten(root,null);
	}
	private static TreeNode flatten(TreeNode root, TreeNode pre){
		if(root==null) return pre;
		pre=flatten(root.right,pre);    
		pre=flatten(root.left,pre);
		root.right=pre;
		root.left=null;
		pre=root;
		return pre;
	}
	public int rob(TreeNode root) {
		int ans[] = robHouse(root);
		return Math.max(ans[0],ans[1]);
	}

	public int[] robHouse(TreeNode root){
		if(root==null){
			return new int[2];
		}

		int left[] = robHouse(root.left);
		int right[] = robHouse(root.right);

		int ans[] = new int[2];

		ans[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
		ans[1] = root.val+left[0]+right[0];

		return ans;
	}



}
