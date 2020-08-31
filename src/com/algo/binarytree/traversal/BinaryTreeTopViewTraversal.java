package com.algo.binarytree.traversal;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
        /
       7
 */

public class BinaryTreeTopViewTraversal {

	private  Node root;	
	Map<Integer, Integer> hzOrderList = new TreeMap<Integer,Integer>();


	private	void printTopView(Node node, int hzDistance) {
		if (node == null) return;

		if(!hzOrderList.containsKey(hzDistance)){
			hzOrderList.put(hzDistance,node.data);
		}
		printTopView(node.left,hzDistance-1);
		printTopView(node.right,hzDistance+1);
	}

	private void printVerticalOrder(Node node, int hzDistance) {
		printTopView( node,  hzDistance);
		for( Map.Entry<Integer, Integer> tcMap : hzOrderList.entrySet() ){		
			System.out.print(tcMap.getValue()+"  ");
		}
	}
	private static TreeMap<Integer, Integer> ht = new TreeMap<>();;

	private void topView(Node root, int level) {
		
		if (root == null) return;
		// create a queue for level order traversal
		Queue<QueuePack> queue = new LinkedList<>();
		// add root with level 0 (create a queue item pack)
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			// take out the items from the package
			Node tnode = q.tnode;
			int lvl = q.level;

			// check if this is the first node you are visiting at the level
			if (ht.containsKey(lvl)) {

			} else {// print it, its the first element at his level
				System.out.print(tnode.data + "  ");
				ht.put(lvl, tnode.data);
			}

			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}
	public static void main(String args[]) {

		BinaryTreeTopViewTraversal tree = new BinaryTreeTopViewTraversal();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(9);
		tree.root.left.right.right.right.left = new Node(7);
		tree.root.right = new Node(3);

		/*tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.right.right = new Node(11);*/

		/*	tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(4);
		tree.root.right.left.left = new Node(5);*/

		tree.printVerticalOrder(tree.root,0);
		System.out.println();
		tree.topView(tree.root,0);
	}
	private static class Node {
		int data;
		Node left, right;
		Node(int item){
			data = item;
			left = right = null;
		}
	}
	// this class' represents the items stored in queue (used for level order
	// traversal). Objects will store the nodes and its level
	class QueuePack {
		int level;
		Node tnode;

		public QueuePack(int level, Node tnode) {
			this.level = level;
			this.tnode = tnode;
		}
	}
}