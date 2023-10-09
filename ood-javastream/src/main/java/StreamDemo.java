import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 4, 5, 6, 2, 3, 9, 3);
        integerStream.sorted().forEach(System.out::println);

        List<Integer> integerList = List.of(10, 20, 30, 40, 60, 15);
        integerList.stream().forEach(p -> System.out.println(p));

        //Created a list of integers
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(12);
        list1.add(6);

        list1.stream()                           // Created a stream from the list
                .filter(num -> num > 10)        //filter operation to get only numbers greater than 10
                .forEach(System.out::println);  // Printing each number in the list after filtering.


        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23));
        list.add(new Person("Joe", 18));
        list.add(new Person("Ryan", 54));
        list.add(new Person("Iyan", 5));
        list.add(new Person("Ray", 63));

        list.stream().filter(p->p.age>20 && p.age<50).forEach(System.out::println);
        list.stream()
                .filter(person -> person.getName() != null) // Filtering the object where name is not null
                .filter(person -> person.getAge() > 18) // Filtering the objects where age is greater than 18
                .filter(person -> person.getAge() < 60) // Filtering the objects where age is less than 60
                .forEach(System.out::println);

    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

