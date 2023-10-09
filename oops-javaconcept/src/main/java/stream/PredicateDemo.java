package stream;

import java.util.function.Predicate;

public class PredicateDemo {

    static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }


    public static void main (String args[]){
        Person person = new Person("Alex", 23);
        // Created a predicate. It returns true if age is greater than 18.
        Predicate<Person> predicate1 = p-> p.age>20;
        Predicate<Person> predicate2 = p-> p.age<30;
        Predicate<Person> predicate = predicate1.and(predicate2);
        Predicate<Person> predicate3 = predicate1.or(predicate2);
        boolean eligible = isPersonEligibleForVoting(person , predicate3);

        System.out.println("Person is eligible for voting: " + eligible);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}