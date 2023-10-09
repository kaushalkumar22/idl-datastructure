package graph_dfs_backtracking;

import java.util.*;

/**
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * <p>
 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output: [ "cats and dog", "cat sand dog" ]
 * <p>
 * Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen",
 * "pine", "pineapple"] Output: [ "pine apple pen apple", "pineapple pen apple",
 * "pine applepen apple" ] Explanation: Note that you are allowed to reuse a
 * dictionary word.
 * <p>
 * Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: []
 */
public class WordBreakII {
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		System.out.println(new WordBreakII().wordBreak( s, wordDict));
	}
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		dfs(s,wordDict,res,new StringBuilder(),0);
		return res;
	}
	private void dfs(String s, List<String> wordDict,List<String> res, StringBuilder sb,int index){
		if(index>s.length()){
			return;
		}
		if(index==s.length()){
			res.add(new String(sb));
			return;
		}
		for(int i =0;i<wordDict.size();i++){
			String word = wordDict.get(i);
			if(!word.equals(s.substring(index,index+word.length()))) continue;
			sb.append(" ").append(word);
			dfs(s,wordDict,res,sb,index+word.length());
			sb.delete(sb.length()-word.length(),sb.length());
		}
	}
	public List<String> wordBreak1(String s, List<String> wordDict) {
		return backtrack(s,wordDict,new HashMap<String, List<String>>());
	}
	// backtrack returns an array including all substrings derived from s.
	public List<String> backtrack(String s, List<String> wordDict, Map<String,List<String>> mem){
		if(mem.containsKey(s)) return mem.get(s);
		List<String> result = new ArrayList<String>();
		for(String word: wordDict)
			if(s.startsWith(word)) {
				String next = s.substring(word.length());
				if(next.length()==0) result.add(word);
				else for(String sub: backtrack(next, wordDict, mem)) result.add(word+" "+sub);
			}
		mem.put(s, result);
		return result;
	}
}
