package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1,"abc");
        Employee emp2 = new Employee(1,"abc");
        Map<Employee,Boolean> set = new HashMap();
        set.put(emp1,true);
        set.put(emp2,true);
        System.out.println("Size: "+set.size());
    }
}
class Employee{
    int id;
    String name;
    Employee(int id ,String name){
       this.id =id;
       this.name = name;
    }
}