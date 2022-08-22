package com.algo.dp.common;

/**
Imagine you have a special keyboard with the following keys: 
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed. 

If you can only press the keyboard for N times (with the above four keys), write a program to produce maximum numbers
of A's. That is to say, the input parameter is N (No. of keys that you can press), the output is M 
(No. of As that you can produce).
Input:  N = 7
Output: 9
We can at most get 9 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V

Input:  N = 11
Output: 27
We can at most get 27 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V, Ctrl A, 
Ctrl C, Ctrl V, Ctrl V
 */
public class Keyboard4Keys {

	public static void main(String args[]){
		Keyboard4Keys ca =new Keyboard4Keys();
		System.out.println(ca.maxA(25));
		System.out.println(ca.countAs(25));

	}
	public int maxA(int N) {
		int res = N;
		// number of printing A is between [1, N-3],
		// the number of pasting is N-2-i,
		// plus the printed part, it is N-1-i
		for (int i = 1; i < N - 2; ++i) {
			res = Math.max(res, maxA(i) * (N - 1 - i));
		}
		return res;

	}
	public int maxA(int N) {

		//dp[i] represents the maximum number of A that can be printed when the total number of steps is i
		int[] dp = new int[N + 1];
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i - 2; j++) {
				dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
			}

			dp[i] = Math.max(dp[i], dp[i - 1] + 1);
		}

		return dp[N];
	}
}
public int countAs(int n){
	if(n < 7){
		return n;
	}

	int T[] = new int[n+1];
	for(int i=1; i < 7 ; i++){
		T[i] = i;
	}
	for(int i=7; i <= n; i++){
		for(int b = i-3; b > 0; b--){
			T[i] = Math.max(T[i], T[b]*(i-b-1));
		}
	}
	return T[n];
}


}
