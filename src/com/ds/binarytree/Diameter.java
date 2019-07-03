package com.ds.binarytree;

public class Diameter {

	static class Height{
		int h;
	}
	private Node root;
	private  int maxDiameter;
	//its a  n^2 approach
	private int getDiameterByCalHeight(Node node){
		if(node == null){
			return 0;
		}
		int leftSubtreeHeight = height(node.left);
		int rightSubtreeHeight = height(node.right);

		int diameterOfNode = leftSubtreeHeight + rightSubtreeHeight + 1;

		int leftDiameter = getDiameterByCalHeight(node.left);
		int rightDiameter = getDiameterByCalHeight(node.right);

		return Math.max(diameterOfNode, Math.max(leftDiameter, rightDiameter));
	}

	private int height(Node node){
		if( node == null){
			return 0;
		}
		int lHeight = height(node.left);
		int rHeight = height(node.right);
		return Math.max(lHeight , rHeight)+1;
	}
	private int getDiameter(Node node){


		if (node == null)  return 0; 

		int leftDiameter = getDiameter(node.left); // Height of Left Subtree
		int rightDiameter = getDiameter(node.right); // Height of Right Subtree

		if(leftDiameter + rightDiameter + 1 > maxDiameter){ // + 1 for node itself
			maxDiameter = leftDiameter + rightDiameter + 1;
		}
		if(leftDiameter>rightDiameter)
			return leftDiameter + 1;
		else
			return rightDiameter + 1;
	}

	public static int[] getDiameterOptimized(Node root) {

		//0th element is diameter and 1st element is height
		int[] result = new int[]{0,0};        

		if (root == null)  
			return result;

		int[] leftResult = getDiameterOptimized(root.left);
		int[] rightResult = getDiameterOptimized(root.right);
		int height = Math.max(leftResult[1], rightResult[1]) + 1;

		int rootDiameter = leftResult[1] + rightResult[1] + 1;
		int leftDiameter = leftResult[0];
		int rightDiameter = rightResult[0];

		result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
		result[1] = height;

		return result;
	}

	private void diameter(){
		System.out.println(getDiameterOptimized(root)[0]);
		System.out.println(getDiameterByCalHeight(root));
		getDiameter(root);
		System.out.println(maxDiameter);

	}

	public static void main(String args[]){
		/* creating a binary tree and entering the nodes */
		Diameter tree = new Diameter();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.diameter();
	}
	private static class Node{
		int data;
		Node left, right;

		public Node(int item)
		{
			this.data = item;
			this.left = this.right = null;
		}
	}
}