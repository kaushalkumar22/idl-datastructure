package stack_miscellaneous;

import java.util.Stack;

public class SortStackRecursion
{
	public static void main(String[] args)
	{
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(10);
		s1.push(40);
		s1.push(20);
		s1.push(30);
		/*s1.push(40);
		s1.push(50);
		s1.push(60);*/
		System.out.println("Before Sort :");
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());


		s1.push(10);
		s1.push(40);
		s1.push(20);
		s1.push(30);

		sortStack(s1);
		System.out.println("After sort :");
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());

	}
	public static void sortStack(Stack<Integer> s){
		if (s.isEmpty()) {
			return;
		} else {
			Integer a = s.pop();
			sortStack(s);
			sortedInsert(s, a);
		}
	}
	public static void sortedInsert(Stack<Integer> s, Integer a) {
		if (s.isEmpty() || a > s.peek()) {
			s.push(a);
			return;
		} 
		int temp = s.pop();
		sortedInsert(s, a);
		s.push(temp);
	}
}
