package com.g4g.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


//Three Great Candidates
//Show Topic Tags

/**
 * Array, Maths, Negative Multiplication can produce big positive numbers
 */

/*Description*/
//******************************************************************************************************************
// The hiring team of Google aims to find 3 candidates who are great collectively. Each candidate has his or her ability expressed as an integer. 3 candidate are great collectively if product of their abilities is maximum. Find the maximum collective ability from the given pool of candidates.

//Input:
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. First line of each test case conatins an interger N  denoting the number of candidates.
//        The second line of each test case contains N space separated elements denoting the ablities of candidates.
//
//
//        Output:
//        Corresponding to each test case, print the desired output(maximum collective ability of three candidates) in a newline.
//
//
//        Constraints:
//        1 ≤ T ≤ 100
//        3 ≤ N ≤ 1000
//        -1000 ≤ ability ≤ 1000
//
//
//        Example:
//        Input
//        1
//        6
//        0 -1 3 100 70 50
//
//        Output:
//        350000
//
//        Explanation
//        70*50*100 = 350000 which is the maximum possible.

//Hints: consider negative values multiplies together will produce positive numbers.

//1 86
//386 277 415 293 -165 -114 -8 149 -79 -138 -473 190 -441 263 426 40 -74 -328 236 -289 -132 67 -71 282 30 362 -377 -433 -365 429 302 -478 -442 -431 -333 -107 -44 -489 -458 -271 -127 -79 419 284 37 -302 -176 -185 -130 -87 26 -409 480 456 373 362 -330 496 -219 -195 425 -416 -173 -164 5 346 229 -187 357 -376 395 82 45 314 -133 -66 -136 -457 250 -413 308 -224 -322 288 84 -97
//Expected: 115936032
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/three-great-candidates/0/?ref=self
//******************************************************************************************************************

public class ThreeGreateCandidates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (--T >= 0) {
            int len = scan.nextInt();
            int[] arr = new int[len];
            for(int i = 0;i< len;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(run(arr));
        }
    }



    //using heaps (Priority Queue) O(n) as long as our queu is of constant size (3 items only)
    static int run(int[] arr) {
        //simple, just find products of the HIGHEST numbers for 3 candidates
        PriorityQueue<Integer> descinding_pq = new PriorityQueue<>(3, Collections.reverseOrder());
        PriorityQueue<Integer> ascending_pq = new PriorityQueue<>(2);

        for(int i: arr){
            descinding_pq.add(i);

            ascending_pq.add(i);
        }



        int highest = descinding_pq.poll();
        int highBound = descinding_pq.poll() * descinding_pq.poll();

        int lowBound = ascending_pq.poll() * ascending_pq.poll();

        if(highBound>lowBound)
            return highest * highBound;

        return  highest * lowBound;

    }


    //sort then get the last 3 elems. O(nlogn)
    static int run1(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        if(arr[arr.length - 2] * arr[arr.length - 3] > arr[0] * arr[1])
        return arr[arr.length - 1]  * arr[arr.length - 2] * arr[arr.length - 3];
        else
            return arr[arr.length - 1]  * arr[0] * arr[1];
    }


}
