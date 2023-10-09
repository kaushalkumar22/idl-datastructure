package a_util;

public class TestInterface {

    public static void main(String[] args) {

    }
}
interface HView{
    void executeHview();
}
class TestA implements HView{

    @Override
    public void executeHview() {
        System.out.println("invoking method A");
    }
}
class TestB implements HView{

    @Override
    public void executeHview() {
        System.out.println("invoking method B");
    }
}