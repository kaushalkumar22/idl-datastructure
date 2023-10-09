package array_google;

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
    }
}
