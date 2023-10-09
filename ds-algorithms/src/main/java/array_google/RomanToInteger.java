package array_google;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res = map.get(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(map.get(s.charAt(i-1))<map.get(s.charAt(i))){
                res += map.get(s.charAt(i))-2*map.get(s.charAt(i-1));
            }else{
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
