package com.algo.graph;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedwithSameRoworColumn {
	public static void main(String[] args) {

	}
	Map<Integer, Integer> map = new HashMap<>();
	int islands = 0;

	public int removeStones(int[][] stones) {
		for (int i = 0; i < stones.length; ++i)
			union(stones[i][0], ~stones[i][1]);
		return stones.length - islands;
	}

	public int find(int x) {
		if (map.putIfAbsent(x, x) == null)
			islands++;
		if (x != map.get(x))
			map.put(x, find(map.get(x)));
		return map.get(x);
	}

	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			map.put(x, y);
			islands--;
		}
	}
}

