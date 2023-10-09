package array_google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * For example,
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {

    public static void main(String[] args) {
        MovingAverageFromDataStream average = new MovingAverageFromDataStream(3);
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));
    }
    private int size;
    private int count ;
    private Deque<Integer> deque;
    private int sum ;
    public MovingAverageFromDataStream(int size) {
       this.size = size;
       this.deque = new LinkedList<>();
       this.count = 0;
       this.sum = 0;
    }
    public double next(int val) {
        count++;
        deque.add(val);
        if(count <size){
            sum +=val;
            return (double) sum/count;
        }else{
            sum += val- deque.removeLast();
            return (double) sum/size;
        }
    }
}