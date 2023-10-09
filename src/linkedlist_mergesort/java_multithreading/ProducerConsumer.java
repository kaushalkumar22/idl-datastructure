package linkedlist_mergesort.java_multithreading;

public class ProducerConsumer {
    public static void main(String[] args) {
        ResourceQueue rq = new ResourceQueue();
        new Thread(new Producer(rq)).start();
        Thread t =new Thread(new Consumer(rq));
       t.start();
      
       String s ="420";
    		   s+=20;
    		   System.out.println(s);

    }
    static class ResourceQueue{

        private boolean available = false;
        private int resource;
        public synchronized void put(int val){
            while(available){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            resource =val;
            available =true;
            notifyAll();
        }
        public synchronized int get(){
            while (!available){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            available =false;
            notifyAll();
            return resource;
        }
    }
    static class Producer implements Runnable {
        ResourceQueue rq;
        public Producer(ResourceQueue rq) {
            this.rq = rq;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i < 10; i++) {
                    System.out.println("Producing message" + i);
                    rq.put(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    static class Consumer implements Runnable {
        ResourceQueue rq;
        public Consumer(ResourceQueue rq) {
            this.rq = rq;
        }
        @Override
        public void run() {

            while (true) {
                try {
                    System.out.println("Consuming " + rq.get());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}