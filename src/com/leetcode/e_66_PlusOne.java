package com.leetcode;

//e_66_PlusOne
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
//
//The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
//You may assume the integer does not contain any leading zero, except the number 0 itself.
//
//Example 1:
//
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Example 2:
//
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.

//******************************************************************************************************************
//Companies: Google | 3  Amazon | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/plus-one/
//******************************************************************************************************************

public class e_66_PlusOne {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new e_66_PlusOne().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new e_66_PlusOne().plusOne2(new int[]{1, 2, 3})));

    }


    ////////////////////////////////////////////////////////


    public int[] plusOne(int[] digits, int i, int carry) {
        //when carry equals zero, we are done
        if (carry == 0)
            return digits;

        //if current index less than zero, we are done, just add carry at index 0 and right-shift all other elems
        if (i < 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;

            for (int idx = 0; idx < digits.length; idx++) {
                res[idx + 1] = digits[idx];
            }

            return res;
        }

        //add 1 and re-calc carry then recursively call plusOne again with the new carry to decide if we need to continue further
        int s = digits[i] + carry;
        digits[i] = s % 10;
        carry = s / 10;

        return plusOne(digits, i - 1, carry);
    }

    public int[] plusOne(int[] digits) {
        return plusOne(digits, digits.length - 1, 1);
    }

    ////////////////////////////////////////////////////////


    public int[] plusOne2(int[] digits) {
        //array list to store result
        List<Integer> res = new ArrayList<>();
        int i = digits.length - 1, carry = 0;

        //loop thru from right to left and don't stop until we i = -1 and carry = 0
        while (i >= 0 || carry > 0) {
            //cal sum
            int s = (i >= 0 ? digits[i] : 0) + (i == digits.length - 1 ? 1 : 0) + carry;
            //re-calc carry
            carry = s / 10;
            //add to res
            res.add(s % 10);
            i--;
        }
        //reverse results
        Collections.reverse(res);

        //convert to int[]
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    ////////////////////////////////////////////////////////

    @Test
    public void TestPlusOne() {
        Assert.assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
        Assert.assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));
        Assert.assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1, 0, 0, 0}, plusOne(new int[]{9, 9, 9}));

        ///////////////

        Assert.assertArrayEquals(new int[]{1, 0}, plusOne2(new int[]{9}));
        Assert.assertArrayEquals(new int[]{1}, plusOne2(new int[]{0}));
        Assert.assertArrayEquals(new int[]{1, 2, 4}, plusOne2(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1, 0, 0, 0}, plusOne2(new int[]{9, 9, 9}));
    }

}
