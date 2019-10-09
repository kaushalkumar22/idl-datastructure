package com.ds.binarytree.construct;

public class ConstructPostorderFromInorderPreorder {

	 public static void main(String args[]){
		 
         int in[] = {4, 2, 5, 1, 3, 6};
         int pre[] =  {1, 2, 4, 5, 3, 6};
         int n = in.length;
         //cout << "Postorder traversal " << endl;
         printPostOrder(0,in.length-1, in, pre);
    }
 
    public static int search(int start, int end, int arr[], int x)
    {
        for (int i = start; i <= end; i++)
            if (arr[i] == x)
            return i;
        return -1;
    }
 
 static int preIndex=0;
// Prints postorder traversal from given inorder and preorder traversals
    public static void printPostOrder(int inStart, int inEnd, int in[], int pre[])
    {
        if(inStart > inEnd) return;
        
        if(inStart == inEnd) {
        	System.out.print(pre[preIndex++]+" ");
        	return;
        }
        
        int index = search(inStart, inEnd, in, pre[preIndex++]);
        printPostOrder(inStart, index-1, in, pre);
        printPostOrder(index+1, inEnd, in, pre);
        System.out.print(in[index]+" ");
    }
}
