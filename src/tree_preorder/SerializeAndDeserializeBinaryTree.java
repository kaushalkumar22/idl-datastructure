package tree_preorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Clarification: The input/output format is the same as how LeetCode serializes
 * a binary tree. You do not necessarily need to follow this format, so please
 * be creative and come up with different approaches yourself.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,null,null,4,5] Output: [1,2,3,null,null,4,5]
 * 
 * Example 2:
 * 
 * Input: root = [] Output: []
 * 
 * Example 3:
 * 
 * Input: root = [1] Output: [1]
 * 
 * Example 4:
 * 
 * Input: root = [1,2] Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104]. -1000 <= Node.val
 * <= 1000
 * 
 * 
 */
public class SerializeAndDeserializeBinaryTree {
	private int index = 0;
	public static void main(String args[]) {
		SerializeAndDeserializeBinaryTree tree = new SerializeAndDeserializeBinaryTree();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1));
		//TreeUtil.inorder(root);
		String serial = tree.serialize( root);
		System.out.println(serial);
		TreeNode des = tree.deserialize(serial);
		TreeUtil.inorder(des);
	}
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	 StringBuilder sb = new StringBuilder();
    	 serialize( root,  sb);
        return sb.toString();
    }

	// Encodes a tree to a single string.
	public void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#").append(",");
			return ;
		}
		sb.append(root.val).append(",");
		serialize(root.left, sb);
		serialize(root.right, sb);
		
	}
	public TreeNode deserialize(String data) {
		List<String> list = Arrays.asList(data.split(","));
		return buildTree(list);
	}
	
	// Decodes your encoded data to tree.
	public TreeNode buildTree(List<String> list) {

		if (index >= list.size() || list.get(index).equals( "#")) {
			index++;
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(list.get(index)));
		index++;
		root.left  = buildTree(list);
		root.right = buildTree(list);

		return root;

	}
}