package a_util;

public class InputFormater {
    public static void main(String[] args) {
        String s =" [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]], n = 4";
        s = s.replace("[","{").replace("]","}").replace("\"","'");
        System.out.println(s);
    }
}
