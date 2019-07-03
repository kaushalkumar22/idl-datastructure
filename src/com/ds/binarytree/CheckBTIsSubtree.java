package com.ds.binarytree;
/*ALgo: 1 time complexity O(n^2) and space O(1)

1.If small tree is null' then return true since 'null' tree is sub-tree for any tree.
2.If Big tree is null'  then return false since null tree cannot have any sub-tree except null tree for which 
we have already checked in.
3.If both 1 and 2 are false then check if value of small root is equal to value of big.
if yes then 
4. If condition #3 evaluated to true then we check if left sub-tree of 
   smallTreeRoot exactly matches to left sub-tree of bigTreeRoot and right sub-tree of smallTreeRoot exactly matches to right sub-tree of bigTreeRoot. 
   If both sub-trees match then we return true since we know that smallTree is now a sub-tree of bigTree.
5. If either #3 or #4 evaluate to false then we check if left sub-tree of bigTreeRoot contains smallTree or 
   right sub-tree of bigTreeRoot contains smallTree. For checking this we simply make recursive calls.*/
//Time Complexity: Time worst case complexity of above solution is O(n^2) where m and n are number of nodes in given two trees. 
public class CheckBTIsSubtree {

	Node root1,root2;

	/* A utility function to check whether trees with roots as root1 and root2 are identical or not */
	boolean areIdentical(Node node1, Node node2) {

		if (node1 == null && node2 == null) return true;		

		/* Check if the data of both roots is same and data of left and right subtrees are also same */
		return (node1.data == node2.data&& areIdentical(node1.left, node2.left)
				&& areIdentical(node1.right, node2.right));
	}

	/* This function returns true if S is a subtree of T, otherwise false */
	private boolean isSubtree(Node big, Node small) {

		/* base cases */
		if (small == null) return true;
		if (big == null) return false;
		
		/* Check the tree with root as current node */
		if (areIdentical(big, small)) return true;
		
		/* If the tree with root as current node doesn't match then try left and right subtrees one by one */
		return isSubtree(big.left, small)|| isSubtree(big.right, small);
	}

	public static void main(String args[]) {

		CheckBTIsSubtree tree = new CheckBTIsSubtree();

		// TREE 1
		/* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

		tree.root1 = new Node(26);
		tree.root1.right = new Node(3);
		tree.root1.right.right = new Node(3);
		tree.root1.left = new Node(10);
		tree.root1.left.left = new Node(4);
		tree.root1.left.left.right = new Node(30);
		tree.root1.left.right = new Node(6);

		// TREE 2
		/* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

		tree.root2 = new Node(10);
		tree.root2.right = new Node(6);
		tree.root2.left = new Node(4);
		tree.root2.left.right = new Node(30);

		if (tree.isSubtree(tree.root1, tree.root2)) {
			System.out.println("Tree 2 is subtree of Tree 1 ");
		} else {
			System.out.println("Tree 2 is not a subtree of Tree 1");
		}
	}
	private static class Node {

		int data;
		Node left, right;
		Node(int item) {
			data = item;
			left = right = null;
		}
	}
}
