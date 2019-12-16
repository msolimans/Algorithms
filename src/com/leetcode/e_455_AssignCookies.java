package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//e_455_AssignCookies 
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
// Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj.
// If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children
// and output the maximum number.
//
//Note:
//You may assume the greed factor is always positive.
//You cannot assign more than one cookie to one child.
//
//Example 1:
//Input: [1,2,3], [1,1]
//
//Output: 1
//
//Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
//And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
//You need to output 1.
//Example 2:
//Input: [1,2], [1,2,3]
//
//Output: 2
//
//Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
//You have 3 cookies and their sizes are big enough to gratify all of the children,
//You need to output 2.
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/assign-cookies/
//******************************************************************************************************************

public class e_455_AssignCookies {

    //98% Faster
    public int findContentChildren(int[] g, int[] s) {
        //sort both arrays to make sure we will be able to match cookies with children
        Arrays.sort(g);
        Arrays.sort(s);

        //2 pointers to keep track of current position/index in arrays
        int ig = 0, is = 0;
        int count = 0;

        //loop thru until we exhaust any or both of the arrays
        while (ig < g.length && is < s.length) {
            //increase count in case we have s[i] greater than or equal to current g[ig]
            //in this case we forward both pointers
            if (g[ig] <= s[is]) {
                count++;
                ig++;
                is++;
            } else {
                //in other cases we will move "is" forward only
                //this is handling duplicates situations like this [1,2] and [1,1,2,3] //test case# 2 below
                is++;
            }
        }

        return count;
    }


    @Test
    public void Teste_455_AssignCookies() {
        Assert.assertEquals(1, findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        Assert.assertEquals(2, findContentChildren(new int[]{1, 2}, new int[]{1, 1, 2, 3}));
        Assert.assertEquals(0, findContentChildren(new int[]{3}, new int[]{1,1,1,}));
        Assert.assertEquals(0, findContentChildren(new int[]{3}, new int[]{}));

    }
}
