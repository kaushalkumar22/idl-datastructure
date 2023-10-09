package tree_validate;

import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;


/**
 * Check if a given Binary Tree is SumTree( Complexity O(n))
 * 
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the
 * nodes present in its left subtree and right subtree. An empty tree is SumTree
 * and sum of an empty tree can be considered as 0. A leaf node is also
 * considered as SumTree.
 * 
 * The Method uses following rules to get the sum directly. 1) If the node is a
 * leaf node then sum of subtree rooted with this node is equal to value of this
 * node.
 * 
 * 2) If the node is not a leaf node then sum of subtree rooted with this node
 * is twice the value of this node (Assuming that the tree rooted with this node
 * is SumTree).
 * 
 * *        26
           /  \
          10   3
         /  \   \
        4    6   3
 * 
 * 
 */

public class SumTree {

	public static void main(String args[]) {

		SumTree tree = new SumTree();
		List<Integer> nums = Arrays.asList(26, 10, 3, 4, 6, null, 3);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.isSumTree(root));
		System.out.println(SumTree.isSumTree2(root));

	}

	// returns 1 if SumTree property holds for the given tree
	private boolean isSumTree(TreeNode root) {
	    if(root==null) return true;
		return isSum(root)!=-1;
	}

	private int isSum(TreeNode root) {
		if (root == null) return 0;
		
	    int left =isSum( root.left);
	    int right =isSum( root.right);
	    
	    if (root.left == null && root.right == null) {
            return root.val;
        }
	    if(root.val!=(left+right)) return -1;
	    
		return root.val+left+right;
	}
	public static int isSumTree2(TreeNode root){
        // base case: empty tree
        if (root == null) {
            return 0;
        }
 
        // special case: leaf node
        if (root.left == null && root.right == null) {
            return root.val;
        }
 
        int left = isSumTree2(root.left);
        int right = isSumTree2(root.right);
 
        // if the root's value is equal to the sum of all elements present in its
        // left and right subtree
        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE &&
                root.val == left + right) {
            return 2 * root.val;
        }
 
        return Integer.MIN_VALUE;
    }
}
