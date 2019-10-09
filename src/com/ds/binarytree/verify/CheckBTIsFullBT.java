package com.ds.binarytree.verify;
/*
A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. 
Conversely, there is no node in a full binary tree, which has one child node. 
*/
public class CheckBTIsFullBT {

    private Node root;
     
    /* this function checks if a binary tree is full or not */
    boolean isFullTree(Node node)  {
        // if empty tree
        if(node == null)  return true;
         
        // if leaf node
        if(node.left == null && node.right == null )
            return true;
         
        // if both left and right subtrees are not null the are full
        if((node.left!=null) && (node.right!=null))
            return isFullTree(node.left) && isFullTree(node.right);
         
        // if none work
        return false;
    }
 
     
    // Driver program
    public static void main(String args[]) {
    	CheckBTIsFullBT tree = new CheckBTIsFullBT();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.left.left = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.left.left.left = new Node(80);
        tree.root.right.right = new Node(70);
        tree.root.left.left.right = new Node(90);
        tree.root.left.right.left = new Node(80);
        tree.root.left.right.right = new Node(90);
        tree.root.right.left.left = new Node(80);
        tree.root.right.left.right = new Node(90);
        tree.root.right.right.left = new Node(80);
        tree.root.right.right.right = new Node(90);
         
        if(tree.isFullTree(tree.root))
            System.out.print("The binary tree is full");
        else
            System.out.print("The binary tree is not full"); 
    }
    static class Node {
   	 
        int data;
        Node left, right;
     
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}