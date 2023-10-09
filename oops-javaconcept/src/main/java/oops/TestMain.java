package oops;

public class TestMain{
    public static void main(String[] args) {
      System.out.println(new Test().display());
    }
}

interface A {
     String display();
}
interface B {
     String display();
}

class Test implements B,A{

    @Override
    public String display() {
        return "Hi";
    }
}
