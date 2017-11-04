package com.g4g.Easy;

import java.util.Scanner;


//Even and odd elements at even and odd positions
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array. The task is to arrange the array such that odd elements occupy the odd positions and even elements occupy the even positions. The order of elements must remain same. Consider zero-based indexing. After printing according to conditions, if remaining, print the remaining elements as it is.

//Input:
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.
//
//        Output:
//        For each test case, in a new line print the arranged array.
//
//        Constraints:
//        1<=T<=100
//        1<=N<=105
//        1<=A[i]<=105
//
//        Example:
//        Input:
//        2
//        6
//        1 2 3 4 5 6
//        4
//        3 2 4 1
//        Output:
//        2 1 4 3 6 5
//        2 3 4 1
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/even-and-odd-elements-at-even-and-odd-positions/0
//******************************************************************************************************************

public class EvenAndOddNumbersAtEvenAndOddPositions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            //do your action here for each test case
            run();
        }
    }

    //cast or change return type based on problem's needs
    static void run() {
        //my function implementation should go here
    }
}
