package com.algo.graph;

public class IsGraphBipartite {
	public static void main(String[] args) {

	}

	public boolean isBipartite(int[][] g) {
		int[] colors = new int[g.length];
		for (int i = 0; i < g.length; i++)
			if (colors[i] == 0 && !validColor(g, colors, 1, i))
				return false;
		return true;
	}

	boolean validColor(int[][] g, int[] colors, int color, int node) {
		if (colors[node] != 0)
			return colors[node] == color;
		colors[node] = color;
		for (int adjacent : g[node])
			if (!validColor(g, colors, -color, adjacent))
				return false;
		return true;
	}
}

