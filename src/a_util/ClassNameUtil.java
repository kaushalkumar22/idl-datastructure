package a_util;

public class ClassNameUtil {
    public static void main(String[] args) {
        String s ="Maximum Number of Events That Can Be Attended\r\n";
        String[] ss = s.split(" ");
        String name="";
        for(String str :ss){
            name+= str.substring(0, 1).toUpperCase()+ str.substring(1);
        }
        System.out.println(name);
        System.out.println(
                " matrix = [[9,9,4],[6,6,8],[2,1,1]]"
                .replace("[", "{")
                .replace("]", "}")
                        .replace("\"", "'"));

    }
}
