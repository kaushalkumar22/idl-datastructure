package a_util;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableComparator{

    public static void main(String[] args) {
        Emps[] comp = new Emps[10];
        for (int i = 100; i > 90; i--) {
            comp[i-91] = new Emps(i, "name_" + i, 1000.5 + i);
        }
        System.out.println(Arrays.toString(comp));
        Arrays.sort(comp,Emps.NAME_COMP);
        System.out.println(Arrays.toString(comp));
    }
}
class Emps implements Comparable<Emps>{

    private int id;
    private String name;
    private double salary;

    public Emps(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emps e) {
        return Integer.compare(e.id,this.id);
    }

    public static Comparator<Emps> ID_COMP = new Comparator<Emps>() {
        @Override
        public int compare(Emps e1, Emps e2) {
            return Integer.compare(e1.id, e2.id);
        }
    };
    public static Comparator<Emps> NAME_COMP = new Comparator<Emps>() {
        @Override
        public int compare(Emps e1, Emps e2) {
            return e1.name.compareTo(e2.name);
        }
    };
    public static Comparator<Emps> SALARY_COMP = new Comparator<Emps>() {
        @Override
        public int compare(Emps e1, Emps e2) {
            return Double.compare(e1.salary,e2.salary);
        }
    };

    @Override
    //this is required to print the user-friendly information about the Emps
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

    public static Comparator<Emps> getIdComp() {
        return ID_COMP;
    }

    public static Comparator<Emps> getNameComp() {
        return NAME_COMP;
    }

    public static Comparator<Emps> getSalaryComp() {
        return SALARY_COMP;
    }


}
