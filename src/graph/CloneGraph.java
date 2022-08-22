package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeTreeNode;

public class CloneGraph {
	public TreeTreeNode cloneGraph(TreeNode TreeNode) {
		if (TreeNode == null) return null;
		TreeNode graph = new TreeNode(TreeNode.val);
		HashMap<TreeNode, TreeNode> mp = new HashMap<>();
		mp.put(TreeNode, graph);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(TreeNode);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			for (TreeNode val : cur.neighbors) {
				if (!mp.containsKey(val)) {
					mp.put(val, new TreeNode(val.val));
					queue.offer(val);
				}
				mp.get(cur).neighbors.add(mp.get(val));
			}
		}
		return graph;
	}
	public HashMap<Integer, TreeNode> map = new HashMap<>();

	public TreeNode cloneGraph(TreeNode TreeNode) {
		return clone(TreeNode);
	}

	public TreeNode clone(TreeNode TreeNode) {
		if (TreeNode == null) return null;

		if (map.containsKey(TreeNode.val)) 
			return map.get(TreeNode.val);

		TreeNode newTreeNode = new TreeNode(TreeNode.val, new ArrayList<TreeNode>());
		map.put(newTreeNode.val, newTreeNode);
		for (TreeNode neighbor : TreeNode.neighbors) 
			newTreeNode.neighbors.add(clone(neighbor));
		return newTreeNode;
	}

}

