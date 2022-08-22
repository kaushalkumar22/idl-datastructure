package tree_preorder;

import java.util.Arrays;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

public class ConvertBinaryTreeIntoMirror {

	public static void main(String args[]) {

		ConvertBinaryTreeIntoMirror tree = new ConvertBinaryTreeIntoMirror();
		TreeNode root =TreeUtil.createTree(Arrays.asList(1,2,3,4,5));
		TreeUtil.inorder(root);
		tree.mirror(root);
		TreeUtil.inorder(root);
	}
	private void mirror(TreeNode root) {
		if (root == null) {
			return;
		} 

		mirror(root.left);
		mirror(root.right);

		/* swap the objects/values in this node */
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	
	
}