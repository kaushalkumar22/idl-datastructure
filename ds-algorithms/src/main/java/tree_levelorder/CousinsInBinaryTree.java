package tree_levelorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents.
 * 
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree.
 * 
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4], x = 4, y = 3 Output: false
 * 
 * Example 2:
 * 
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4 Output: true
 * 
 * Example 3:
 * 
 * Input: root = [1,2,3,null,4], x = 2, y = 3 Output: false
 *
 * 
 * 
 */
public class CousinsInBinaryTree {

	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(1, 2, 3, null, 4, null, 5);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Is Cousins : " + isCousins(root, 5, 4));
	}

	public static boolean isCousins(TreeNode root, int A, int B) {
		if (root == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean isAexist = false;
			boolean isBexist = false;
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.val == A) isAexist = true;
				if (cur.val == B) isBexist = true;
				if (cur.left != null && cur.right != null) {
					if (cur.left.val == A && cur.right.val == B) { return false; }
					if (cur.left.val == B && cur.right.val == A) { return false; }
				}
				if (cur.left != null) { queue.offer(cur.left); }
				if (cur.right != null) { queue.offer(cur.right);}
			}
			if (isAexist && isBexist)
				return true;
		}
		return false;
	}
	TreeNode xParent = null;
	TreeNode yParent = null;
	int xDepth = -1, yDepth = -1;

	public boolean isCousinsRec(TreeNode root, int x, int y) {
		getDepthAndParent(root, x, y, 0, null);
		return xDepth == yDepth && xParent != yParent? true: false;
	}
	//get both the depth and parent for x and y
	public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
		if(root == null){
			return;
		}
		if(root.val == x){
			xParent = parent;
			xDepth = depth;
		}else if(root.val == y){
			yParent = parent;
			yDepth = depth;
		}       
		getDepthAndParent(root.left, x, y, depth + 1, root);
		getDepthAndParent(root.right, x, y, depth + 1, root);
	}

}
