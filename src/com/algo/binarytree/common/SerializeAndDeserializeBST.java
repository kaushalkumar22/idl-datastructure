package com.algo.binarytree.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment. Design an algorithm to serialize and
 * deserialize a binary search tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure
 * that a binary search tree can be serialized to a string and this string can
 * be deserialized to the original tree structure. The encoded string should be
 * as compact as possible.
 * 
 *
 */
public class SerializeAndDeserializeBST {

	public static void main(String[] args) {
		SerializeAndDeserializeBST tree = new SerializeAndDeserializeBST();
		List<Integer> nums = (List<Integer>) Arrays.asList(3, 9, 20, null, null, 15, 7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Minimum Depth is : " + tree.serialize(root));

	}

	public String serialize(TreeNode root) {
		if (root == null) {
			return "#!";
		}
		String res = root.val + "!";
		res += serialize(root.left);
		res += serialize(root.right);
		return res;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] strings = data.split("!");
		LinkedList<String> list = new LinkedList<>();
		for (String string : strings) {
			list.add(string);
		}
		return reconPreOrder(list);
	}

	public TreeNode reconPreOrder(LinkedList<String> queue) {
		String val = queue.poll();
		if (val.equals("#")) {
			return null;
		}
		TreeNode head = new TreeNode(Integer.valueOf(val));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}
}
