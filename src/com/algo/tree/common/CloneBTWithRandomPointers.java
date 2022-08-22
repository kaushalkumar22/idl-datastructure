package com.algo.tree.common;

import java.util.HashMap;
import java.util.Map;


/*      
    1
   / \
  2   3
   \
    4
     \
      5
       \
        9
 */


public class CloneBTWithRandomPointers {

	private Node root;
	Map<Node, Node> map = new HashMap<Node, Node>();

	public Node clone(Node root){
		copyNode(root);
		for( Map.Entry<Node, Node> nodePair : map.entrySet() ){
			Node oriNode = nodePair.getKey();
			Node cloneRoot = nodePair.getValue();
			cloneRoot.left = map.get(oriNode.left);
			cloneRoot.right = map.get(oriNode.right);
			cloneRoot.random = map.get(oriNode.random);
		}
		return map.get(root);
	}
	public void copyNode(Node root){
		if(root!=null){
			map.put(root, new Node(root.data));
			copyNode(root.left);
			copyNode(root.right);
		}
	}
	private void inorderTraverse(Node root){
		if(root==null) return;
		System.out.print(root.data+" ");
		inorderTraverse(root.left);
		inorderTraverse(root.right);
	}

	public static void main(String args[]) {

		CloneBTWithRandomPointers tree = new CloneBTWithRandomPointers();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(9);

		tree.root.random =tree.root.left.right;
		tree.root.left.random = tree.root.left.right.right;
		tree.root.right.random = tree.root.left.right.right.right.left;

		tree.root.left.right.random = tree.root;
		tree.root.left.right.right.random= tree.root.left;
		tree.root.left.right.right.right.random = tree.root.right;

		tree.inorderTraverse(tree.root);
		System.out.println();
		Node node = tree.clone(tree.root);
		tree.inorderTraverse(node);
	}
	private	static class Node {
		int data;
		Node left, right,random;
		Node(int item){
			data = item;
			left = right = random = null;
		}
	}
}