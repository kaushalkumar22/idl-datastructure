package a_util;

public class InputFormater {
    public static void main(String[] args) {
        String s ="intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]";
        s = s.replace("[","{").replace("]","}").replace("\"","'");
        System.out.println(s);
    }
}
