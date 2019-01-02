package com.probs;

/**
 * Created by msoliman on 4/23/17.
 */
public class p_5_PowerOf4 {

    //Problem 5:
    // check if given number is power of 4
    public static void main(String[] args){
        //series: 4^0       -       4^1     -       4^2     -       4^3         -       4^4
        //series: 2^2^0     -       2^2^1   -       2^2^2   -       2^2^3       -       2^2^4
        //series: 2^0       -       2^2     -       2^4     -       2^6         -       2^8         (even numbers in the power of 2)
        //series: 1         -       4       -       16      -       64          -       512
        //series: 0001      -       0100    -       10000   -       1000000     -       100000000   (positions of 1's come in odd places, this what should check for)
        //positions of 1's come in odd places if it's 1-based index array or in even position if it's 0-based index array of bits, this what should check for

        System.out.println(String.format("%d: %s", 2, run(2)));
        System.out.println(String.format("%d: %s", 11, run(11)));
        System.out.println(String.format("%d: %s", 16, run(16)));

    }

    public static boolean run(int num){

        boolean isCorrect = false;

        //only one bit should come as 1 and in odd position
        for(int i= 0 ; i < 32;i++){

            if((num & (1 << i)) > 0){
                if(i%2 > 0) return false;

                if(isCorrect)

                    return false;

                else
                    isCorrect = true;

            }



        }

        return  isCorrect;

    }
}
