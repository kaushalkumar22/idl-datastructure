package heap;

public class MaxHeap {

	private int heapArr[]; // pointer to array of elements in heap
	private int capacity; // maximum possible size of max heap
	private int heapSize; // Current number of elements in max heap

	// Constructor: Builds a heap from a given array a[] of given size
	private MaxHeap(int capacity){
		this.heapSize = 0;
		this.capacity = capacity;
		this.heapArr = new int[capacity];
	}
	private int getParent(int i) { 
		return (i-1)/2; 
	}
	private int getLeftChild(int i) { 
		return 2*i+1;
	}
	private int getRightChild(int i) { 
		return 2*i + 2; 
	}

	private int getMaxValue() { 
		return heapArr[0]; 
	}

	private void buildMaxHeap(int k){

		if (heapSize == capacity){
			System.out.println("Overflow: Could not insertKey");
			return;
		}
		heapSize++;
		heapArr[heapSize-1] = k;
		for(int i = heapSize/2;i>=0;i--){
			heapify(i);
		}
	}

	// Decreases value of key at index 'i' to new_val.  It is assumed that new_val is smaller than harr[i].
	private void decreaseKey(int index, int newVal){
		heapArr[index] = newVal;
		for(int i = heapSize/2;i>=0;i--){
			heapify(i);
		}
	}

	// Method to remove minimum element (or root) from min heap
	private int removeRoot()
	{
		if (heapSize <= 0)
			return Integer.MAX_VALUE;

		if (heapSize == 1){
			heapSize--;
			return heapArr[0];
		}
		int root = heapArr[0];
		heapArr[0] = heapArr[heapSize-1];
		heapSize--;
		for(int i = heapSize/2;i>=0;i--){
			heapify(i);
		}
		return root;
	}


	/*// This function deletes key at index i. It first reduced value to minus
	// infinite, then calls extractMin()
	private void deleteKey(int i){
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}*/

	// A recursive method to heapify a subtree with root at given index 
	//This method assumes that the subtrees are already heapified
	private void heapify(int i){

		int l = getLeftChild(i);
		int r = getRightChild(i);
		int latgest = i;
		if (l <=heapSize && heapArr[l] > heapArr[latgest])
			latgest = l;
		if (r <= heapSize && heapArr[r] > heapArr[latgest])
			latgest = r;
		if (latgest != i){
			swap(heapArr,i, latgest);
			heapify(latgest);
		}
	}

	private void swap(int heapArr[],int x, int y){
		int temp   = heapArr[x];
		heapArr[x] = heapArr[y];
		heapArr[y] = temp;
	}

	public static void main(String[] args) {

		MaxHeap  h = new MaxHeap(11); 
		h.buildMaxHeap(3);
		h.buildMaxHeap(2);
		h.buildMaxHeap(15);
		h.buildMaxHeap(5);
		h.buildMaxHeap(4);
		h.buildMaxHeap(45);
		h.buildMaxHeap(1);
		System.out.println(h.getMaxValue() +" ");
		System.out.println(h.removeRoot() +" ");
		System.out.println(h.getMaxValue() +" ");
		
		//h.decreaseKey(2, 1);
		for(int i=0;i<h.heapSize;i++){
			System.out.println(h.heapArr[i]);
		}

	}
}
