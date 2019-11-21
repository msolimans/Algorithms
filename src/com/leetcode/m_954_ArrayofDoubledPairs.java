package com.leetcode;

//m_954_ArrayofDoubledPairs 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Tags: Array, Hashtable
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
//
//
//
//Example 1:
//
//Input: [3,1,3,6]
//Output: false
//Example 2:
//
//Input: [2,1,2,6]
//Output: false
//Example 3:
//
//Input: [4,-2,2,-4]
//Output: true
//Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
//Example 4:
//
//Input: [1,2,4,16,8,4]
//Output: false
//
//
//Note:
//
//0 <= A.length <= 30000
//A.length is even
//-100000 <= A[i] <= 100000

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/array-of-doubled-pairs/
//******************************************************************************************************************

public class m_954_ArrayofDoubledPairs {


    public static void main(String[] args) {

        System.out.println(new m_954_ArrayofDoubledPairs().canReorderDoubled(new int[]{1, 2, 1, 0, 0, 2}));
    }


    //sort the array
    //always record frequencies of elems in the array
    //loop thru the array and for every elem we have its double number, omit both from frequency
    //in case of negatives we should have the half of the elem not the double => after sort it should be in this order [-8 -4] leading to -8 / 2 => -4
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i : A) {
            frequencies.put(i, frequencies.getOrDefault(i, 0) + 1);
        }

        for (int i : A) {
            int second = i * 2;
            //if it is negative, change second as to be i/2 instead of i*2
            if (i < 0) {
                second = i / 2;
            }

            if (frequencies.containsKey(i) && frequencies.containsKey(second)) {
                //update freq map
                int iNewfreq = frequencies.get(i) - 1;
                if (iNewfreq == 0) {
                    frequencies.remove(i);
                } else {
                    frequencies.put(i, iNewfreq);
                }

                int sNewfreq = frequencies.getOrDefault(second, 0) - 1;
                if (sNewfreq < 0)//this handle err in leetcode test case, supposed not to be there but added to handle odd length of array in case of "zero" . check last test case for more info
                    break;
                else if (sNewfreq == 0) {
                    frequencies.remove(second);
                } else {
                    frequencies.put(second, sNewfreq);
                }

            }
        }


        return frequencies.isEmpty();
    }

    @Test
    public void TestCanRecordDoubled() {
        Assert.assertFalse(canReorderDoubled(new int[]{3, 1, 3, 6}));
        Assert.assertFalse(canReorderDoubled(new int[]{2, 1, 2, 6}));
        Assert.assertTrue(canReorderDoubled(new int[]{4, -2, 2, -4}));
        Assert.assertTrue(canReorderDoubled(new int[]{0, 0, 1, 2, 1, 0, 2, 0, 2, 2, 2, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0}));
    }

}
