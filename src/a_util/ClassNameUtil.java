package a_util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClassNameUtil {
    public static void main(String[] args) {
        String s ="Maximum Number of Events That Can Be Attended\r\n";
        String[] ss = s.split(" ");
        String name="";
        for(String str :ss){
            name+= str.substring(0, 1).toUpperCase()+ str.substring(1);
        }
        System.out.println(name);
        System.out.println("grid = [[0,1,0],[0,0,0],[0,0,1]]"
                .replace("[", "{")
                .replace("]", "}")
                        .replace("\"", "'"));
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> it = set.iterator();
        for(Integer stock : set){
            System.out.println(stock);
        }



    }
}
