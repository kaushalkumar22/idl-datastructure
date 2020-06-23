package com.algo.geometric;

/**
 * In a 1 million by 1 million grid, the coordinates of each grid square are (x,
 * y) with 0 <= x, y < 10^6.
 * 
 * We start at the source square and want to reach the target square. Each move,
 * we can walk to a 4-directionally adjacent square in the grid that isn't in
 * the given list of blocked squares.
 * 
 * Return true if and only if it is possible to reach the target square through
 * a sequence of moves.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2] Output: false
 * Explanation: The target square is inaccessible starting from the source
 * square, because we can't walk outside the grid. Example 2:
 * 
 * Input: blocked = [], source = [0,0], target = [999999,999999] Output: true
 * Explanation: Because there are no blocked cells, it's possible to reach the
 * target square.
 * 
 * @author I339640
 *
 */
public class EscapeALargeMaze {

	/*Important Foreword
	Leetcode add some new corner cases recently,
	if it has different output with solution, don't be surprised.
	It's very probably that, my solution is correct, OJ is wrong.

	Also, I suggest you read other solutions.
	But please don't 100% trust the bound given by the other solution, thanks.
	(Even these solutions are accepted by Leetcode)

	If you doubt the bound that I insist in my solution (you can and you should),
	Please refer first to FAQ or replies below,
	they may help before we discussed repeated question.


	FAQ
	Question I think the maximum area is 10000?
	Answer
	The maximum area is NOT 10000. Even it's accepted with bound 10000, it's WRONG.
	The same, the bfs with just block.size steps, is also wrong.

	In the following case, the area is 19900.

	0th      _________________________
	         |O O O O O O O X
	         |O O O O O O X
	         |O O O O O X
	         |O O O O X
	         .O O O X
	         .O O X
	         .O X
	200th    |X

	Question I think the maximum area is area of a sector.
	Answer
	All cells are discrete, so there is nothing to do with pi.


	Question What is the maximum area?
	Answer
	It maximum blocked is achieved when the blocked squares,
	surrounding one of the corners as a 45-degree straight line.

	And it's easily proved.

	If two cells are connected horizontally,
	we can slide one part vertically to get bigger area.

	If two cells are connected vertically,
	we can slide one part horizontally to get bigger area.


	Question Can we apply a BFS?
	Answer
	Yes, it works.
	BFS in 4 directions need block.length * 2 as step bounds,
	BFS in 8 directions need block.length as step bounds.

	It needs to be noticed that,
	The top voted BFS solution is WRONG with bound,
	though it's accpected by Leetcode.

	But compared with the complexity:
	Searching with limited area is O(0.5B*B).
	BFS with steps can be O(2B^B).


	Intuition
	Simple search will get TLE, because the big search space.
	Anyway, we don't need to go further to know if we are blocked or not.
	Because the maximum area blocked are 19900.


	Explanation
	Search from source to target,
	if find, return true;
	if not find, return false;
	if reach 20000 steps, return true.

	Then we do the same thing searching from target to source.


	Complexity
	Time complexity depends on the size of blocked
	The maximum area blocked are B * (B - 1) / 2.
	As a result, time and space complexity are both O(B^2)
	In my solution I used a fixed upper bound 20000.

*/
	/*Python, DFS:
	    def isEscapePossible(self, blocked, source, target):
	        blocked = set(map(tuple, blocked))

	        def dfs(x, y, target, seen):
	            if not (0 <= x < 10**6 and 0 <= y < 10**6) or (x, y) in blocked or (x, y) in seen: return False
	            seen.add((x, y))
	            if len(seen) > 20000 or [x, y] == target: return True
	            return dfs(x + 1, y, target, seen) or \
	                dfs(x - 1, y, target, seen) or \
	                dfs(x, y + 1, target, seen) or \
	                dfs(x, y - 1, target, seen)
	        return dfs(source[0], source[1], target, set()) and dfs(target[0], target[1], source, set())
	Python, BFS:
	    def isEscapePossible(self, blocked, source, target):
	        blocked = {tuple(p) for p in blocked}

	        def bfs(source, target):
	            bfs, seen = [source], {tuple(source)}
	            for x0, y0 in bfs:
	                for i, j in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
	                    x, y = x0 + i, y0 + j
	                    if 0 <= x < 10**6 and 0 <= y < 10**6 and (x, y) not in seen and (x, y) not in blocked:
	                        if [x, y] == target: return True
	                        bfs.append([x, y])
	                        seen.add((x, y))
	                if len(bfs) == 20000: return True
	            return False
	        return bfs(source, target) and bfs(target, source)*/
}
