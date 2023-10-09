package a_util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSteam {

    public static void main(String[] args) {
        //Stream<Integer> stream = Stream.of(1,2,3,4,4,5,6);
       // stream.forEach(p->System.out.println(p));
        List<Integer> li = new ArrayList<>(){{add(10);add(20);add(30);add(40);add(50);}};
        li.stream().filter(p->p>20).forEach(System.out::println);

    }
}
