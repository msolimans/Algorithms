package com.g4g.basic;
import java.util.Scanner;

//Problem Title
//Show Topic Tags
/**
 * Array
 */

/*Description*/
//******************************************************************************************************************
//Given a Binary Number, Print its decimal equivalent.
//
//        Input:
//
//        The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. Each test case contains a single Binary number.
//
//        Output:
//
//        Print each Decimal number in new line.
//
//        Constraints:
//
//        1< T <100
//        1<=Digits in Binary<=8
//
//        Example:
//        Input:
//        2
//        10001000
//        101100
//
//        Output:
//        136
//        44
//
//        ** For More Input/Output Examples Use 'Expected Output' option **
//        http://practice.geeksforgeeks.org/problems/binary-number-to-decimal-number/0#ExpectOP
//        Contributor: Ayush Govil
//
//******************************************************************************************************************
//Companies: Zoho, VMWare, Paytm
//******************************************************************************************************************
public class BinaryNumberToDecimalNumber {


    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        //pick how many test cases and assign to T
        int T = scan.nextInt();
        while(--T >= 0){
            //read as string
            String input = scan.next();

            //pass the string to function for conversion and print the result
            System.out.println(convertBinaryToDecimal(input));
        }
    }

    static long convertBinaryToDecimal(String input){
        long result = 0;
        int indx = 0;
        //loop through the length of the string from the *END*
        for(int i = input.length() - 1; i>=0;i--){
            //if we get 1 then we should calculate the 2 to the power of current index (index start from zero and from *RIGHT*)
            //Example:
            // 1     0       0       1
            //2^3   2^2     2^1     2^0
            if(input.charAt(i) == '1') {
                result += Math.pow(2, indx);
            }

            //indx should be counting up from ZERO to the (length - 1)
            indx++;
        }

        return result;
    }


}
