package com.probs;

import java.util.Stack;

/**
 * Created by msoliman on 4/26/17.
 */
public class p_8_BinaryToDecimal {
    //convert from a decimal to binary
    public static void main(String[] args){
        System.out.println(String.format("binary(%s) = %s", 10, run(10)));
        System.out.println(String.format("binary(%s) = %s", 100, run(100)));
        System.out.println(String.format("binary(%s) = %s", 8, run(8)));
        System.out.println(String.format("binary(%s) = %s", 128, run(128)));
    }

    static String run(int num){
        //you can use stack too here instead of string however u still have to manager to pop all elements at the end
        //Stack<Integer> s = new Stack();
        //s.push()
        //while(!s.empty())
            //s.pop();

        StringBuilder builder = new StringBuilder();
        while(num > 0){
            int rem = num % 2;
            num = num/2;

            builder.append(rem);
        }

        return builder.reverse().toString();
    }



}
