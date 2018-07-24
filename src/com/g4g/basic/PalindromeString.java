package com.g4g.basic;
import java.util.Scanner;

//Palindrome String
//Show Topic Tags
/**
 * String
*/

/*Description*/
//******************************************************************************************************************
//Given a string s check if it is palindrome or not.
//
//        Input:
//        The first line contains 'T' denoting the number of test cases. Then follows description of test cases.
//        Each case begins with a single integer N denoting the length of string. The next line contains the string s.
//
//
//        Output:
//        Print "Yes" if it is a palindrome else "No". (Without the double quotes)
//
//
//        Constraints:
//        1<=T<=30
//        1<=N<=100
//
//
//        Example:
//        Input:
//        1
//        4
//        abba
//
//        Output:
//        Yes
//
//        ** For More Input/Output Examples Use 'Expected Output' option **
//          http://practice.geeksforgeeks.org/problems/palindrome-string/0/?ref=self#ExpectOP
//******************************************************************************************************************
//Comapanies: Paytm
//******************************************************************************************************************
public class PalindromeString {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T-- > 0){
            //check palindrome
            //I don't see any benefit in len as long as I have len in str
            int len = scan.nextInt();
            String str = scan.next();
            //validate palindrome
            System.out.println(run(str)?"Yes": "No");
            //recursive call
            //System.out.println(run(str,0,len - 1)?"Yes": "No");
        }
    }

    //xor all chars if it gives zero
    //XOR operations
    //1 ^ 1 = 0
    //1 ^ 0 = 1
    //0 ^ 1 = 1
    //0 ^ 0 = 0
    static boolean run(String str){
        int i = 0;
        int j = str.length() - 1;
        while(j > i){
            //can be simplified to make assignment comparison too
            if((str.charAt(i++) ^ str.charAt(j--)) != 0) //same as => str.charAt(i++)  == str.charAt(j--)
                return false;
        }

        return  true;
    }


    //recursive call, i should start with zero and j with length - 1
    static boolean run(String str, int i, int j){
        //once i == j or getting even less than i, return true
        if(j <= i)
            return  true;

        //as long j is greater than i, we should continue on recursive call
        //stack or commbine all results in conditional AND
        return str.charAt(i) == str.charAt(j) && run(str,++i, --j);

        //all of it can be written in the followig way however I wrote in previous one to be more readable and understandable
        //return j <= i || str.charAt(i) == str.charAt(j) && run(str, ++i, --j);
    }




}
