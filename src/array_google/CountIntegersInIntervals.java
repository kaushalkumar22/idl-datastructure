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
        countIntervals.add(39, 44);  // add [2, 3] to the set of intervals.
        countIntervals.add(13, 49); // add [7, 10] to the set of intervals.
        System.out.println( countIntervals.count()); // return 6
        // the integers 2 and 3 are present in the interval [2, 3].
        // the integers 7, 8, 9, and 10 are present in the interval [7, 10].
        countIntervals.add(47,50);  // add [5, 8] to the set of intervals.
        System.out.println( countIntervals.count());    // return 8
    }

    private List<int[]> intervals ;
    private int integersCount = 0;
    public CountIntegersInIntervals() {

        intervals = new ArrayList<>();
    }
    //[[],[],[39,44],[13,49],[],[],[47,50]]
    public void add(int left, int right) {
        int[] newInterval ={left,right};
        integersCount=0;
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<intervals.size();i++){
            int[] interval =intervals.get(i);
            if(interval[1]<newInterval[0]){
                res.add(interval);
                integersCount += (interval[1]-interval[0] +1);
            }else if(interval[0]>newInterval[1]){
                res.add(newInterval);
                integersCount += (newInterval[1]-newInterval[0] +1);
                while(i++<intervals.size()){
                    integersCount += (intervals.get(i)[1]-intervals.get(i)[0] +1);
                    res.add(intervals.get(i));
                }
            }else {
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
        }
        res.add(newInterval);
        integersCount += (newInterval[1]-newInterval[0] +1);
        intervals = res;
    }

    public int count() {
        return integersCount;
    }


}
