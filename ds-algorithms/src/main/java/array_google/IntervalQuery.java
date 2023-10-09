package array_google;

import java.util.TreeMap;

public class IntervalQuery {
    public static void main(String[] args) {
        IntervalQuery intervalQuery =  new IntervalQuery();
        intervalQuery.add(2,5);
        System.out.println(intervalQuery.query( 3));
        System.out.println(intervalQuery.query( 6));
        intervalQuery.add(8,10);
        System.out.println(intervalQuery.query( 7));
        System.out.println(intervalQuery.query( 10));
        intervalQuery.add(4,11);
        System.out.println(intervalQuery.query( 7));
        System.out.println(intervalQuery.query( 11));
        System.out.println(intervalQuery.intervals);
    }
    TreeMap<Integer,Integer> intervals;
    public IntervalQuery(){
        intervals = new TreeMap<>();
    }

    public void add(int left ,int right){
        Integer currLeft = intervals.floorKey(right);
        while(currLeft!= null && intervals.get(currLeft)>=left){
            int currRight = intervals.get(currLeft);
            intervals.remove(currLeft);
            left  = Math.min(left,currLeft);
            right = Math.max(right,currRight);
            currLeft = intervals.floorKey(right);
        }
        intervals.put(left,right);
    }
    boolean query(int x){
        Integer key = intervals.floorKey(x);
        if(key==null) return false;
        int value = intervals.get(key);
        return key<=x&&value>=x ? true :false;
    }
}
