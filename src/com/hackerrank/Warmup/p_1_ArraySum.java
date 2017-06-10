package com.hackerrank.Warmup;

import java.util.Scanner;

/**
 * Created by msoliman on 5/9/17.
 * Given an array of  integers, can you find the sum of its elements?

 Input Format

 The first line contains an integer, , denoting the size of the array.
 The second line contains  space-separated integers representing the array's elements.

 Output Format

 Print the sum of the array's elements as a single integer.

 Sample Input

 6
 1 2 3 4 10 11
 Sample Output

 31
 Explanation

 We print the sum of the array's elements

 https://www.hackerrank.com/challenges/simple-array-sum?h_r=next-challenge&h_v=zen

 */
public class p_1_ArraySum {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int sum = 0;

        while (--count>=0){
            sum += sc.nextInt();
        }

       System.out.print(sum);
    }


}
