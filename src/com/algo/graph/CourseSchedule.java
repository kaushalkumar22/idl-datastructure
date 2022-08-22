package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi 
first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have 
finished course 1. So it is impossible.
 */
public class CourseSchedule {

	public static void main(String[] args) {
		int[][] prerequisites= {{0,1},{0,2},{1,3},{1,4},{3,4}};
		//int[][] prerequisites= {{1,0}};
		System.out.println(canFinishDFS(5,prerequisites));
	}
	
	public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		if(prerequisites.length==0) return true;
		Map<Integer,List<Integer>> adjMap = new HashMap<>();

		for (int i=0;i<numCourses;i++) {
			adjMap.put(i, new ArrayList<Integer>());					
		}
		for (int[] pre : prerequisites) {		
			adjMap.get(pre[0]).add(pre[1]);			
		}
		//System.out.println(adjMap);
		 Set<Integer> visited = new HashSet<>();

		for (int i = 0 ; i < numCourses; i++) {
			if (!dfs(i, adjMap,visited)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(int course, Map<Integer, List<Integer>> adjMap,Set<Integer> visited) {

		if(visited.contains(course)) return false;

		if (adjMap.get(course).isEmpty()) return true;	

		visited.add(course);
		for (Integer pre : adjMap.get(course)) {	
			if (!dfs(pre, adjMap,visited)) return false;
		}
		visited.remove(course);
		adjMap.put(course,new ArrayList<>());
		return true;
	}
	public static boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        return bfs.size() == n;
    }
}
