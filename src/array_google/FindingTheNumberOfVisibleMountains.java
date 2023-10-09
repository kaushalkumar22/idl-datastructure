package array_google;

<<<<<<< HEAD
import java.util.Arrays;

/**
 *
 */
public class FindingTheNumberOfVisibleMountains {
    public static void main(String[] args) {
        // int[][] peaks = {{2,2},{6,3},{5,4}};
       // int[][] peaks = {{2,2},{2,2}};
        int[][] peaks = {{7,5},{4,2}};
        //sorting need to do in such a way that if left co-ordinate are not equal then normal sorting,
        // if left co-ordinates equal then which has max Right co-ordinate will come first.
        Arrays.sort(peaks,(a,b)->(
                (a[0]-a[1])!=(b[0]-b[1]) ? Integer.compare((a[0]-a[1]),(b[0]-b[1])):
                        Integer.compare((b[0]+b[1]),(a[0]+a[1]))));
      System.out.println( visibleMountains(peaks));

    }
    public static int visibleMountains(int[][] peaks) {

        int res = 0;
        int maxRightSoFar = 0;
        for(int i =0 ;i< peaks.length;i++){
            int currMaxRight = peaks[i][0]+peaks[i][1];
            if(currMaxRight>maxRightSoFar){
                if(!isInvisible(peaks,i)){
                    res++;
                }
                maxRightSoFar = currMaxRight;
            }
        }
        return res;
    }
    private static boolean isInvisible(int[][] peaks,int i){
        return (i+1<peaks.length
                && (peaks[i][0] == peaks[i+1][0])
                && (peaks[i][1]==peaks[i+1][1]));
=======

import java.util.Arrays;

public class FindingTheNumberOfVisibleMountains {
    public static void main(String[] args) {
        int[][] peaks = {{6,3},{5,4},{2,2}};//2
        //int[][] peaks = {{1,3},{1,3}};//0
        Arrays.sort(peaks,(a,b)->Integer.compare((a[0]-a[1]),(b[0]-b[1])));
        for(int[] peak : peaks){
            System.out.println(Arrays.toString(peak));
        }

        System.out.println(visibleMountains(peaks));
    }
    public static int visibleMountains(int[][] peaks) {

        return 0;
>>>>>>> 8a047339a54026e2e27a7b38d9ad047d99d1d6b7
    }
}
