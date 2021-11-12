package com.algo.string.common;

/**
 * Given a stream of characters, find the first non-repeating character from
 * stream. You need to tell the first non-repeating character in O(1) time at
 * any moment.
 * 
 * 
 * If we use the first not repeating char from string approach, then we need to
 * go through the count array every time to find the first non-repeating element
 * is queried. We can find the first non-repeating character from the stream at
 * any moment without traversing any array in O(1) time. The idea is to use a DLL
 * (Doubly Linked List) to get the first non-repeating character
 * from a stream in O(1). The DLL contains all non-repeating characters in order, i.e.,
 * the head of DLL contains first non-repeating character, the second node
 * contains the second non-repeating and so on.
 * 
 * Create an empty DLL. Also create two arrays inDLL[] and repeated[] of size
 * 256. inDLL is an array of pointers to DLL nodes. repeated[] is a boolean
 * array, repeated[x] is true if x is repeated two or more times, otherwise
 * false. inDLL[x] contains a pointer to a DLL node if character x is present in
 * DLL, otherwise NULL.
 * 
 * Initialize all entries of inDLL[] as NULL and repeated[] as false.
 * 
 * To get the first non-repeating character, return character at head of DLL.
 * 
 * Following are steps to process a new character ‘x’ in a stream.
 * 
 * If repeated[x] is true, ignore this character (x is already repeated two or
 * more times in the stream)
 * 
 * If repeated[x] is false and inDLL[x] is NULL (x is seen first time). Append x
 * to DLL and store address of new DLL node in inDLL[x].
 * 
 * If repeated[x] is false and inDLL[x] is not NULL (x is seen second time). Get
 * DLL node of x using inDLL[x] and remove the node. Also, mark inDLL[x] as NULL
 * and repeated[x] as true.
 *
 * 
 */
public class FirstNonRepeatingCharacterFromStream {

	private static final int MAX_CHAR = 256;
	private static Node head;
	private static Node tail;

	public static void main(String[] args) {

		String stream = "geeksforgeeksandgeeksquizfor";
		Node[] inDLL = new Node[MAX_CHAR];
		boolean[] repeated = new boolean[MAX_CHAR];

		for (int i = 0; i < stream.length(); i++) {
			char x = stream.charAt(i);
			System.out.println("Reading " + x + " from stream n");
			// We process this character only if it has not occurred or occurred only once. 
			//repeated[x] is true if x is repeated twice or more.s
			if (!repeated[x]) {
				// If the character is not in DLL, then add this at the end of DLL.
				Node node = inDLL[x];
				if (node == null) {
					add(x);
					inDLL[x] = head;
				} else {
					remove(node);
					repeated[x] = true; // Also mark it as repeated
				}
			}
			// Print the current first non-repeating character from stream
			if (tail!=null) {
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
			node.prev = head;
			head.next = node;
			head = node;
		}
	}

	private static void remove(Node node) {
		
		if (node.prev == null) {
			tail = node.next;
			node.next.prev = null;
		} else if (node.next == null) {
			head = node.prev;
			node.prev.next = null;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	private static class Node {
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