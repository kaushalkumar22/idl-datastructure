package com.ds.dynamicprogramming;
//http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
public class EggDrop {
	 // A utility function to get maximum of two integers
    static int max(int a, int b) { return (a > b)? a: b; }
      
    /* Function to get minimum number of trails needed in worst
    case with n eggs and k floors */
    static int eggDrop(int n, int k)
    {
       /* A 2D table where entery eggFloor[i][j] will represent minimum
       number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n+1][k+1];
        int res;
        int i, j, x;
          
        // We need one trial for one floor and0 trials for 0 floors
        for (i = 1; i <= n; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }
          
       // We always need j trials for one egg and j floors.
        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;
          
        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= n; i++)  {
            for (j = 2; j <= k; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                	eggFloor[i][j] = Math.min(eggFloor[i][j],(1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x])));
                    // if (res < eggFloor[i][j])
                     //   eggFloor[i][j] = res;
                }
            }
        }
          
        // eggFloor[n][k] holds the result
        return eggFloor[n][k];
 
    }
          
   

	public int calculateRecursive(int eggs, int floors){
		if(eggs == 1){
			return floors;
		}
		if(floors == 0){
			return 0;
		}
		int min = 1000;
		for(int i=1; i <= floors; i++){
			int val = 1 + Math.max(calculateRecursive(eggs-1, i-1),calculateRecursive(eggs, floors-i));
			if(val < min){
				min = val;
			}
		}
		return min;
	}

	public static void main(String args[]){
		EggDrop ed = new EggDrop();
		int r = ed.eggDrop(2,6);
		System.out.println(r);
	}
}