package com.ds.binarytree.common;

public class LowestCommonAncestor{
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
		LowestCommonAncestor tree = new LowestCommonAncestor();
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