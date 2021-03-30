package com.leetcode;

//e_989_AddtoArrayFormofInteger 
//Show Topic Tags

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
// For example, if X = 1231, then the array form is [1,2,3,1].
//
//Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
//
//
//
//Example 1:
//
//Input: A = [1,2,0,0], K = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
//Example 2:
//
//Input: A = [2,7,4], K = 181
//Output: [4,5,5]
//Explanation: 274 + 181 = 455
//Example 3:
//
//Input: A = [2,1,5], K = 806
//Output: [1,0,2,1]
//Explanation: 215 + 806 = 1021
//Example 4:
//
//Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
//Output: [1,0,0,0,0,0,0,0,0,0,0]
//Explanation: 9999999999 + 1 = 10000000000
//
//
//Note：
//
//1 <= A.length <= 10000
//0 <= A[i] <= 9
//0 <= K <= 10000
//If A.length > 1, then A[0] != 0

//******************************************************************************************************************
//Companies: Facebook
//******************************************************************************************************************
//Link: https://leetcode.com/problems/add-to-array-form-of-integer/
//******************************************************************************************************************

public class e_989_AddtoArrayFormofInteger {


    public static void main(String[] args) {


    }

    public List<Integer> addToArrayForm(int[] A, int K) {


        List<Integer> res = new ArrayList<>();

        return addToArrayForm(A, A.length - 1, K, 0, res);

    }

    public List<Integer> addToArrayForm(int[] A, int i, int K, int carry, List<Integer> res) {

        //base case
        // 1) no elems more to add from K
        // 2) no carry left from previous add operations
        // 3) no elems left in A
        if (i < 0 && carry == 0 && K == 0) {
            //reverse res and return
            Collections.reverse(res);
            return res;
        }

        //get int at index i from right to left then add it to that similar one in A
        int toAdd = K % 10;
        //calc sum now
        int sum = (i < 0 ? 0 : A[i]) + toAdd + carry;

        //make sure it doesn't exceed 10, so we need to re-calc sum val and carry
        res.add(sum % 10);
        carry = sum / 10;

        //re-calc K again
        K /= 10;

        return addToArrayForm(A, i - 1, K, carry, res);
    }

    @Test
    public void TestAddToArrayForm() {
        Assert.assertArrayEquals(new Integer[]{1, 0}, addToArrayForm(new int[]{9}, 1).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4}, addToArrayForm(new int[]{1, 2, 0, 0}, 34).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{4, 5, 5}, addToArrayForm(new int[]{2, 7, 4}, 181).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{1, 0, 2, 1}, addToArrayForm(new int[]{2, 1, 5}, 806).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{1,0,0,0,0,0,0,0,0,0,0}, addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1).toArray(new Integer[0]));
    }
}
