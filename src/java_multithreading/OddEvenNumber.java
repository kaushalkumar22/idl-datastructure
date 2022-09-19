package java_multithreading;

public class OddEvenNumber implements Runnable{

    public static void main(String[] args) {
        Runnable odd = new OddEvenNumber();
       Runnable even = new OddEvenNumber();
        Thread t1= new Thread(odd,"Thread1");
        Thread t2 =new Thread(even, "Thread2");
        t1.start();
        t2.start();
       // t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void run() {
        for (int i=1;i<20;i++){
            if(i%2==0&&Thread.currentThread().getName().equals("Thread1")){
                even(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else {
                odd(i);
            }
        }
    }

   boolean available = true;
    public  void odd(int odd){
        System.out.println(Thread.currentThread().getName()+" "+ odd);
    }
    public  void even(int even){
        System.out.println(Thread.currentThread().getName()+" "+ even);
    }
}
