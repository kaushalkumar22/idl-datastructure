package a_util;

public class SecondLargest {

    public static void main(String[] args) {

        int[] A = {2,5,7,1,0};

            int n= A.length;

            int small  = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){

                int temp = small;
                small= Math.min(small,A[i]);

                if(temp!=small){
                    second =Math.min(temp,second);
                }else{
                    second =Math.min(second,A[i]);
                }

            }
        System.out.println(second);
        }
}
