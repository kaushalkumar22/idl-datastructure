package greedy;

import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appears once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example 1:
 * 
 * Input: "bcabc" Output: "abc" Example 2:
 * 
 * Input: "cbacdcbc" Output: "acdb" Note: This question is the same as 1081:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * 
 * @author I339640
 *
 */
public class RemoveDuplicateLetters {

	public String removeDuplicateLetters1(String s) {
		int[] cnt = new int[26];
		int pos = 0; // the position for the smallest s[i]
		for (int i = 0; i < s.length(); i++) 
			cnt[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos)) pos = i;
			if (--cnt[s.charAt(i) - 'a'] == 0) break;
		}
		return s.length() == 0 ? "" : s.charAt(pos) +
				removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}

	public String removeDuplicateLetters(String sr) {
		int[] res = new int[26]; //will contain number of occurences of character (i+'a')
		boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
		char[] ch = sr.toCharArray();
		for(char c: ch){  //count number of occurences of character 
			res[c-'a']++;
		}
		Stack<Character> st = new Stack<>(); // answer stack
		int index;
		for(char s:ch){ 
			index= s-'a';
			res[index]--;   //decrement number of characters remaining in the string to be analysed
			if(visited[index]) //if character is already present in stack, dont bother
				continue;
			//if current character is smaller than last character in stack which occurs later in the string again
			//it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
			while(!st.isEmpty() && s<st.peek() && res[st.peek()-'a']!=0){ 
				visited[st.pop()-'a']=false;
			}
			st.push(s); //add current character and mark it as visited
			visited[index]=true;
		}

		StringBuilder sb = new StringBuilder();
		//pop character from stack and build answer string from back
		while(!st.isEmpty()){
			sb.insert(0,st.pop());
		}
		return sb.toString();
	}
}
