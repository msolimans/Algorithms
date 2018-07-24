package com.hackerrank.Warmup;

import java.util.Scanner;

/**
 * Created by msoliman on 5/9/17.
 *
 * https://www.hackerrank.com/challenges/staircase?h_r=next-challenge&h_v=zen
 *
 * <p>
 * Consider a staircase of size :
 * <p>
 * #
 * ##
 * ###
 * ####
 * Observe that its base and height are both equal to , and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.
 * <p>
 * Write a program that prints a staircase of size .
 * <p>
 * Input Format
 * <p>
 * A single integer, , denoting the size of the staircase.
 * <p>
 * Output Format
 * <p>
 * Print a staircase of size  using # symbols and spaces.
 * <p>
 * Note: The last line must have  spaces in it.
 * <p>
 * Sample Input
 * <p>
 * 6
 * Sample Output
 * <p>
 * #
 * ##
 * ###
 * ####
 * #####
 * ######
 * Explanation
 * <p>
 * The staircase is right-aligned, composed of # symbols and spaces, and has a height and width of
 */
public class p_6_StairCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(run_recursive(i - 1, i));
        System.out.println(run(i, i));


//        System.out.println(run_recursive(2,3));
//        System.out.println(run_recursive(3,4));
//
//
//        System.out.println(run(4,4));
//        System.out.println(run(2,3));


    }

    static String run(int n, int l) {
        StringBuilder stringBuilder = new StringBuilder();

        while (--n >= 0) {
            for (int i = 0; i < l; i++) {
                if (i < n)
                    stringBuilder.append(" ");
                else
                    stringBuilder.append("#");

            }
            stringBuilder.append("\n");

        }

        return stringBuilder.toString();
    }

    static String run_recursive(int n, int l) {
        if (n < 0)
            return "";

        char[] arr = new char[l];
        for (int i = 0; i < n; i++)
            arr[i] = ' ';
        for (int i = n; i < l; i++) {
            arr[i] = '#';
        }

        return String.valueOf(arr) + "\n" + run_recursive(n - 1, l);
    }


}
