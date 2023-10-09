package commons;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Immutable {
    public static void main(String[] args) {
        List<Address> addressList = Arrays.asList(new Address("123"),new Address("432"),new Address("654"));
        Employee emp = new Employee("abc",120,addressList);
        System.out.println(emp.getName());
        emp.getAddressList().add(new Address("1000"));

    }

}
final class Employee {
    final private  String name;
    final private  int id ;
    final private List<Address> addressList ;

   public  Employee(String name, int id, List<Address> addressList){
       this.name = name;
       this.id = id;
       this.addressList = Collections.unmodifiableList(addressList);
   }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}
class Address{
    String add;
    public Address(String add){
        this.add = add;
    }
}