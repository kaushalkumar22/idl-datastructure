package a_util;
	
import java.io.FileNotFoundException;
import java.io.IOException;

public class CustException extends Exception{
	public CustException(String message) {
		super(message);
	}

	public CustException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustException(Throwable cause) {
		super(cause);
	}

	protected CustException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

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