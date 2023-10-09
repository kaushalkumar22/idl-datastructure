package heap_pq;

public class SortNearlySortedArray {

	private static int heap_size =0;
	private static int harr[];
	public static void main(String[] args) {

		int arr[] = {6, 2, 3, 12, 20, 8,25,40,30,70,50,60};
		//heap_size = arr.length;
		printArray(arr);
		//sortNearlySortedArray(arr);
		sortK(arr, 3);
		printArray(arr);
	}
	// Given an array of size n, where every element is k away from its target
	// position, sorts the array in O(nLogk) time.
	private static void  sortK(int arr[], int k){

		int n = arr.length;
		int arrIndex=-1;
		int arrK[] = new int[k];
		if(k>=n){
			k=n;
		}
		for (int i = 0; i<k; i++){    // i < n condition is needed when k > n
			arrIndex++;
			arrK[i] = arr[i];
		}
		manHeap(arrK);
		for(int i=arrIndex+1;i<n;i++){
			sortNearlySortedArray(arr,arrK,arr[i]);
		}
		for(int i=0;i<k;i++){
			arrIndex++;
			arr[heap_size++] = arrK[0];
			arrK[0]  = Integer.MAX_VALUE;
			for(int j=k/2-1;j>=0;j--){
				heapify(arrK,k,j);
			}
		}
	}
	private static void manHeap(int arr[]){
		int n= arr.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
	}
	

	private static void sortNearlySortedArray(int arr[],int arrK[],int value){

		int root = arrK[0];
		arrK[0]  = value;
		arr[heap_size++] = root;

		int n= arrK.length;

		for(int i=n/2-1;i>=0;i--){
			heapify(arrK,n,i);
		}

		/*int n= arr.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}*/
	}
	private static void heapify(int arr[], int n, int i){

		int left = 2*i+1;
		int right = 2*i+2;
		int smalest =i;

		if(left<n&&arr[left]<arr[smalest]){
			smalest = left;
		}
		if(right<n&&arr[right]<arr[smalest]){
			smalest=right;
		}
		if(smalest!=i){
			swap(arr, smalest, i);
			heapify(arr, n, smalest);
		}
	}

	private static void swap(int arr[], int smalest, int i){

		int temp =arr[i];
		arr[i] =arr[smalest];
		arr[smalest]=temp;
	}

	private static void printArray(int arr[]){

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
