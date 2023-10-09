package linkedlist_mergesort.java_multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQue = new ArrayBlockingQueue<>(5);
        new Thread(new Producer(blockingQue)).start();
        new Thread(new Consumer(blockingQue)).start();
    }
}
class Producer implements Runnable{
    BlockingQueue<String> blockingQue;

    public Producer(BlockingQueue<String> blockingQue) {
        this.blockingQue = blockingQue;
    }

    @Override
    public void run() {

        try {
            for(int i=1;i<10;i++) {
                System.out.println("Producing message"+i);
                blockingQue.offer("message"+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class Consumer implements Runnable{
    BlockingQueue<String> blockingQue;

    public Consumer(BlockingQueue<String> blockingQue) {
        this.blockingQue = blockingQue;
    }

    @Override
    public void run() {

        while (true){
            try {
                System.out.println("Consuming "+blockingQue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}