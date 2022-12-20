package a_util;

public class InputFormater {
    public static void main(String[] args) {
        String s ="graph = [[1,3],[0,2],[1,3],[0,2]]";
        s = s.replace("[","{").replace("]","}").replace("\"","'");
        System.out.println(s);
    }
}
