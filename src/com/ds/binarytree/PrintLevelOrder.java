package com.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;


/*       1
       /   \
      2     3
     / \   / \
    4   5 6   7
           \   \
            8   9
                 \
                  11      
4 2  1 3 8 7 9 11 

    1
   / \
  2   3
   \
    4
     \
      5
       \
        9
        /\
       7  11
 */


public class PrintLevelOrder {

	private Node root;

	public static void nonRecursiveTreeLevel(Node root){

		Queue<Node> currentLevel = new LinkedList<Node>();
		Queue<Node> nextLevel = new LinkedList<Node>();
		currentLevel.add(root);
		while (!currentLevel.isEmpty()) {
			Node currNode = currentLevel.peek();
			currentLevel.remove();
			if (currNode!= null) {
				System.out.print(currNode.data+ " ");     
				nextLevel.add(currNode.left);
				nextLevel.add(currNode.right);
			}
			if (currentLevel.isEmpty()) {
				System.out.println();
				currentLevel.addAll(nextLevel);
				nextLevel.clear();
			}
		}
	}
	public static void main(String args[]) {

		PrintLevelOrder tree = new PrintLevelOrder();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.left.right.left = new Node(11);
		tree.root.right.right.right = new Node(9);


		/*tree.root = new Node(1);
	tree.root.left = new Node(2);
	tree.root.left.right = new Node(4);
	tree.root.left.right.right = new Node(5);
	tree.root.left.right.right.right = new Node(9);
	tree.root.left.right.right.right.left = new Node(7);
	tree.root.left.right.right.right.right = new Node(11);
	tree.root.right = new Node(3);*/

		nonRecursiveTreeLevel(tree.root);
	}
	private	static class Node {
		int data;
		Node left, right;
		Node(int item){
			data = item;
			left = right = null;
		}
	}
}