package com.algo.queue;
//http://www.geeksforgeeks.org/efficiently-implement-k-queues-single-array/
public class KQueues {

	int arr[];   // Array of size n to store actual content to be stored in queue
    int front[];   // Array of size k to store indexes of front elements of queue
    int rear[];   // Array of size k to store indexes of rear elements of queue
    int next[];  // Array of size n to store next entry in all queues
                // and free list
    int n, k;
    int free; // To store beginning index of free list

    // A utility function to check if there is space available
    boolean isFull()   {  return (free == -1);  }
 
 
    // To check whether queue number 'qn' is empty or not
    boolean isEmpty(int qn)  {  return (front[qn] == -1); }
 
// Constructor to create k queues in an array of size n
KQueues(int k1, int n1)
{
    // Initialize n and k, and allocate memory for all arrays
    k = k1; n = n1;
    arr = new int[n];
    front = new int[k];
    rear = new int[k];
    next = new int[n];
 
    // Initialize all queues as empty
    for (int i = 0; i < k; i++)
        front[i] = -1;
 
    // Initialize all spaces as free
    free = 0;
    for (int i=0; i<n-1; i++)
        next[i] = i+1;
    next[n-1] = -1;  // -1 is used to indicate end of free list
}
 
// To enqueue an item in queue number 'qn' where qn is from 0 to k-1
void enqueue(int item, int qn)
{
    // Overflow check
    if (isFull())
    {
        System.out.println("\nQueue Overflow\n");
        return;
    }
 
    int i = free;      // Store index of first free slot
 
    // Update index of free slot to index of next slot in free list
    free = next[i];
 
    if (isEmpty(qn))
        front[qn] = i;
    else
        next[rear[qn]] = i;
 
    next[i] = -1;
 
    // Update next of rear and then rear for queue number 'qn'
    rear[qn] = i;
 
    // Put the item in array
    arr[i] = item;
}
 
// To dequeue an from queue number 'qn' where qn is from 0 to k-1
int dequeue(int qn)
{
    // Underflow checkSAS
    if (isEmpty(qn))
    {
         System.out.println("\nQueue Underflow\n");
         return Integer.MAX_VALUE;
    }
 
    // Find index of front item in queue number 'qn'
    int i = front[qn];
 
    front[qn] = next[i];  // Change top to store next of previous top
 
    // Attach the previous front to the beginning of free list
    next[i] = free;
    free = i;
 
    // Return the previous front item
    return arr[i];
}
 
/* Driver program to test kStacks class */
 public static void main(String[] args) {
   // Let us create 3 queue in an array of size 10
    int k = 3, n = 10;
    KQueues ks = new KQueues(3, 10);
 
    // Let us put some items in queue number 2
    ks.enqueue(15, 2);
    ks.enqueue(45, 2);
 
    // Let us put some items in queue number 1
    ks.enqueue(17, 1);
    ks.enqueue(49, 1);
    ks.enqueue(39, 1);
 
    // Let us put some items in queue number 0
    ks.enqueue(11, 0);
    ks.enqueue(9, 0);
    ks.enqueue(7, 0);
 
    System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
    System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1) );
    System.out.println( "Dequeued element from queue 0 is " + ks.dequeue(0) );
}
}
