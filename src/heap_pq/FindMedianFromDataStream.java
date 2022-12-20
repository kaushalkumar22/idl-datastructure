package heap_pq;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value,
 * and the median is the mean of the two middle values.
 *
 *     For example, for arr = [2,3,4], the median is 3.
 *     For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 *
 * Implement the MedianFinder class:
 *
 *     MedianFinder() initializes the MedianFinder object.
 *     void addNum(int num) adds the integer num from the data stream to the data structure.
 *     double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 *
 * Constraints:
 *
 *     -105 <= num <= 105
 *     There will be at least one element in the data structure before calling findMedian.
 *     At most 5 * 104 calls will be made to addNum and findMedian.
 *
 * Follow up:
 *     If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 *     If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */
public class FindMedianFromDataStream {

	/*
	 * keep two heaps (or priority queues):
	 * 
	 * Max-heap small has the smaller half of the numbers. Min-heap large has
	 * the larger half of the numbers. This gives me direct access to the one or
	 * two middle values (they're the tops of the heaps), so getting the median
	 * takes O(1) time. And adding a number takes O(log n) time.
	 * 
	 * Supporting both min- and max-heap is more or less cumbersome, depending
	 * on the language, so I simply negate the numbers in the heap in which I
	 * want the reverse of the default order. To prevent this from causing a bug
	 * with -231 (which negated is itself, when using 32-bit ints), I use
	 * integer types larger than 32 bits.
	 * 
	 * Using larger integer types also prevents an overflow error when taking
	 * the mean of the two middle numbers. I think almost all solutions posted
	 * previously have that bug.
	 * 
	 * Update: These are pretty short already, but by now I wrote even shorter
	 * ones.
	 */

	public static void main(String[] args) {
		FindMedianFromDataStream mediun = new FindMedianFromDataStream();
		mediun.addNum(2);
		mediun.addNum(3);
		//System.out.println(mediun.findMedian());
		mediun.addNum(4);
		//mediun.addNum(5);
		//mediun.addNum(6);

		System.out.println(maxpq.peek());
		System.out.println(minpq.peek());
		System.out.println(mediun.findMedian());


	}
	private static PriorityQueue<Integer> maxpq;
	private static PriorityQueue<Integer> minpq;

	public FindMedianFromDataStream() {
		minpq = new PriorityQueue<Integer>();
		maxpq = new PriorityQueue<Integer>(Comparator.reverseOrder());
	}

	public void addNum(int num) {
		maxpq.offer(num);
		minpq.offer(maxpq.poll());
		if(maxpq.size()<minpq.size()) {
			maxpq.offer(minpq.poll());
		}
	}

	public double findMedian() {	
		return (maxpq.size()==minpq.size())?((maxpq.peek()+minpq.peek())/2.0): maxpq.peek();
	}
}