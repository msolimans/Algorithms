package com.g4g.basic;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.Scanner;


//Swap two nibbles in a byte
//Show Topic Tags

/**
 * Bit Manipulation, Array
 */

/*Description*/
//******************************************************************************************************************
//Given a byte, swap the two nibbles in it. For example 100 is be represented as 01100100 in a byte (or 8 bits). The two nibbles are (0110) and (0100). If we swap the two nibbles, we get 01000110 which is 70 in decimal.

//Input:
//
//        The first line contains 'T' denoting the number of testcases. Each testcase contains a single positive integer X.
//
//
//        Output:
//
//        In each separate line print the result after swapping the nibbles.
//
//
//        Constraints:
//
//        1 ≤ T ≤ 70
//        1 ≤ X ≤ 255
//
//
//        Example:
//
//        Input:
//
//        2
//        100
//        129
//
//        Output:
//
//        70
//        24
//

//******************************************************************************************************************
//Companies: Samsung
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte/0/?ref=self
//******************************************************************************************************************

public class SwapTwoNibblesInByte {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            //it is small integers (only 8 bits)
            System.out.println(run2(scan.nextInt()));
        }
    }

    //pure bit manipulation
    static int run(int n){
        //we can deal with it like an array

        char c = 0;
        int result = 0;


        for(char i = 4;i <8;i++){
            if((n & (1 << i)) > 0)
                result += Math.pow(2, c);

            c++;
        }

        for(char i = 0;i <4;i++){
            if((n & (1 << i)) > 0)
                result += Math.pow(2, c);

            c++;
        }


        return result;
    }

    //2 linked list as queue to save the order of bits
    static int run2(int n) {
        LinkedList<Boolean> right = new LinkedList<>();
        LinkedList<Boolean> left = new LinkedList<>();

        for(char i = 0;i<8;i++){

            if(i<4)
                right.addLast((n & (1 << i)) > 0);
            else
                left.addLast((n & (1 << i)) > 0);
        }

        int i = 0; int result = 0;
        while(!left.isEmpty()){
            if(left.pollFirst())
                result += Math.pow(2,i);

            i++;
        }

        while(!right.isEmpty()){
            if(right.pollFirst())
                result += Math.pow(2,i);

            i++;
        }

        return result;
    }
}
