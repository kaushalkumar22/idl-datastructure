package tree_levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
 *   3
   / \
  9  20
    /  \
   15   7
 * 
 * return its bottom-up level order traversal as:
 * 
 * [ [15,7], [9,20], [3] ]
 *
 */
public class BinaryTreeLevelOrderTraversalII {
	public static void main(String args[]) {

		BinaryTreeLevelOrderTraversalII tree = new BinaryTreeLevelOrderTraversalII();
		List<Integer> nums = Arrays.asList(3,9,20,null,null,15,7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.levelOrderBottom(root));
		System.out.println(tree.levelOrderBottomRec(root));
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
		if(root==null) {
			return levelOrder;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while(!que.isEmpty()) {
			int count = que.size();
			List<Integer> level = new ArrayList<Integer>();
			for(int i=0;i<count;i++) {
				root =que.poll();
				level.add(root.val);
				if(root.left!=null) {
					que.offer(root.left);
				}
				if(root.right!=null) {
					que.offer(root.right);
				}		
			}
			levelOrder.add(0,level);
		}
		return levelOrder;
	}
	public List<List<Integer>> levelOrderBottomRec(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        levelMaker( root, 0,res);
        return res;
    }
    
    public void levelMaker(TreeNode root, int level,List<List<Integer>> res) {
        if(root == null) return;
       
        if(res.size()==level){
			List<Integer> temp  = new ArrayList<Integer>();
			temp.add(root.val);
			res.add(0,temp);			
		}else{
			List<Integer> list = res.get(res.size()-level-1);
			list.add(root.val);
		}        
        levelMaker(root.left, level+1,res);
        levelMaker(root.right, level+1,res);
    }
}
