package a_util;

import java.util.ArrayList;
import java.util.List;

public class TestJava {
    public static void main(String[] args) {
        List<Integer> list1= new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        System.out.println(list1);
    }
}
