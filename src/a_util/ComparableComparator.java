package a_util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ComparableComparator{

    public static void main(String[] args) {
        Employee[] comp = new Employee[10];
        for (int i = 100; i > 90; i--) {
            comp[i-91] = new Employee(i, "name_" + i, 1000.5 + i);
        }
        System.out.println(Arrays.toString(comp));
        Arrays.sort(comp,Employee.NAME_COMP);
        System.out.println(Arrays.toString(comp));
    }
}
class Employee implements Comparable<Employee>{

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        return Integer.compare(e.id,this.id);
    }

    public static Comparator<Employee> ID_COMP = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Integer.compare(e1.id, e2.id);
        }
    };
    public static Comparator<Employee> NAME_COMP = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.name.compareTo(e2.name);
        }
    };
    public static Comparator<Employee> SALARY_COMP = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.salary,e2.salary);
        }
    };

    @Override
    //this is required to print the user-friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name +  ", salary=" +
                this.salary + "]";
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public static Comparator<Employee> getIdComp() {
        return ID_COMP;
    }

    public static Comparator<Employee> getNameComp() {
        return NAME_COMP;
    }

    public static Comparator<Employee> getSalaryComp() {
        return SALARY_COMP;
    }


}
