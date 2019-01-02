package com.leetcode;

//Self Dividing Numbers
//Show Topic Tags

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//A self-dividing number is a number that is divisible by every digit it contains.
//
//        For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
//
//        Also, a self-dividing number is not allowed to contain the digit zero.
//
//        Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
//
//        Example 1:
//        Input:
//        left = 1, right = 22
//        Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
//        Note:
//
//        The boundaries of each input argument are 1 <= left <= right <= 10000.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/self-dividing-numbers/description/
//******************************************************************************************************************

public class e_728_SelfDividingNumbers {


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for(int i=left;i<=right;i++)
            if(selfDivindNumber(i)) result.add(i);

        return result;
    }

    public boolean selfDivindNumber(int number){

        int n = number;

        while (n > 0){
            if((n % 10) == 0 || number % (n % 10) > 0)
                return false;


            n = n / 10;
        }

        return true;
    }


    public static void main(String[] args) {

        //new e_728_SelfDividingNumbers().selfDivindNumber(19987);
        System.out.println(
                Arrays.toString(
                new e_728_SelfDividingNumbers().selfDividingNumbers(1,22).toArray())
        );
    }
}
