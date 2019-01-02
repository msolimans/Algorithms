package com.probs;

/**
 * Created by msoliman on 4/26/17.
 */
public class p_9_MaximumExecutiveOnes {

    //convert from decimal to binary and give me what's the maximum consecutive ones
    public static void main(String[] args){
        System.out.println(run(10));
        System.out.println(run(13));
        System.out.println(run(128));

    }

    static int run(int num){
        int maxTotal = 0;
        int max  = 0;

        while(num > 0){
            int rem = num % 2;
            num = num / 2;
            if(rem == 1)
                max++;


            if(maxTotal < max)
                maxTotal = max;


            if(rem == 0)
                max = 0;


        }



        return maxTotal;
    }
}
