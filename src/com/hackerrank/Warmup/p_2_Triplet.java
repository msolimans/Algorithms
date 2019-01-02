package com.hackerrank.Warmup;

import java.util.Scanner;

/**
 * Created by msoliman on 5/9/17.
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from  to  for three categories: problem clarity, originality, and difficulty.

 We define the rating for Alice's challenge to be the triplet , and the rating for Bob's challenge to be the triplet .

 Your task is to find their comparison points by comparing  with ,  with , and  with .

 If , then Alice is awarded  point.
 If , then Bob is awarded  point.
 If , then neither person receives a point.
 Comparison points is the total points a person earned.

 Given  and , can you compare the two challenges and print their respective comparison points?

 Input Format

 The first line contains  space-separated integers, , , and , describing the respective values in triplet .
 The second line contains  space-separated integers, , , and , describing the respective values in triplet .

 Constraints



 Output Format

 Print two space-separated integers denoting the respective comparison points earned by Alice and Bob.

 Sample Input

 5 6 7
 3 6 10
 Sample Output

 1 1
 Explanation

 In this example:



 Now, let's compare each individual score:

 , so Alice receives  point.
 , so nobody receives a point.
 , so Bob receives  point.
 Alice's comparison score is , and Bob's comparison score is . Thus, we print 1 1 (Alice's comparison score followed by Bob's comparison score) on a single line.

 https://www.hackerrank.com/challenges/compare-the-triplets?h_r=next-challenge&h_v=zen
 */
public class p_2_Triplet {
    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        // Complete this function
        int alice = 0;
        int bob = 0;


        if(a0 > b0)
            alice++;
        else if(a0 < b0)
            bob++;

        if(a1 > b1)
            alice++;
        else if(a1 < b1)
            bob++;

        if(a2 < b2)
            bob++;
        else if(a2 > b2)
            alice++;


        return new int[]{alice,bob};

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int[] result = solve(a0, a1, a2, b0, b1, b2);

        String separator = "", delimiter = " ";

        for (Integer value : result) {
            System.out.print(separator + value);
            separator = delimiter;
        }
        System.out.println("");


    }


}
