package xyz_miscellaneous;

import tree_miscellaneous.TreeNode;

public class PopulatingNextRightPointersInEachNodeII {
	public static void main(String[] args) {

	}
	//based on level order traversal
	public void connect(TreeNode root) {

		TreeNode head = null; //head of the next level
		TreeNode prev = null; //the leading node on the next level
		TreeNode cur = root;  //current node of current level

		while (cur != null) {

			while (cur != null) { //iterate on the current level
				//left child
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}
				//right child
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				//move to next node
				cur = cur.next;
			}        
			//move to next level
			cur = head;
			head = null;
			prev = null;
		}   
	}
}


