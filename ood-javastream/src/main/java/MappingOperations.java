import java.util.ArrayList;
import java.util.List;

public class MappingOperations {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Joe");
        list.add("Ryan");
        list.add("Iyan");
        list.add("Ray");

        list.stream().map(p->p.toLowerCase()).forEach(System.out::println);
        list.stream().mapToInt(p->p.length()).forEach(System.out::println);

    }

}
