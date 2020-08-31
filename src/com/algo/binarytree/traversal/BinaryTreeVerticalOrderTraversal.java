package com.algo.binarytree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
//http://javabypatel.blogspot.in/2015/10/print-binary-tree-in-vertical-order.html

/*       1
       /   \
      2     3
     / \   / \
    4   5 6   7
           \   \
            8   9
                 \
                 11      
 */
public class BinaryTreeVerticalOrderTraversal{
	
	private Node root;
	Map<Integer,List<Node>> hzOrderList = new TreeMap<Integer,List<Node>>();
	private void getNodeHorizontalDistance(Node node, int hzDistance) {
		
		if (node == null){
			return;
		}
		if(hzOrderList.containsKey(hzDistance)){
			List<Node> nList = hzOrderList.get(hzDistance);
			nList.add(node);
		}else{
			List<Node> n = new ArrayList<Node>();
			n.add(node);
			hzOrderList.put(hzDistance, n);
		}
		getNodeHorizontalDistance(node.left, hzDistance - 1);
		getNodeHorizontalDistance(node.right, hzDistance + 1);
		
	}

	private void printVerticalOrder() {
		
		for( Map.Entry<Integer, List<Node>> tcMap : hzOrderList.entrySet() ){		
			List<Node> valueList = tcMap.getValue();
			for(Node value : valueList){
				System.out.print(value.data+" ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
	
		BinaryTreeVerticalOrderTraversal tree = new BinaryTreeVerticalOrderTraversal();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.right.right = new Node(11);
		
		tree.getNodeHorizontalDistance(tree.root,0);
		tree.printVerticalOrder();
	}
	private static class Node {
		int data;
		Node left, right;
		Node(int item){
			data = item;
			left = right = null;
		}
	}
	
}