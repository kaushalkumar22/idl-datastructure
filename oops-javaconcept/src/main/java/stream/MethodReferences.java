package stream;

import java.util.ArrayList;
import java.util.List;

public class MethodReferences {
    public static int getLength(String str){
        return str.length();
    }
    public  int length(String str){
        return str.length();
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("word");
        list.add("practice");
        list.add("fake");
        list.stream().map(a->MethodReferences.getLength(a)).forEach(System.out::println);
        list.stream().mapToInt(MethodReferences::getLength).forEach(System.out::println);
        MethodReferences mr = new MethodReferences();
        list.stream().map(a->mr.length(a)).forEach(System.out::println);
        list.stream().mapToInt(mr::length).forEach(System.out::println);
        list.stream().mapToInt(new MethodReferences()::length).forEach(System.out::println);


    }
}
