package com.algo.lds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of directory info including directory path, and all the files
 * with contents in this directory, you need to find out all the groups of
 * duplicate files in the file system in terms of their paths.
 * 
 * A group of duplicate files consists of at least two files that have exactly
 * the same content.
 * 
 * A single directory info string in the input list has the following format:
 * 
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ...
 * fn.txt(fn_content)"
 * 
 * It means there are n files (f1.txt, f2.txt ... fn.txt with content
 * f1_content, f2_content ... fn_content, respectively) in directory
 * root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the
 * directory is just the root directory.
 * 
 * The output is a list of group of duplicate file paths. For each group, it
 * contains all the file paths of the files that have the same content. A file
 * path is a string that has the following format:
 * 
 * "directory_path/file_name.txt"
 * 
 * Example 1:
 * 
 * Input: ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d
 * 4.txt(efgh)", "root 4.txt(efgh)"] Output:
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * 
 *
 */
public class FindDuplicateFile {

	public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] dir = path.split(" ");
            String root = dir[0];
            for(int i=1;i<dir.length;i++){
                String content = dir[i].substring(dir[i].indexOf("("),dir[i].indexOf(")"));
                if(map.get(content)==null)
                    map.put(content,new ArrayList<>());
                map.get(content).add(root +"/" +dir[i].substring(0,dir[i].indexOf("(")));
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            if(entry.getValue().size()>1)
                list.add(entry.getValue());
        }
        return list;
    }

}
