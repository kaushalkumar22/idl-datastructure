package com.algo.trie;

/**
 * 
 * Design a data structure that is initialized with a list of different words.
 * Provided a string, you should determine if you can change exactly one
 * character in this string to match any word in the data structure.
 * 
 * Implement the MagicDictionary class:
 * 
 * MagicDictionary() Initializes the object. void buildDict(String[] dictionary)
 * Sets the data structure with an array of distinct strings dictionary. bool
 * search(String searchWord) Returns true if you can change exactly one
 * character in searchWord to match any string in the data structure, otherwise
 * returns false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["MagicDictionary", "buildDict", "search", "search", "search",
 * "search"] [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"],
 * ["leetcoded"]] Output [null, null, false, true, false, false]
 * 
 * Explanation MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // return False
 * magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to
 * match "hello" so we return True magicDictionary.search("hell"); // return
 * False magicDictionary.search("leetcoded"); // return False
 *
 * 
 */
public class ImplementMagicDictionary {

	class Node{
        Node[] next= new Node[26];
        boolean isEnd;
    }
    Node root= new Node();
    /** Initialize your data structure here. */
    public ImplementMagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s: dict){
            Node cur= root;
            for (char c: s.toCharArray()){
                if (cur.next[c-'a']==null) cur.next[c-'a']=new Node();
                cur=cur.next[c-'a'];
            }
            cur.isEnd=true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return dfs(root, word, 0, false);
    }
    public boolean dfs(Node cur, String word, int idx, boolean used){
        if (cur==null) return false;
        if (idx==word.length()) return cur.isEnd && used;
        char c= word.charAt(idx);
        for (int i=0; i<26; i++){
            if (used && (c-'a')!=i) continue;
            if (dfs(cur.next[i], word, idx+1, used || (c-'a')!=i)) return true;
        }
        return false;
    }
}
