package com.algo.universal;

import java.util.LinkedList;
/**
We are given an array asteroids of integers representing asteroids in a row. 
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right,
negative meaning left). Each asteroid moves at the same speed. 
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, 
both will explode. Two asteroids moving in the same direction will never meet. 
Example 1:
asteroids = [5, 10, -5]
Output: [5, 10] 
The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.

Example 2:
asteroids = [8, -8]
Output: []
The 8 and -8 collide exploding each other.

Example 3: 
asteroids = [10, 2, -5]
Output: [10]
The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.

Example 4:
asteroids = [-2, -1, 1, 2]
Output: [-2, -1, 1, 2]
The -2 and -1 are moving left, while the 1 and 2 are moving right.
Asteroids moving the same direction never meet, so no asteroids will meet each other.

At the end, all the negative star has to be on the left, and all the positive star has to be on the right.
from the left, a negative star will pass through if no positive star on the left;
keep track of all the positive stars moving to the right, the right most one will be the 1st confront the challenge of any future negative star.
if it survives, keep going, otherwise, any past positive star will be exposed to the challenge, by being popped out of the stack.
 *
 */
public class AsteroidCollision {

	public static void main(String[] args) {
		int[] a= {8,-8};
		for (int i : asteroidCollision(a)) {
			System.out.println(i);
		}

	}
	public static int[] asteroidCollision(int[] a) {
		LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0 || s.isEmpty() || s.getLast() < 0)
				s.add(a[i]);
			else if (s.getLast() <= -a[i]) 
			 if (s.pollLast() < -a[i]) i--;
		}
		return s.stream().mapToInt(i->i).toArray();
	}
}
