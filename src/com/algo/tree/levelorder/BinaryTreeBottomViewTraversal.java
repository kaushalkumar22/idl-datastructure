package com.algo.tree.levelorder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*  
 http://www.geeksforgeeks.org/bottom-view-binary-tree/
 http://algorithms.tutorialhorizon.com/print-the-bottom-view-of-the-binary-tree/
 http://javabypatel.blogspot.in/2015/10/print-bottom-view-of-binary-tree.html
 solution is different from above links
       1
      /  \
     2    3
    / \  /  \
   4  5 6    7
      / \     \
         8     9
 */
public class BinaryTreeBottomViewTraversal {

	Node root;
	Map<Integer,Node> hzDistanceMap = new TreeMap<Integer,Node>();
	Map<Integer,Integer> levelMap = new HashMap<Integer,Integer>();//this map will track whether node will get override or not in hzDistanceMap

	private void printBottomView(Node node, int level,int hzDistance) {
		if (node == null){
			return;
		}
		if(hzDistanceMap.containsKey(hzDistance)&&level>=levelMap.get(hzDistance)){
			hzDistanceMap.put(hzDistance, node);
		}else{	
			levelMap.put(hzDistance,level );
			hzDistanceMap.put(hzDistance, node);
		}
		printBottomView(node.left, level+1,hzDistance - 1);
		printBottomView(node.right, level+1,hzDistance + 1);
	}
	
	private static TreeMap<Integer, Integer> ht = new TreeMap<>();
	public static void bottomView(Node root, int level) {
		if (root == null)
			return;
		// create a queue for level order traversal
		Queue<QueuePack> queue = new LinkedList<>();
		// add root with level 0 (create a queue item pack)
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			// take out the items from the package
			Node tnode = q.tnode;
			int lvl = q.level;

			// keep updating the Map so that it will have the last entry from
			// each level(vertically) and that will the bottom view of the tree
			ht.put(lvl, tnode.data);

			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}
	// this class' represents the items stored in queue (used for level order
	// traversal). Objects will store the nodes and its level
	static class QueuePack {
		int level;
		Node tnode;

		public QueuePack(int level, Node tnode) {
			this.level = level;
			this.tnode = tnode;
		}
	}
	private void printVerticalOrder() {
		for( Map.Entry<Integer,Node> tcMap : hzDistanceMap.entrySet() ){							
			System.out.print(tcMap.getValue().data+" ");
		}
	}
	public static void main(String args[]) {

		BinaryTreeBottomViewTraversal tree = new BinaryTreeBottomViewTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.printBottomView(tree.root,0,0);
		tree.printVerticalOrder();
	}
	private	static class Node{
		int data;
		Node left, right;
		Node(int item){
			data = item;
			left = right = null;
		}
	}

}