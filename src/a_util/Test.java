package a_util;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        String t= "cycle";
        System.out.println(minStep( "BAAABAB"));//ABBBABA
        System.out.println(solution( "abacdec"));
    }
    //BAAABAB
    public  static int minStep(String S) {

        int charA= 'A';
        int countB=0;
        int minimumDelete=0;
        for(int i=0;i<S.length();i++){
            if(charA==S.charAt(i)){
                minimumDelete= Math.min(countB,minimumDelete+1);
            }else {
                countB++;
            }
        }
        return minimumDelete;
    }
    public static int solution(String S) {//abacdec
        // write your code in Java SE 8
        if(S==null||S.length()==0) return 0;
        Set<Character> charSet = new HashSet<>();
        int count=1;
        for(char c:S.toCharArray()){
            if(charSet.contains(c)) {
                charSet.clear();
                count++;
            }
            charSet.add(c);
        }
        return count;
    }
    static void swap(char[] nums,int i,int j) {
        char c = nums[i];
        nums[i]=nums[j];
        nums[j]=c;
    }
}
