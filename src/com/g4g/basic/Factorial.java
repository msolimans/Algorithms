package com.g4g.basic;

import java.util.Scanner;

//Factorial
//Show Topic Tags
/**
* Array
 * Maths
*/

/*Description*/
// ********************************

//     Calculate the factorial for a given number.
//
//        Input:
//        The first line contains an integer 'T' denoting the total number of test cases. In each test cases, it contains an integer 'N'.
//
//
//        Output:
//        In each seperate line output the answer to the problem.
//
//        Constraints:
//        1<=T<=19
//        0<=N<=18
//
//        Example:
//        Input:
//        1
//        1
//
//        Output:
//        1
//
//        ** For More Input/Output Examples Use 'Expected Output' option **
//        * http://practice.geeksforgeeks.org/problems/factorial/0/?ref=self#ExpectOP

public class Factorial {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        //pick how many test cases and assign to T
        int T = scan.nextInt();

        while(T-- > 0){
            //pick the number from standard input to calculate its factorial
            if(scan.hasNext()) {
                int N = scan.nextInt();

                System.out.println(factorial(N));
            }
        }

    }


    /*
    Factorial Examples
        factorial(6) = 6 * 5 * 4 * 3 * 2 * 1
        factorial(3) = 3 * 2 * 1
        factorial(2) = 2 * 1
        factorial(1) = 1
        factorial(0) = 1
        ..
    Implementation:
        we can implement this in rescursive call where:
        Base case is 1 where it has a result = 1
        other cases factorial(N) = N * factorial(N - 1)
    */
    static  long factorial(int i){
        //stop condition: handle base cases (0 and 1)
        if(i <= 1)
            return 1;

        return i * factorial(i -1);
    }
}
