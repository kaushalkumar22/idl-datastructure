package heap_pq;

public class HeapSort {

	public static void main(String args[]){

		int arr[] = {20,13,6,9,12,25,27,16,3,15,7,1,19};
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

	private static void heapSort(int arr[]){

		int n= arr.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
		extractRoot(arr, n);

	}
	private static void heapify(int arr[], int n, int i){

		int left = 2*i+1;
		int right = 2*i+2;
		int largest =i;

		if(left<n&&arr[left]>arr[largest]){
			largest = left;
		}
		if(right<n&&arr[right]>arr[largest]){
			largest=right;
		}
		if(largest!=i){
			swap(arr, largest, i);
			heapify(arr, n, largest);
		}

	}
	private static void extractRoot(int arr[],int n){

		for(int i=n-1;i>=0;i--){
			swap(arr, i,0);
			heapify(arr, i, 0);
		}
	}

	private static void swap(int arr[], int largest, int i){

		int temp =arr[i];
		arr[i] =arr[largest];
		arr[largest]=temp;
	}

	private static void printArray(int arr[]){

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+ " ");	
		}
		System.out.println();
	}
}
