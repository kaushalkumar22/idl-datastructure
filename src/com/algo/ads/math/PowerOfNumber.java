package com.algo.ads.math;

public class PowerOfNumber 
{
    // computes value of 'a' power 'b'
    public double power(int a, int b)
    {
        // base case
        if (b == 0)
        {
            return 1;
        }
         
        // a^(-b) = 1/(a^b)
        if (b < 0)
        {
            return 1/power(a,-b);
        }
         
        if (b%2 == 0) // if 'b' is even
        {
            return power(a, b/2)*power(a, b/2);
        }
        else // if 'b' is odd
        {
            return a*power(a, (b-1)/2)*power(a, (b-1)/2);
        }
    }
     
    public static void main(String[] args) 
    {
        PowerOfNumber solution = new PowerOfNumber();
         
        int a = -2, b = -3;
         
        System.out.println(solution.power(a, b));
    }
}
