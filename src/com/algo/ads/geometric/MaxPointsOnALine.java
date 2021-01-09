package com.algo.ads.geometric;

import java.util.HashMap;
import java.util.Map;

/**
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
*/


public class MaxPointsOnALine {


	public int maxPoints(Point[] points) {
		if (points == null) return 0;

		int solution = 0;

		for (int i = 0; i < points.length; i++)
		{
			Map<String, Integer> map = new HashMap<>();
			int duplicate = 0;
			int max = 0;
			for (int j = i + 1; j < points.length; j++)
			{
				int deltaX = points[j].x - points[i].x;
				int deltaY = points[j].y - points[i].y;

				if (deltaX == 0 && deltaY == 0)
				{
					duplicate++;
					continue;
				}

				int gcd = gcd(deltaX, deltaY);
				int dX = deltaX / gcd;
				int dY = deltaY / gcd;

				map.put(dX + "," + dY, map.getOrDefault(dX + "," + dY, 0) + 1);
				max = Math.max(max, map.get(dX + "," + dY));
			}

			solution = Math.max(solution, max + duplicate + 1);
		}

		return solution;
	}

	public int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}
}
class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

