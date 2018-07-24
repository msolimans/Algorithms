package com.g4g.basic;
import java.util.Scanner;

//An Easy problem
//Show Topic Tags

/**
 * simple-math
 */

/*Description*/
//******************************************************************************************************************
// You have been a number K , l , r , x and y . you have to tell if there exist two numbers a and b , such that a/b=K , where a lies between l and r , both inclusive and b lies between x and y , both inclusive . If  such a and b exist then print “YES” otherwise print “NO”.

//Input:
//        First line contains T , indicating number of test cases . Only line of every test case consists of 5 integers K, L, R, X, Y.
//
//        Output:
//        Single line output, print “YES” if such a and b exists else “NO”.
//
//        Constraints:
//        1<=T<=100
//        1<=K,L,R,X,Y<=10^5
//
//        Example:
//        Input:
//        2
//        1 1 10 1 10
//        1 1 5 6 10
//        Output:
//        YES
//        NO
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************

public class AnEasyProblem {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T-- > 0){
            //do your action here for each test case
            int k = scan.nextInt(),l  = scan.nextInt() ,r = scan.nextInt(),x = scan.nextInt(),y = scan.nextInt();
            run(k,l,r,x,y);
        }
    }


    static void run(int k, int l, int r, int x, int y){

    }
}
