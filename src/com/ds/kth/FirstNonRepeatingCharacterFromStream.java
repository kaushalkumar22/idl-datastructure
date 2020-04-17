package com.ds.kth;

public class FirstNonRepeatingCharacterFromStream {

	private static final int MAX_CHAR = 256; 
	private static Node head;
	private static Node tail;
	/* Driver program to test above function */
	public static void main(String[] args)  { 

		// Let us consider following stream and see the process 
		String stream = "geeksforgeeksandgeeksquizfor"; 
		Node[] inDLL =new Node[256];
		boolean[] repeated =new boolean[MAX_CHAR]; 

		for (int i=0;i < stream.length();i++) { 
			char x = stream.charAt(i); 
			System.out.println("Reading "+ x +" from stream n"); 
			// We process this character only if it has not occurred 
			// or occurred only once. repeated[x] is true if x is repeated twice or more.s 
			if(!repeated[x]) { 
				// If the character is not in DLL, then add this at the end of DLL. 
				
				Node node = inDLL[x];
				if(node==null) {
					add(x);
					inDLL[x]=head;
				}else {
					delete(node) ;
					repeated[x] = true; // Also mark it as repeated 
				}
			} 
			// Print the current first non-repeating character from stream 
			if(inDLL.length != 0) { 
				System.out.print("First non-repeating character so far is "); 
				System.out.println(tail.item); 
			} 
		}     
	} 

	private static void add(char data) { 

		Node node = new Node(data); 
		if (head == null) { 
			node.prev = null; 
			head = node; 
			tail = node;
			return; 
		} else {
			node.prev=head;
			head.next=node;
			head=node;	
		}
	} 
	private static void delete(Node node) { 

		if(node.prev==null) {	  
			tail=node.next;
			node.next.prev=null;
		}else if(node.next==null){
			head=node.prev;
			node.prev.next=null;
		}else {
			node.prev.next=node.next;
			node.next.prev=node.prev;
		}
	} 

	private static class Node{
		private char item;
		private Node next;
		private Node prev;
		public Node(char item) {
			this.item = item;
			this.next = null;
			this.prev = null;
		}	  
	}

} 