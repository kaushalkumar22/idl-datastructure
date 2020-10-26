package com.algo.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Design an in-memory file system to simulate the following functions
 * 
 * ls:Given a path in string format. If it is a file path, return a list that only
 * contains this file's name. If it is a directory path, return the list of file
 * and directory names in this directory. Your output (file and directory names
 * together) should in lexicographic order.
 * 
 * mkdir: Given a directory path that does not exist, you should make a new
 * directory according to the path. If the middle directories in the path don't
 * exist either, you should create them as well. This function has void return
 * type.
 * 
 * addContentToFile: Given a file path and file content in string format. If the
 * file doesn't exist, you need to create that file containing given content. If
 * the file already exists, you need to append given content to original
 * content. This function has void return type.
 * 
 * readContentFromFile: Given a file path, return its content in string format.
 * Example:
 * 
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * 
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 * 
 * Output: [null,[],null,null,["a"],"hello"]
 *
 */
public class InMemoryFileSystem {
	public static void main(String[] args) {
		InMemoryFileSystem obj = new InMemoryFileSystem();
		  System.out.println(obj.ls("/"));
		  obj.mkdir("/a/b/c");
		  obj.addContentToFile("/a/b/c/d","hello");
		  System.out.println(obj.ls("/"));
		  String param_4 = obj.readContentFromFile("/a/b/c/d");
		  System.out.println(param_4);
	}

	class File {
		boolean isFile = false;
		Map<String, File> children = new HashMap<>();
		String content = "";
	}

	File root = null;

	public InMemoryFileSystem() {
		root = new File();
	}

	public List<String> ls(String path) {
		String[] dirs = path.split("/");
		File node = root;
		List<String> result = new ArrayList<>();
		String name = "";
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!node.children.containsKey(dir)) {
				return result;
			}
			node = node.children.get(dir);
			name = dir;
		}

		if (node.isFile) {
			result.add(name);
		}
		else {
			for (String key : node.children.keySet()) {
				result.add(key);
			}
		}

		Collections.sort(result);

		return result;
	}

	public void mkdir(String path) {
		String[] dirs = path.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}
	}

	public void addContentToFile(String filePath, String content) {
		String[] dirs = filePath.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}
		node.isFile = true;
		node.content += content;
	}

	public String readContentFromFile(String filePath) {
		String[] dirs = filePath.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}

		return node.content;
	}
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */