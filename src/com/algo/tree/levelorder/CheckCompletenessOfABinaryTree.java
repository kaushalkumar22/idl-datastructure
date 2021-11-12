package com.algo.tree.levelorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Given a binary tree, determine if it is a complete binary tree.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6] Output: true Explanation: Every level before the last is
 * full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last
 * level ({4, 5, 6}) are as far left as possible.
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4,5,null,7] Output: false Explanation: The node with value 7
 * isn't as far left as possible.
 * 
 * Note:
 * 
 * The tree will have between 1 and 100 nodes.
 *
 * 
 * 
 */
public class CheckCompletenessOfABinaryTree {

	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,3,4,5,null,7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(isCompleteTree(root));
	}
	public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean seenEmpty = false;
        
        while(!que.isEmpty()) {
            TreeNode curr = que.poll();
            if (curr == null) {
                seenEmpty = true;
                continue;
            } else if (seenEmpty) {
                    return false;
            }
            
            que.offer(curr.left);
            que.offer(curr.right);
        }        
        return true;
    }
}
