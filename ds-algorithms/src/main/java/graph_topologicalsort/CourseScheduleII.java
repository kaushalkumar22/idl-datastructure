package graph_topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 *
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 You are given an array prerequisites where prerequisites[i] = [ai, bi]
 indicates that you must take course bi first if you want to take course ai.
 For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
 If it is impossible to finish all courses, return an empty array.

 Input: numCourses = 2, prerequisites = [[1,0]]
 Output: [0,1]
 Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
 So the correct course order is [0,1].
 *
 */
public class CourseScheduleII {

	public static void main(String[] args) {
		//int[][] prerequisites= {{0,1},{0,2},{1,3},{1,4},{3,4}};
		int[][] prerequisites= {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(Arrays.toString(new CourseScheduleII().findOrder(4,prerequisites)));
	}

	public  int[]  findOrder(int numCourses, int[][] prerequisites) {

		Map<Integer,List<Integer>> adjMap = getAdjMap( numCourses, prerequisites);
		Set<Integer> visited =new HashSet<>();
		List<Integer> res = new ArrayList<>();
		for (int i = 0 ; i < numCourses; i++) {
			if (!dfs(i, adjMap,res,visited,new HashSet<>())) {
				return  new int[] {};
			}
		}
		return  res.stream().mapToInt(i -> i).toArray();
	}

	private  boolean dfs(int course, Map<Integer, List<Integer>> adjMap,
						 List<Integer> res,Set<Integer> visited,Set<Integer> cycle) {

		if(cycle.contains(course)) return false;
		if(visited.contains(course)) return true;
		cycle.add(course);
		for (Integer pre : adjMap.get(course)) {
			if (!dfs(pre, adjMap,res,visited,cycle)) return false;
		}
		visited.add(course);
		res.add(course);
		return true;
	}
	private Map<Integer,List<Integer>> getAdjMap(int numCourses, int[][] prerequisites){
		Map<Integer,List<Integer>> adjMap = new HashMap<>();
		for (int i=0;i<numCourses;i++) {
			adjMap.put(i, new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			adjMap.get(pre[0]).add(pre[1]);
		}
		return adjMap;
	}
}

