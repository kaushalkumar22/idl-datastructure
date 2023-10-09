package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a", "b", "c"));
        list.add(Arrays.asList("d", "e", "f"));
        list.add(Arrays.asList("g", "h", "i"));
        list.add(Arrays.asList("j", "k", "l"));

        // filter() method do not work on stream of collections
        list.stream().filter(x -> "a".equals(x.toString()))
        //This will not print anything
        .forEach(System.out::println);
        // Flattened the stream.
        list.stream().flatMap(p->p.stream()).filter(p->p.equals("h")).forEach(System.out::println);
        list.stream().flatMap(p->p.stream()).mapToInt(p->p.length()).forEach(System.out::println);
        //Applied filter on flattened stream.
    }
}
