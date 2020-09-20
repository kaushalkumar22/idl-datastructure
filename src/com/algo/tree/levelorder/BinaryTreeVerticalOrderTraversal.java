package com.algo.tree.levelorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.algo.tree.common.TreeNode;

//http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
//http://javabypatel.blogspot.in/2015/10/print-binary-tree-in-vertical-order.html

/*       1
       /   \
      2     3
     / \   / \
    4   5 6   7
           \   \
            8   9
                 \
                 11      
 */
public class BinaryTreeVerticalOrderTraversal{
	
	 public List<List<Integer>> verticalTraversal(TreeNode root) {
	        Map<Integer,List<Integer>> hzOrderList = new TreeMap<Integer,List<Integer>>();
	        getNodeHorizontalDistance( root,0,hzOrderList);
	        List<List<Integer>> listofvalues= new ArrayList(hzOrderList.values());        
	        return listofvalues;
	    }
	    
		private void getNodeHorizontalDistance(TreeNode node, int hzDistance, Map<Integer,List<Integer>> hzOrderList) {
			
			if (node == null){
				return;
			}
			if(hzOrderList.containsKey(hzDistance)){
				List<Integer> nList = hzOrderList.get(hzDistance);    
				nList.add(node.val);
			}else{
				List<Integer> n = new ArrayList<Integer>();
				n.add(node.val);
				hzOrderList.put(hzDistance, n);
			}
	        getNodeHorizontalDistance(node.left, hzDistance - 1,hzOrderList);
	        getNodeHorizontalDistance(node.right, hzDistance + 1,hzOrderList);
			
			
		}

	public static void main(String args[]) {
	
		BinaryTreeVerticalOrderTraversal tree = new BinaryTreeVerticalOrderTraversal();

	}
	
}