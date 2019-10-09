package com.ds.binarytree.traversal;

public class PrintReverseLevelOrderRecurcive {
    
    private Node root;

    private void reverseLevelOrder(Node node) {
        int h = height(node);
        int i;
        for (i = h; i >= 1; i--) {
            printGivenLevel(node, i);
        }
    }
    /* Print nodes at a given level */
    private void printGivenLevel(Node node, int level) {
        if (node == null)  return;
        
        if (level == 1) {
            System.out.print(node.data + " ");
        } else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
 
    /* Compute the "height" of a tree -- the number of nodes along the longest path 
     * from the root node down to the farthest leaf node.*/
    private int height(Node node){
		if( node == null){
			return 0;
		}
		int lHeight = height(node.left);
		int rHeight = height(node.right);
		return Math.max(lHeight , rHeight)+1;
	}
 
    public static void main(String args[]) {
         
    	PrintReverseLevelOrderRecurcive tree = new PrintReverseLevelOrderRecurcive();
 
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
         
        System.out.println("Level Order traversal of binary tree is : ");
        tree.reverseLevelOrder(tree.root);
         
    }
    private static class Node {
        
        int data;
        Node left, right;    
        Node(int item) {
            data = item;
            left = right;
        }
    }
}