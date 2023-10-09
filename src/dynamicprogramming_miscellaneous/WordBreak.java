package dynamicprogramming_miscellaneous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. Note: The same word in the
 * dictionary may be reused multiple times in the segmentation. You may assume
 * the dictionary does not contain duplicate words. Example 1: Input: s =
 * "leetcode", wordDict = ["leet", "code"] Output: true Explanation: Return true
 * because "leetcode" can be segmented as "leet code". Example 2: Input: s =
 * "applepenapple", wordDict = ["apple", "pen"] Output: true Explanation: Return
 * true because "applepenapple" can be segmented as "apple pen apple". Note that
 * you are allowed to reuse a dictionary word. Example 3: Input: s =
 * "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] Output: false
 *
 *
 */
public class WordBreak {

    public static void main(String[] args) {
     //  String  s = "catsandog", wordDict[] = {"cats", "dog", "sand", "and", "cat"};
       String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
       String  wordDict[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
      //  String  s = "leetcode", wordDict[] = {"leet", "code"};
       // String s ="applepenapple", wordDict[] = {"apple", "pen"};
       // String s ="abcd", wordDict[]  ={"a","abc","b","cd"};
       System.out.println(dfs( s,wordDict, 0));
        Set<String> dict = new HashSet<>(Arrays.asList(wordDict));
        System.out.println(wordBreak(s, dict));
    }
    private static boolean dfs(String s, String[] dic,int index){


        if(index==s.length()){
            return true;
        }
        for(int i =0;i<dic.length;i++){
            String word = dic[i];
           if( s.length()<index+word.length()) continue;
            if(!word.equals(s.substring(index,index+word.length()))) continue;
            if( dfs(s,dic,index+word.length())) return true;
        }
        return false;
    }
    public static boolean wordBreak(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
