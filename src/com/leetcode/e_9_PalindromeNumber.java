package com.leetcode;

//e_9_PalindromeNumber 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
//Example 1:
//
//Input: 121
//Output: true
//Example 2:
//
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//Example 3:
//
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//Follow up:
//
//Coud you solve it without converting the integer to a string?

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/palindrome-number/
//******************************************************************************************************************

public class e_9_PalindromeNumber {


    public static void main(String[] args) {
        System.out.println(new e_9_PalindromeNumber().isPalindrome(121));
        System.out.println(new e_9_PalindromeNumber().isPalindrome(11));
    }

    public boolean isPalindrome(int x) {

        //reverse the number then compare if they're equal
        int original = x, reverse = 0;
        while (x > 0) { //if x was < 0 [negative] then it will not get into the loop thus returning false [exactly what we want]
            //take the first part of x [right most part/number] every time and
            //add it to the right side of the reverse .. this will eventually convert 123 to 321
            reverse = (reverse * 10) + (x % 10);
            //remove from x the right most number
            x /= 10;
        }


        return reverse == original;
    }

    @Test
    public void TestIsPalindrome() {
        Assert.assertFalse(isPalindrome(012));
        Assert.assertTrue(isPalindrome(01));
        Assert.assertTrue(isPalindrome(0));
        Assert.assertTrue(isPalindrome(121));
        Assert.assertFalse(isPalindrome(-121));
    }

}
