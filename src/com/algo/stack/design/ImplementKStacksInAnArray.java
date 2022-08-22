package com.algo.stack.design;

public class ImplementKStacksInAnArray {

	int stackData[];   // Array of size n to store actual content to be stored in stacks 
	int topOfStack[];   // Array of size k to store indexes of top elements of stacks 
	int nextIndex[];  // Array of size n to store next entry in all stacks and free list 
	int nextAvailable ; // To store beginning index of free list 

	//constructor to create k stacks in an array of size n 
	ImplementKStacksInAnArray(int k, int n){ 
		// Initialize n and k, and allocate memory for all arrays 
		stackData = new int[n]; 
		topOfStack = new int[k]; 
		nextIndex = new int[n]; 

		// Initialize all stacks as empty 
		for (int i = 0; i < k; i++) 
			topOfStack[i] = -1; 

		// Initialize all spaces as free 
		nextAvailable  = 0; 
		for (int i = 0; i < n - 1; i++) 
			nextIndex[i] = i + 1; 
		nextIndex[n - 1] = -1; // -1 is used to indicate end of free list 
	} 


	// To push an item in stack number 'sn' where sn is from 0 to k-1 
	void push(int val, int stack){ 
		// Overflow check 
		if (isAvailable()){ 
			System.out.println("Stack Overflow"); 
			return; 
		} 

		int i = nextAvailable ; // Store index of first free slot 

		// Update index of free slot to index of next slot in free list 
		nextAvailable  = nextIndex[i]; 

		// Update next of top and then top for stack number 'sn' 
		nextIndex[i] = topOfStack[stack]; 
		topOfStack[stack] = i; 

		// Put the item in array 
		stackData[i] = val; 
	} 

	// To pop an from stack number 'sn' where sn is from 0 to k-1 
	public int pop(int stack){ 
		// Underflow check 
		if (isEmpty(stack))  { 
			System.out.println("Stack Underflow"); 
			return Integer.MAX_VALUE; 
		} 

		// Find index of top item in stack number 'sn' 
		int i = topOfStack[stack]; 
		topOfStack[stack] = nextIndex[i]; // Change top to store next of previous top 
		// Attach the previous top to the beginning of free list 
		nextIndex[i] = nextAvailable ; 
		nextAvailable  = i; 

		// Return the previous top item 
		return stackData[i]; 
	} 

	// A utility function to check if there is space available 
	boolean isAvailable(){ 
		return (nextAvailable  == -1); 
	} 

	// To check whether stack number 'sn' is empty or not 
	boolean isEmpty(int sn){ 
		return (topOfStack[sn] == -1); 
	} 
}

/*
 * int[] topOfStack; int[] stackData; int[] nextIndex; int nextAvailable = 0;
 * 
 * public ImplementKStacksInAnArray(int numStacks, int capacity) { topOfStack =
 * new int[numStacks];
 * 
 * for (int i = 0; i < topOfStack.length; i++) { topOfStack[i] = -1; } stackData
 * = new int[capacity]; nextIndex = new int[capacity]; for (int i = 0; i <
 * nextIndex.length - 1; i++) { nextIndex[i] = i+1; }
 * 
 * nextIndex[nextIndex.length - 1] = -1; }
 * 
 * public void push(int stack, int value) {
 * 
 * if (stack < 0 || stack >= topOfStack.length) { throw new
 * IndexOutOfBoundsException(); }
 * 
 * if (nextAvailable < 0) return;
 * 
 * int currentIndex = nextAvailable; nextAvailable = nextIndex[currentIndex];
 * 
 * stackData[currentIndex] = value; nextIndex[currentIndex] = topOfStack[stack];
 * 
 * topOfStack[stack] = currentIndex; }
 * 
 * public int pop(int stack) {
 * 
 * if (stack < 0 || stack >= topOfStack.length || topOfStack[stack] < 0) { throw
 * new IndexOutOfBoundsException(); } int currentIndex = topOfStack[stack]; int
 * value = stackData[currentIndex]; topOfStack[stack] = nextIndex[currentIndex];
 * 
 * nextIndex[currentIndex] = nextAvailable; nextAvailable = currentIndex; return
 * value; }
 */

