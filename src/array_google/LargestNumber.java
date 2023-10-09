package array_google;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber( new int[]{3,30,34,5,9}));
    }
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for(int i =0;i<n;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(a,b)-> (b+a).compareTo(a+b));
        String res="";
        for(int i =0;i<n;i++){
           res+=strs[i];
        }
      return res;
    }
}
