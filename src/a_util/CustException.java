package a_util;
	111
import java.io.FileNotFoundException;
import java.io.IOException;

public class CustException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustException() {
		super();
	}
	public static void main(String args[]){
		SuperClass s = new SubClass();
		try {
			s.method();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class SuperClass {
	void method() throws Error {
		System.out.println("SUP");
	}
}
class SubClass extends SuperClass {
	void method() {//OK ,IOException//Exception
		//{Exception IOException is not compatible with throws clause in SuperClass.method()
		System.out.println("SUB");
	}
}