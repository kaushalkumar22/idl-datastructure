package array_google;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
       // String  pattern = "abba", s = "dog cat cat dog";
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern( pattern, s));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length()!=words.length) return  false;

        Map map = new HashMap();
        for(int i =0;i<pattern.length();i++){
            if(map.get(words[i])!= map.get(pattern.charAt(i))){
                return false;
            }
            map.put(words[i],i);
            map.put(pattern.charAt(i),i);
        }
        return true;
    }
}
