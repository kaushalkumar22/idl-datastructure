package tree_postorder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given the root of a binary tree, return all duplicate subtrees.
 * 
 * For each kind of duplicate subtrees, you only need to return the root node of
 * any one of them.
 * 
 * Two trees are duplicate if they have the same structure with the same node
 * values.
 * 
 * 
 * Input: root = [1,2,3,4,null,2,4,null,null,4] Output: [[2,4],[4]]
 * 
 * Example 2:
 * 
 * Input: root = [2,1,1] Output: [[1]]
 * 
 * Example 3:
 * 
 * Input: root = [2,2,2,3,null,3,null] Output: [[2,3],[3]]
 *
 * 
 */
public class FindDuplicateSubtrees {
	public static void main(String[] args) {
		FindDuplicateSubtrees tree= new FindDuplicateSubtrees();
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,3,4,null,2,4,null,null,4);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println( tree.findDuplicateSubtrees(root));
	}
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	    List<TreeNode> res = new LinkedList<>();
	    postorder(root, new HashMap<>(), res);
	    return res;
	}

	public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
	    if (cur == null) return "#";  
	    String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
	    if (map.getOrDefault(serial, 0) == 1) res.add(cur);
	    map.put(serial, map.getOrDefault(serial, 0) + 1);
	    return serial;
	}
}
