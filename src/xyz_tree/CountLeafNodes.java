package xyz_tree;
/*
getLeafCount(node)
1) If node is NULL then return 0.
2) Else If left and right child nodes are NULL return 1.
3) Else recursively calculate leaf count of the tree using below formula.
    Leaf count of a tree = Leaf count of left subtree + 
     Leaf count of right subtree
 */                               
public class CountLeafNodes {

	//Root of the Binary Tree

	int getLeafCount(Node node) 
	{
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{
		/* create a tree */
		CountLeafNodes tree = new CountLeafNodes();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		/* get leaf count of the abve tree */
		System.out.println("The leaf count of binary tree is : "
				+ tree.getLeafCount(root));
	}
	static class Node 
	{
		int data;
		Node left, right;

		public Node(int item) 
		{
			data = item;
			left = right = null;
		}
	}
}