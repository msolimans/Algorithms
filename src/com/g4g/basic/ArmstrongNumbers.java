package com.g4g.basic;
import java.util.Scanner;

//Problem Title
//Show Topic Tags
/**
 * Maths
 */
/*Description*/
//******************************************************************************************************************
//For a given 3 digit number, find whether it is armstrong number or not. An Armstrong number of three digits is an integer
// such that the sum of the cubes of its digits is equal to the number itself.
// For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371

//Input:
//        First line contains an integer, the number of test cases 'T' Each test case should contain a positive integer N.
//
//
//        Output:
//        Print "Yes" if it is a armstrong number else print "No".
//
//
//        Constraints:
//        1<=T<=31
//        100<= N <1000
//
//
//        Example:
//        Input:
//        1
//        371
//
//        Output:
//        Yes
//
//        ** For More Input/Output Examples Use 'Expected Output' option **
//        http://practice.geeksforgeeks.org/problems/armstrong-numbers/0/?ref=self#ExpectOP
//******************************************************************************************************************
//Companies: VMWare, Oracle
//******************************************************************************************************************

public class ArmstrongNumbers {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T-- > 0){
            int i = scan.nextInt();
            //do your action here for each test case
            System.out.println(run(i) == i?"Yes":"No");
        }
    }

    //armstrong valdiation
    static int run(int no){
        //to split 371
        //it is easy task by doing remainders and divisions, check the following algroithm
        //to get 1 => get remainder for 10              => 371 % 10 = 1
        //to get 7 => get remainder for 100             => 371 % 100 = 71                   then now divide by 10       => 71 / 10 = 7
        //to get 3 => get remainder for 1000            => 371 % 1000 = 371                 then now devide by 100      => 371 / 100 = 3
        //=> we should have the stop condition as remainder = number itself
        //let's implement it
        int base = 10;
        int result = 0;

        while(true){
            int i = (no % base) / (base / 10);
            result += (i * i * i);

            if(no % base == no)
                break;

            base *= 10;
        }

        return result;
    }
}
