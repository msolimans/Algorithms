package com.leetcode;

//e_970_PowerfulIntegers 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
//
//Return a list of all powerful integers that have value less than or equal to bound.
//
//You may return the answer in any order.  In your answer, each value should occur at most once.
//
//
//
//Example 1:
//
//Input: x = 2, y = 3, bound = 10
//Output: [2,3,4,5,7,9,10]
//Explanation:
//2 = 2^0 + 3^0
//3 = 2^1 + 3^0
//4 = 2^0 + 3^1
//5 = 2^1 + 3^1
//7 = 2^2 + 3^1
//9 = 2^3 + 3^0
//10 = 2^0 + 3^2
//Example 2:
//
//Input: x = 3, y = 5, bound = 15
//Output: [2,4,6,8,10,14]
//
//
//Note:
//
//1 <= x <= 100
//1 <= y <= 100
//0 <= bound <= 10^6

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/powerful-integers/
//******************************************************************************************************************

public class e_970_PowerfulIntegers {


    public static void main(String[] args) {
        System.out.println(new e_970_PowerfulIntegers().powerfulIntegers(2, 3, 10));

    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();

        double r = 0d;
        //x^i+y^j=z => we need to find z
        for (int i = 0; ; i++) {
            if (Math.pow(x, i) > bound) //if it exceeds the bound, exit the loop
                break;

            for (int j = 0; ; j++) {

                r = Math.pow(x, i) + Math.pow(y, j);//cal x^i+y^j

                if (r > bound) {//if it exceeds bound, break
                    break;
                }

                result.add((int) r);//add it to the result

                if (y == 1)//otherwise it will be endless loop in case of 1 and 1
                    break;
            }

            if (x == 1)//otherwise it will be endless loop
                break;

        }


        return new ArrayList<>(result);
    }

    @Test
    public void TestPowerfulIntegers() {
        List<Integer> a = Arrays.asList(2, 3, 4, 5, 7, 9, 10);
        Assert.assertArrayEquals(a.toArray(), powerfulIntegers(2, 3, 10).toArray());

        List<Integer> aa = Arrays.asList(2, 3, 5, 9);
        Assert.assertArrayEquals(aa.toArray(), powerfulIntegers(2, 1, 10).toArray());


    }
}
