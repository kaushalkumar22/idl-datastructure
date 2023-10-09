package a_util;

public class InputFormater {
    public static void main(String[] args) {
        String s =" points = [[10,16],[2,8],[1,6],[7,12]]";
        s = s.replace("[","{").replace("]","}").replace("\"","'");
        System.out.println(s);
    }
}
