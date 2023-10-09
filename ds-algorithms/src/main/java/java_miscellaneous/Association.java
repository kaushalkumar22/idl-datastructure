package java_miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class Association {

	public static void main(String[] args) {

		//Create two professor objects
		Professor ak = new Professor("Arun Kumar");
		Professor ry = new Professor("Rahul Yadav");

		//Create a department
		Department cse = new Department("CSE");

		//Add the professors to a list and add this list to department
		List<Professor> staff_cse = new ArrayList<Professor>();
		staff_cse.add(ak);
		staff_cse.add(ry);

		//Add staff to cse department
		cse.setStaff(staff_cse);

		//Output

		System.out.println("The staff of department " + cse.getName() + " is: " + cse.getStaff());


	}

}
class Professor {
	private String name;

	//Assign professor name
	Professor(String name)
	{
		this.name = name;
	}

	//Retrieve name
	public String getName()
	{
		return this.name;
	}

}

//Department Class
class Department {
	private String name;
	List<Professor> staff;

	//Assign department name
	Department(String name)
	{
		this.name = name;
	}

	//Retrieve name
	public String getName()
	{
		return this.name;
	}

	//Assign list of department staff
	public void setStaff(List<Professor> staff)
	{
		this.staff = staff;
	}

	//Return the list of staff names
	public List<String> getStaff()
	{

		List<String> professor_names = new ArrayList<String>();
		for(Professor prof : this.staff)
		{
			professor_names.add(prof.getName()); //add name of each professor to names list
		}
		return professor_names; // return names list
	}
}



