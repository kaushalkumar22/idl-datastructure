package com.ds.problemset;
/*
 *Matching nuts and bolts problem can be stated as follows: � Given a collection of n nuts of distinct sizes and n bolts 
 *such that there is a one-to-one correspondence between the nuts and the bolts, find for each nut its corresponding bolt.
 * We can only compare nuts to bolts i.e., we can neither compare nuts to nuts nor bolts to bolts.
 * 
 * Suppose we choose a nut and partition all bolts in {1…n}, by comparing with this nut, into three intervals 
 * : {1…i-1}, {i}, {i+1, n} such that each bolt in {1, i-1} is smaller, bolt i matches and each bolt in {i+1, n} 
 * is larger than the chosen nut. This procedure is similar to the partition procedure used in quicksort and can
 * be implemented in O(n). Now, we can use the matching bolt to partition all nuts in three intervals in a 
 * similar manner so that the nut i and bolt i match. We have reduced the problem of finding matchings in the 
 * interval {1…n} into two smaller subproblems: finding matchings in the intervals {1…i-1} and {i+1…n}.
 * 
 * 
 * As we apply partitioning on nuts and bolts both so the total time complexity will be Θ(2*nlogn) = Θ(nlogn) on average.
 */

public class NutsAndBoltsMatch{

	public static void main(String[] args){

		char nuts[] = {'@', '#', '$', '%', '^', '&'};
		char bolts[] = {'$', '%', '&', '^', '@', '#'};

		matchNutBoltPairs(nuts, bolts, 0, 5);

		System.out.println("Matched nuts and bolts are : ");
		printArray(nuts);
		printArray(bolts);
	}

	private static void matchNutBoltPairs(char[] nuts, char[] bolts, int low,int high){

		if (low < high) {
			// Choose last character of bolts array for nuts partition.
			int pivot = partition(nuts, low, high, bolts[high]);

			// Now using the partition of nuts choose that for bolts partition.
			partition(bolts, low, high, nuts[pivot]);

			// Recur for [low...pivot-1] & [pivot+1...high] for nuts and bolts array.
			matchNutBoltPairs(nuts, bolts, low, pivot-1);
			matchNutBoltPairs(nuts, bolts, pivot+1, high);
		}
	}

	private static int partition(char[] arr, int low, int high, char pivot){
		int pIndex = low;
		for(int i=low;i<high;i++){   	 
			if(arr[i]<pivot){
				swap(arr,i,pIndex);
				pIndex++;
			} else if(arr[i] == pivot){
				swap(arr,i,high);
				i--;
			}  	
		}
		swap(arr,high,pIndex);
		return pIndex;
	}
	private static void swap(char[] arr,int i,int j){
		char temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	// Method to print the array
	private static void printArray(char[] arr) {
		for (char ch : arr){
			System.out.print(ch + " ");
		}
		System.out.print("\n");
	}

}