package com.ds.binarytree.common;
//http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
public class PopulatingNextRightPointersInEachNode {

	static Node root;

	/* This function returns the leftmost child of nodes at the same level as p.
	     This function is used to getNExt right of p's right child
	     If right child of is NULL then this can also be sued for the left child */
	Node getNextRight(Node p) {
		Node temp = p.nextRight;

		/* Traverse nodes at p's level and find and return
	         the first node's first child */
		while (temp != null) {
			if (temp.left != null) {
				return temp.left;
			}
			if (temp.right != null) {
				return temp.right;
			}
			temp = temp.nextRight;
		}

		// If all the nodes at p's level are leaf nodes then return NULL
		return null;
	}

	/* Sets nextRight of all nodes of a tree with root as p */
	void connect(Node p) {
		Node temp = null;

		if (p == null) {
			return;
		}

		// Set nextRight for root
		p.nextRight = null;

		// set nextRight of all levels one by one
		while (p != null) {
			Node q = p;

			/* Connect all childrem nodes of p and children nodes of all other nodes
	             at same level as p */
			while (q != null) {

				// Set the nextRight pointer for p's left child
				if (q.left != null) {

					// If q has right child, then right child is nextRight of
					// p and we also need to set nextRight of right child
					if (q.right != null) {
						q.left.nextRight = q.right;
					} else {
						q.left.nextRight = getNextRight(q);
					}
				}

				if (q.right != null) {
					q.right.nextRight = getNextRight(q);
				}

				// Set nextRight for other nodes in pre order fashion
				q = q.nextRight;
			}

			// start from the first node of next level
			if (p.left != null) {
				p = p.left;
			} else if (p.right != null) {
				p = p.right;
			} else {
				p = getNextRight(p);
			}
		}
	}

	public static void main(String args[]) {
		PopulatingNextRightPointersInEachNode tree = new PopulatingNextRightPointersInEachNode();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.right.right = new Node(90);

		// Populates nextRight pointer in all nodes
		tree.connect(tree.root);

		// Let us check the values of nextRight pointers
		int a = root.nextRight != null ? root.nextRight.data : -1;
		int b = root.left.nextRight != null ? root.left.nextRight.data : -1;
		int c = root.right.nextRight != null ? root.right.nextRight.data : -1;
		int d = root.left.left.nextRight != null ? root.left.left.nextRight.data : -1;
		int e = root.right.right.nextRight != null ? root.right.right.nextRight.data : -1;

		// Now lets print the values
		System.out.println("Following are populated nextRight pointers in "
				+ " the tree(-1 is printed if there is no nextRight)");
		System.out.println("nextRight of " + root.data + " is " + a);
		System.out.println("nextRight of " + root.left.data + " is " + b);
		System.out.println("nextRight of " + root.right.data + " is " + c);
		System.out.println("nextRight of " + root.left.left.data + " is " + d);
		System.out.println("nextRight of " + root.right.right.data + " is " + e);
	}
	static class Node {

		int data;
		Node left, right, nextRight;
		Node(int item) {
			data = item;
			left = right = nextRight = null;
		}
	}

}
