package com.ds.binarytree;



public class ConstructBTFromAncestorMatrix {


	private static int N=7;
	private static int REMOVED = -1;
	private static int NO_VALUE_FOUND =-2;
	static int nodeName[] =       { 1, 4, 5, 8,10,30,40};

	// Last column is for sum
	static int ancestorMat[][]={ 
		{ 0, 1, 1, 0, 1, 0, 0, 0 },
		{ 0, 0, 1, 0, 1, 0, 0, 0 },
		{ 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 0, 0, 1, 0, 1, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 0, 0, 0, 0, 1, 1, 0, 0 }};

	public static void main(String[] args) {

		printMat();
		Node root = convertMatToTree();
		System.out.println("\nPreOrder Traversal of tree: ");
		preOrder(root);

	}
	// Calculate the sum first time
	static void calculateInitialSumAndRemoveRoot()
	{
		for(int i=0; i<N; i++)
		{
			ancestorMat[i][N] = 0;

			for(int j=0; j<N; j++)
				ancestorMat[i][N] += ancestorMat[i][j];
		}
	}

	static int findAndRemoveFristZeroElement()
	{
		for(int i=0; i<N; i++){
			if(ancestorMat[i][N] == 0)
			{
				ancestorMat[i][N] = REMOVED;
				return nodeName[i];
			}
		}
		return NO_VALUE_FOUND; // NO MORE NODE
	}

	static void decrementParentCountForNode(int value)
	{
		for(int j=0; j<N; j++)
		{
			if(nodeName[j] == value)
			{
				for(int i=0; i<N; i++){                 
					if(ancestorMat[i][j] == 1)                 
					{                    
						ancestorMat[i][N]--;                
					}             }             
				return;        
			}    
		} 
	} 
	static void convertMatToTreerecursive(Node root) {     
		if(root == null){ 
			return;
		}          // decreasing the sum count for children of root.    
		decrementParentCountForNode(root.data);

		// Finding first child and setting it as left child
		int value = findAndRemoveFristZeroElement();
		if(value != NO_VALUE_FOUND){
			root.left = new Node(value);
		}

		// Finding second child and setting it as right child
		value = findAndRemoveFristZeroElement();
		if(value != NO_VALUE_FOUND){
			root.right = new Node(value);
		}

		// If there is a left child create the left tree
		if(root.left != null)
			convertMatToTreerecursive(root.left);

		// If there is a right child create the right tree
		if(root.right != null)
			convertMatToTreerecursive(root.right);

	}

	static Node convertMatToTree()
	{
		// compute the sum column first time.
		calculateInitialSumAndRemoveRoot();

		// Find value of the root node of the tree.
		// and remove it from matrix
		int rootValue = findAndRemoveFristZeroElement();

		// If there is no root node then return
		if(rootValue == NO_VALUE_FOUND){ return null; }

		// If there is a root node then make tree.
		Node root = new Node(rootValue);

		// Create rest of the tree and set the
		// values in left and right child of root
		convertMatToTreerecursive(root);

		return root;
	}

	// Helper function to pring the matrix
	static void printMat(){
		for(int i=0; i<N; i++){
			for(int j=0; j<=N; j++)
				System.out.print(ancestorMat[i][j]+" ");
			System.out.println();
		}

	}

	// Helper function to print the tree in PreOrder
	static void preOrder(Node r)
	{
		if(r==null){return;}

		
		preOrder(r.left);
		System.out.print(r.data+" ");
		preOrder(r.right);
	}

	static  class Node {

		int data;
		Node left, right;

		Node(int item) {
			this.data = item;
			left = right = null;
		}
	}
}
