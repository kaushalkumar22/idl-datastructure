package com.ds.stack;
import java.util.Stack;

//Implement Queue using Stack.
public class ImplementQueueUsingStack {
	Stack<Integer> S1 = new Stack<Integer>();
	Stack<Integer> S2 = new Stack<Integer>();
	public static void main(String[] args)
	{
		ImplementQueueUsingStack myQueue = new ImplementQueueUsingStack();
		myQueue.EnQueue(10);
		myQueue.EnQueue(20);
		myQueue.EnQueue(30);
		//to verify whether code is working as queue or not
		System.out.println(myQueue.DeQueue());
		myQueue.EnQueue(40);
		System.out.println(myQueue.DeQueue());
		myQueue.EnQueue(50);
		myQueue.EnQueue(60);
		System.out.println(myQueue.DeQueue());
		System.out.println(myQueue.DeQueue());
		System.out.println(myQueue.DeQueue());
		System.out.println(myQueue.DeQueue());
	}
	public void EnQueue(int k){
		S1.push(k);
	}
	public int DeQueue(){
		if(S2.isEmpty()&&S1.isEmpty()){
			return -1;
		}else if(S2.isEmpty()){		
			while(!S1.isEmpty()){
				S2.push(S1.pop());
			}
		}
		return S2.pop();
	}
}

