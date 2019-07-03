package com.ds.matrix;

public class CollectMaxCoins {

	private static int maxCoins = -1;
	private static char arr[][] = {

		{'E', 'C', 'C', '#', 'C'},
		{'C', '#', 'C', '#', 'E'},
		{'#', 'C', 'C', '#', 'C'},
		{'C', 'E', 'E', 'C', 'E'},
		{'C', 'E', '#', 'C', 'E'}
	};
	private static int  N = arr.length;
	private static int[][] coins = new int[N][N];
	public static void main(String[] args) {


		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(arr[i][j]=='#'){
					coins[i][j]=-1;
				}else if(arr[i][j]=='C'){
					coins[i][j]=1;
				}else {
					coins[i][j]=0;
				}
			}
		}
		System.out.println("Maximum number of collected coins is "+ collectMaxCoins(coins,0,0,0));
		
	}
	private static boolean collectMaxCoins(int coins[][], int row ,int column,int maxPoint){

		int temp[] = new int[N];
		/*for(int j=0;j<N;j++){
			//for(int j=N-1;j>=0;j--){
				System.out.print(coins[0][j]+" ");
			}
			System.out.println();*/
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				
				if(coins[i][j]==-1){
					temp[j]= 0;
				}else{
					temp[j]+=coins[i][j];
				}
			}
			for(int j=0;j<N;j++){
			//for(int j=N-1;j>=0;j--){
				System.out.print(temp[j]+" ");
			}
			System.out.println();
		}
		
		return false;	 
	}
	private static boolean isValidMove(int row,int column){
		return (row >= 0 && row < N && column >= 0 &&column < N &&coins[row][column]!=-1);
	}
	static boolean isValid(int i, int j)
	{
		return (i >=0 && i < N && j >=0 && j < N);
	}

	// dir = 0 for left, dir = 1 for right.  This function returns
	// number of maximum coins that can be collected starting from
	// (i, j).
	static int maxCoinsUtil(char arr[][],  int i, int j, int dir,int dp[][][]){
		// If this is a invalid cell or if cell is a blocking cell
		if (isValid(i,j) == false || arr[i][j] == '#')
			return 0;

		// If this subproblem is already solved than return the
		// already evaluated answer.
		if (dp[i][j][dir] != -1)
			return dp[i][j][dir];

		// Check if this cell contains the coin 'C' or if its 'E'.
		dp[i][j][dir] = (arr[i][j] == 'C')? 1: 0;

		// Get the maximum of two cases when you are facing right
		// in this cell
		if (dir == 1) // Direction is right
			dp[i][j][dir] += Math.max(maxCoinsUtil(arr, i+1, j, 0, dp), // Down
					maxCoinsUtil(arr, i, j+1, 1, dp)); // Ahead in rught

		// Get the maximum of two cases when you are facing left
		// in this cell
		if (dir == 0) // Direction is left
			dp[i][j][dir] += Math.max(maxCoinsUtil(arr, i+1, j, 1, dp),  // Down
					maxCoinsUtil(arr, i, j-1, 0, dp)); // Ahead in left

		// return the answer
		return dp[i][j][dir];
	}

	// This function mainly creates a lookup table and calls
	// maxCoinsUtil()
	static int maxCoins(char arr[][]){
		// Create lookup table and initialize all values as -1
		int dp[][][] = new int[N][N][2];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				for(int k=0;k<2;k++){
					dp[i][j][k]=-1;
				}
			}
		}
		// As per the question initial cell is (0, 0) and direction
		// is right
		return maxCoinsUtil(arr, 0, 0, 1, dp);
	}

	// Driver program to test above function

}
