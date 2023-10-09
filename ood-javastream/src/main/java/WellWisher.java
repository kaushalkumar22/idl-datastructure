public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        // We are passing an anonymous class object to the wish method.
        wish(new Greeting() {
            @Override
            public void greet() {
                System.out.println("1");
            }
        });
        wish(() ->{
            System.out.println("2");
        });
        wish(() ->
                System.out.println("3")
        );
    }
}

interface Greeting {
    void greet();
}