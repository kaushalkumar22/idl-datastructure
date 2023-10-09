package array_google;

import java.util.*;

/**
 * Given an empty set of intervals, implement a data structure that can:
 *
 *     Add an interval to the set of intervals.
 *     Count the number of integers that are present in at least one interval.
 *
 * Implement the CountIntervals class:
 *
 *     CountIntervals() Initializes the object with an empty set of intervals.
 *     void add(int left, int right) Adds the interval [left, right] to the set of intervals.
 *     int count() Returns the number of integers that are present in at least one interval.
 *
 * Note that an interval [left, right] denotes all the integers x where left <= x <= right.
 *
 * Input
 * ["CountIntervals", "add", "add", "count", "add", "count"]
 * [[], [2, 3], [7, 10], [], [5, 8], []]
 * Output
 * [null, null, null, 6, null, 8]
 *
 * Explanation
 * CountIntervals countIntervals = new CountIntervals(); // initialize the object with an empty set of intervals.
 * countIntervals.add(2, 3);  // add [2, 3] to the set of intervals.
 * countIntervals.add(7, 10); // add [7, 10] to the set of intervals.
 * countIntervals.count();    // return 6
 *                            // the integers 2 and 3 are present in the interval [2, 3].
 *                            // the integers 7, 8, 9, and 10 are present in the interval [7, 10].
 * countIntervals.add(5, 8);  // add [5, 8] to the set of intervals.
 * countIntervals.count();    // return 8
 *                            // the integers 2 and 3 are present in the interval [2, 3].
 *                            // the integers 5 and 6 are present in the interval [5, 8].
 *                            // the integers 7 and 8 are present in the intervals [5, 8] and [7, 10].
 *                            // the integers 9 and 10 are present in the interval [7, 10].
 * Constraints:
 *
 *     1 <= left <= right <= 109
 *     At most 105 calls in total will be made to add and count.
 *     At least one call will be made to count.
 *
 * ["CountIntervals","count","add","add","count","count","add"]
 *
 * 19 / 73 testcases passed
 * Output
 * [null,0,null,null,6,6,null]
 * Expected
 * [null,0,null,null,37,37,null]
 */
public class CountIntegersInIntervals {
    public static void main(String[] args) {
        CountIntegersInIntervals countIntervals = new CountIntegersInIntervals(); // initialize the object with an empty set of intervals.
<<<<<<< HEAD
        countIntervals.add(39, 44);  // add [2, 3] to the set of intervals.
        System.out.println(countIntervals.count()); // return 6
        // the integers 2 and 3 are present in the interval [2, 3].
        // the integers 7, 8, 9, and 10 are present in the interval [7, 10].
        countIntervals.add(47, 50);  // add [5, 8] to the set of intervals.
        countIntervals.add(13, 49); // add [7, 10] to the set of intervals.

        System.out.println(countIntervals.count());    // return 8
    }
    TreeMap<Integer, Integer> intervalTreeMap;
    public CountIntegersInIntervals (){
        intervalTreeMap = new TreeMap<>();
    }
    int intCount = 0;

    public void add(int left, int right) {
        Integer floor = intervalTreeMap.floorKey(right);
        while(floor!=null && intervalTreeMap.get(floor)>=left){
            int smallLeft = floor;
            int smallRight = intervalTreeMap.get(floor);
            intCount -= (smallRight-smallLeft+1);
            left = Math.min(left,floor);
            right = Math.max(right,smallRight);
            intervalTreeMap.remove(smallLeft);
            floor = intervalTreeMap.floorKey(right);
        }
        intervalTreeMap.put(left,right);
        intCount += (right-left+1);
    }

    public int count() {
        return intCount;
    }
}
=======
        countIntervals.add(39, 44);
        countIntervals.add(13, 49);
        System.out.println( countIntervals.count());
        countIntervals.add(47,50);
       // countIntervals.add(11, 11);
        System.out.println( countIntervals.count());
    }
    private TreeMap<Integer,Integer> intervals;
    private int count ;
    public CountIntegersInIntervals(){
        intervals = new TreeMap<>();
    }

    public void add(int left ,int right){
        Integer currLeft = intervals.floorKey(right);
        while(currLeft!= null && intervals.get(currLeft)>=left){
            int currRight = intervals.get(currLeft);
            intervals.remove(currLeft);
            count -= (currRight-currLeft+1);
            left  = Math.min(left,currLeft);
            right = Math.max(right,currRight);
            currLeft = intervals.floorKey(right);
        }
        intervals.put(left,right);
        count += (right-left+1);
    }
   public int count(){
       return count;
    }

}
>>>>>>> 8a047339a54026e2e27a7b38d9ad047d99d1d6b7
