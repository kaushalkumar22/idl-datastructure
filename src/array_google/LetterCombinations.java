package array_google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        String text = "098q7654";
        String regex = "\\d+";
        System.out.println(text.matches(regex));
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        Map<Integer,String> keyPad = new HashMap<>();
        keyPad.put(2,"abc");
        keyPad.put(3,"def");
        keyPad.put(4,"ghi");
        keyPad.put(5,"jkl");
        keyPad.put(6,"mno");
        keyPad.put(7,"pqrs");
        keyPad.put(8,"tuv");
        keyPad.put(9,"wxyz");


        dfs(digits,res,new StringBuffer(),0,keyPad);
        return res;
    }

    private static void dfs(String digits, List<String> res, StringBuffer sub, int i, Map<Integer, String> keyPad) {
        if(i==digits.length()){
            res.add(new String(sub));
            return;
        }
        for(char c :keyPad.get(digits.charAt(i)-'0').toCharArray()){
            sub.append(c);
            dfs(digits,res,sub,i+1,keyPad);
            sub.deleteCharAt(sub.length()-1);
        }
    }
}
