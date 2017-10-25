package com.g4g.basic;
import java.util.Scanner;


//Problem Title
//Show Topic Tags

/**
 * Maths
 * Permutation
 */

/*Description*/
//******************************************************************************************************************
//Given 3 characters a, b, c. Find the number of strings of length n that can be formed from these 3 characters.
// Given that : we can use ‘a’ as many times as we want, ‘b’ maximum once, and ‘c’ maximum twice.

//        Input:
//        The first line of input contains an integer T denoting the number of test cases. The first and last line of each test case consists of an integer n.
//
//        Output:
//        Print the total number of string that can be formed.
//
//        Constraints:
//        1<=T<=20
//        1<=N<=20
//
//        Example:
//        Input:
//        2
//        3
//        5
//
//        Output:
//        19
//        71
//
//        ** For More Input/Output Examples Use 'Expected Output' option **
//
//        Contributor: Saksham Ashtputre
//******************************************************************************************************************
//Companies: VMWare, Oracle
//******************************************************************************************************************

public class TotalNumberOfStrings {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T-- > 0){
            //do your action here for each test case
            System.out.println(run(scan.nextInt()));
        }
    }

    /**
     * Solution Desc:
     * @param len the string length
     * @return number of strings of length n to be formed from 'a','b','c'
     *
     * Analysis:
     * Step 1) As per question, 'b' can come 0 or 1 and 'c' can come up 0,1, or 2.
     * so we should construct strings that has those features then fill up the missing with 'a' as long it was mentioend that 'a' can be used as many times as we want
     *
     * Step 2) Permutate over those constructed strings and check how many consequences that can be generated, please notice the duplications of character 'a' and 'c'
     *
     */
    static int run(int len){
        //basic which is a,b,c
        if(len == 1)
            return 3;

        //since we have b = 0,1 and c =0,1,2 => times all possibilities together gives 6 (2*3)
        char[][] arr = new char[len][6];

        //max number of bs or cs, it should be at least as the length that is passed to the array. if it is greater than len we should use len
        int bMax = len<1?len:1;
        int cMax = len<2?len:2;

        int indx = 0;

        //i represents how many bs it should be in the array and j represents how many cs in the array
        for(int i=0;i<=bMax;i++)
            for(int j=0;j<cMax;j++){
                fill(arr, indx++, len, i, j);
            }

        int result = 0;
        for(char[] c: arr){
            //permutate over every entry and count
            result += permutate(c);
        }

        return result;
    }

    //fill each entry with 'b's then 'c's then what is left should go for 'a's
    static char[][] fill(char[][] arr, int index, int len, int bs, int cs){
        int i = 0;
        for(;i<bs;i++)
            arr[index][i] = 'b';
        for(;i<cs;i++)
            arr[index][i] = 'c';


        for(;i<len;i++)
            arr[index][i] = 'a';
        return  arr;
    }

    //calculate permutation
    static int permutate(char[] arr){

        return 1;
    }



}
