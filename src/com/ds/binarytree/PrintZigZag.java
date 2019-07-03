package com.ds.binarytree;

import java.util.Stack;

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


public class PrintZigZag {

	private Node root;

	public static void printInZigzagOrder(Node root){

		Stack<Node> currentLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		boolean leftToRight = false;
		currentLevel.push(root);
		while (!currentLevel.empty()) {
			Node currNode = currentLevel.peek();
			currentLevel.pop();
			if (currNode!=null) {
				System.out.print(currNode.data+ " ");     
				if (leftToRight) {
					nextLevel.push(currNode.left);
					nextLevel.push(currNode.right);
				} else {
					nextLevel.push(currNode.right);
					nextLevel.push(currNode.left);
				}
			}
			if (currentLevel.empty()) {
				System.out.println();
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel =temp;
			}
		}
	}
	public static void main(String args[]) {
		PrintZigZag tree = new PrintZigZag();

		/*tree.root = new Node(1);
	tree.root.left = new Node(2);
	tree.root.right = new Node(3);
	tree.root.left.left = new Node(4);
	tree.root.left.right = new Node(5);
	tree.root.right.left = new Node(6);
	tree.root.right.right = new Node(7);
	tree.root.right.left.right = new Node(8);
	tree.root.right.left.right.left = new Node(11);
	tree.root.right.right.right = new Node(9);*/


		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(9);
		tree.root.left.right.right.right.left = new Node(7);
		tree.root.left.right.right.right.right = new Node(11);
		tree.root.right = new Node(3);

		printInZigzagOrder(tree.root);
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