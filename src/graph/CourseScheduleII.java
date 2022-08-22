package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * 
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 *
 */
public class CourseScheduleII {

	public static void main(String[] args) {
		//int[][] prerequisites= {{0,1},{0,2},{1,3},{1,4},{3,4}};
		int[][] prerequisites= {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(Arrays.toString(findOrder(4,prerequisites)));
		System.out.println(Arrays.toString(new CourseScheduleII().findOrder1(4,prerequisites)));
		
	}
	//Using Node Indegree
	public int[] findOrder1(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		 List<List<Integer>> adjs = graph(indegree,prerequisites);
		return solveByBFS(indegree, adjs);
	}
	private List<List<Integer>> graph(int[] indegree, int[][] prerequisites){
		int n = indegree.length;
		List<List<Integer>> adjs = new ArrayList<>(n);		
		for(int i=0;i<n;i++) {
			adjs.add(new ArrayList<>());
		}
		for (int[] edge : prerequisites) {
			indegree[edge[0]]++;
			adjs.get(edge[1]).add(edge[0]);
		}
		return adjs;
	}

	private int[] solveByBFS(int[] indegree, List<List<Integer>> adjs){
		int[] order = new int[indegree.length];
		Queue<Integer> que = new ArrayDeque<>();
	
		// Add all vertices with 0 in-degree to the queue
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				que.add(i);
			}
		}    
		int seen = 0;
	    // Process until the Q becomes empty
		while (!que.isEmpty()) {
			int from = que.poll();
			order[seen++] = from;
			for (int to : adjs.get(from)) {
				indegree[to]--;
				if (indegree[to] == 0) {
					que.offer(to);
				}
			}
		}
		return seen == indegree.length ? order : new int[0]; 
	}

	
	public static int[]  findOrder(int numCourses, int[][] prerequisites) {
		//if(prerequisites.length==0) return new int[];
		Map<Integer,List<Integer>> adjMap = new HashMap<>();
		 Set<Integer> visited =new HashSet<>();
		 Set<Integer> cycle =new HashSet<>();

		for (int i=0;i<numCourses;i++) {
			adjMap.put(i, new ArrayList<Integer>());					
		}
		for (int[] pre : prerequisites) {	
			if(pre.length==0)continue;
			adjMap.get(pre[0]).add(pre[1]);			
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0 ; i < numCourses; i++) {
			if (!dfs(i, adjMap,res,visited,cycle)) {
				return  new int[] {};
			}
		}
		int[] array = new int[res.size()];
		for(int i = 0; i < res.size(); i++)
			array[i] = res.get(i);
		return array;
	}

	private static boolean dfs(int course, Map<Integer, List<Integer>> adjMap,
			List<Integer> res,Set<Integer> visited,Set<Integer> cycle) {

		if(cycle.contains(course)) return false;
		if(visited.contains(course)) return true;
		cycle.add(course);
		for (Integer pre : adjMap.get(course)) {	
			if (!dfs(pre, adjMap,res,visited,cycle)) return false;
		}
		cycle.remove(course);
		visited.add(course);
		res.add(course);
		return true;
	}
}

