package array_google;


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
    }
}
