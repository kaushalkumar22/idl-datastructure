package com.algo.bitmanipulation;

public class ReverseBits {

    public int reverse(int num){
        //assuming int is 32 bits.
        int result = 0;
        int r1 = 1;
        for(int i=16; i >= 0; i--,r1<<=1){
            if((num & 1<<i) != 0){
                result = result | r1;
            }
        }
        return result;
    }
    
    
    public static void main(String args[]){
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverse(418));
    }
}