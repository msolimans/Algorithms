package com.leetcode;

//e_1189_MaximumNumberofBalloons 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
//
//You can use each character in text at most once. Return the maximum number of instances that can be formed.
//
//
//
//Example 1:
//
//
//
//Input: text = "nlaebolko"
//Output: 1
//Example 2:
//
//
//
//Input: text = "loonbalxballpoon"
//Output: 2
//Example 3:
//
//Input: text = "leetcode"
//Output: 0
//
//
//Constraints:
//
//1 <= text.length <= 10^4
//text consists of lower case English letters only.
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximum-number-of-balloons/submissions/
//******************************************************************************************************************

public class e_1189_MaximumNumberofBalloons {


    public static void main(String[] args) {
        System.out.println(new e_1189_MaximumNumberofBalloons().maxNumberOfBalloons("ballono"));

    }

    public int maxNumberOfBalloons(String text) {
        //balloon.. count how many chars then check the least count of them
        //O(n) with constant space
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
            }
        }

        //l=>3/2 = 1
        //o=>4/2 = 2
        l /= 2;
        o /= 2;

        int sum = Integer.MAX_VALUE;
        if (b < sum)
            sum = b;
        if (a < sum)
            sum = a;

        if (l < sum)
            sum = l;
        if (o < sum)
            sum = o;
        if (n < sum)
            sum = n;

        return sum;
    }

    @Test
    public void TestmaxNumberOfBalloons() {
        Assert.assertEquals(1, maxNumberOfBalloons("nlaebolko"));
        Assert.assertEquals(2, maxNumberOfBalloons("loonbalxballllpooon"));
        Assert.assertEquals(0, maxNumberOfBalloons("leetcode"));
        Assert.assertEquals(0, maxNumberOfBalloons("balon"));
    }

}
