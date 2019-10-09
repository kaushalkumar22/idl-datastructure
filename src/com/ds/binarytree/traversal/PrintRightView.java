package com.ds.binarytree.traversal;

import java.util.LinkedList;
import java.util.Queue;

/* 
 *       1
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

public class PrintRightView {

	private Node root;
	private int levels = -1 ;
	public static void main(String args[]) 
	{
		PrintRightView tree = new PrintRightView();

		/*	tree.root = new Node(1);
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

		System.out.println();
		tree.printRightView2(tree.root,0);
		System.out.println();
		printRightViewWithoutRecursion(tree.root);
	}

	private void printRightView2(Node node, int level) {
		
		if (node == null) return;
		
		if(levels<level){
			System.out.print(node.data+" ");
			levels = level;
		}
		printRightView2(node.right, level+1);
		printRightView2(node.left, level+1);
	}

	public static void printRightViewWithoutRecursion(Node root){
		Queue<Node> currentLevel = new LinkedList<Node>();
		Queue<Node> nextLevel = new LinkedList<Node>();
		currentLevel.add(root);
		boolean flag = false;
		System.out.print(root.data+ " ");  
		while (!currentLevel.isEmpty()) {
			Node currNode = currentLevel.peek();
			currentLevel.remove();
			if (currNode!= null) {
				if(flag)
					System.out.print(currNode.data+ " ");  
				flag=false;
				nextLevel.add(currNode.right);
				nextLevel.add(currNode.left);
			}
			if (currentLevel.isEmpty()) {
				Queue<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel =temp;
				flag = true;
			}
		}
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