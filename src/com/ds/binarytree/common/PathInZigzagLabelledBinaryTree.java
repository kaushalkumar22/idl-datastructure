package com.ds.binarytree.common;

import java.util.LinkedList;
import java.util.List;

/**
In an infinite binary tree where every node has two children, the nodes are labelled in row order.
In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows 
(second, fourth, sixth,...), the labelling is right to left.
Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.

Input: label = 14
Output: [1,3,4,14]

Input: label = 26
Output: [1,2,6,10,26]

Intuition
If the tree is numbered left-to-right (not zigzag), the parent's label can be always determined as label / 2. 
For zigzag, we need to "invert" the parent label.

Solution
Determine the tree level where our value is located. The maximum label in the level is 1 << level - 1, 
and minimum is 1 << (level - 1). We will use this fact to "invert" the parent label.


Complexity Analysis
Runtime: O(log n)
Memory: O(1) or O(log n) if we consider the memory required for the result.
 *
 */
public class PathInZigzagLabelledBinaryTree {

	public static void main(String[] args) {
		System.out.println(pathInZigZagTree(14));
	}
	public static List<Integer> pathInZigZagTree(int label) {
		LinkedList<Integer> result = new LinkedList<>();
		int parent = label;
		result.addFirst(parent);

		while(parent != 1) {
			int d = (int)(Math.log(parent)/Math.log(2));
			int offset = (int)Math.pow(2, d+1) - 1 - parent;
			parent = ((int)Math.pow(2, d) + offset) / 2;
			result.addFirst(parent);   
		}

		return result;
	}
}
