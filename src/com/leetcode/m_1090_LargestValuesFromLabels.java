package com.leetcode;

//m_1090_LargestValuesFromLabels 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//We have a set of items: the i-th item has value values[i] and label labels[i].
//
//Then, we choose a subset S of these items, such that:
//
//|S| <= num_wanted
//For every label L, the number of items in S with label L is <= use_limit.
//Return the largest possible sum of the subset S.
//
//
//
//Example 1:
//
//Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
//Output: 9
//Explanation: The subset chosen is the first, third, and fifth item.
//Example 2:
//
//Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
//Output: 12
//Explanation: The subset chosen is the first, second, and third item.
//Example 3:
//
//Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
//Output: 16
//Explanation: The subset chosen is the first and fourth item.
//Example 4:
//
//Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
//Output: 24
//Explanation: The subset chosen is the first, second, and fourth item.
//
//
//Note:
//
//1 <= values.length == labels.length <= 20000
//0 <= values[i], labels[i] <= 20000
//1 <= num_wanted, use_limit <= values.length
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/largest-values-from-labels/
//******************************************************************************************************************

public class m_1090_LargestValuesFromLabels {


    public static void main(String[] args) {
        System.out.println(new m_1090_LargestValuesFromLabels().largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1));

    }

    //vals = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
    //9
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        //List all labels in hashmap O(n)
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            LinkedList<Integer> list = map.getOrDefault(values[i], new LinkedList<>());
            list.add(labels[i]);
            map.put(values[i], list);
        }

        //sort
        Arrays.sort(values);
        //put back all vals from hashmap "flatten linked list to array back"
        for (int i = values.length - 1; i >= 0; i--) {
            labels[i] = map.get(values[i]).pollLast();
        }

        //return largest sum
        return getSum(values, labels, num_wanted, use_limit);

    }


    public int getSum(int[] values, int[] labels, int num_wanted, int use_limit) {
        //count is public to all array
        Map<Integer, Integer> max = new HashMap<>();

        int iv = values.length - 1, il = labels.length - 1, n = 0, sum = 0;
        //loop thru both arrays "pointers"
        while (n < num_wanted && iv >= 0) {

            //in case we reached limit, skip it
            if (max.getOrDefault(labels[il], 0) == use_limit) {
                il--;
                iv--;
                continue;
            }


            //incr nums count, add occurence to max map, add to sum, n move pointers
            n++;
            max.put(labels[il], max.getOrDefault(labels[il], 0) + 1);
            sum += values[iv];
            il--;
            iv--;
        }

        return sum;
    }

    @Test
    public void TestLargestValsFromLabels() {
//
        Assert.assertEquals(9, largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1));
        Assert.assertEquals(12, largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2));
        Assert.assertEquals(16, largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 1));
        Assert.assertEquals(24, largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 2));
        Assert.assertEquals(6, largestValsFromLabels(new int[]{2, 6, 1, 2, 6,}, new int[]{2, 2, 2, 1, 1}, 1, 1));
        Assert.assertEquals(9, largestValsFromLabels(new int[]{2, 6, 3, 6, 5}, new int[]{1, 1, 2, 1, 1}, 3, 1));


    }
}
