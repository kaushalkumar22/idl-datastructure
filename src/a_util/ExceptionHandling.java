package a_util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionHandling {

    public static void main(String[] args) {
        System.out.println("my test Exception");
    }
    public void method1() throws Exception {
        System.out.println("my test Exception");
        method2();
    }
    public void method2() throws IOException{
        System.out.println("my test Exception");
    }
    public void method3() throws RuntimeException  {
        System.out.println("my test Exception");
        method4();
    }
    public void method4() throws NullPointerException {
        System.out.println("my test Exception");
    }
    public void execute(int i) throws FileNotFoundException {
        if(i == 1) {
        }
    }
    public void method6() throws NullPointerException {
        try{

        }catch (ArrayIndexOutOfBoundsException | NullPointerException ex){

        }
    }
    }
