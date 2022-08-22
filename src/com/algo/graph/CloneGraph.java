package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;

import com.algo.tree.common.TreeNode;

public class CloneGraph {
	public Node cloneGraph(Node node) {
		if (node == null) return null;
		Node graph = new Node(node.val);
		HashMap<Node, Node> mp = new HashMap<>();
		mp.put(node, graph);
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (Node val : cur.neighbors) {
				if (!mp.containsKey(val)) {
					mp.put(val, new Node(val.val));
					queue.offer(val);
				}
				mp.get(cur).neighbors.add(mp.get(val));
			}
		}
		return graph;
	}
	public HashMap<Integer, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		return clone(node);
	}

	public Node clone(Node node) {
		if (node == null) return null;

		if (map.containsKey(node.val)) 
			return map.get(node.val);

		Node newNode = new Node(node.val, new ArrayList<Node>());
		map.put(newNode.val, newNode);
		for (Node neighbor : node.neighbors) 
			newNode.neighbors.add(clone(neighbor));
		return newNode;
	}

}

