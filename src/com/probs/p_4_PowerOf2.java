package com.probs;

/**
 * Created by msoliman on 4/23/17.
 */
public class p_4_PowerOf2 {


    //Problem 4:
    // check if given number is power of two

    public static void main(String[] strs){

        System.out.println(String.format("%d: %s", 2, run(2)));
        System.out.println(String.format("%d: %s", 11, run(11)));
        System.out.println(String.format("%d: %s", 16, run(16)));

    }

    //Only one bit should come as 1
    //0001  2^0 = 1
    //0010  2^1 = 2
    //0100  2^2 = 4
    //1000  2^3 = 8
    public static  boolean run(int num){
        boolean isPowerof2= false;

        for(int c=0;c<32;c++){

            if((num & (1 << c)) > 0){
                if(isPowerof2)
                    return false;
                else
                    isPowerof2 = true;
            }

        }

        return isPowerof2;
    }

    //check other solutions in /g4g/basic/PowerOf2
}
