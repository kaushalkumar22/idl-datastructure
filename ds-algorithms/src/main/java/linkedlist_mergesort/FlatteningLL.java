package linkedlist_mergesort;
/* Let us create the following linked list
5 -> 10 -> 19 -> 28
|    |     |     |
V    V     V     V
7    20    22    35
|          |     |
V          V     V
8          50    40
|                |
V                V
30               45
*/
public class FlatteningLL {

	Node head;  // head of list
	
	private Node flatten(Node node){

		if (node == null || node.right == null) return node;

		// recur for list on right
		node.right = flatten(node.right);
		node = merge(node, node.right);
		//printList(root);
		return node;
	}
	private Node merge(Node a, Node b){
		// if first linked list is empty then second is the answer
		if (a == null)     return b;
		// if second linked list is empty then first is the result
		if (b == null)    return a;
		Node result;
		if (a.data < b.data){
			result = a;
			result.down =  merge(a.down, b);
		}else{
			result = b;
			result.down = merge(a, b.down);
		}

		return result;
	}
	public static void main(String args[]) {

		FlatteningLL list = new FlatteningLL();

	
		list.head =  new Node(5);
		list.head.right =  new Node(10);
		list.head.right.right =  new Node(19);
		list.head.right.right.right =  new Node(28);

		list.head.down = new Node(7);
		list.head.down.down = new Node(8);
		list.head.down.down.down= new Node(30);

		list.head.right.down = new Node(20);

		list.head.right.right.down = new Node(22);
		list.head.right.right.down.down= new Node(50);


		list.head.right.right.right.down = new Node(35);
		list.head.right.right.right.down.down = new Node(40);
		list.head.right.right.right.down.down.down= new Node(45);

		list.head = list.flatten(list.head);

		list.printList(list.head);
	}
	private void printList(Node head){
		Node temp = head;
		while (temp != null){
			System.out.print(temp.data + " ");
			temp = temp.down;
		}
		System.out.println();
	}
	private static class Node {
		int data;
		Node right, down;
		Node(int data)
		{
			this.data = data;
			right = null;
			down = null;
		}
	}
} 
