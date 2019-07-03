package com.ds.binarytree;
public class CreateBST {
	private static Node root;
	public static void main(String[] args) {
		CreateBST bst = new CreateBST();
		bst.insert(15);
		bst.insert(22);
		bst.insert(10);
		bst.insert(17);
		bst.insert(33);
		bst.insert(11);
		bst.insert(5);
		System.out.println() ;
		bst.printInorder(root);
	}
	
	private void insert(int num){

		Node newNode = new Node(num);
		if (root == null){
			root = newNode;
		}else{
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(num < current.data){
					current = current.left;
					if(current == null){                 
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if(current == null){                 
						parent.right = newNode;
						return;
					}
				}
			} 
		}		
	}

	private void printInorder(Node node) {
		if (node == null) 
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}
	private static class Node{
		Node left ;
		int data;
		Node right ;
		private Node(int ele){
			this.left = this.right=null;
			this.data = ele;
		}
	}
}
