package com.algo.stack.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.algo.graph.SatisfiabilityofEqualityEquations;

/**
 * Maximum Frequency Stack
 * 
 * Implement FreqStack, a class which simulates the operation of a stack-like
 * data structure.
 * 
 * FreqStack has two functions:
 * 
 * push(int x), which pushes an integer x onto the stack. pop(), which removes
 * and returns the most frequent element in the stack. If there is a tie for
 * most frequent element, the element closest to the top of the stack is removed
 * and returned.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]] Output:
 * [null,null,null,null,null,null,null,5,7,5,4] Explanation: After making six
 * .push operations, the stack is [5,7,5,7,4,5] from bottom to top. Then:
 * 
 * pop() -> returns 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
 * 
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the
 * top. The stack becomes [5,7,5,4].
 * 
 * pop() -> returns 5. The stack becomes [5,7,4].
 * 
 * pop() -> returns 4. The stack becomes [5,7].
 * 
 * Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9. It is
 * guaranteed that FreqStack.pop() won't be called if the stack has zero
 * elements. The total number of FreqStack.push calls will not exceed 10000 in a
 * single test case. The total number of FreqStack.pop calls will not exceed
 * 10000 in a single test case. The total number of FreqStack.push and
 * FreqStack.pop calls will not exceed 150000 across all test cases.
 * 
 *
 */
public class FreqStack {
	public static void main(String[] args) {
		FreqStack stack = new FreqStack();
		stack.push(5);
		stack.push(7);
		stack.push(5);
		stack.push(7);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
	/*
	 * create a frequency map that will contains frequency of each no.
	 * create a list that will hold a stack at each index and stack will hold the 
	 * nums which are having the same frequency.
	 */
	Map<Integer,Integer> keyVsFreq;
	List<Stack<Integer>> bucket;
	public FreqStack() {
		keyVsFreq = new HashMap<Integer, Integer>();
		bucket = new ArrayList<Stack<Integer>>();
	}

	public void push(int x) {

		keyVsFreq.put(x, keyVsFreq.getOrDefault(x, 0)+1);
		int freq = keyVsFreq.get(x);
		if(freq-1==bucket.size()) {
			bucket.add(new Stack<Integer>());
		}
		bucket.get(freq-1).push(x);
	}

	public int pop() {
		int freq = bucket.size();
		int x = bucket.get(freq-1).pop();
		if(bucket.get(freq-1).isEmpty()) {
			bucket.remove(freq-1);
		}
		keyVsFreq.put(x, keyVsFreq.get(x)-1);
		return x;

	}
}
