package com.algo.tree.preorder;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number. An example is the root-to-leaf path 1->2->3 which
 * represents the number 123. Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children. 
 * Input: [1,2,3]
 *  1
   / \
  2   3
 * Output: 25 Explanation: The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13. Therefore, sum = 12 + 13
 * = 25.
 * 
 * Input: [4,9,0,5,1] 4
 *  4
   / \
  9   0
 / \
5   1
 * Output: 1026 Explanation: The root-to-leaf path 4->9->5 represents the number
 * 495. The root-to-leaf path 4->9->1 represents the number 491. The
 * root-to-leaf path 4->0 represents the number 40. Therefore, sum = 495 + 491 +
 * 40 = 1026.
 *
 */
public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		SumRootToLeafNumbers tree = new SumRootToLeafNumbers();
		List<Integer> nums = Arrays.asList(4, 9, 0, 5, 1);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.sumNumbersRec(root));
		System.out.println(tree.sumNumbers(root));
	}
    public int sumNumbersRec(TreeNode root) {
        return sum(root, 0);
    }
	public int sum(TreeNode n, int s) {
		if (n == null) return 0;
		if (n.right == null && n.left == null) return s * 10 + n.val;
		
		int l =sum(n.left, s * 10 + n.val) ;
		int r = sum(n.right, s * 10 + n.val);
		return l+r;
	}
	 public int sumNumbers(TreeNode root) {
         if(root==null){
             return 0;
         }
         int sum = 0;
         TreeNode curr;
         Stack<TreeNode> ws = new Stack<TreeNode>();
         ws.push(root);
         
         while(!ws.empty()){
             curr = ws.pop();
             
             if(curr.right!=null){
                 curr.right.val = curr.val*10+curr.right.val;
                 ws.push(curr.right);
             }
             
             if(curr.left!=null){
                 curr.left.val = curr.val*10+curr.left.val;
                 ws.push(curr.left);
             }
             
             if(curr.left==null && curr.right==null){ // leaf node
                 sum+=curr.val;
             }
         }
         return sum;
     }
}
