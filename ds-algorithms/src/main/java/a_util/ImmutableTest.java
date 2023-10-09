package a_util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableTest {

public static void main(String[] args) {
	List<Employee> list = new ArrayList<>();
	list.add(new Employee("abc"));
	list.add(new Employee("def"));
	list.add(new Employee("kjhgfd"));
	Immutable im = new Immutable(100, "test", list);
	System.out.println(im.getEmp().get(0).getName());
	System.out.println(im.getEmp().get(2).getName());

	im.getEmp().add(new Employee("test"));
	System.out.println(im.getEmp().get(2).getName());
}
}
 final class Immutable {

	private final int id;
	private final String name;
	private final List<Employee> emp  ;

	public Immutable(int id, String name,List<Employee> emp) {
		this.id = id;
		this.name = name;
		//this.emp=emp;    
		this.emp= Collections.unmodifiableList(emp);  

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Employee> getEmp() {
		 Collections.unmodifiableList(emp);
		return emp;
	}
}
	
class Employee{
	String name;

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
