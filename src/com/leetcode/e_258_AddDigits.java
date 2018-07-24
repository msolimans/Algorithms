package com.leetcode;

/**
 * Created by msoliman on 5/8/17.
 */
public class e_258_AddDigits {
    public static void main(String[] args){

        System.out.println(run(19));

    }

    static int run(int num){


        while(true) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if(sum % 10 == sum)
                return sum;

            num = sum;
        }
    }
}
