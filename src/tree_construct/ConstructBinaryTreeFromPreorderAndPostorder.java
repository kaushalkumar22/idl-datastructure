package tree_construct;

import java.util.ArrayDeque;
import java.util.Deque;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;
/**
Return any binary tree that matches the given preorder and postorder traversals.
Values in the traversals pre and post are distinct positive integers.
Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

 * @author I339640
 *
 */
public class ConstructBinaryTreeFromPreorderAndPostorder {


	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndPostorder tree = new ConstructBinaryTreeFromPreorderAndPostorder();
		int[] pre ={1,2,4,5,3,6,7};
		int[] post ={4,5,2,6,7,3,1};
		TreeNode root = tree.constructFromPrePost(pre, post);
		TreeUtil.preorder(root);
	}

	int preIndex = 0, posIndex = 0;
	public TreeNode constructFromPrePost1(int[]pre, int[]post) {
		TreeNode root = new TreeNode(pre[preIndex++]);
		if (root.val != post[posIndex])
			root.left = constructFromPrePost(pre, post);
		if (root.val != post[posIndex])
			root.right = constructFromPrePost(pre, post);
		posIndex++;
		return root;
	}

	public TreeNode constructFromPrePost(int[] pre, int[] post){
		Deque<TreeNode> s = new ArrayDeque<>();
		s.offer(new TreeNode(pre[0]));
		for(int i = 1, j = 0; i < pre.length; ++i) {
			TreeNode node = new TreeNode(pre[i]);
			while(s.getLast().val == post[j]) {
				s.pollLast(); 
				j++;
			}
			if(s.getLast().left == null) {
				s.getLast().left = node;
			}else {
				s.getLast().right = node;
			}
			s.offer(node);
		}
		return s.getFirst();
	}


}
