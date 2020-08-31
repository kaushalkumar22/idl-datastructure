package com.algo.binarytree.common;
/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes 
p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]


 * @author I339640
 *
 */
public class LowestCommonAncestorOfABinaryTree{
	private  Node root;
	Node findLowestCommonAncestor(Node node, Node n1, Node n2){

		if (node == null) return null;

		if (node == n1||node== n2) return node;

		Node lNode = findLowestCommonAncestor(node.left, n1, n2);
		Node rNode = findLowestCommonAncestor(node.right, n1, n2);

		if (lNode != null && rNode != null) return node;

		if (lNode == null && rNode == null) return null;

		return (lNode!= null) ? lNode : rNode;
	}

	public static void main(String args[]){
		LowestCommonAncestorOfABinaryTree tree = new LowestCommonAncestorOfABinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		Node n1 = tree.root.left.left = new Node(4);
		Node n2 = tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		Node lca = tree.findLowestCommonAncestor(tree.root,n1, n2);
		if (lca != null)
			System.out.println("LCA = " + lca.data);
		else
			System.out.println("Keys are not present");
	}
	private static class Node{
		int data;
		Node left, right;
		public Node(int item){
			data = item;
			left = right = null;
		}
	}
}