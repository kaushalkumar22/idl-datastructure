package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
          //PriorityQueue<Integer> pq = new  PriorityQueue<Integer>(Comparator.reverseOrder());
          PriorityQueue<Integer> pq = new  PriorityQueue<Integer>();
          pq.offer(100);
          pq.offer(20);
          pq.offer(15);
          pq.offer(9);
          pq.offer(11);
          pq.offer(20);
          
          System.out.println(pq.poll());
	}
}
