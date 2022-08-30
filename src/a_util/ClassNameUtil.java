package a_util;

public class ClassNameUtil {
    public static void main(String[] args) {
        String s ="Minimum Cost to Connect Sticks";
        String[] ss = s.split(" ");
        String name="";
        for(String str :ss){
            name+= str.substring(0, 1).toUpperCase()+ str.substring(1);
        }
        System.out.println(name);
    }
}
