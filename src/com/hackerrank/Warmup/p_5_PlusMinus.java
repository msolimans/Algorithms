package com.hackerrank.Warmup;

import java.util.Scanner;

/**
 * Created by msoliman on 5/9/17.
 * https://www.hackerrank.com/challenges/plus-minus?h_r=next-challenge&h_v=zen
 * Given an array of integers, calculate which fraction of its elements are positive, which fraction of its elements are negative, and which fraction of its elements are zeroes, respectively. Print the decimal value of each fraction on a new line.
 * <p>
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the size of the array.
 * The second line contains  space-separated integers describing an array of numbers .
 * <p>
 * Output Format
 * <p>
 * You must print the following  lines:
 * <p>
 * A decimal representing of the fraction of positive numbers in the array compared to its size.
 * A decimal representing of the fraction of negative numbers in the array compared to its size.
 * A decimal representing of the fraction of zeroes in the array compared to its size.
 * Sample Input
 * <p>
 * 6
 * -4 3 -9 0 4 1
 * Sample Output
 * <p>
 * 0.500000
 * 0.333333
 * 0.166667
 * Explanation
 * <p>
 * There are  positive numbers,  negative numbers, and  zero in the array.
 * The respective fractions of positive numbers, negative numbers and zeroes are ,  and , respectively.
 */
public class p_5_PlusMinus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        float length = count;

        int p = 0;
        int n = 0;
        int z = 0;

        int num = 0;

        while (--count >= 0.0f) {
            num = sc.nextInt();

            if (num == 0)
                z++;
            else if (num > 0)
                p++;
            else
                n++;
        }



        System.out.printf("%2.6f\n", p/length);
        System.out.printf("%2.6f\n",n/length);
        System.out.printf("%2.6f\n",z/length);

    }

}

